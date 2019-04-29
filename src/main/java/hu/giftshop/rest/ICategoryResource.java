/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.giftshop.rest;

import hu.giftshop.dto.CategoryDto;
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
@Path("categories")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface ICategoryResource {
    
    @GET
    public List<CategoryDto> getAllCategories();
    
    @GET
    @Path("{id}")
    public CategoryDto getCategory(@PathParam("id") int id);
    
    @POST
    public Response createCategory(CategoryDto categoryDto);
    
    @PUT
    public Response updateCategory(CategoryDto categoryDto);
    
    @DELETE
    @Path("{id}")
    public Response deleteCategory(@PathParam("id") int id);
    
}
