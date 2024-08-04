package com.example.rentACar.dataAccess.abstracts;

import java.util.List;

import com.example.rentACar.entities.concretes.Brand;


public interface BrandRepository {
	
	List<Brand> getAll();

}
