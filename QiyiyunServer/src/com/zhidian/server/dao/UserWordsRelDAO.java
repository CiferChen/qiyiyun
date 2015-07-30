package com.zhidian.server.dao;

import com.zhidian.server.model.UserWordsRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserWordsRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.UserWordsRel
  * @author MyEclipse Persistence Tools 
 */
public class UserWordsRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserWordsRelDAO.class);
		//property constants
	public static final String USER_ID = "userId";
	public static final String WORDS_ID = "wordsId";



    
    public void save(UserWordsRel transientInstance) {
        log.debug("saving UserWordsRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserWordsRel persistentInstance) {
        log.debug("deleting UserWordsRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserWordsRel findById( java.lang.String id) {
        log.debug("getting UserWordsRel instance with id: " + id);
        try {
            UserWordsRel instance = (UserWordsRel) getSession()
                    .get("com.zhidian.server.model.UserWordsRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserWordsRel instance) {
        log.debug("finding UserWordsRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.UserWordsRel")
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
      log.debug("finding UserWordsRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserWordsRel as model where model." 
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
	
	public List findByWordsId(Object wordsId
	) {
		return findByProperty(WORDS_ID, wordsId
		);
	}
	

	public List findAll() {
		log.debug("finding all UserWordsRel instances");
		try {
			String queryString = "from UserWordsRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserWordsRel merge(UserWordsRel detachedInstance) {
        log.debug("merging UserWordsRel instance");
        try {
            UserWordsRel result = (UserWordsRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserWordsRel instance) {
        log.debug("attaching dirty UserWordsRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserWordsRel instance) {
        log.debug("attaching clean UserWordsRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}