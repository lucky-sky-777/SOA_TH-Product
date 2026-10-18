package com.thienbao.soa_th_product.main.controller;

import com.thienbao.soa_th_product.common.dto.ResponseDTO;
import com.thienbao.soa_th_product.main.dto.request.ProductRequestDto;
import com.thienbao.soa_th_product.main.dto.response.ProductIdResponseDto;
import com.thienbao.soa_th_product.main.dto.response.ProductResponseDto;
import com.thienbao.soa_th_product.main.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	ProductService productService;

	@GetMapping()
	public void test() {
		System.out.println("authenticated");
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<ProductResponseDto>>> getList() {
		List<ProductResponseDto> response = productService.getList();
		return ResponseEntity.ok(
				ResponseDTO.ok(
						"Get product list successful",
						response
				)
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<ProductResponseDto>> get(
			@PathVariable Long id
	) {
		ProductResponseDto response = productService.get(id);
		return ResponseEntity.ok(
				ResponseDTO.ok(
						"Get product successful",
						response
				)
		);
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<ProductResponseDto>> create(
			@RequestBody ProductRequestDto request
	) {
		ProductResponseDto response = productService.create(request);
		return ResponseEntity.ok(
				ResponseDTO.ok(
						"Create product successful",
						response
				)
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<ProductResponseDto>> update(
			@PathVariable Long id,
			@RequestBody ProductRequestDto request
	) {
		ProductResponseDto response = productService.update(id, request);
		return ResponseEntity.ok(
				ResponseDTO.ok(
						"Update product successful",
						response
				)
		);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<ProductIdResponseDto>> delete(
			@PathVariable Long id
	) {
		ProductIdResponseDto response = productService.delete(id);
		return ResponseEntity.ok(
				ResponseDTO.ok(
						"Delete product successful",
						response
				)
		);
	}

}