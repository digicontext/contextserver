package com.digitalcontext.contextserver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	
	private Long id;

	@Column(name = "name")		
	private String name;

	@Column(name = "description")			
	private String description;
	
	@Column(name = "status")				
	private int status;
	
	@JsonIgnore		
	@Column(name = "create_time", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date createTime;

	@JsonIgnore		
	@Column(name = "update_time", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date updateTime;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
