package com.zhidian.server.dao;

import com.zhidian.server.model.Favorite;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Favorite entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Favorite
  * @author MyEclipse Persistence Tools 
 */
public class FavoriteDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(FavoriteDAO.class);
		//property constants
	public static final String USER_ID = "userId";
	public static final String GOODS_ID = "goodsId";
	public static final String SERVICE_GOODS_ID = "serviceGoodsId";



    
    public void save(Favorite transientInstance) {
        log.debug("saving Favorite instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Favorite persistentInstance) {
        log.debug("deleting Favorite instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Favorite findById( java.lang.String id) {
        log.debug("getting Favorite instance with id: " + id);
        try {
            Favorite instance = (Favorite) getSession()
                    .get("com.zhidian.server.model.Favorite", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Favorite instance) {
        log.debug("finding Favorite instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Favorite")
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
      log.debug("finding Favorite instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Favorite as model where model." 
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
	
	public List findByGoodsId(Object goodsId
	) {
		return findByProperty(GOODS_ID, goodsId
		);
	}
	
	public List findByServiceGoodsId(Object serviceGoodsId
	) {
		return findByProperty(SERVICE_GOODS_ID, serviceGoodsId
		);
	}
	

	public List findAll() {
		log.debug("finding all Favorite instances");
		try {
			String queryString = "from Favorite";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Favorite merge(Favorite detachedInstance) {
        log.debug("merging Favorite instance");
        try {
            Favorite result = (Favorite) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Favorite instance) {
        log.debug("attaching dirty Favorite instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Favorite instance) {
        log.debug("attaching clean Favorite instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public int deleteAllByUserId(String userId) {
		try{
			String deleteString = "delete from Favorite where userId=?";
			Query query = getSession().createQuery(deleteString);
			query.setParameter(0, userId);
			return query.executeUpdate();
		}catch(RuntimeException re){
			log.error("delete failed");
			throw re;
		}
	}
}