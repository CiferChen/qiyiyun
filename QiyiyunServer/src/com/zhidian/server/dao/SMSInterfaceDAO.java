package com.zhidian.server.dao;

import com.zhidian.server.model.SMSInterface;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for SMSInterface entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.SMSInterface
  * @author MyEclipse Persistence Tools 
 */
public class SMSInterfaceDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SMSInterfaceDAO.class);
		//property constants
	public static final String SMS_INTERFACE_NAME = "smsInterfaceName";
	public static final String SMS_INTERFACE_URL = "smsInterfaceUrl";
	public static final String SMS_INTERFACE_USER_NAME = "smsInterfaceUserName";
	public static final String SMS_INTERFACE_PASSWORD = "smsInterfacePassword";
	public static final String SMS_INTERFACE_STATUS = "smsInterfaceStatus";



    
    public void save(SMSInterface transientInstance) {
        log.debug("saving SMSInterface instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SMSInterface persistentInstance) {
        log.debug("deleting SMSInterface instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SMSInterface findById( java.lang.String id) {
        log.debug("getting SMSInterface instance with id: " + id);
        try {
            SMSInterface instance = (SMSInterface) getSession()
                    .get("com.zhidian.server.model.SMSInterface", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SMSInterface instance) {
        log.debug("finding SMSInterface instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.SMSInterface")
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
      log.debug("finding SMSInterface instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SMSInterface as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySmsInterfaceName(Object smsInterfaceName
	) {
		return findByProperty(SMS_INTERFACE_NAME, smsInterfaceName
		);
	}
	
	public List findBySmsInterfaceUrl(Object smsInterfaceUrl
	) {
		return findByProperty(SMS_INTERFACE_URL, smsInterfaceUrl
		);
	}
	
	public List findBySmsInterfaceUserName(Object smsInterfaceUserName
	) {
		return findByProperty(SMS_INTERFACE_USER_NAME, smsInterfaceUserName
		);
	}
	
	public List findBySmsInterfacePassword(Object smsInterfacePassword
	) {
		return findByProperty(SMS_INTERFACE_PASSWORD, smsInterfacePassword
		);
	}
	
	public List findBySmsInterfaceStatus(Object smsInterfaceStatus
	) {
		return findByProperty(SMS_INTERFACE_STATUS, smsInterfaceStatus
		);
	}
	

	public List findAll() {
		log.debug("finding all SMSInterface instances");
		try {
			String queryString = "from SMSInterface";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SMSInterface merge(SMSInterface detachedInstance) {
        log.debug("merging SMSInterface instance");
        try {
            SMSInterface result = (SMSInterface) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SMSInterface instance) {
        log.debug("attaching dirty SMSInterface instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SMSInterface instance) {
        log.debug("attaching clean SMSInterface instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}