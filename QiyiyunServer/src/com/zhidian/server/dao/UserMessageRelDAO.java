package com.zhidian.server.dao;

import com.zhidian.server.model.UserMessageRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for UserMessageRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.UserMessageRel
  * @author MyEclipse Persistence Tools 
 */
public class UserMessageRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserMessageRelDAO.class);
		//property constants
	public static final String USER_ID = "userId";
	public static final String MESSAGE_ID = "messageId";



    
    public void save(UserMessageRel transientInstance) {
        log.debug("saving UserMessageRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserMessageRel persistentInstance) {
        log.debug("deleting UserMessageRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserMessageRel findById( java.lang.String id) {
        log.debug("getting UserMessageRel instance with id: " + id);
        try {
            UserMessageRel instance = (UserMessageRel) getSession()
                    .get("com.zhidian.server.model.UserMessageRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    

	public List<UserMessageRel> findByUserId(String userId){
		log.info("find message by userId");
		Transaction tx = getSession().beginTransaction();
		try{
			String queryString = "from UserMessageRel where userId=?";
			Query query = getSession().createQuery(queryString);
			query.setParameter(0, userId);
			query.executeUpdate();
			tx.commit();
			log.info("query success");
			return query.list();
		}
		catch(RuntimeException re){
			log.error("get failed");
			throw re;
		}
	}
    
    public List findByExample(UserMessageRel instance) {
        log.debug("finding UserMessageRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.UserMessageRel")
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
      log.debug("finding UserMessageRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserMessageRel as model where model." 
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
	
	public List findByMessageId(Object messageId
	) {
		return findByProperty(MESSAGE_ID, messageId
		);
	}
	

	public List findAll() {
		log.debug("finding all UserMessageRel instances");
		try {
			String queryString = "from UserMessageRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserMessageRel merge(UserMessageRel detachedInstance) {
        log.debug("merging UserMessageRel instance");
        try {
            UserMessageRel result = (UserMessageRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserMessageRel instance) {
        log.debug("attaching dirty UserMessageRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserMessageRel instance) {
        log.debug("attaching clean UserMessageRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}