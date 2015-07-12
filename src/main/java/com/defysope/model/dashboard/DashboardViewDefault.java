package com.defysope.model.dashboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_view_default")
public class DashboardViewDefault {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "dashboard_view_default_cid_gen")
	@SequenceGenerator(name = "dashboard_view_default_cid_gen", sequenceName = "dashboard_view_default_cid_seq")
	@Column(name = "cid")
	private int id;

	@Column(name = "typeName")
	private String type;

	private String item;

	@Column(name = "rowNumber")
	private int row;

	@Column(name = "columnNumber")
	private int column;

	private int height;

	@Column(name = "viewOptions")
	private String options;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

}
