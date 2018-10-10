package com.nasoto.tiendavirtual.service.assembler;

import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.entities.User;

@Component("userAssembler")
public class UserAssembler extends Assembler<UserDto, User> {

	@Override
	public UserDto getDTOTransform(User mapping) {
		UserDto udto = UserDto.builder()
				.idUser(mapping.getId())
				.nameUser(mapping.getName())
				.passwordUser(mapping.getPassword())
				.createUser(mapping.getCreate())
				.productsUser(mapping.getProducts())
				.activeUser(mapping.getActive()).build();
		return udto;
	}

	@Override
	public User getMappingTransform(UserDto dto) {
		User entity = User.builder()
				.id(dto.getIdUser())
				.name(dto.getNameUser())
				.password(dto.getPasswordUser())
				.create(dto.getCreateUser())
				.products(dto.getProductsUser())
				.active(dto.getActiveUser()).build();
		return entity;
	}

}
