package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

//service annotayonunu yazmamıza gerek vardır çünkü burada spring in 
//kendi içinde olan herhangi bir şeyi extend veya implement etmiyoruz
@Service
@AllArgsConstructor
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	//@AllArgsConstructor annotasyonunu eklersek aşağıdaki gibi
	//Constructorı oluşturmamıza gerek yoktur
//	@Autowired
//	public BrandManager(BrandRepository brandRepository) {
//		this.brandRepository = brandRepository;
//	}

	@Override
	public List<GetAllBrandsResponse> getAll() {
		//iş kuralları
		List<Brand> brands = brandRepository.findAll();
		
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			brandsResponse.add(responseItem);
//		}
		//yukarıdaki kod silinip aşağıdaki kod ile düzenlendi
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
		.map(brand-> this.modelMapperService.forResponse()
		.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
//		Brand brand = new Brand();
//		brand.setName(createBrandRequest.getName());
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);	
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		
		Brand brand = this.brandRepository.findById(id).orElseThrow();

		GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
		
		return getByIdBrandResponse;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

		this.brandRepository.save(brand);	
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);		
	}
}
