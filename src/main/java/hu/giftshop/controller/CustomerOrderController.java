/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.CustomerDto;
import hu.giftshop.dto.CustomerOrderDto;
import hu.giftshop.dto.OrderProductDto;
import hu.giftshop.dto.impl.CustomerOrderDtoImpl;
import hu.giftshop.model.Customer;
import hu.giftshop.model.CustomerOrder;
import hu.giftshop.model.OrderProduct;
import hu.giftshop.model.Product;
import hu.giftshop.repository.ICustomerOrderRepository;
import hu.giftshop.util.EJBAccess;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */
@Stateless
public class CustomerOrderController {
    
    @EJB
    private OrderProductController orderProductController;
    
    @EJB
    private CustomerController customerController;
    
    @EJB
    private ProductController productController;
    
    public CustomerOrderController() {

    }

    public static CustomerOrder convertFromDto(CustomerOrderDto customeOrderDto){
        CustomerOrder order = new CustomerOrder();
        order.setOrderDate(customeOrderDto.getOrderDate());
        order.setFulfillDate(customeOrderDto.getFulfillDate());
        Customer customer = CustomerController.convertFromDto(customeOrderDto.getCustomer());
        order.setCustomer(customer);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : customeOrderDto.getOrderProductList()) {
            OrderProduct item = OrderProductController.convertFromDto(dto);
            orderProducts.add(item);
        }
        order.setOrderProductList(orderProducts);
        return order;
    }
    
    private Calendar hotfixDateValue(Calendar earlierDate){
        if(earlierDate != null){
            Calendar fixed = Calendar.getInstance();
            fixed.set(Calendar.YEAR, earlierDate.get(Calendar.YEAR));
            fixed.set(Calendar.MONTH, earlierDate.get(Calendar.MONTH));
            fixed.set(Calendar.DAY_OF_MONTH, earlierDate.get(Calendar.DAY_OF_MONTH));
            return fixed;
        }
        return null;
    }
    
//    private Calendar dateToCalendar(Date date){
//        Calendar calendar = Calendar.getInstance();
//        calendar.set
//    }
    
   
    
    public List<CustomerOrderDto> getAllCustomerOrders(){
        List<CustomerOrderDto> customerOrders = new ArrayList<>();
        try {
            ICustomerOrderRepository customerOrderRepository = EJBAccess.getCustomerOrderRepository();
            for (CustomerOrder customerOrder : customerOrderRepository.findAll()) {
                CustomerDto customerDto = CustomerController.convertFromEntity(customerOrder.getCustomer());
                List<OrderProductDto> orderProductDtoList = new ArrayList<>();
                for (OrderProduct orderProduct : customerOrder.getOrderProductList()) {
                    orderProductDtoList.add(OrderProductController.convertFromEntity(orderProduct));
                }
                
                customerOrders.add(new CustomerOrderDtoImpl.CustomerOrderDtoBuilder()
                            .id(customerOrder.getId())
                            .orderDate(hotfixDateValue(customerOrder.getOrderDate()))
                            .fulfillDate(hotfixDateValue(customerOrder.getFulfillDate()))
                            .customer(customerDto)
                            .orderProductList(orderProductDtoList)
                            .build()
                );
            }
            
        } catch (NamingException ex) {
            System.out.println("NAMING EXCEPTION");
            
        } catch (Exception ex){
            System.out.println("EXCEPTION");
            
        } finally {
            return customerOrders;
        }    
    }
    
    private Calendar stringToCalendar(String date){
        System.out.println("date:" + date);
        Calendar calendar = Calendar.getInstance();
        Integer year = Integer.parseInt(date.split("-")[0]);
        Integer month = Integer.parseInt(date.split("-")[1]);
        Integer day = Integer.parseInt(date.split("-")[2]);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }
    
    public void createCustomerOrder(String customerOrder){
        try {
            JsonReader reader = Json.createReader(new StringReader(customerOrder));
            JsonObject jsonObject = reader.readObject();
            
            CustomerOrder order = new CustomerOrder();
            order.setOrderDate(stringToCalendar(jsonObject.getString("orderDate")));
            if(jsonObject.isNull("fulfillDate")){
                order.setFulfillDate(null);
            } else {
                order.setFulfillDate(stringToCalendar(jsonObject.getString("fulfillDate")));
            } 
            
            int customerId = jsonObject.getJsonObject("customer").getInt("id");
            Customer customer = CustomerController.convertFromDto(customerController.getCustomer(customerId));
            order.setCustomer(customer);
            List<OrderProduct> orderProductList= new ArrayList<>();
            order.setOrderProductList(orderProductList);
            //adatb
            //
            ICustomerOrderRepository customerOrderRepository = EJBAccess.getCustomerOrderRepository();
            Integer insertedId = customerOrderRepository.createCustomerOrder(order);
            
            JsonArray list = jsonObject.getJsonArray("orderProductList"); 
            //lehet kéne lista is amihez visszaseteljük az elöbb beszurt customerOrder-t
            for(int i = 0; i< list.size(); i++){
                OrderProduct orderProduct= new OrderProduct();
                int productId = list.getJsonObject(i).getJsonObject("product").getInt("id");
                Product product = productController.getProduct(productId);
                
                orderProduct.setProduct(product);
                orderProduct.setQuantity(list.getJsonObject(i).getInt("quantity"));
                orderProduct.setOrder(customerOrderRepository.find(insertedId));
                
                orderProductController.create(orderProduct);
                
                //todo: létre kell hozni az orderproductot
                //todo: bele kell rakni az orderproductlistbe
                //todo:orderproductlistet bele kell rakni az orderbe
            }
            //order.setOrderProductList(jsonObject.getJsonArray("orderProductList"));            
//            System.out.println(jsonObject.getString("customer").toString());
//            order.setCustomer(customer);
//            customerOrderRepository = EJBAccess.getCustomerOrderRepository();
            
//            List<OrderProduct> orderProductDtos = customerOrder.getOrderProductList();
//            System.out.println("order date - " + customerOrder.getOrderDate());
//            System.out.println("fulfill date - " + customerOrder.getFulfillDate());
//            System.out.println("Customer ID: " + customerOrder.getCustomer().getId());
//            System.out.println("ORDER PRORUCTS SIZE: " + customerOrder.getOrderProductList().size());
            //invoice generation + quantity updating todo...
        } catch(NamingException ex){
            System.out.println("");
        } catch (Exception ex){
            System.out.println("");
            
        }
        
    
    }
    
    
    
}
