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
@Table(name = "contexts")
public class Context {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	
	private Long id;
	
	@Column(name = "context_id")	
	private String contextId;	
	
	@Column(name = "name")		
	private String name;

	@Column(name = "description")			
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type")	
	private ContextType contextType;
			
	@Column(name = "status")				
	private int status;
	
	@Column(name = "landing_page")	
	private String landingPage;
	
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
	public String getContextId() {
		return contextId;
	}
	public void setContextId(String id) {
		this.contextId = id;
	}
	public String getLandingPage() {
		return landingPage;
	}
	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
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
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	
	public ContextType getContextType() {
		return contextType;
	}
	public void setContextType(ContextType contextType) {
		this.contextType = contextType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contextId == null) ? 0 : contextId.hashCode());
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
		Context other = (Context) obj;
		if (contextId == null) {
			if (other.contextId != null)
				return false;
		} else if (!contextId.equals(other.contextId))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Context [id=" + id + ", contextId=" + contextId + ", name="
				+ name + ", description=" + description + ", contextType="
				+ contextType
				+ ", status=" + status
				+ ", landingPage=" + landingPage + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
	
	
}
