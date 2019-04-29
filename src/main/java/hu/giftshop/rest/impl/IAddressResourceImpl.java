/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest.impl;

import hu.giftshop.controller.AddressController;
import hu.giftshop.dto.AddressDto;
import hu.giftshop.rest.IAddressResource;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author szotyi
 */

@RequestScoped
public class IAddressResourceImpl implements IAddressResource {

    @EJB
    private AddressController addressController;
    
    
    @Override
    public List<AddressDto> getAllAddresses() {
        return addressController.getAllAddresses();
    }

    @Override
    public AddressDto getAddress(int id) {
        return addressController.getAddress(id);
    }
    
}
