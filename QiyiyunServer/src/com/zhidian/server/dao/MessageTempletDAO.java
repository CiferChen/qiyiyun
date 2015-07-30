package com.zhidian.server.dao;

import com.zhidian.server.model.MessageTemplet;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MessageTemplet entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.MessageTemplet
  * @author MyEclipse Persistence Tools 
 */
public class MessageTempletDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MessageTempletDAO.class);
		//property constants
	public static final String MESSAGE_TEMPLET_TYPE_ID = "messageTempletTypeId";
	public static final String MESSAGE_TEMPLET_CONTENT = "messageTempletContent";
	public static final String MESSAGE_TEMPLET_IS_DELETE = "messageTempletIsDelete";



    
    public void save(MessageTemplet transientInstance) {
        log.debug("saving MessageTemplet instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MessageTemplet persistentInstance) {
        log.debug("deleting MessageTemplet instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MessageTemplet findById( java.lang.String id) {
        log.debug("getting MessageTemplet instance with id: " + id);
        try {
            MessageTemplet instance = (MessageTemplet) getSession()
                    .get("com.zhidian.server.model.MessageTemplet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MessageTemplet instance) {
        log.debug("finding MessageTemplet instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.MessageTemplet")
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
      log.debug("finding MessageTemplet instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MessageTemplet as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMessageTempletTypeId(Object messageTempletTypeId
	) {
		return findByProperty(MESSAGE_TEMPLET_TYPE_ID, messageTempletTypeId
		);
	}
	
	public List findByMessageTempletContent(Object messageTempletContent
	) {
		return findByProperty(MESSAGE_TEMPLET_CONTENT, messageTempletContent
		);
	}
	
	public List findByMessageTempletIsDelete(Object messageTempletIsDelete
	) {
		return findByProperty(MESSAGE_TEMPLET_IS_DELETE, messageTempletIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MessageTemplet instances");
		try {
			String queryString = "from MessageTemplet";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MessageTemplet merge(MessageTemplet detachedInstance) {
        log.debug("merging MessageTemplet instance");
        try {
            MessageTemplet result = (MessageTemplet) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MessageTemplet instance) {
        log.debug("attaching dirty MessageTemplet instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MessageTemplet instance) {
        log.debug("attaching clean MessageTemplet instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}