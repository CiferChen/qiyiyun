package com.zhidian.server.dao;

import com.zhidian.server.model.UserWordsType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserWordsType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.UserWordsType
  * @author MyEclipse Persistence Tools 
 */
public class UserWordsTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserWordsTypeDAO.class);
		//property constants
	public static final String USER_WORDS_TYPE_NAME = "userWordsTypeName";
	public static final String USER_WORDS_TYPE_IS_DELETE = "userWordsTypeIsDelete";



    
    public void save(UserWordsType transientInstance) {
        log.debug("saving UserWordsType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserWordsType persistentInstance) {
        log.debug("deleting UserWordsType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserWordsType findById( java.lang.String id) {
        log.debug("getting UserWordsType instance with id: " + id);
        try {
            UserWordsType instance = (UserWordsType) getSession()
                    .get("com.zhidian.server.model.UserWordsType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserWordsType instance) {
        log.debug("finding UserWordsType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.UserWordsType")
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
      log.debug("finding UserWordsType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserWordsType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserWordsTypeName(Object userWordsTypeName
	) {
		return findByProperty(USER_WORDS_TYPE_NAME, userWordsTypeName
		);
	}
	
	public List findByUserWordsTypeIsDelete(Object userWordsTypeIsDelete
	) {
		return findByProperty(USER_WORDS_TYPE_IS_DELETE, userWordsTypeIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all UserWordsType instances");
		try {
			String queryString = "from UserWordsType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserWordsType merge(UserWordsType detachedInstance) {
        log.debug("merging UserWordsType instance");
        try {
            UserWordsType result = (UserWordsType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserWordsType instance) {
        log.debug("attaching dirty UserWordsType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserWordsType instance) {
        log.debug("attaching clean UserWordsType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}