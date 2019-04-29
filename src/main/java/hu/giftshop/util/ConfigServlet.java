
package hu.giftshop.util;

//import hu.giftshop.repository.IAddressRepositoryLocal;
import hu.giftshop.repository.IAddressRepositoryLocal;
import hu.giftshop.repository.ICategoryRepositoryLocal;
import hu.giftshop.repository.ICustomerOrderRepositoryLocal;
import hu.giftshop.repository.ICustomerRepositoryLocal;
import hu.giftshop.repository.IOrderProductRepositoryLocal;
import hu.giftshop.repository.IProductRepositoryLocal;
import java.util.HashMap;
import java.util.Locale;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class ConfigServlet extends HttpServlet {
    
    private static HashMap<String, Object> localInterfaces = new HashMap<String, Object>();
    
    @EJB
    private ICategoryRepositoryLocal categoryRepositoryLocal;
    
    @EJB
    private IAddressRepositoryLocal addressRepositoryLocal;
    
    @EJB
    private IProductRepositoryLocal productRepositoryLocal;
     
    @EJB
    private ICustomerRepositoryLocal customerRepositoryLocal;
    
    @EJB
    private IOrderProductRepositoryLocal orderProductRepositoryLocal;
    
    @EJB
    private ICustomerOrderRepositoryLocal customerOrderRepositoryLocal;
    
    @Override
    public void init() throws ServletException {
        System.out.println("------Starting app------");
        
        localInterfaces.put(ICategoryRepositoryLocal.class.getName(), categoryRepositoryLocal);       
        localInterfaces.put(IAddressRepositoryLocal.class.getName(), addressRepositoryLocal);
        localInterfaces.put(IProductRepositoryLocal.class.getName(), productRepositoryLocal);
        localInterfaces.put(ICustomerRepositoryLocal.class.getName(), customerRepositoryLocal);
        localInterfaces.put(IOrderProductRepositoryLocal.class.getName(), orderProductRepositoryLocal);
        localInterfaces.put(ICustomerOrderRepositoryLocal.class.getName(), customerOrderRepositoryLocal);
        
        Locale.setDefault(new Locale("hu", "HU"));
    }
    
    static HashMap<String, Object> getLocalInterfaces() {
        return localInterfaces;
    }
    
    
    
}
