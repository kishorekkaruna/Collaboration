package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.ForumDAO;
import com.niit.collaborationbackend.model.Blog;
import com.niit.collaborationbackend.model.Forum;

@RestController
public class ForumController {
	
	@Autowired ForumDAO forumDAO;
	
	@GetMapping("/forums")
	public List<Forum> list(){
		List<Forum> forumList=forumDAO.list();
		return forumList;
		
	}
	
	@GetMapping("/forum/{fourm_id}")
	public ResponseEntity<Forum> getByForumId(@PathVariable("forumid")int id ){
		Forum forum = forumDAO.get(id);
		if (forum == null) {
			return new ResponseEntity("No Forum found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}

}
