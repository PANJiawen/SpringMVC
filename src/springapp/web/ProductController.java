package springapp.web;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springapp.business.ProductManager;
import springapp.model.Product;

@Controller()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductManager manager;

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listProducts() {
        logger.info("List of products");
        Collection<Product> products = manager.findAll();
        return new ModelAndView("productsList", "products", products);
    }

}