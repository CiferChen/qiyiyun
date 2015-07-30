package com.zhidian.server.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhidian.server.model.Visitor;

/**
 	* A data access object (DAO) providing persistence and search support for Visitor entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Visitor
  * @author MyEclipse Persistence Tools 
 */
public class VisitorDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(VisitorDAO.class);
		//property constants
	public static final String VISITOR_NAME = "visitorName";
	public static final String VISITOR_PHONE = "visitorPhone";
	public static final String VISITOR_EMAIL = "visitorEmail";
	public static final String VISITOR_START_TIME = "visitorStartTime";
	public static final String USER_ID = "userId";
	public static final String USER_PERSON_ID = "userPersonId";
	public static final String ORGAN_ID = "organId";
	public static final String VISITOR_IS_DELETE = "visitorIsDelete";



    
    public void save(Visitor transientInstance) {
    	Transaction tx= getSession().beginTransaction();
        log.debug("saving Visitor instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Visitor persistentInstance) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting Visitor instance");
        try {
            getSession().delete(persistentInstance);
            tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Visitor findById( java.lang.String id) {
        log.debug("getting Visitor instance with id: " + id);
        try {
            Visitor instance = (Visitor) getSession()
                    .get("com.zhidian.server.model.Visitor", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Visitor instance) {
        log.debug("finding Visitor instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Visitor")
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
      log.debug("finding Visitor instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Visitor as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVisitorName(Object visitorName
	) {
		return findByProperty(VISITOR_NAME, visitorName
		);
	}
	
	public List findByVisitorPhone(Object visitorPhone
	) {
		return findByProperty(VISITOR_PHONE, visitorPhone
		);
	}
	
	public List findByVisitorEmail(Object visitorEmail
	) {
		return findByProperty(VISITOR_EMAIL, visitorEmail
		);
	}
	
	public List findByVisitorStartTime(Object visitorStartTime
	) {
		return findByProperty(VISITOR_START_TIME, visitorStartTime
		);
	}
	
	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List findByUserPersonId(Object userPersonId
	) {
		return findByProperty(USER_PERSON_ID, userPersonId
		);
	}
	
	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	
	public List findByVisitorIsDelete(Object visitorIsDelete
	) {
		return findByProperty(VISITOR_IS_DELETE, visitorIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Visitor instances");
		try {
			String queryString = "from Visitor";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Visitor merge(Visitor detachedInstance) {
        log.debug("merging Visitor instance");
        try {
            Visitor result = (Visitor) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Visitor instance) {
        log.debug("attaching dirty Visitor instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Visitor instance) {
        log.debug("attaching clean Visitor instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}