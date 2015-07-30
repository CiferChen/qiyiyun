package com.zhidian.server.dao;
// default package


import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhidian.server.model.AccountRecord;

/**
 	* A data access object (DAO) providing persistence and search support for AccountRecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .AccountRecord
  * @author MyEclipse Persistence Tools 
 */
public class AccountRecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AccountRecordDAO.class);
		//property constants
	public static final String ACCOUNT_TYPE = "accountType";
	public static final String ACCOUNT_OWNER_ID = "accountOwnerId";
	public static final String OPERATOR_ID = "operatorId";
	public static final String OPERATE_TIME = "operateTime";
	public static final String OPERATE_REASON = "operateReason";
	public static final String OPERATE_WAY = "operateWay";
	public static final String OPERATE_COUNT = "operateCount";
	public static final String OPERATE_TYPE = "operateType";



    
    public void save(AccountRecord transientInstance) {
        log.debug("saving AccountRecord instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AccountRecord persistentInstance) {
        log.debug("deleting AccountRecord instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AccountRecord findById( java.lang.String id) {
        log.debug("getting AccountRecord instance with id: " + id);
        try {
            AccountRecord instance = (AccountRecord) getSession()
                    .get("com.zhidian.server.model.AccountRecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AccountRecord instance) {
        log.debug("finding AccountRecord instance by example");
        try {
            List results = getSession()
                    .createCriteria("AccountRecord")
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
      log.debug("finding AccountRecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AccountRecord as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAccountType(Object accountType
	) {
		return findByProperty(ACCOUNT_TYPE, accountType
		);
	}
	
	public List findByAccountOwnerId(Object accountOwnerId
	) {
		return findByProperty(ACCOUNT_OWNER_ID, accountOwnerId
		);
	}
	
	public List findByOperatorId(Object operatorId
	) {
		return findByProperty(OPERATOR_ID, operatorId
		);
	}
	
	public List findByOperateTime(Object operateTime
	) {
		return findByProperty(OPERATE_TIME, operateTime
		);
	}
	
	public List findByOperateReason(Object operateReason
	) {
		return findByProperty(OPERATE_REASON, operateReason
		);
	}
	
	public List findByOperateWay(Object operateWay
	) {
		return findByProperty(OPERATE_WAY, operateWay
		);
	}
	
	public List findByOperateCount(Object operateCount
	) {
		return findByProperty(OPERATE_COUNT, operateCount
		);
	}
	
	public List findByOperateType(Object operateType
	) {
		return findByProperty(OPERATE_TYPE, operateType
		);
	}
	

	public List findAll() {
		log.debug("finding all AccountRecord instances");
		try {
			String queryString = "from AccountRecord";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AccountRecord merge(AccountRecord detachedInstance) {
        log.debug("merging AccountRecord instance");
        try {
            AccountRecord result = (AccountRecord) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AccountRecord instance) {
        log.debug("attaching dirty AccountRecord instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AccountRecord instance) {
        log.debug("attaching clean AccountRecord instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}