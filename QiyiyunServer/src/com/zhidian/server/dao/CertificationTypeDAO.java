package com.zhidian.server.dao;

import com.zhidian.server.model.CertificationType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for CertificationType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.CertificationType
  * @author MyEclipse Persistence Tools 
 */
public class CertificationTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CertificationTypeDAO.class);
		//property constants
	public static final String CERTIFICATION_TYPE_NAME = "certificationTypeName";



    
    public void save(CertificationType transientInstance) {
        log.debug("saving CertificationType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CertificationType persistentInstance) {
        log.debug("deleting CertificationType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CertificationType findById( java.lang.String id) {
        log.debug("getting CertificationType instance with id: " + id);
        try {
            CertificationType instance = (CertificationType) getSession()
                    .get("com.zhidian.server.model.CertificationType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CertificationType instance) {
        log.debug("finding CertificationType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.CertificationType")
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
      log.debug("finding CertificationType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CertificationType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCertificationTypeName(Object certificationTypeName
	) {
		return findByProperty(CERTIFICATION_TYPE_NAME, certificationTypeName
		);
	}
	

	public List findAll() {
		log.debug("finding all CertificationType instances");
		try {
			String queryString = "from CertificationType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CertificationType merge(CertificationType detachedInstance) {
        log.debug("merging CertificationType instance");
        try {
            CertificationType result = (CertificationType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CertificationType instance) {
        log.debug("attaching dirty CertificationType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CertificationType instance) {
        log.debug("attaching clean CertificationType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}