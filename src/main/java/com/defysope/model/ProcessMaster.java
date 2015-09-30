package com.defysope.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cy_ts_process_master")
public class ProcessMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cy_ts_process_master_process_id_gen")
	@SequenceGenerator(name = "cy_ts_process_master_process_id_gen", sequenceName = "cy_ts_process_master_process_id_gen")
	@Column(name = "process_id")
	private Integer id;
	
	private String name;
	private String descriptipon;
	private Integer productId;
	private Integer sequence;

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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
}
