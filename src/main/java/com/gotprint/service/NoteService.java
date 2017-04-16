package com.gotprint.service;

import java.util.List;

import com.gotprint.model.NoteDto;

/**
 * This interface contains all the methods for CRUD operations of note
 * This interface takes input from rest controller and pass them to NoteRepository 
 * @author piyushpcegarg
 *
 */

public interface NoteService {
	
	public List<NoteDto> getAllNotes(NoteDto noteDto);
	
	public NoteDto getNoteByNoteId(NoteDto noteDto);
	
	public NoteDto saveNote(NoteDto noteDto);
	
	public void updateNote(NoteDto noteDto);

}
