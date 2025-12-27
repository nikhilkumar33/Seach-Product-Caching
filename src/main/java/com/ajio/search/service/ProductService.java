package com.ajio.search.service;

import com.ajio.search.request.ProductRequest;
import com.ajio.search.response.ProductResponse;

public interface ProductService 
{
	int saveProduct(ProductRequest productRequest);
	
	ProductResponse searchProductByName(String itemName);
}
