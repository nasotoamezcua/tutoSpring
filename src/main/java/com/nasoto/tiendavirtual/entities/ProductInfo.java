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
@ToString(exclude = {"OrderItems"})
@EqualsAndHashCode(exclude = {"OrderItems"})
@Builder
@Entity
@Table(name = "DEMO_PRODUCT_INFO")
public class ProductInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long id;
	
	@Column(name = "PRODUCT_NAME")
	private String name;
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String description;
	
	@Column(name = "CATEGORY" )
	private String category;
	
	@Column(name = "PRODUCT_AVAIL")
	private String avail;
	
	@Column(name = "LIST_PRICE")
	private int price;
	
	@Column(name = "MIMETYPE")
	private String type;
	
	@Column(name = "FILENAME")
	private String fileName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "IMAGE_LAST_UPDATE")
	private Date dateUpdate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productInfo")	
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
	private Set<OrderItems> OrderItems = new HashSet<OrderItems>();
	
	
	public ProductInfo(Long id, String name, String description, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
	}

}
