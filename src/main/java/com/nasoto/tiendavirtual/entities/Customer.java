package com.nasoto.tiendavirtual.entities;

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
@ToString(exclude = {"orders"})
@EqualsAndHashCode(exclude = {"orders"})
@Builder
@Entity
@Table(name = "DEMO_CUSTOMERS")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private Long Id;
	
	@Column(name = "CUST_FIRST_NAME")
	private String firstName;
	
	@Column(name = "CUST_LAST_NAME")
	private String lastName;

	@Column(name = "CUST_STREET_ADDRESS1")
	private String addres;
	
	@Column(name = "CUST_CITY")
	private String city;
	
	@Column(name = "CUST_STATE")
	private String state;
	
	@Column(name = "CUST_POSTAL_CODE" )
	private String postalCode;
	
	@Column(name = "PHONE_NUMBER1")
	private String phoneNumber;
	
	@Column(name = "CREDIT_LIMIT")
	private int credirLimit;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	@Cascade({CascadeType.DELETE})
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
	private  Set<Order> orders = new HashSet<Order>();

	public Customer(Long id, String firstName, String lastName) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
