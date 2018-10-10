package com.nasoto.tiendavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolesDto {
	
	private Long idRoles;
	private String nameRol;
	private UserDto userDto;

}
