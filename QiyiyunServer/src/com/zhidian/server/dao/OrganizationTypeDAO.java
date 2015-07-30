package com.zhidian.server.dao;

import com.zhidian.server.model.OrganizationType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for OrganizationType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.OrganizationType
  * @author MyEclipse Persistence Tools 
 */
public class OrganizationTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OrganizationTypeDAO.class);
		//property constants
	public static final String ORGAN_TYPE_NAME = "organTypeName";
	public static final String ORGAN_TYPE_IS_DELETE = "organTypeIsDelete";



    
    public void save(OrganizationType transientInstance) {
        log.debug("saving OrganizationType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OrganizationType persistentInstance) {
        log.debug("deleting OrganizationType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrganizationType findById( java.lang.String id) {
        log.debug("getting OrganizationType instance with id: " + id);
        try {
            OrganizationType instance = (OrganizationType) getSession()
                    .get("com.zhidian.server.model.OrganizationType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OrganizationType instance) {
        log.debug("finding OrganizationType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.OrganizationType")
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
      log.debug("finding OrganizationType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OrganizationType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOrganTypeName(Object organTypeName
	) {
		return findByProperty(ORGAN_TYPE_NAME, organTypeName
		);
	}
	
	public List findByOrganTypeIsDelete(Object organTypeIsDelete
	) {
		return findByProperty(ORGAN_TYPE_IS_DELETE, organTypeIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all OrganizationType instances");
		try {
			String queryString = "from OrganizationType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OrganizationType merge(OrganizationType detachedInstance) {
        log.debug("merging OrganizationType instance");
        try {
            OrganizationType result = (OrganizationType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OrganizationType instance) {
        log.debug("attaching dirty OrganizationType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrganizationType instance) {
        log.debug("attaching clean OrganizationType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}