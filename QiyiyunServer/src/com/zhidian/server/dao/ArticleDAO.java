package com.zhidian.server.dao;

import com.zhidian.server.model.Article;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Article entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Article
  * @author MyEclipse Persistence Tools 
 */
public class ArticleDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ArticleDAO.class);
		//property constants
	public static final String ARTICLE_TYPE_ID = "articleTypeId";
	public static final String CLICK_COUNT = "clickCount";
	public static final String ARTICLE_CONTENT = "articleContent";
	public static final String ARTICLE_TIME = "articleTime";
	public static final String ARTICLE_IS_DELETE = "articleIsDelete";



    
    public void save(Article transientInstance) {
        log.debug("saving Article instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Article persistentInstance) {
        log.debug("deleting Article instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Article findById( java.lang.String id) {
        log.debug("getting Article instance with id: " + id);
        try {
            Article instance = (Article) getSession()
                    .get("com.zhidian.server.model.Article", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Article instance) {
        log.debug("finding Article instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Article")
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
      log.debug("finding Article instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Article as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByArticleTypeId(Object articleTypeId
	) {
		return findByProperty(ARTICLE_TYPE_ID, articleTypeId
		);
	}
	
	public List findByClickCount(Object clickCount
	) {
		return findByProperty(CLICK_COUNT, clickCount
		);
	}
	
	public List findByArticleContent(Object articleContent
	) {
		return findByProperty(ARTICLE_CONTENT, articleContent
		);
	}
	
	public List findByArticleTime(Object articleTime
	) {
		return findByProperty(ARTICLE_TIME, articleTime
		);
	}
	
	public List findByArticleIsDelete(Object articleIsDelete
	) {
		return findByProperty(ARTICLE_IS_DELETE, articleIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Article instances");
		try {
			String queryString = "from Article";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Article merge(Article detachedInstance) {
        log.debug("merging Article instance");
        try {
            Article result = (Article) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Article instance) {
        log.debug("attaching dirty Article instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Article instance) {
        log.debug("attaching clean Article instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}