package com.zhidian.server.dao;

import com.zhidian.server.model.ManagerRole;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ManagerRole entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ManagerRole
  * @author MyEclipse Persistence Tools 
 */
public class ManagerRoleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ManagerRoleDAO.class);
		//property constants
	public static final String MANAGER_ROLE_NAME = "managerRoleName";
	public static final String MANAGER_ROLE_DESCRIPTION = "managerRoleDescription";
	public static final String MANAGER_ROLE_IS_DELETE = "managerRoleIsDelete";



    
    public void save(ManagerRole transientInstance) {
        log.debug("saving ManagerRole instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ManagerRole persistentInstance) {
        log.debug("deleting ManagerRole instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ManagerRole findById( java.lang.String id) {
        log.debug("getting ManagerRole instance with id: " + id);
        try {
            ManagerRole instance = (ManagerRole) getSession()
                    .get("com.zhidian.server.model.ManagerRole", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ManagerRole instance) {
        log.debug("finding ManagerRole instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ManagerRole")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ManagerRole instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ManagerRole as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByManagerRoleName(Object managerRoleName
	) {
		return findByProperty(MANAGER_ROLE_NAME, managerRoleName
		);
	}
	
	public List findByManagerRoleDescription(Object managerRoleDescription
	) {
		return findByProperty(MANAGER_ROLE_DESCRIPTION, managerRoleDescription
		);
	}
	
	public List findByManagerRoleIsDelete(Object managerRoleIsDelete
	) {
		return findByProperty(MANAGER_ROLE_IS_DELETE, managerRoleIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all ManagerRole instances");
		try {
			String queryString = "from ManagerRole";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ManagerRole merge(ManagerRole detachedInstance) {
        log.debug("merging ManagerRole instance");
        try {
            ManagerRole result = (ManagerRole) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ManagerRole instance) {
        log.debug("attaching dirty ManagerRole instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ManagerRole instance) {
        log.debug("attaching clean ManagerRole instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}