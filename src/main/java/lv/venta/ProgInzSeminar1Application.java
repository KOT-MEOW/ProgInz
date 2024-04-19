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
				
				Product p1 = new Product("productThree", 0.99f, "mas", 3);
				Product p2 = new Product("producttwo", 1.99f, "was", 2);
				Product p3 = new Product("productOne", 2.99f, "kas", 1);
				
				productRepo.save(p1);
				productRepo.save(p2);
				productRepo.save(p3);
				
				
			}
		};
		
		
	}
	
	
}
