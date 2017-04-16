package com.gotprint.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * This class is the model class for USER_MST table
 * @author piyushpcegarg
 */
@Entity
@Table(name = "USER_MST", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL_ID"))
public class UserMst implements Serializable {

	private static final long serialVersionUID = -562415707620699766L;
	
	private long userId;
	private String emailId;
	private String password;
	private Date creationTime;
	private Date lastUpdateTime;
	private Set<Note> notes = new HashSet<Note>(0);
	
	public UserMst() {
	}
	
	public UserMst(long userId) {
		this.userId = userId;
	}
	
	@Id

	@Column(name = "USER_ID", unique = true, nullable = false, precision = 18, scale = 0)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "EMAIL_ID", unique = true, nullable = false, length = 120)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "PASSWORD", nullable = false, length = 120)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_TIME", nullable = false, length = 7)
	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATE_TIME", length = 7)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userMst")
	public Set<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
	
}
