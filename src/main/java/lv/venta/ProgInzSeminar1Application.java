package lv.venta;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class ProgInzSeminar1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDatabase(IProductRepo productRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO izveidot 3 produktus
				// ar save funkciju saglabat
				
				//izsaukt caur repo count()
				//izsaukt caur repo findById()
				//izsaukt update cour repo
				
				
				Product p11 = new Product("productTen", 0.99f, "aaaa", 3);
				Product p22 = new Product("productEleven", 1.99f, "bbb", 2);
				Product p33 = new Product("productTwelve", 2.99f, "cccc", 1);
				
				productRepo.save(p11);
				productRepo.save(p22);
				productRepo.save(p33);
				
				System.out.println("how many product " + productRepo.count());
				System.out.println("get product by id (102): " + productRepo.findById(3).get());
				/*
				Product productForDeliting = productRepo.findById(2).get();
				productRepo.delete(productForDeliting);
				Product productForUpdate = productRepo.findById(3).get();
				productForUpdate.setPrice(5.99f);
				productRepo.save(productForUpdate);
				*/
				
			}
		};
		
		
	}
	
	
}
