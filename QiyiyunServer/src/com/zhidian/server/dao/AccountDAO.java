package com.zhidian.server.dao;
// default package


import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhidian.server.model.Account;

/**
 	* A data access object (DAO) providing persistence and search support for Account entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Account
  * @author MyEclipse Persistence Tools 
 */
public class AccountDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AccountDAO.class);
		//property constants
	public static final String ACCOUNT_TYPE = "accountType";
	public static final String ACCOUNT_OWNER_ID = "accountOwnerId";
	public static final String ACCOUNT_BALANCE = "accountBalance";
	public static final String ACCOUNT_MARGIN_BALANCE = "accountMarginBalance";



    
    public void save(Account transientInstance) {
        log.debug("saving Account instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Account persistentInstance) {
        log.debug("deleting Account instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Account findById( java.lang.String id) {
        log.debug("getting Account instance with id: " + id);
        try {
            Account instance = (Account) getSession()
                    .get("com.zhidian.server.model.Account", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Account instance) {
        log.debug("finding Account instance by example");
        try {
            List results = getSession()
                    .createCriteria("Account")
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
      log.debug("finding Account instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Account as model where model." 
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
	
	public List findByAccountBalance(Object accountBalance
	) {
		return findByProperty(ACCOUNT_BALANCE, accountBalance
		);
	}
	
	public List findByAccountMarginBalance(Object accountMarginBalance
	) {
		return findByProperty(ACCOUNT_MARGIN_BALANCE, accountMarginBalance
		);
	}
	

	public List findAll() {
		log.debug("finding all Account instances");
		try {
			String queryString = "from Account";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Account merge(Account detachedInstance) {
        log.debug("merging Account instance");
        try {
            Account result = (Account) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Account instance) {
        log.debug("attaching dirty Account instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Account instance) {
        log.debug("attaching clean Account instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}