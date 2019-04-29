/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository;

import hu.giftshop.model.Address;
import java.util.List;

/**
 *
 * @author szotyi
 */
public interface IAddressRepository {
    
    public List<Address> findAll();
    
    public Address find(int id);
    
    public void create(Address address);
    
    public void update(Address address);
    
    public void delete(Address address);
    
}
