package com.zhidian.server.dao;

import com.zhidian.server.model.Department;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Department entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zhidian.server.model.Department
 * @author MyEclipse Persistence Tools
 */
public class DepartmentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DepartmentDAO.class);
	// property constants
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String CREATOR_ID = "creatorId";
	public static final String CREATE_TIME = "createTime";
	public static final String OGAN_ID = "oganId";
	public static final String DEPARTMENT_DESC = "departmentDesc";
	public static final String DEPARTMENT_LEADER_ID = "departmentLeaderId";
	public static final String DEPARTMENT_IS_DELETE = "departmentIsDelete";

	public void save(Department transientInstance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("saving Department instance");
		try {
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
			} catch (RuntimeException re) {
				log.error("save failed", re);
				throw re;
		}
	}

	public void delete(Department persistentInstance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("deleting Department instance");
		try {
			getSession().delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Department findById(java.lang.String id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) getSession().get(
					"com.zhidian.server.model.Department", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Department instance) {
		log.debug("finding Department instance by example");
		try {
			List results = getSession()
					.createCriteria("com.zhidian.server.model.Department")
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
		log.debug("finding Department instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Department as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDepartmentName(Object departmentName) {
		return findByProperty(DEPARTMENT_NAME, departmentName);
	}

	public List findByCreatorId(Object creatorId) {
		return findByProperty(CREATOR_ID, creatorId);
	}

	public List findByCreateTime(Object createTime) {
		return findByProperty(CREATE_TIME, createTime);
	}

	public List findByOganId(Object oganId) {
		return findByProperty(OGAN_ID, oganId);
	}

	public List findByDepartmentDesc(Object departmentDesc) {
		return findByProperty(DEPARTMENT_DESC, departmentDesc);
	}

	public List findByDepartmentLeaderId(Object departmentLeaderId) {
		return findByProperty(DEPARTMENT_LEADER_ID, departmentLeaderId);
	}

	public List findByDepartmentIsDelete(Object departmentIsDelete) {
		return findByProperty(DEPARTMENT_IS_DELETE, departmentIsDelete);
	}

	public List findAll() {
		log.debug("finding all Department instances");
		try {
			String queryString = "from Department";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Department merge(Department detachedInstance) {
		log.debug("merging Department instance");
		try {
			Department result = (Department) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Department instance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("attaching dirty Department instance");
		try {
			getSession().saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Department instance) {
		log.debug("attaching clean Department instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}