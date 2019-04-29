/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.controller;

import hu.giftshop.dto.AddressDto;
import hu.giftshop.dto.impl.AddressDtoImpl;
import hu.giftshop.model.Address;
import hu.giftshop.repository.IAddressRepository;
import hu.giftshop.util.EJBAccess;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;

/**
 *
 * @author szotyi
 */

@Stateless
public class AddressController {

    public AddressController() {
    }
    
    public static Address convertFromDto(AddressDto dto){
        Address address = new Address();
        address.setId(dto.getId());
        address.setCountry(dto.getCountry());
        address.setZipCode(dto.getZipCode());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHouseNumber(dto.getHouseNumber());
        address.setDoorbell(dto.getFloor());
        address.setDoor(dto.getDoor());
        address.setDoorbell(dto.getDoorbell());
        return address;
    }
    
    public static AddressDto convertFromEntity(Address entity){
        if(entity != null){
            return new AddressDtoImpl.AddressDtoBuilder()
                .id(entity.getId())
                .country(entity.getCountry())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .street(entity.getStreet())
                .houseNumber(entity.getHouseNumber())
                .floor(entity.getFloor())
                .door(entity.getDoor())
                .doorbell(entity.getDoorbell())
                .build();
        }
        return null;
    }
    
    public List<AddressDto> getAllAddresses(){
        List<AddressDto> addresses = new ArrayList<>();
        try {
            IAddressRepository addressRepository = EJBAccess.getAddressRepository();
            for (Address address : addressRepository.findAll()) {
                addresses.add(new AddressDtoImpl.AddressDtoBuilder()
                    .id(address.getId())
                    .country(address.getCountry())
                    .zipCode(address.getZipCode())
                    .city(address.getCity())
                    .street(address.getStreet())
                    .houseNumber(address.getHouseNumber())
                    .floor(address.getFloor())
                    .door(address.getDoor())
                    .doorbell(address.getDoorbell())
                    .build()
                );
            }
            return addresses;
        } catch(NamingException ex){
            //LOGGER SHOULD BE USED HERE..
            System.out.println("");
            return addresses;     
        } catch(Exception ex){
            //LOGGER SHOULD BE USED HERE..
            System.out.println("EXCEPTION");
            return addresses; 
        }
    }
    
    public AddressDto getAddress(int id){
        AddressDto addressDto = null;
        try {
            IAddressRepository addressRepository = EJBAccess.getAddressRepository();
            Address address = addressRepository.find(id);
            addressDto = new AddressDtoImpl.AddressDtoBuilder()
                    .id(address.getId())
                    .country(address.getCountry())
                    .zipCode(address.getZipCode())
                    .city(address.getCity())
                    .street(address.getStreet())
                    .houseNumber(address.getHouseNumber())
                    .floor(address.getFloor())
                    .door(address.getDoor())
                    .doorbell(address.getDoorbell())
                    .build();
        } catch (NamingException ex){
            //LOGGER SHOULD BE USED HERE..
            System.out.println("NAMING EXCEPTION AT ADDRESS CONTROLLER");
        } catch (Exception ex){
            //LOGGER SHOULD BE USED HERE..
            System.out.println("EXCEPTION AT ADDRESS CONTROLLER");
        } finally {
            return addressDto;
        }
    }
    
    
}
