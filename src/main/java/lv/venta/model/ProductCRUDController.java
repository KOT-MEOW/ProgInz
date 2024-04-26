package lv.venta.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud/")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService crudService;

	
	
	@GetMapping("/all") //localhost:8080/product/crud/all
	public String getProdctCRUDAll(Model model) {
		try {
			model.addAttribute("mydata", crudService.retrieveAll());
			return "more-product-in-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
	
	
	
	
	
}
