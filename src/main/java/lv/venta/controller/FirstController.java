package lv.venta.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;


@Controller
public class FirstController {

		@GetMapping("/hello")	//localhost:8080/hello
		public String getHello() {
			System.out.println("First controller works");
			return "hello-page"; //tiks paradita hello-page.html lapa
		}
	
		//TODO uztaisit plasaku html lapu
		//TODO jaunu konteineru funkciju, kas parada citu html lapu
	
		
		Random rand = new Random();
		@GetMapping("/hello/msg") //localhost:8080/hello/msg
		public String getHelloMsg(Model model) {
			model.addAttribute("mydata", "Zina no Ilja -> " + rand.nextInt(0,100));
			return "hello-msg-page"; //tiks paratida hello-msg-page.html, ar padotiem datiem
		}
		
		//TODO izveidot kontrollera funkciju kur caur model pados Jusu izveidoto produktu
	
		@GetMapping("/product/test") //localhost:8080/product/test
		public String getProductTest(Model model) {
			Product product = new Product("Abols", 0.99f, "Sarkans", 4);
			model.addAttribute("mydata", product);
			return "product-show-one-page"; //tiks paradita product-show-one-page.html lapa
		}
	
		//TODO izveidot controllera funkcija kura ieksiene uztaisit 3 produktus
		// uz salikt tos saraksta. Ka mydaya iedot so satrakstu
		// paradit hmtl lapa
	
		
		@GetMapping("/product/moreproducts")	//localhost:8080/product/moreproducts
		public String getMoreProducts(Model model) {
			
			ArrayList<Product> allProducts = new ArrayList<>();
			
			Product productN1 = new Product("meme1", 1.99f, "Sarkans", 3);
			Product productN2 = new Product("meme2", 2.99f, "Heheh", 2);
			Product productN3 = new Product("meme3", 3.99f, ":O", 1);
			
			allProducts.add(productN1);
			allProducts.add(productN2);
			allProducts.add(productN3);
			
			model.addAttribute("mydata", allProducts);
			return "more-product-in-page";
		}
		
		
		
		
		
		
	
}
