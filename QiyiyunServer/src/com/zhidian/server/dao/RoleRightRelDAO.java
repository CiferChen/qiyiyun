package com.zhidian.server.dao;

import com.zhidian.server.model.RoleRightRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for RoleRightRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.RoleRightRel
  * @author MyEclipse Persistence Tools 
 */
public class RoleRightRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(RoleRightRelDAO.class);
		//property constants
	public static final String ROLE_ID = "roleId";
	public static final String RIGHT_ID = "rightId";



    
    public void save(RoleRightRel transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving RoleRightRel instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RoleRightRel persistentInstance) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting RoleRightRel instance");
        try {
            getSession().delete(persistentInstance);
            tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RoleRightRel findById( java.lang.String id) {
        log.debug("getting RoleRightRel instance with id: " + id);
        try {
            RoleRightRel instance = (RoleRightRel) getSession()
                    .get("com.zhidian.server.model.RoleRightRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RoleRightRel instance) {
        log.debug("finding RoleRightRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.RoleRightRel")
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
      log.debug("finding RoleRightRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RoleRightRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRoleId(Object roleId
	) {
		return findByProperty(ROLE_ID, roleId
		);
	}
	
	public List findByRightId(Object rightId
	) {
		return findByProperty(RIGHT_ID, rightId
		);
	}
	

	public List findAll() {
		log.debug("finding all RoleRightRel instances");
		try {
			String queryString = "from RoleRightRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RoleRightRel merge(RoleRightRel detachedInstance) {
        log.debug("merging RoleRightRel instance");
        try {
            RoleRightRel result = (RoleRightRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RoleRightRel instance) {
        log.debug("attaching dirty RoleRightRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RoleRightRel instance) {
        log.debug("attaching clean RoleRightRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public void deleteByRoleId(String roleId) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting RoleRightRel instance");
        try {
        	String queryString = "delete from RoleRightRel where roleId= '"+roleId+"'";
	        Query queryObject = getSession().createQuery(queryString);
	        queryObject.executeUpdate();
            tx.commit();
            log.debug("deleteByRoleId successful");
        } catch (RuntimeException re) {
            log.error("deleteByRoleId failed", re);
            throw re;
        }		
	}
}