package com.zhidian.server.dao;

import com.zhidian.server.model.UserOrganizationRel;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserOrganizationRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.UserOrganizationRel
  * @author MyEclipse Persistence Tools 
 */
public class UserOrganizationRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(UserOrganizationRelDAO.class);
		//property constants
	public static final String USER_ID = "userId";
	public static final String ORGAN_ID = "organId";



    
    public void save(UserOrganizationRel transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving UserOrganizationRel instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserOrganizationRel persistentInstance) {
        log.debug("deleting UserOrganizationRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserOrganizationRel findById( java.lang.String id) {
        log.debug("getting UserOrganizationRel instance with id: " + id);
        try {
            UserOrganizationRel instance = (UserOrganizationRel) getSession()
                    .get("com.zhidian.server.model.UserOrganizationRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserOrganizationRel instance) {
        log.debug("finding UserOrganizationRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.UserOrganizationRel")
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
      log.debug("finding UserOrganizationRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserOrganizationRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	

	public List findAll() {
		log.debug("finding all UserOrganizationRel instances");
		try {
			String queryString = "from UserOrganizationRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserOrganizationRel merge(UserOrganizationRel detachedInstance) {
        log.debug("merging UserOrganizationRel instance");
        try {
            UserOrganizationRel result = (UserOrganizationRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserOrganizationRel instance) {
        log.debug("attaching dirty UserOrganizationRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserOrganizationRel instance) {
        log.debug("attaching clean UserOrganizationRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public void deleteByUserIdAndOrganId(String userId, String organId) {
		Transaction tx = getSession().beginTransaction();
		log.debug("deleteByUserIdAndOrganId");
		try {
			String queryString = "delete from UserOrganizationRel where userId = '"+userId+"' and organId = '"+organId+"'";
	        getSession().createQuery(queryString).executeUpdate();
	        tx.commit();
		} catch (RuntimeException re) {
			log.error("deleteByUserIdAndOrganId failed", re);
			throw re;
		}			
	}
}