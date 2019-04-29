/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.OrderProductDto;
import hu.giftshop.dto.ProductDto;
import hu.giftshop.dto.impl.OrderProductDtoImpl;
import hu.giftshop.model.CustomerOrder;
import hu.giftshop.model.OrderProduct;
import hu.giftshop.model.Product;
import hu.giftshop.repository.ICustomerOrderRepository;
import hu.giftshop.repository.IOrderProductRepository;
import hu.giftshop.repository.IProductRepository;
import hu.giftshop.util.EJBAccess;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */
@Stateless
public class OrderProductController {

    
    public OrderProductController() {
    }
    
    public static OrderProduct convertFromDto(OrderProductDto dto){
        OrderProduct orderProduct = new OrderProduct();
        Product product = ProductController.convertFromProduct(dto.getProduct());
        orderProduct.setProduct(product);
        orderProduct.setQuantity(dto.getQuantity());
        return orderProduct;
    }
    
    public static OrderProductDto convertFromEntity(OrderProduct orderProduct){
        ProductDto productDto = ProductController.convertFromEntity(orderProduct.getProduct());
        return new OrderProductDtoImpl.OrderProductDtoBuilder()
                    .id(orderProduct.getId())
                    .product(productDto)
                    .quantity(orderProduct.getQuantity())
                    .build();           
    }
    
    public List<OrderProductDto> getAllOrderProducts(){
        List<OrderProductDto> orderProducts = new ArrayList<>();
//        for () {
//            
//        }
        return orderProducts;
    }
    
    public void createOrderProduct(Integer customerOrderId, Integer productId, Integer quantity ){ 
        try{
            ICustomerOrderRepository customerOrderRepository = EJBAccess.getCustomerOrderRepository();
            IProductRepository productRepopsitory = EJBAccess.getProductRepository();
            IOrderProductRepository orderProductRepository = EJBAccess.getOrderProductRepository();
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(customerOrderRepository.find(customerOrderId));
            orderProduct.setProduct(productRepopsitory.find(productId));
            orderProduct.setQuantity(quantity);
            orderProductRepository.create(orderProduct);
            System.out.println("ORDER PRODUCT CREATED");
        } catch(NamingException ex){
            System.out.println("");
        } catch (Exception ex){
            System.out.println("");
        }
    }
    
    public void create(OrderProduct orderProduct){
        try {
            IOrderProductRepository orderProductRepository = EJBAccess.getOrderProductRepository();
            orderProductRepository.create(orderProduct);
            System.out.println("ORDER PRODUCT CREATED");
            
        } catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
        } catch (Exception ex){
            System.out.println("NAMING EXCEPTION");
        }
    }
    
//    public Integer OrderProduct(Product product, ){
//        
//    }
    
}
