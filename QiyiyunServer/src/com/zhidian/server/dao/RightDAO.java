package com.zhidian.server.dao;

import com.zhidian.server.model.Right;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Right
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zhidian.server.model.Right
 * @author MyEclipse Persistence Tools
 */
public class RightDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RightDAO.class);
	// property constants
	public static final String RIGHT_TYPE = "rightType";
	public static final String RIGHT_NAME = "rightName";
	public static final String RIGHT_DESCRIPTION = "rightDescription";

	public void save(Right transientInstance) {
		log.debug("saving Right instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Right persistentInstance) {
		log.debug("deleting Right instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Right findById(java.lang.String id) {
		log.debug("getting Right instance with id: " + id);
		try {
			Right instance = (Right) getSession().get(
					"com.zhidian.server.model.Right", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Right instance) {
		log.debug("finding Right instance by example");
		try {
			List results = getSession()
					.createCriteria("com.zhidian.server.model.Right")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Right instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Right as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRightType(Object rightType) {
		return findByProperty(RIGHT_TYPE, rightType);
	}

	public List findByRightName(Object rightName) {
		return findByProperty(RIGHT_NAME, rightName);
	}

	public List findByRightDescription(Object rightDescription) {
		return findByProperty(RIGHT_DESCRIPTION, rightDescription);
	}

	public List findAll() {
		log.debug("finding all Right instances");
		try {
			String queryString = "from Right";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Right merge(Right detachedInstance) {
		log.debug("merging Right instance");
		try {
			Right result = (Right) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Right instance) {
		log.debug("attaching dirty Right instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Right instance) {
		log.debug("attaching clean Right instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}