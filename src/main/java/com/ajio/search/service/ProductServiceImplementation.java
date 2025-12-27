package com.ajio.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ajio.search.entiity.ProductEntity;
import com.ajio.search.exception.ProductNotFoundException;
import com.ajio.search.repository.ProductRepository;
import com.ajio.search.request.ProductRequest;
import com.ajio.search.response.ProductResponse;

@Service
public class ProductServiceImplementation implements ProductService 
{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public int saveProduct(ProductRequest productRequest) {
		ProductEntity entity = new ProductEntity();
		entity.setItemName(productRequest.getItemName());
		entity.setPrice(productRequest.getPrice());
		entity.setQty(productRequest.getQty());
		entity.setDescription(productRequest.getDescription());
		
		entity = productRepository.save(entity);
		return entity.getProductId();
	}

	@Cacheable(value="products", key="#itemName", unless="#result == null" )
	@Override
	public ProductResponse searchProductByName(String itemName) {
		
		ProductEntity entity = productRepository.findByItemName(itemName);
		if(entity == null) {
			throw new ProductNotFoundException("No product found.. "+itemName);
		}
		ProductResponse response=new ProductResponse();
		response.setItemName(entity.getItemName());
		response.setPrice(entity.getPrice());
		response.setDescription(entity.getDescription());
		
		return response;
	}

}
