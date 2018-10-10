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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString(exclude = {"customer","OrderItems", "user"})
@EqualsAndHashCode(exclude = {"customer","OrderItems","user"})
@Builder
@Entity
@Table(name = "DEMO_ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private  Customer customer;
	
	@Column(name = "ORDER_TOTAL" )
	private int orderTotal;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_TIMESTAMP")
	private Date timeStamp;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	@Cascade({CascadeType.DELETE})
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
	private  Set<OrderItems> OrderItems = new HashSet<OrderItems>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
}
