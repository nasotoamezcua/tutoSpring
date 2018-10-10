package com.nasoto.tiendavirtual.service.assembler;

import org.springframework.stereotype.Component;

import com.nasoto.tiendavirtual.dto.RolesDto;
import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.entities.Roles;
import com.nasoto.tiendavirtual.entities.User;

@Component("rolesAssembler")
public class RolesAssembler extends Assembler<RolesDto, Roles> {

	@Override
	public RolesDto getDTOTransform(Roles mapping) {
		
		UserDto userDto = new UserDto(mapping.getUser().getName(), mapping.getUser().getPassword(), 
								mapping.getUser().getCreate(), mapping.getUser().getProducts(), 
								mapping.getUser().getActive());
		
		RolesDto rolesDto = RolesDto.builder()
				.idRoles(mapping.getId())
				.nameRol(mapping.getNameRol())
				.userDto(userDto)
				.build();
		
		return rolesDto;
	}

	@Override
	public Roles getMappingTransform(RolesDto dto) {
		
		User user = new User(dto.getUserDto().getNameUser(), dto.getUserDto().getPasswordUser(), 
							dto.getUserDto().getCreateUser(), dto.getUserDto().getProductsUser(), 
							dto.getUserDto().getActiveUser());
		
		Roles rolesEntity = Roles.builder()
				.id(dto.getIdRoles())
				.nameRol(dto.getNameRol())
				.user(user)
				.build();
		
		return rolesEntity;
	}

}
