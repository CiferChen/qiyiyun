package com.zhidian.server.dao;

import com.zhidian.server.model.MessageType;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MessageType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.MessageType
  * @author MyEclipse Persistence Tools 
 */
public class MessageTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MessageTypeDAO.class);
		//property constants
	public static final String MESSAGE_TYPE_NAME = "messageTypeName";
	public static final String MESSAGE_TYPE_IS_DELETE = "messageTypeIsDelete";



    
    public void save(MessageType transientInstance) {
        log.debug("saving MessageType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MessageType persistentInstance) {
        log.debug("deleting MessageType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MessageType findById( java.lang.String id) {
        log.debug("getting MessageType instance with id: " + id);
        try {
            MessageType instance = (MessageType) getSession()
                    .get("com.zhidian.server.model.MessageType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MessageType instance) {
        log.debug("finding MessageType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.MessageType")
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
      log.debug("finding MessageType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MessageType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMessageTypeName(Object messageTypeName
	) {
		return findByProperty(MESSAGE_TYPE_NAME, messageTypeName
		);
	}
	
	public List findByMessageTypeIsDelete(Object messageTypeIsDelete
	) {
		return findByProperty(MESSAGE_TYPE_IS_DELETE, messageTypeIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MessageType instances");
		try {
			String queryString = "from MessageType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MessageType merge(MessageType detachedInstance) {
        log.debug("merging MessageType instance");
        try {
            MessageType result = (MessageType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MessageType instance) {
        log.debug("attaching dirty MessageType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MessageType instance) {
        log.debug("attaching clean MessageType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}