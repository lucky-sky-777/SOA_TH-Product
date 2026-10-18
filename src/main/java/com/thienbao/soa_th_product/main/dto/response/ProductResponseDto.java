package com.thienbao.soa_th_product.main.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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

@JsonPropertyOrder(value = {
		"id",
		"name",
		"description",
		"price",
		"quantity",
		"created_at",
		"updated_at"
})
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DTO
public class ProductResponseDto {

	@JsonProperty(value = "id")
	Long id;

	@JsonProperty(value = "name")
	String name;

	@JsonProperty(value = "description")
	String description;

	@JsonProperty(value = "price")
	BigDecimal price;

	@JsonProperty(value = "quantity")
	Integer quantity;

	@JsonProperty(value = "created_at")
	Instant createdAt;

	@JsonProperty(value = "updated_at")
	Instant updatedAt;

}