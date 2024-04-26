package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer> {
	
	// public abstract jau pec noklusejuma
	// SELECT * FROM product_table THERE title= 1 argumants AND description 2 arguments AND price= 3 arguments
	Product findByTitleAndDescriptionAndPrice(String title, String description, float price);
	
	// public abstract jau pec noklusejuma
	
	ArrayList<Product> findByPriceLessThan(float threshold);
	// public abstract jau pec noklusejuma
	
	ArrayList<Product> findByQuantityLessThan(int threshold);
	
	// public abstract jau pec noklusejuma
	ArrayList<Product> findByTitleIgnoreCaseLikeOrDescriptionIgnoreCaseLike(String phrase, String phrase2);
	
	// public abstract jau pec noklusejuma
	// bet vaicajumu vaidojam pasi
	@Query(nativeQuery = true, value = "SELECT SUM(price * quantity) FROM product_table;")
	float calculateTotalValueFromRepoProducts();
	
	
	
}
