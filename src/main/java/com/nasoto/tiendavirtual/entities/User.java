package com.nasoto.tiendavirtual.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles","orders"})
@EqualsAndHashCode(exclude = {"roles","orders"})
@Builder
@Entity
@Table(name = "DEMO_USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "USER_NAME")
	private String name;
	@Column(name = "PASSWORD")
	private String password;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON" )
	private Date create;
	@Column(name = "PRODUCTS")
	private String products;
	@Column(name = "ACTIVE")
	private int active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Cascade({CascadeType.DELETE})
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
	private Set<Roles> roles = new HashSet<Roles>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
	private Set<Order> orders = new HashSet<Order>();

	public User(String name, String password, Date create, String products, int active) {
		super();
		this.name = name;
		this.password = password;
		this.create = create;
		this.products = products;
		this.active = active;
	}
	
	

}
