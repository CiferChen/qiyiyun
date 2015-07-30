package com.zhidian.server.dao;

import com.zhidian.server.model.OrderServiceRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for OrderServiceRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.OrderServiceRel
  * @author MyEclipse Persistence Tools 
 */
public class OrderServiceRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OrderServiceRelDAO.class);
		//property constants
	public static final String ORDER_ID = "orderId";
	public static final String SERVICE_ID = "serviceId";



    
    public void save(OrderServiceRel transientInstance) {
        log.debug("saving OrderServiceRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OrderServiceRel persistentInstance) {
        log.debug("deleting OrderServiceRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrderServiceRel findById( java.lang.String id) {
        log.debug("getting OrderServiceRel instance with id: " + id);
        try {
            OrderServiceRel instance = (OrderServiceRel) getSession()
                    .get("com.zhidian.server.model.OrderServiceRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OrderServiceRel instance) {
        log.debug("finding OrderServiceRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.OrderServiceRel")
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
      log.debug("finding OrderServiceRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OrderServiceRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOrderId(Object orderId
	) {
		return findByProperty(ORDER_ID, orderId
		);
	}
	
	public List findByServiceId(Object serviceId
	) {
		return findByProperty(SERVICE_ID, serviceId
		);
	}
	

	public List findAll() {
		log.debug("finding all OrderServiceRel instances");
		try {
			String queryString = "from OrderServiceRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OrderServiceRel merge(OrderServiceRel detachedInstance) {
        log.debug("merging OrderServiceRel instance");
        try {
            OrderServiceRel result = (OrderServiceRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OrderServiceRel instance) {
        log.debug("attaching dirty OrderServiceRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrderServiceRel instance) {
        log.debug("attaching clean OrderServiceRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}