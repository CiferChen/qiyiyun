package com.zhidian.server.dao;

import com.zhidian.server.model.Order;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Order entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Order
  * @author MyEclipse Persistence Tools 
 */
public class OrderDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);
		//property constants
	public static final String GOODS_ID = "goodsId";
	public static final String ORDER_PAY_WAY = "orderPayWay";
	public static final String ORDER_PAY_STATUS = "orderPayStatus";
	public static final String ORDER_STATUS = "orderStatus";
	public static final String ORDER_MONEY = "orderMoney";
	public static final String ORDER_IS_DELETE = "orderIsDelete";



    
    public void save(Order transientInstance) {
        log.debug("saving Order instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Order persistentInstance) {
        log.debug("deleting Order instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Order findById( java.lang.String id) {
        log.debug("getting Order instance with id: " + id);
        try {
            Order instance = (Order) getSession()
                    .get("com.zhidian.server.model.Order", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Order instance) {
        log.debug("finding Order instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Order")
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
      log.debug("finding Order instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Order as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGoodsId(Object goodsId
	) {
		return findByProperty(GOODS_ID, goodsId
		);
	}
	
	public List findByOrderPayWay(Object orderPayWay
	) {
		return findByProperty(ORDER_PAY_WAY, orderPayWay
		);
	}
	
	public List findByOrderPayStatus(Object orderPayStatus
	) {
		return findByProperty(ORDER_PAY_STATUS, orderPayStatus
		);
	}
	
	public List findByOrderStatus(Object orderStatus
	) {
		return findByProperty(ORDER_STATUS, orderStatus
		);
	}
	
	public List findByOrderMoney(Object orderMoney
	) {
		return findByProperty(ORDER_MONEY, orderMoney
		);
	}
	
	public List findByOrderIsDelete(Object orderIsDelete
	) {
		return findByProperty(ORDER_IS_DELETE, orderIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Order merge(Order detachedInstance) {
        log.debug("merging Order instance");
        try {
            Order result = (Order) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Order instance) {
        log.debug("attaching dirty Order instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Order instance) {
        log.debug("attaching clean Order instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}