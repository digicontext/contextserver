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
@Table(name = "users")
public class User {
	
	@JsonIgnore			
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")		
	private Integer id;
	
	@Column(name = "user_id")			
	private String userId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "primary_auth_type")		
	private AuthenticationType authType;
	
	@Column(name = "user_details")			
	private String userDetails;

	@Column(name = "company")					
	private String company;
	
	@Column(name = "interests")					
	private String interests;
	
	@JsonIgnore
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public AuthenticationType getAuthType() {
		return authType;
	}
	public void setAuthType(AuthenticationType authType) {
		this.authType = authType;
	}
	public String getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authType == null) ? 0 : authType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authType == null) {
			if (other.authType != null)
				return false;
		} else if (!authType.equals(other.authType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userDetails=" + userDetails
				+ ", company=" + company + ", interests=" + interests + "]";
	}
	
}
