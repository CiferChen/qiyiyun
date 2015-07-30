package com.zhidian.server.dao;

import com.zhidian.server.model.ServiceGoods;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ServiceGoods entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ServiceGoods
  * @author MyEclipse Persistence Tools 
 */
public class ServiceGoodsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ServiceGoodsDAO.class);
		//property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SERVICE_GOODS_NAME = "serviceGoodsName";
	public static final String SERVICE_GOODS_TIME_UNIT = "serviceGoodsTimeUnit";
	public static final String SERVICE_GOODS_DESC = "serviceGoodsDesc";
	public static final String SERVICE_GOODS_MARGIN = "serviceGoodsMargin";



    
    public void save(ServiceGoods transientInstance) {
        log.debug("saving ServiceGoods instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServiceGoods persistentInstance) {
        log.debug("deleting ServiceGoods instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServiceGoods findById( java.lang.String id) {
        log.debug("getting ServiceGoods instance with id: " + id);
        try {
            ServiceGoods instance = (ServiceGoods) getSession()
                    .get("com.zhidian.server.model.ServiceGoods", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServiceGoods instance) {
        log.debug("finding ServiceGoods instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ServiceGoods")
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
      log.debug("finding ServiceGoods instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServiceGoods as model where model." 
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
	
	public List findByServiceGoodsName(Object serviceGoodsName
	) {
		return findByProperty(SERVICE_GOODS_NAME, serviceGoodsName
		);
	}
	
	public List findByServiceGoodsTimeUnit(Object serviceGoodsTimeUnit
	) {
		return findByProperty(SERVICE_GOODS_TIME_UNIT, serviceGoodsTimeUnit
		);
	}
	
	public List findByServiceGoodsDesc(Object serviceGoodsDesc
	) {
		return findByProperty(SERVICE_GOODS_DESC, serviceGoodsDesc
		);
	}
	
	public List findByServiceGoodsMargin(Object serviceGoodsMargin
	) {
		return findByProperty(SERVICE_GOODS_MARGIN, serviceGoodsMargin
		);
	}
	

	public List findAll() {
		log.debug("finding all ServiceGoods instances");
		try {
			String queryString = "from ServiceGoods";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServiceGoods merge(ServiceGoods detachedInstance) {
        log.debug("merging ServiceGoods instance");
        try {
            ServiceGoods result = (ServiceGoods) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServiceGoods instance) {
        log.debug("attaching dirty ServiceGoods instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServiceGoods instance) {
        log.debug("attaching clean ServiceGoods instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}