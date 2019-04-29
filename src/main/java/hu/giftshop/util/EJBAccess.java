/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.util;

//import hu.giftshop.repository.IAddressRepository;
//import hu.giftshop.repository.IAddressRepositoryLocal;
import hu.giftshop.repository.IAddressRepository;
import hu.giftshop.repository.IAddressRepositoryLocal;
import hu.giftshop.repository.ICategoryRepository;
import hu.giftshop.repository.ICategoryRepositoryLocal;
import hu.giftshop.repository.ICustomerOrderRepository;
import hu.giftshop.repository.ICustomerOrderRepositoryLocal;
import hu.giftshop.repository.ICustomerRepository;
import hu.giftshop.repository.ICustomerRepositoryLocal;
import hu.giftshop.repository.IOrderProductRepository;
import hu.giftshop.repository.IOrderProductRepositoryLocal;
import hu.giftshop.repository.IProductRepository;
import hu.giftshop.repository.IProductRepositoryLocal;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */
public class EJBAccess {
    
    public static ICategoryRepository getCategoryRepository() throws NamingException {
        return (ICategoryRepository) lookup(ICategoryRepositoryLocal.class.getName());
    }
    
    public static IProductRepository getProductRepository() throws NamingException {
        return (IProductRepository) lookup(IProductRepositoryLocal.class.getName());
    }
    
    public static IAddressRepository getAddressRepository() throws NamingException {
        return (IAddressRepository) lookup(IAddressRepositoryLocal.class.getName());
    }
    
    public static ICustomerRepository getCustomerRepository() throws NamingException {
        return (ICustomerRepository) lookup(ICustomerRepositoryLocal.class.getName());
    }
    
    public static IOrderProductRepository getOrderProductRepository() throws NamingException {
        return (IOrderProductRepository) lookup(IOrderProductRepositoryLocal.class.getName());
    }
    
    public static ICustomerOrderRepository getCustomerOrderRepository() throws NamingException {
        return (ICustomerOrderRepository) lookup(ICustomerOrderRepositoryLocal.class.getName());
    }
    
    private static Object lookup(String localClass) throws NamingException {
        return ConfigServlet.getLocalInterfaces().get(localClass);
    }
}
