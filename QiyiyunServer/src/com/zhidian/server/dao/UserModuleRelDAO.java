package com.zhidian.server.dao;

import com.zhidian.server.model.UserModuleRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserModuleRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.UserModuleRel
  * @author MyEclipse Persistence Tools 
 */
public class UserModuleRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserModuleRelDAO.class);
		//property constants
	public static final String USER_ID = "userId";
	public static final String MODULE_ID = "moduleId";



    
    public void save(UserModuleRel transientInstance) {
        log.debug("saving UserModuleRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserModuleRel persistentInstance) {
        log.debug("deleting UserModuleRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserModuleRel findById( java.lang.String id) {
        log.debug("getting UserModuleRel instance with id: " + id);
        try {
            UserModuleRel instance = (UserModuleRel) getSession()
                    .get("com.zhidian.server.model.UserModuleRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserModuleRel instance) {
        log.debug("finding UserModuleRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.UserModuleRel")
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
      log.debug("finding UserModuleRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserModuleRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List findByModuleId(Object moduleId
	) {
		return findByProperty(MODULE_ID, moduleId
		);
	}
	

	public List findAll() {
		log.debug("finding all UserModuleRel instances");
		try {
			String queryString = "from UserModuleRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserModuleRel merge(UserModuleRel detachedInstance) {
        log.debug("merging UserModuleRel instance");
        try {
            UserModuleRel result = (UserModuleRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserModuleRel instance) {
        log.debug("attaching dirty UserModuleRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserModuleRel instance) {
        log.debug("attaching clean UserModuleRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}