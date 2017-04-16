package com.gotprint.model;

import java.io.Serializable;

/**
 * This is data transfer object for note. This is used to transfer data from 
 * controller to service layer and vice versa.
 * @author piyushpcegarg
 */

public class NoteDto implements Serializable {
	
	private static final long serialVersionUID = 1600246150164593355L;
	
	private long noteId;
	private long userId;
	private String noteTitle;
	private String noteDescription;
	
	public long getNoteId() {
		return noteId;
	}
	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteDescription() {
		return noteDescription;
	}
	public void setNoteDescription(String noteDescription) {
		this.noteDescription = noteDescription;
	}
}
