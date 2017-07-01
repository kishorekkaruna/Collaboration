package com.niit.collaborationbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.dao.JobDAO;
import com.niit.collaborationbackend.model.Job;

@Repository("JobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public List<Job> list() {

		return null;
	}

	public void save(Job job) {
		sessionFactory.getCurrentSession().save(job);

	}

	public void saveOrUpdate(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);

	}

	public Job getByJobId(int jobid) {

		return null;
	}

	public void delete(int jobid) {

	}

}
