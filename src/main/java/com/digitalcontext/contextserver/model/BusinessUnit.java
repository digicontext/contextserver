package com.digitalcontext.contextserver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "business_units")
public class BusinessUnit {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	
	private Long id;
	
    @Column(name = "name")		
	private String name;
	
    @Column(name = "description")	    
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", insertable = false, updatable = false)
	private Account account;
	
    @Column(name = "status")		
	private int status;
	
	// TODO - Change to a Enum/Class
    @Column(name = "address")	    
	private String address;
	
    @Column(name = "logo")	   
	private String logo;
	
	@JsonIgnore	    
	@Column(name = "create_time", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date createTime;

	@JsonIgnore		
	@Column(name = "update_time", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String businessName) {
		this.name = businessName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String businessDescription) {
		this.description = businessDescription;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}	
	
	
}
