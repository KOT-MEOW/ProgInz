package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {
	// public abstract jau pec noklusejuma
	// SELECT * FROM product_table THERE title= 1 argumants AND description 2 arguments AND price= 3 arguments
	Product findByTitleAndDescriptionAndPrice(String title, String description, float price);
	
	
	
}
