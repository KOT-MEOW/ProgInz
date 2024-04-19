package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductCRUDService {
	
	public abstract void create(Product product);
	
	public abstract Product retriveById(int id);
	
	public abstract ArrayList<Product> retrieveAll();
	
	public abstract void updateById(int id, Product product);
	
	public abstract void deleteById(int id);
}
