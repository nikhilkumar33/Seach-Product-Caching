package com.ajio.search.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajio.search.entiity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>
{
	ProductEntity findByItemName(String itemName);
}
