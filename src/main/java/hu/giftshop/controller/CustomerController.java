/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.AddressDto;
import hu.giftshop.dto.CustomerDto;
import hu.giftshop.dto.impl.CustomerDtoImpl;
import hu.giftshop.model.Address;
import hu.giftshop.model.Customer;
import hu.giftshop.repository.ICustomerRepository;
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
public class CustomerController {
    
    public CustomerController(){
        
    }  
    
    public static Customer convertFromDto(CustomerDto dto){
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setCustomerType(dto.getCustomerType());
        customer.setEmail(dto.getFirstName());
        customer.setPhone(dto.getFirstName());
        Address address = AddressController.convertFromDto(dto.getAddress());
        customer.setAddress(address);
        customer.setAccountNumber(dto.getAccountNumber());
        return customer;
    }
    
    public static CustomerDto convertFromEntity(Customer customer){
        AddressDto addressDto = AddressController.convertFromEntity(customer.getAddress());
        return new CustomerDtoImpl.CustomerDtoBuilder()
                                  .id(customer.getId())
                                  .firstName(customer.getFirstName())
                                  .lastName(customer.getLastName())
                                  .email(customer.getEmail())
                                  .phone(customer.getPhone())
                                  .customerType(customer.getCustomerType())
                                  .address(addressDto)
                                  .accountNumber(customer.getAccountNumber())
                                  .build();
    }
    
    public List<CustomerDto> getAllCustomers(){
        List<CustomerDto> customers = new ArrayList<>();
        try {   
            ICustomerRepository customerRepository = EJBAccess.getCustomerRepository();      
            for (Customer customer : customerRepository.findAll()) {
                AddressDto addressDto = AddressController.convertFromEntity(customer.getAddress());
                customers.add(new CustomerDtoImpl.CustomerDtoBuilder()
                        .id(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .customerType(customer.getCustomerType())
                        .address(addressDto)
                        .accountNumber(customer.getAccountNumber())
                        .build()
                );
            }
            
        } catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
            
        } catch (Exception ex){
            System.out.println("EXCEPTION");
            
        } finally {
            return customers;
        }
        
    }

    public CustomerDto getCustomer(int id) {
        CustomerDto customerDto = null;
        try{
            ICustomerRepository customerRepository = EJBAccess.getCustomerRepository();
            Customer customer = customerRepository.find(id);
            AddressDto addressDto = AddressController.convertFromEntity(customer.getAddress());
            customerDto = new CustomerDtoImpl.CustomerDtoBuilder()
                        .id(customer.getId())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .phone(customer.getPhone())
                        .customerType(customer.getCustomerType())
                        .address(addressDto)
                        .accountNumber(customer.getAccountNumber())
                        .build();
        }catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
            
        } catch (Exception ex){
            System.out.println("EXCEPTION");
        }finally {
            return customerDto;
        }
    }
    
    
    public Customer createCustomer(CustomerDto customerDto){
        Customer customer = null;
        try {
            ICustomerRepository customerRepository = EJBAccess.getCustomerRepository();
            customer = customerRepository.create(convertFromDto(customerDto));
        } catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
        } catch (Exception ex){
            System.out.println("EXCEPTION");
        } finally {
            return customer;
        }
        
    }
    
    public Customer updateCustomer(CustomerDto customerDto){
        Customer customer = CustomerController.convertFromDto(getCustomer(customerDto.getId()));
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setCustomerType(customerDto.getCustomerType());
        customer.setAddress(AddressController.convertFromDto(customerDto.getAddress()));
        customer.setAccountNumber(customerDto.getAccountNumber());
        try {
            ICustomerRepository customerRepository = EJBAccess.getCustomerRepository();
            customerRepository.update(customer);
        } catch (NamingException ex){
            System.out.println("NAMING EXCEPTION");
        } catch (Exception ex){
            System.out.println("EXCEPTION");
        } finally {
            return customer;
        }
    }
    
    
    public void deleteCustomer(int id){
        try {
            ICustomerRepository customerRepository = EJBAccess.getCustomerRepository();
            customerRepository.delete(customerRepository.find(id));
        } catch (NamingException ex){
            System.out.println("");
        } catch (Exception ex){
            System.out.println("");
        }
    }
    
    
    
}
