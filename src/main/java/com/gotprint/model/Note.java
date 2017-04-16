package com.gotprint.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class is the model class for NOTE table
 * @author piyushpcegarg
 */
@Entity
@Table(name = "NOTE")
public class Note implements java.io.Serializable {

	
	private static final long serialVersionUID = -1395335352973156308L;
	
	private long noteId;
	private UserMst userMst;
	private String noteTitle;
	private String noteDescription;
	private Date creationTime;
	private Date lastUpdateTime;

	public Note() {
	}

	public Note(long noteId, UserMst userMst, String noteTitle, Date creationTime) {
		this.noteId = noteId;
		this.userMst = userMst;
		this.noteTitle = noteTitle;
		this.creationTime = creationTime;
	}

	public Note(long noteId, UserMst userMst, String noteTitle, String noteDescription, Date creationTime,
			Date lastUpdateTime) {
		this.noteId = noteId;
		this.userMst = userMst;
		this.noteTitle = noteTitle;
		this.noteDescription = noteDescription;
		this.creationTime = creationTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	@Id
	@GeneratedValue
	@Column(name = "NOTE_ID", unique = true, nullable = false, precision = 18, scale = 0)
	public long getNoteId() {
		return this.noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public UserMst getUserMst() {
		return this.userMst;
	}

	public void setUserMst(UserMst userMst) {
		this.userMst = userMst;
	}

	@Column(name = "NOTE_TITLE", nullable = false, length = 50)
	public String getNoteTitle() {
		return this.noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	@Column(name = "NOTE_DESCRIPTION", length = 1000)
	public String getNoteDescription() {
		return this.noteDescription;
	}

	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
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

}
