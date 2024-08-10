package com.example.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
		
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> getAll() {
		//iş kuralları
		return brandRepository.findAll();
	}

}
