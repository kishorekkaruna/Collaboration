package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.ForumCommentDAO;
import com.niit.collaborationbackend.model.ForumComment;

@Repository("ForumComment")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ForumCommentDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	
	public List<ForumComment> list() {
		
		return null;
	}

	public void save(ForumComment forumComment) {
		sessionFactory.getCurrentSession().save(forumComment);
		
	}

	public void saveOrUpdate() {
	
		
	}

	public void delete() {
	
		
	}

	public List<ForumComment> getForumComments(int forumId) {
		
		return null;
	}

	public ForumComment getComment(int Id) {
		
		return null;
	}

}
