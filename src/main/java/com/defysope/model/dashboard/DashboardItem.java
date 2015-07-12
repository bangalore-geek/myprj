package com.defysope.model.dashboard;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity()
@Table(name = "dashboard_items")
public class DashboardItem {

	@Id
	private String name;

	@ManyToMany(targetEntity = DashboardType.class, fetch = FetchType.EAGER)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	@JoinTable(name = "dashboard_type_items", joinColumns = { @JoinColumn(name = "item") }, inverseJoinColumns = { @JoinColumn(name = "typeName") })
	private Set<DashboardType> types;

	private String caption;

	private boolean enabled;

	private String featureCode;

	private int span;

	private int height;

	@Column(name = "showoptions")
	private boolean optionsEnabled;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DashboardType> getTypes() {
		return types;
	}

	public void setTypes(Set<DashboardType> types) {
		this.types = types;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public int getSpan() {
		return span;
	}

	public void setSpan(int span) {
		this.span = span;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isOptionsEnabled() {
		return optionsEnabled;
	}

	public void setOptionsEnabled(boolean optionsEnabled) {
		this.optionsEnabled = optionsEnabled;
	}

}
