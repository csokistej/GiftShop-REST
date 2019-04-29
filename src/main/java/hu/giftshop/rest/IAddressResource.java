/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest;

import hu.giftshop.dto.AddressDto;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author szotyi
 */
@Path("addresses")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IAddressResource {
    
    @GET
    public List<AddressDto> getAllAddresses();
    
    @GET
    @Path("{id}")
    public AddressDto getAddress(@PathParam("id") int id);
    
}
