package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Brand;

//@Repository annotasyonunu yazmamıza gerek yoktur çünkü spring in içinde olan 
//jpa repositoryi extend ettiğimiz için spring bunun bir repository olduğunu anlar.
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	boolean existsByName(String name); //spring jpa keywords
}
