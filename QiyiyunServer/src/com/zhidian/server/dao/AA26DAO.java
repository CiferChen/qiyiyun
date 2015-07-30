package com.zhidian.server.dao;

import com.zhidian.server.model.AA26;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for AA26 entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.AA26
  * @author MyEclipse Persistence Tools 
 */
public class AA26DAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AA26DAO.class);
		//property constants
	public static final String AAA146 = "aaa146";
	public static final String AAA147 = "aaa147";
	public static final String AAA148 = "aaa148";



    
    public void save(AA26 transientInstance) {
        log.debug("saving AA26 instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AA26 persistentInstance) {
        log.debug("deleting AA26 instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AA26 findById( java.lang.Integer id) {
        log.debug("getting AA26 instance with id: " + id);
        try {
            AA26 instance = (AA26) getSession()
                    .get("com.zhidian.server.model.AA26", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AA26 instance) {
        log.debug("finding AA26 instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.AA26")
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
      log.debug("finding AA26 instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AA26 as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAaa146(Object aaa146
	) {
		return findByProperty(AAA146, aaa146
		);
	}
	
	public List findByAaa147(Object aaa147
	) {
		return findByProperty(AAA147, aaa147
		);
	}
	
	public List findByAaa148(Object aaa148
	) {
		return findByProperty(AAA148, aaa148
		);
	}
	

	public List findAll() {
		log.debug("finding all AA26 instances");
		try {
			String queryString = "from AA26";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AA26 merge(AA26 detachedInstance) {
        log.debug("merging AA26 instance");
        try {
            AA26 result = (AA26) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AA26 instance) {
        log.debug("attaching dirty AA26 instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AA26 instance) {
        log.debug("attaching clean AA26 instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}