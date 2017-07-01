package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.FriendDAO;
import com.niit.collaborationbackend.model.Friend;

@Repository("FriendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Friend> list() {

		return null;
	}

	public List<Friend> list(int friendId) {

		return null;
	}

	public void save(Friend friend) {
		sessionFactory.getCurrentSession().save(friend);

	}

	public Friend getByFriendId(int id) {

		return null;
	}

	public List<Friend> getByFriendName(String name) {

		return null;
	}

	public List<Friend> getByFriendAccepted(String name) {

		return null;
	}

	public void delete(int id) {

	}

	public void saveOrUpdate(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);

	}

}
