
package hu.giftshop.rest.impl;

import hu.giftshop.controller.OrderProductController;
import hu.giftshop.dto.OrderProductDto;
import hu.giftshop.rest.IOrderProductResoure;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author szotyi
 */
@RequestScoped
public class IOrderProductResourceImpl implements IOrderProductResoure {

    @EJB
    private OrderProductController orderProductController;
    
    @Override
    public List<OrderProductDto> getAllOrderProducts() {
        return orderProductController.getAllOrderProducts();
    }  
     
    
    
}
