package com.zhidian.server.dao;
// default package


import com.zhidian.server.model.Bookstation;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Bookstation entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Bookstation
  * @author MyEclipse Persistence Tools 
 */
public class BookstationDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(BookstationDAO.class);
		//property constants
	public static final String BOOKSTATION_NAME = "bookstationName";
	public static final String BOOKSTATION_PHONE = "bookstationPhone";
	public static final String BOOKSTATION_EMAIL = "bookstationEmail";



    
    public void save(Bookstation transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving Bookstation instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Bookstation persistentInstance) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting Bookstation instance");
        try {
            getSession().delete(persistentInstance);
            tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Bookstation findById( java.lang.String id) {
        log.debug("getting Bookstation instance with id: " + id);
        try {
            Bookstation instance = (Bookstation) getSession()
                    .get("com.zhidian.server.model.Bookstation", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Bookstation instance) {
        log.debug("finding Bookstation instance by example");
        try {
            List results = getSession()
                    .createCriteria("Bookstation")
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
      log.debug("finding Bookstation instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Bookstation as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBookstationName(Object bookstationName
	) {
		return findByProperty(BOOKSTATION_NAME, bookstationName
		);
	}
	
	public List findByBookstationPhone(Object bookstationPhone
	) {
		return findByProperty(BOOKSTATION_PHONE, bookstationPhone
		);
	}
	
	public List findByBookstationEmail(Object bookstationEmail
	) {
		return findByProperty(BOOKSTATION_EMAIL, bookstationEmail
		);
	}
	

	public List findAll() {
		log.debug("finding all Bookstation instances");
		try {
			String queryString = "from Bookstation";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Bookstation merge(Bookstation detachedInstance) {
        log.debug("merging Bookstation instance");
        try {
            Bookstation result = (Bookstation) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Bookstation instance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("attaching dirty Bookstation instance");
        try {
            getSession().saveOrUpdate(instance);
            tx.commit();
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Bookstation instance) {
        log.debug("attaching clean Bookstation instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}