package com.nasoto.tiendavirtual.service.assembler;

import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.entities.Customer;

@Component("customerAssembler")
public class CustomerAssembler extends Assembler<CustomerDto, Customer> {

	@Override
	public CustomerDto getDTOTransform(Customer mapping) {
		
		CustomerDto customerDto = CustomerDto.builder()
				.idCustomer(mapping.getId())
				.firstName(mapping.getFirstName())
				.lastName(mapping.getLastName())
				.addres(mapping.getAddres())
				.city(mapping.getCity())
				.state(mapping.getState())
				.postalCode(mapping.getPostalCode())
				.phoneNumber(mapping.getPhoneNumber())
				.credirLimit(mapping.getCredirLimit())
				.build();
		
		return customerDto;
	}

	@Override
	public Customer getMappingTransform(CustomerDto dto) {
		
		Customer custEntity = Customer.builder()
				.Id(dto.getIdCustomer())
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.addres(dto.getAddres())
				.city(dto.getCity())
				.state(dto.getState())
				.postalCode(dto.getPostalCode())
				.phoneNumber(dto.getPhoneNumber())
				.credirLimit(dto.getCredirLimit())
				.build();
		
		return custEntity;
	}

}
