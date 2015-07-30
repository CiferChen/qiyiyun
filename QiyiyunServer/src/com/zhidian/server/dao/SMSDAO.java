package com.zhidian.server.dao;

import com.zhidian.server.model.SMS;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for SMS entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.SMS
  * @author MyEclipse Persistence Tools 
 */
public class SMSDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SMSDAO.class);
		//property constants
	public static final String SMS_TYPE_ID = "smsTypeId";
	public static final String SMS_RECEIVER = "smsReceiver";
	public static final String SMS_CONTENT = "smsContent";
	public static final String SMS_SEND_TIME = "smsSendTime";
	public static final String SMS_SENDER = "smsSender";
	public static final String SMS_SEND_STATUS = "smsSendStatus";
	public static final String SMS_IS_DELETE = "smsIsDelete";



    
    public void save(SMS transientInstance) {
        log.debug("saving SMS instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SMS persistentInstance) {
        log.debug("deleting SMS instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SMS findById( java.lang.String id) {
        log.debug("getting SMS instance with id: " + id);
        try {
            SMS instance = (SMS) getSession()
                    .get("com.zhidian.server.model.SMS", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SMS instance) {
        log.debug("finding SMS instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.SMS")
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
      log.debug("finding SMS instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SMS as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySmsTypeId(Object smsTypeId
	) {
		return findByProperty(SMS_TYPE_ID, smsTypeId
		);
	}
	
	public List findBySmsReceiver(Object smsReceiver
	) {
		return findByProperty(SMS_RECEIVER, smsReceiver
		);
	}
	
	public List findBySmsContent(Object smsContent
	) {
		return findByProperty(SMS_CONTENT, smsContent
		);
	}
	
	public List findBySmsSendTime(Object smsSendTime
	) {
		return findByProperty(SMS_SEND_TIME, smsSendTime
		);
	}
	
	public List findBySmsSender(Object smsSender
	) {
		return findByProperty(SMS_SENDER, smsSender
		);
	}
	
	public List findBySmsSendStatus(Object smsSendStatus
	) {
		return findByProperty(SMS_SEND_STATUS, smsSendStatus
		);
	}
	
	public List findBySmsIsDelete(Object smsIsDelete
	) {
		return findByProperty(SMS_IS_DELETE, smsIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all SMS instances");
		try {
			String queryString = "from SMS";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SMS merge(SMS detachedInstance) {
        log.debug("merging SMS instance");
        try {
            SMS result = (SMS) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SMS instance) {
        log.debug("attaching dirty SMS instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SMS instance) {
        log.debug("attaching clean SMS instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}