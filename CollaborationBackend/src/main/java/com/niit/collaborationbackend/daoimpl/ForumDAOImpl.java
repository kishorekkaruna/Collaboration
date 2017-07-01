package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.ForumDAO;
import com.niit.collaborationbackend.model.Forum;

@Repository("ForumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> forumList = sessionFactory.getCurrentSession().createQuery("from Forum").list();
		return forumList;
	}

	public List<Forum> getAcceptedList() {
		String hql = "from Forum where status = " + "'A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		return list;
	}

	public List<Forum> getNotAcceptedList() {
		String hql = "from Forum where status = " + "'NA'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		return list;
	}

	public Forum get(int forumId) {
		String hql = "from Forum where forumid ='" + forumId + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) query.list();

		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		return null;

	}

	public void save(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
		
	}

	public Forum saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return forum;
	}

	public void delete(int forumId) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumid(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
		
	}


}
