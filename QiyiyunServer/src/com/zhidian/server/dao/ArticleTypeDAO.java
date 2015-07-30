package com.zhidian.server.dao;

import com.zhidian.server.model.ArticleType;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ArticleType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ArticleType
  * @author MyEclipse Persistence Tools 
 */
public class ArticleTypeDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ArticleTypeDAO.class);
		//property constants
	public static final String ARTICLE_TYPE_NAME = "articleTypeName";
	public static final String ARTICLE_TYPE_IS_DELETE = "articleTypeIsDelete";



    
    public void save(ArticleType transientInstance) {
        log.debug("saving ArticleType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ArticleType persistentInstance) {
        log.debug("deleting ArticleType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ArticleType findById( java.lang.String id) {
        log.debug("getting ArticleType instance with id: " + id);
        try {
            ArticleType instance = (ArticleType) getSession()
                    .get("com.zhidian.server.model.ArticleType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ArticleType instance) {
        log.debug("finding ArticleType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ArticleType")
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
      log.debug("finding ArticleType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ArticleType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByArticleTypeName(Object articleTypeName
	) {
		return findByProperty(ARTICLE_TYPE_NAME, articleTypeName
		);
	}
	
	public List findByArticleTypeIsDelete(Object articleTypeIsDelete
	) {
		return findByProperty(ARTICLE_TYPE_IS_DELETE, articleTypeIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all ArticleType instances");
		try {
			String queryString = "from ArticleType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ArticleType merge(ArticleType detachedInstance) {
        log.debug("merging ArticleType instance");
        try {
            ArticleType result = (ArticleType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ArticleType instance) {
        log.debug("attaching dirty ArticleType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ArticleType instance) {
        log.debug("attaching clean ArticleType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}