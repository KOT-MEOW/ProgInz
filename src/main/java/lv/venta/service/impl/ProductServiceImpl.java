package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;
import lv.venta.service.IProductFilteringService;

@Service
public class ProductServiceImpl implements IProductCRUDService, IProductFilteringService {
	
	@Autowired
	private IProductRepo productRepo;
	
	
	

	@Override
	public ArrayList<Product> filtredByPriceLess(float threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filtredByQuantityLess(int threshold) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> filtredByTitleOrDescriprion(String phrase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateTotalValueOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create(Product product) {
		
		Product existedProduct = productRepo.findByTitleAndDescriptionAndPrice(product.getTitle(),product.getDescription(),product.getPrice());
		
		if(existedProduct != null) {
			existedProduct.setQuantity(existedProduct.getQuantity() + product.getQuantity());
			productRepo.save(existedProduct);
			return;
		} 
		productRepo.save(product);
	}

	@Override
	public Product retriveById(int id) throws Exception{
		if(id < 0) throw new Exception("id cant be negaative");
		
		if(productRepo.existsById(id)) { 
			return productRepo.findById(id).get();
		} else {
			throw new Exception("That id not exists in system");
		}
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(productRepo.count() == 0) throw new Exception("There is no product in the db");
	
		return (ArrayList<Product>) productRepo.findAll();
	}

	@Override
	public void updateById(int id, Product product) throws Exception {
		Product productForUpdate = retriveById(id);
		
		productForUpdate.setTitle(product.getTitle());
		productForUpdate.setDescription(product.getDescription());
		productForUpdate.setPrice(product.getPrice());
		productForUpdate.setQuantity(productForUpdate.getQuantity());
		
		productRepo.save(productForUpdate);
	}

	@Override
	public void deleteById(int id) throws Exception {
		Product productForDeleting = retriveById(id);
		productRepo.delete(productForDeleting);
	}
	
}
