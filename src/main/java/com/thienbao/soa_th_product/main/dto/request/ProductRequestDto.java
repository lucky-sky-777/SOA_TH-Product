package com.thienbao.soa_th_product.main.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thienbao.soa_th_product.common.annotation.DTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DTO
public class ProductRequestDto {

	@JsonProperty(value = "name")
	String name;

	@JsonProperty(value = "description")
	String description;

	@JsonProperty(value = "price")
	BigDecimal price;

	@JsonProperty(value = "quantity")
	Integer quantity;

	@JsonProperty(value = "updated_at")
	Instant updatedAt;

}