package lv.venta.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IProductCRUDService;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@GetMapping("/one") //localhost:8080/product/crud/one?id=2
	public String getProductCRUDone(@RequestParam("id")int id, Model model) {
		try {
			Product foundProduct = crudService.retriveById(id);
			model.addAttribute("mydata", foundProduct);
			return "product-show-one-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
	
	
	
	
	
	
}
