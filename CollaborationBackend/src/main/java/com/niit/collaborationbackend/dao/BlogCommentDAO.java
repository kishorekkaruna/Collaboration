package com.niit.collaborationbackend.dao;

import java.util.List;

import com.niit.collaborationbackend.model.BlogComment;

public interface BlogCommentDAO {
	
	public List<BlogComment> getById(int blogId);
	public void save(BlogComment blogComment);
	public void saveOrUpdate(BlogComment blogComment);
	public void delete(BlogCommentDAO blogComment);

}
