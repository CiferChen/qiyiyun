package com.zhidian.server.dao;

import com.zhidian.server.model.Role;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zhidian.server.model.Role
 * @author MyEclipse Persistence Tools
 */
public class RoleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(RoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String DEPARTMENT_ID = "departmentId";
	public static final String ROLE_DESC = "roleDesc";
	public static final String ROLE_IS_DELETE = "roleIsDelete";

	public void save(Role transientInstance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("saving Role instance");
		try {
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Role persistentInstance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("deleting Role instance");
		try {
			getSession().delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Role findById(java.lang.String id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) getSession().get(
					"com.zhidian.server.model.Role", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List<Role> findByIds(String ids) {
		log.debug("getting Role instance with ids: " + ids);
		try {
			String queryString = "from Role where roleId in("+ids+")";
            Query query = getSession().createQuery(queryString);
            log.debug("find by Ids successful" );
            return query.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Role instance) {
		log.debug("finding Role instance by example");
		try {
			List results = getSession()
					.createCriteria("com.zhidian.server.model.Role")
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
		log.debug("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Role as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByDepartmentId(Object departmentId) {
		return findByProperty(DEPARTMENT_ID, departmentId);
	}

	public List findByRoleDesc(Object roleDesc) {
		return findByProperty(ROLE_DESC, roleDesc);
	}

	public List findByRoleIsDelete(Object roleIsDelete) {
		return findByProperty(ROLE_IS_DELETE, roleIsDelete);
	}

	public List findAll() {
		log.debug("finding all Role instances");
		try {
			String queryString = "from Role";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Role result = (Role) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Role instance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("attaching dirty Role instance");
		try {
			getSession().saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Role instance) {
		log.debug("attaching clean Role instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}