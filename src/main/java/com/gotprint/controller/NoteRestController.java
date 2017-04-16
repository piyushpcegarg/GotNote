package com.gotprint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gotprint.model.CustomUser;
import com.gotprint.model.NoteDto;
import com.gotprint.service.NoteService;


@RestController
@RequestMapping("/gotnote")
public class NoteRestController {

   //Service which will do all data retrieval/manipulation work
   @Autowired
   private NoteService noteService;
   
   /**
    * This method fetches all notes of authenticated user
    * @return {@link ResponseEntity}
    */

   @RequestMapping(value = "/note/", method = RequestMethod.GET)
   public ResponseEntity<List<NoteDto>> getAllNotes() {
	   
	   NoteDto noteDto = getNoteDtoInstance();
       List<NoteDto> notes = noteService.getAllNotes(noteDto); 
       if (notes.isEmpty()) {
           return new ResponseEntity<List<NoteDto>>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<List<NoteDto>>(notes, HttpStatus.OK);
   }
   
   
   /**
    * This method fetches all notes of authenticated user
    * @return {@link ResponseEntity}
    */
   
   @RequestMapping(value = "/note/{noteId}", method = RequestMethod.GET)
   public ResponseEntity<NoteDto> getNote(@PathVariable("noteId") long noteId) {
	   
	   NoteDto noteDto = getNoteDtoInstance();
	   noteDto.setNoteId(noteId);
       noteDto = noteService.getNoteByNoteId(noteDto);
       if (noteDto == null) {
           return new ResponseEntity<NoteDto>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<NoteDto>(noteDto, HttpStatus.OK);
   }
   
   
   /**
    * This method fetches authenticated user information and set userId in NoteDto
    * @return NoteDto
    */
   
   private NoteDto getNoteDtoInstance() {
	   NoteDto noteDto = new NoteDto();
	   CustomUser customUser = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   noteDto.setUserId(customUser.getUserId());
	   return noteDto;
   }
   
}