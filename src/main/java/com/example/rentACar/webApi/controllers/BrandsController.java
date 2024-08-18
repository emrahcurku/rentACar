package com.example.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
 
	private BrandService brandService;

//	@Autowired
//	public BrandsController(BrandService brandService) {
//		this.brandService = brandService;
//	}
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	/*Spring'in yeni versiyonlarında birçok annotasyon otomatik olarak gelir.
	  Örneğin @RequestBody annotasyonunu kullanmasak da swagger de post işlemi yapabiliriz */
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest){
		this.brandService.add(createBrandRequest);
	}
	
}
