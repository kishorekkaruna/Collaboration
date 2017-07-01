package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.Forum;

public interface ForumDAO {
	public List<Forum> list();

	public List<Forum> getAcceptedList();

	public List<Forum> getNotAcceptedList();

	public Forum get(int forumId);

	public void save(Forum forum);

	public Forum saveOrUpdate(Forum forum);

	public void delete(int forumId);
}
