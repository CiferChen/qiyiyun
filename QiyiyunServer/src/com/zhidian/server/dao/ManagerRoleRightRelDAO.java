package com.zhidian.server.dao;

import com.zhidian.server.model.ManagerRoleRightRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ManagerRoleRightRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ManagerRoleRightRel
  * @author MyEclipse Persistence Tools 
 */
public class ManagerRoleRightRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ManagerRoleRightRelDAO.class);
		//property constants
	public static final String MANAGER_ROLE_ID = "managerRoleId";
	public static final String RIGHT_ID = "rightId";



    
    public void save(ManagerRoleRightRel transientInstance) {
        log.debug("saving ManagerRoleRightRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ManagerRoleRightRel persistentInstance) {
        log.debug("deleting ManagerRoleRightRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ManagerRoleRightRel findById( java.lang.String id) {
        log.debug("getting ManagerRoleRightRel instance with id: " + id);
        try {
            ManagerRoleRightRel instance = (ManagerRoleRightRel) getSession()
                    .get("com.zhidian.server.model.ManagerRoleRightRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ManagerRoleRightRel instance) {
        log.debug("finding ManagerRoleRightRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ManagerRoleRightRel")
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
      log.debug("finding ManagerRoleRightRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ManagerRoleRightRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByManagerRoleId(Object managerRoleId
	) {
		return findByProperty(MANAGER_ROLE_ID, managerRoleId
		);
	}
	
	public List findByRightId(Object rightId
	) {
		return findByProperty(RIGHT_ID, rightId
		);
	}
	

	public List findAll() {
		log.debug("finding all ManagerRoleRightRel instances");
		try {
			String queryString = "from ManagerRoleRightRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ManagerRoleRightRel merge(ManagerRoleRightRel detachedInstance) {
        log.debug("merging ManagerRoleRightRel instance");
        try {
            ManagerRoleRightRel result = (ManagerRoleRightRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ManagerRoleRightRel instance) {
        log.debug("attaching dirty ManagerRoleRightRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ManagerRoleRightRel instance) {
        log.debug("attaching clean ManagerRoleRightRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}