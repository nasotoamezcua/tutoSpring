package com.nasoto.tiendavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CustomerDto {
	
	private Long idCustomer;
	private String firstName;
	private String lastName;
	private String addres;
	private String city;
	private String state;
	private String postalCode;
	private String phoneNumber;
	private int credirLimit;
	
	
	public CustomerDto(Long idCustomer, String firstName, String lastName) {
		super();
		this.idCustomer = idCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
