package com.gotprint.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprint.model.Note;
import com.gotprint.model.UserMst;

/**
 * @author piyushpcegarg
 *	This interface extends JpaRepository and provides all the default CRUD operations without implementation.
 *	This interface also contains custom method for different functionalities.
 */

public interface NoteRepository extends JpaRepository<Note, Long>  {
	
	List<Note> findByUserMst(UserMst userMst);
	
	Note findByUserMstAndNoteId(UserMst userMst, long noteId);

}
