package com.ajio.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajio.search.request.ProductRequest;
import com.ajio.search.service.ProductService;

@Controller
public class ProductController
{
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	@ResponseBody
	public ResponseEntity<String> addProduct(@RequestBody ProductRequest productRequest)
	{
		System.out.println("xyx");
		int productId = productService.saveProduct(productRequest);
		return ResponseEntity.ok("Product added successfully.. Product id is : "+productId);
	}
}
