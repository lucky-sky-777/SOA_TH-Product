package com.thienbao.soa_th_product.main.mapper;

import com.thienbao.soa_th_product.common.config.MapStructConfig;
import com.thienbao.soa_th_product.main.dto.request.ProductRequestDto;
import com.thienbao.soa_th_product.main.dto.response.ProductResponseDto;
import com.thienbao.soa_th_product.main.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {

	Product toProduct(ProductRequestDto productRequestDto);

	ProductResponseDto toProductResponseDto(Product product);

	@BeanMapping(
			nullValuePropertyMappingStrategy
					= NullValuePropertyMappingStrategy.IGNORE
	)
	void updateProductFromRequestDto(
			ProductRequestDto productRequestDto,
			@MappingTarget Product product
	);

	default List<ProductResponseDto> toProductResponseDtoList(
			List<Product> productList
	) {
		return productList
				.stream()
				.map(this::toProductResponseDto)
				.toList();
	}

}