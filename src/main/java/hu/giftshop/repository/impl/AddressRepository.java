/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.repository.impl;

import hu.giftshop.model.Address;
import hu.giftshop.repository.IAddressRepositoryLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author szotyi
 */
@Stateless
public class AddressRepository extends AbstractRepository<Address> implements IAddressRepositoryLocal {
    
    public AddressRepository(){
        super(Address.class);
    }

    @Override
    public List<Address> findAll() {
        Query query = getEntityManager().createNamedQuery(Address.class.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public Address find(int id) {
        return getEntityManager().find(Address.class, id);
    }

    @Override
    public void create(Address address) {
        getEntityManager().persist(address);
    }

    @Override
    public void update(Address address) {
        getEntityManager().merge(address);
    }

    @Override
    public void delete(Address address) {
        getEntityManager().remove(address);
    }
    
    
    
    
}
