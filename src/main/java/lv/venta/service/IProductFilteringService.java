package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilteringService {
	public abstract ArrayList<Product> filtredByPriceLess(float threshold) throws Exception;
	
	public abstract ArrayList<Product> filtredByQuantityLess(int threshold) throws Exception;
	
	public abstract ArrayList<Product> filtredByTitleOrDescriprion(String phrase);
	
	public abstract float calculateTotalValueOfProducts();
}
