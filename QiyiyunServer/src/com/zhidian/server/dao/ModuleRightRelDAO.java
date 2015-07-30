package com.zhidian.server.dao;

import com.zhidian.server.model.ModuleRightRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ModuleRightRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.ModuleRightRel
  * @author MyEclipse Persistence Tools 
 */
public class ModuleRightRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ModuleRightRelDAO.class);
		//property constants
	public static final String MODULE_ID = "moduleId";
	public static final String RIGHT_ID = "rightId";



    
    public void save(ModuleRightRel transientInstance) {
        log.debug("saving ModuleRightRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ModuleRightRel persistentInstance) {
        log.debug("deleting ModuleRightRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ModuleRightRel findById( java.lang.String id) {
        log.debug("getting ModuleRightRel instance with id: " + id);
        try {
            ModuleRightRel instance = (ModuleRightRel) getSession()
                    .get("com.zhidian.server.model.ModuleRightRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ModuleRightRel instance) {
        log.debug("finding ModuleRightRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.ModuleRightRel")
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
      log.debug("finding ModuleRightRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ModuleRightRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByModuleId(Object moduleId
	) {
		return findByProperty(MODULE_ID, moduleId
		);
	}
	
	public List findByRightId(Object rightId
	) {
		return findByProperty(RIGHT_ID, rightId
		);
	}
	

	public List findAll() {
		log.debug("finding all ModuleRightRel instances");
		try {
			String queryString = "from ModuleRightRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ModuleRightRel merge(ModuleRightRel detachedInstance) {
        log.debug("merging ModuleRightRel instance");
        try {
            ModuleRightRel result = (ModuleRightRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ModuleRightRel instance) {
        log.debug("attaching dirty ModuleRightRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ModuleRightRel instance) {
        log.debug("attaching clean ModuleRightRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}