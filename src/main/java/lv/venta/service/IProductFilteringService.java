package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilteringService {
	public abstract ArrayList<Product> filtredByPriceLess(float threshold);
	
	public abstract ArrayList<Product> filtredByQuantityLess(int threshold);
	
	public abstract ArrayList<Product> filtredByTitleOrDescriprion(String phrase);
	
	public abstract float calculateTotalValueOfProducts();
}
