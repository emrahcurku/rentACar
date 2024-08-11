package com.example.rentACar.business.abstracts;

import java.util.List;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
