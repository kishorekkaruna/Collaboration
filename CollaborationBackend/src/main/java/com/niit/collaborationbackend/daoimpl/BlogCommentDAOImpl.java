package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.BlogCommentDAO;
import com.niit.collaborationbackend.model.BlogComment;

@Repository("BlogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public List<BlogComment> getById(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(BlogComment blogComment) {
		sessionFactory.getCurrentSession().save(blogComment);
		
	}

	public void saveOrUpdate(BlogComment blogComment) {
		// TODO Auto-generated method stub
		
	}

	public void delete(BlogCommentDAO blogComment) {
		// TODO Auto-generated method stub
		
	}

	

}
