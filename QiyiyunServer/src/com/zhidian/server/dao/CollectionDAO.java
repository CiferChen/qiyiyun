package com.zhidian.server.dao;

import com.zhidian.server.model.Collection;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Collection entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Collection
  * @author MyEclipse Persistence Tools 
 */
public class CollectionDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CollectionDAO.class);
		//property constants
	public static final String COLLECTION_TITLE = "collectionTitle";
	public static final String TARGET_TABLE = "targetTable";
	public static final String TARGET_ID = "targetId";
	public static final String COLLECTION_TIME = "collectionTime";
	public static final String OPERATOR_ID = "operatorId";



    
    public void save(Collection transientInstance) {
        log.debug("saving Collection instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Collection persistentInstance) {
        log.debug("deleting Collection instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Collection findById( java.lang.String id) {
        log.debug("getting Collection instance with id: " + id);
        try {
            Collection instance = (Collection) getSession()
                    .get("com.zhidian.server.model.Collection", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Collection instance) {
        log.debug("finding Collection instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Collection")
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
      log.debug("finding Collection instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Collection as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCollectionTitle(Object collectionTitle
	) {
		return findByProperty(COLLECTION_TITLE, collectionTitle
		);
	}
	
	public List findByTargetTable(Object targetTable
	) {
		return findByProperty(TARGET_TABLE, targetTable
		);
	}
	
	public List findByTargetId(Object targetId
	) {
		return findByProperty(TARGET_ID, targetId
		);
	}
	
	public List findByCollectionTime(Object collectionTime
	) {
		return findByProperty(COLLECTION_TIME, collectionTime
		);
	}
	
	public List findByOperatorId(Object operatorId
	) {
		return findByProperty(OPERATOR_ID, operatorId
		);
	}
	

	public List findAll() {
		log.debug("finding all Collection instances");
		try {
			String queryString = "from Collection";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Collection merge(Collection detachedInstance) {
        log.debug("merging Collection instance");
        try {
            Collection result = (Collection) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Collection instance) {
        log.debug("attaching dirty Collection instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Collection instance) {
        log.debug("attaching clean Collection instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}