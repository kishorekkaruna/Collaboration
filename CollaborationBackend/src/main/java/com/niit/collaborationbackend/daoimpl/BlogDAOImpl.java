package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.model.Blog;

@Repository("BlogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public List<Blog> list() {
		
		return null;
	}

	public Blog getByBlogId(int blogId) {
		
		return null;
	}

	public List<Blog> getAcceptedBlog() {
		
		return null;
	}

	public List<Blog> getNotAcceptedBlog() {
		
		return null;
	}

	public Blog getByuId(int user_id) {
		
		return null;
	}

	public Blog getbyemailId(String email_Id) {
		
		return null;
	}

	public void save(Blog blog) {
		sessionFactory.getCurrentSession().save(blog);
		
	}

	public void delete(int blogId) {
		
		
	}

	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		
	}

}
