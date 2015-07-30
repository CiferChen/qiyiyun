package com.zhidian.server.dao;

import com.zhidian.server.model.ManagerInfo;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ManagerInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ManagerInfo
  * @author MyEclipse Persistence Tools 
 */
public class ManagerInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ManagerInfoDAO.class);
		//property constants
	public static final String MANAGER_ROLE_ID = "managerRoleId";
	public static final String MANAGER_PERSON_NAME = "managerPersonName";
	public static final String MANAGER_AGE = "managerAge";
	public static final String MANAGER_CERTIFICATION_TYPE = "managerCertificationType";
	public static final String MANAGER_CERITFICATION_NUMBER = "managerCeritficationNumber";
	public static final String MANAGER_PHONE = "managerPhone";
	public static final String MANAGER_EMAIL = "managerEmail";



    
    public void save(ManagerInfo transientInstance) {
        log.debug("saving ManagerInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ManagerInfo persistentInstance) {
        log.debug("deleting ManagerInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ManagerInfo findById( java.lang.String id) {
        log.debug("getting ManagerInfo instance with id: " + id);
        try {
            ManagerInfo instance = (ManagerInfo) getSession()
                    .get("com.zhidian.server.model.ManagerInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ManagerInfo instance) {
        log.debug("finding ManagerInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ManagerInfo")
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
      log.debug("finding ManagerInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ManagerInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByManagerRoleId(Object managerRoleId
	) {
		return findByProperty(MANAGER_ROLE_ID, managerRoleId
		);
	}
	
	public List findByManagerPersonName(Object managerPersonName
	) {
		return findByProperty(MANAGER_PERSON_NAME, managerPersonName
		);
	}
	
	public List findByManagerAge(Object managerAge
	) {
		return findByProperty(MANAGER_AGE, managerAge
		);
	}
	
	public List findByManagerCertificationType(Object managerCertificationType
	) {
		return findByProperty(MANAGER_CERTIFICATION_TYPE, managerCertificationType
		);
	}
	
	public List findByManagerCeritficationNumber(Object managerCeritficationNumber
	) {
		return findByProperty(MANAGER_CERITFICATION_NUMBER, managerCeritficationNumber
		);
	}
	
	public List findByManagerPhone(Object managerPhone
	) {
		return findByProperty(MANAGER_PHONE, managerPhone
		);
	}
	
	public List findByManagerEmail(Object managerEmail
	) {
		return findByProperty(MANAGER_EMAIL, managerEmail
		);
	}
	

	public List findAll() {
		log.debug("finding all ManagerInfo instances");
		try {
			String queryString = "from ManagerInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ManagerInfo merge(ManagerInfo detachedInstance) {
        log.debug("merging ManagerInfo instance");
        try {
            ManagerInfo result = (ManagerInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ManagerInfo instance) {
        log.debug("attaching dirty ManagerInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ManagerInfo instance) {
        log.debug("attaching clean ManagerInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}