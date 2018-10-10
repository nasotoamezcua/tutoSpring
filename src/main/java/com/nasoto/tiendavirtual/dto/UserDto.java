package com.nasoto.tiendavirtual.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private Long idUser;
	private String nameUser;
	private String passwordUser;
	@Temporal(TemporalType.DATE)
	private Date createUser;
	private String productsUser;
	private int activeUser;
	
	
	public UserDto(String nameUser, String passwordUser, Date createUser, String productsUser, int activeUser) {
		super();
		this.nameUser = nameUser;
		this.passwordUser = passwordUser;
		this.createUser = createUser;
		this.productsUser = productsUser;
		this.activeUser = activeUser;
	}

}
