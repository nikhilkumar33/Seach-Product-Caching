package com.ajio.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajio.search.response.ProductResponse;
import com.ajio.search.service.ProductService;

@RestController
public class SearchController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/searchProductByName")
	public ResponseEntity searchProductByName(@RequestParam String itemName)
	{
		ProductResponse response = productService.searchProductByName(itemName);
		return ResponseEntity.ok(response);
	}
}
