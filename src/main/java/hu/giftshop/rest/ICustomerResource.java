/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest;

import hu.giftshop.dto.CustomerDto;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author szotyi
 */
@Path("customers")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ICustomerResource {
    
    @GET
    public List<CustomerDto> getAllCustomers();
    
   @GET
   @Path("{id}")
   public CustomerDto getCustomer(@PathParam("id") int id);
    
   @POST
   public Response createCustomer(CustomerDto customerDto);
   
   @PUT
   public Response updateCustomer(CustomerDto customerDto);
   
   @DELETE
   @Path("{id}")
   public Response deleteCustomer(@PathParam("id") int id);
   
}
