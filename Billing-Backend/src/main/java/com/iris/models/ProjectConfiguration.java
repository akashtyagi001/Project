package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Config")
public class ProjectConfiguration {
	@Id
	@GeneratedValue
	@Column(name="ConfigId")
	private int configurationId;
	@Column(name="perhourbilling")
	private int bill;
	@Column(name="Loc")
	private String location;
	@ManyToOne
	@JoinColumn(name="RoleId")
	Role RoleObj;
	@ManyToOne
	@JoinColumn(name="ProjectId")
	Project ProjObj;
	
	public int getConfigurationId() {
		return configurationId;
	}
	public void setConfigurationId(int configurationId) {
		this.configurationId = configurationId;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Role getRoleObj() {
		return RoleObj;
	}
	public void setRoleObj(Role roleObj) {
		RoleObj = roleObj;
	}
	public Project getProjObj() {
		return ProjObj;
	}
	public void setProjObj(Project projObj) {
		ProjObj = projObj;
	}
	
	
	
	
	
	
	
	
	
}
