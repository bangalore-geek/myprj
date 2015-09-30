package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cy_ts_product_master")
public class ProductMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cy_ts_product_master_product_id_gen")
	@SequenceGenerator(name = "cy_ts_product_master_product_id_gen", sequenceName = "cy_ts_product_master_product_id_seq")
	@Column(name = "product_id")
	private Integer id;
	private String name;
	private String descriptipon;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptipon() {
		return descriptipon;
	}
	public void setDescriptipon(String descriptipon) {
		this.descriptipon = descriptipon;
	}
}
