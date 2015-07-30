package com.zhidian.server.dao;

import com.zhidian.server.model.Nav;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Nav entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Nav
  * @author MyEclipse Persistence Tools 
 */
public class NavDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(NavDAO.class);
		//property constants
	public static final String NAV_ADDRESS = "navAddress";
	public static final String NAV_IMAGE = "navImage";
	public static final String NAV_COUNT = "navCount";
	public static final String NAV_LINK_ADDRESS = "navLinkAddress";
	public static final String NAV_IS_DELETE = "navIsDelete";



    
    public void save(Nav transientInstance) {
        log.debug("saving Nav instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Nav persistentInstance) {
        log.debug("deleting Nav instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Nav findById( java.lang.String id) {
        log.debug("getting Nav instance with id: " + id);
        try {
            Nav instance = (Nav) getSession()
                    .get("com.zhidian.server.model.Nav", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Nav instance) {
        log.debug("finding Nav instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Nav")
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
      log.debug("finding Nav instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Nav as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNavAddress(Object navAddress
	) {
		return findByProperty(NAV_ADDRESS, navAddress
		);
	}
	
	public List findByNavImage(Object navImage
	) {
		return findByProperty(NAV_IMAGE, navImage
		);
	}
	
	public List findByNavCount(Object navCount
	) {
		return findByProperty(NAV_COUNT, navCount
		);
	}
	
	public List findByNavLinkAddress(Object navLinkAddress
	) {
		return findByProperty(NAV_LINK_ADDRESS, navLinkAddress
		);
	}
	
	public List findByNavIsDelete(Object navIsDelete
	) {
		return findByProperty(NAV_IS_DELETE, navIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Nav instances");
		try {
			String queryString = "from Nav";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Nav merge(Nav detachedInstance) {
        log.debug("merging Nav instance");
        try {
            Nav result = (Nav) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Nav instance) {
        log.debug("attaching dirty Nav instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Nav instance) {
        log.debug("attaching clean Nav instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}