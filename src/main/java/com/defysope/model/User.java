package com.defysope.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbluser")
public class User implements Serializable {

	private static final long serialVersionUID = 3254858222800347249L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbluser_cid_gen")
	@SequenceGenerator(name = "tbluser_cid_gen", sequenceName = "tbluser_cid_seq")
	@Column(name = "cid")
	private Integer id;

	private String userName;

	private String password;

	private String email;

	private String briefcasePassword;

	private boolean isSystemDisabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_user_roles", joinColumns = { @JoinColumn(name = "userid", referencedColumnName = "cid") }, inverseJoinColumns = { @JoinColumn(name = "roleid", referencedColumnName = "cid") })
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSystemDisabled() {
		return isSystemDisabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSystemDisabled(boolean isSystemDisabled) {
		this.isSystemDisabled = isSystemDisabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBriefcasePassword() {
		return briefcasePassword;
	}

	public void setBriefcasePassword(String briefcasePassword) {
		this.briefcasePassword = briefcasePassword;
	}

}
