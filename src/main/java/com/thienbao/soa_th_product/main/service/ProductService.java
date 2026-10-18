package com.thienbao.soa_th_product.main.service;

import com.thienbao.soa_th_product.main.dto.request.ProductRequestDto;
import com.thienbao.soa_th_product.main.dto.response.ProductIdResponseDto;
import com.thienbao.soa_th_product.main.dto.response.ProductResponseDto;
import com.thienbao.soa_th_product.main.entity.Product;
import com.thienbao.soa_th_product.common.exception.entity.GlobalException;
import com.thienbao.soa_th_product.main.mapper.ProductMapper;
import com.thienbao.soa_th_product.main.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class ProductService {

	ProductRepository productRepository;
	ProductMapper productMapper;

	@Transactional(readOnly = true)
	public List<ProductResponseDto> getList() {
		return productMapper.toProductResponseDtoList(
				productRepository.findAll()
		);
	}

	@Transactional(readOnly = true)
	public ProductResponseDto get(Long id) {
		return productMapper.toProductResponseDto(
				findByIdOrThrow(id)
		);
	}

	@Transactional
	public ProductResponseDto create(ProductRequestDto request) {
		Product newProduct = productMapper.toProduct(request);
		Product responseProduct = save(newProduct);
		return productMapper.toProductResponseDto(responseProduct);
	}

	@Transactional
	public ProductResponseDto update(
			Long id,
			ProductRequestDto request
	) {
		Product currentProduct = findByIdOrThrow(id);
		productMapper.updateProductFromRequestDto(request, currentProduct);
		Product responseProduct = save(currentProduct);
		return productMapper.toProductResponseDto(responseProduct);
	}

	@Transactional
	public ProductIdResponseDto delete(Long id) {
		Product currentProduct = findByIdOrThrow(id);
		delete(currentProduct);
		return new ProductIdResponseDto(
				currentProduct.getId()
		);
	}

	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Transactional
	public Product findByIdOrThrow(Long id) {
		return productRepository
				.findById(id)
				.orElseThrow(() ->
						new GlobalException(GlobalException.Type.NOT_FOUND)
				);
	}

}