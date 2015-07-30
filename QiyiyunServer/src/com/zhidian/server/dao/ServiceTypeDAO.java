package com.zhidian.server.dao;

import com.zhidian.server.model.ServiceType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ServiceType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ServiceType
  * @author MyEclipse Persistence Tools 
 */
public class ServiceTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ServiceTypeDAO.class);
		//property constants
	public static final String SERVICE_TYPE_NAME = "serviceTypeName";
	public static final String SERVICE_TYPE_IS_DELETE = "serviceTypeIsDelete";



    
    public void save(ServiceType transientInstance) {
        log.debug("saving ServiceType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServiceType persistentInstance) {
        log.debug("deleting ServiceType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServiceType findById( java.lang.String id) {
        log.debug("getting ServiceType instance with id: " + id);
        try {
            ServiceType instance = (ServiceType) getSession()
                    .get("com.zhidian.server.model.ServiceType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServiceType instance) {
        log.debug("finding ServiceType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ServiceType")
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
      log.debug("finding ServiceType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServiceType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByServiceTypeName(Object serviceTypeName
	) {
		return findByProperty(SERVICE_TYPE_NAME, serviceTypeName
		);
	}
	
	public List findByServiceTypeIsDelete(Object serviceTypeIsDelete
	) {
		return findByProperty(SERVICE_TYPE_IS_DELETE, serviceTypeIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all ServiceType instances");
		try {
			String queryString = "from ServiceType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServiceType merge(ServiceType detachedInstance) {
        log.debug("merging ServiceType instance");
        try {
            ServiceType result = (ServiceType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServiceType instance) {
        log.debug("attaching dirty ServiceType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServiceType instance) {
        log.debug("attaching clean ServiceType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}