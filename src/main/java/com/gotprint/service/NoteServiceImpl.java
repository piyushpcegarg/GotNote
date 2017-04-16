package com.gotprint.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gotprint.dao.NoteRepository;
import com.gotprint.model.Note;
import com.gotprint.model.NoteDto;
import com.gotprint.model.UserMst;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	/**
	 * This method take user details (userId) from the user and fetch all the notes associated with him
	 * userId is primary key of user_mst table
	 * User can fetch notes related to him
	 * @param noteDto
	 */
	
	public List<NoteDto> getAllNotes(NoteDto noteDto) {
		// Create new UserMst object to set userId in UserMst object
		UserMst userMst = new UserMst(noteDto.getUserId());
		List<Note> notes = noteRepository.findByUserMst(userMst);
		List<NoteDto> noteDtoList = new ArrayList<NoteDto>();
		NoteDto noteDTO = null;
		for(Note note : notes) {
			noteDTO = new NoteDto();
			BeanUtils.copyProperties(note, noteDTO);
			noteDTO.setUserId(note.getUserMst().getUserId());
			noteDtoList.add(noteDTO);	
		}
		return noteDtoList;
	}
	
	/**
	 * This method take note details (noteId and userId) from the user and fetch note from the database
	 * noteId is primary key of note table
	 * userId is primary key of user_mst table
	 * User can fetch notes related to him
	 * @param noteDto
	 */
	
	public NoteDto getNoteByNoteId(NoteDto noteDto) {
		// Create new UserMst object to set userId in UserMst object
		UserMst userMst = new UserMst(noteDto.getUserId());
		Note note = noteRepository.findByUserMstAndNoteId(userMst , noteDto.getNoteId());
		BeanUtils.copyProperties(note, noteDto);
		noteDto.setUserId(note.getUserMst().getUserId());
		return noteDto;
	}
	
	/**
	 * This method take note details from the user and saves in the database
	 * noteId which is primary key of note table is generated with the help of sequence
	 * @param noteDto
	 */
	
	public NoteDto saveNote(NoteDto noteDto) {
		Note note = new Note();
		BeanUtils.copyProperties(noteDto, note);
		// Create new UserMst object to set userId in UserMst object
		UserMst userMst = new UserMst(noteDto.getUserId());
		note.setUserMst(userMst);
		note.setCreationTime(new Date());
		
		note = noteRepository.save(note);
		BeanUtils.copyProperties(note, noteDto);
		return noteDto;
	}
	
	/**
	 * This method take note details from the user and update in the database
	 * noteId which is primary key of note table is generated with the help of sequence
	 * @param noteDto
	 */
	
	public void updateNote(NoteDto noteDto) {
		// Create new UserMst object to set userId in UserMst object
		UserMst userMst = new UserMst(noteDto.getUserId());
		// fetch existing note from userId and noteId
		Note note = noteRepository.findByUserMstAndNoteId(userMst, noteDto.getNoteId());
		// copy updated values
		BeanUtils.copyProperties(noteDto, note);
		// set updation time
		note.setLastUpdateTime(new Date());
		
		noteRepository.save(note);
	}
	
}
