package com.zhidian.server.dao;

import com.zhidian.server.model.MessageTempletType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MessageTempletType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.MessageTempletType
  * @author MyEclipse Persistence Tools 
 */
public class MessageTempletTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MessageTempletTypeDAO.class);
		//property constants
	public static final String MESSAGE_TEMPLET_TYPE_NAME = "messageTempletTypeName";
	public static final String MESSAGE_TEMPLET_IS_DELETE = "messageTempletIsDelete";



    
    public void save(MessageTempletType transientInstance) {
        log.debug("saving MessageTempletType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MessageTempletType persistentInstance) {
        log.debug("deleting MessageTempletType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MessageTempletType findById( java.lang.String id) {
        log.debug("getting MessageTempletType instance with id: " + id);
        try {
            MessageTempletType instance = (MessageTempletType) getSession()
                    .get("com.zhidian.server.model.MessageTempletType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MessageTempletType instance) {
        log.debug("finding MessageTempletType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.MessageTempletType")
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
      log.debug("finding MessageTempletType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MessageTempletType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMessageTempletTypeName(Object messageTempletTypeName
	) {
		return findByProperty(MESSAGE_TEMPLET_TYPE_NAME, messageTempletTypeName
		);
	}
	
	public List findByMessageTempletIsDelete(Object messageTempletIsDelete
	) {
		return findByProperty(MESSAGE_TEMPLET_IS_DELETE, messageTempletIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MessageTempletType instances");
		try {
			String queryString = "from MessageTempletType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MessageTempletType merge(MessageTempletType detachedInstance) {
        log.debug("merging MessageTempletType instance");
        try {
            MessageTempletType result = (MessageTempletType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MessageTempletType instance) {
        log.debug("attaching dirty MessageTempletType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MessageTempletType instance) {
        log.debug("attaching clean MessageTempletType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}