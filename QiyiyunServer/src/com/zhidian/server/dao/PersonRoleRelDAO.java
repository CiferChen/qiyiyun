package com.zhidian.server.dao;

import com.zhidian.server.model.PersonRoleRel;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PersonRoleRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.PersonRoleRel
  * @author MyEclipse Persistence Tools 
 */
public class PersonRoleRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(PersonRoleRelDAO.class);
		//property constants
	public static final String PERSON_ID = "personId";
	public static final String ROLE_ID = "roleId";



    
    public void save(PersonRoleRel transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving PersonRoleRel instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PersonRoleRel persistentInstance) {
        log.debug("deleting PersonRoleRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PersonRoleRel findById( java.lang.String id) {
        log.debug("getting PersonRoleRel instance with id: " + id);
        try {
            PersonRoleRel instance = (PersonRoleRel) getSession()
                    .get("com.zhidian.server.model.PersonRoleRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PersonRoleRel instance) {
        log.debug("finding PersonRoleRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.PersonRoleRel")
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
      log.debug("finding PersonRoleRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PersonRoleRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPersonId(Object personId
	) {
		return findByProperty(PERSON_ID, personId
		);
	}
	
	public List findByRoleId(Object roleId
	) {
		return findByProperty(ROLE_ID, roleId
		);
	}
	

	public List findAll() {
		log.debug("finding all PersonRoleRel instances");
		try {
			String queryString = "from PersonRoleRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PersonRoleRel merge(PersonRoleRel detachedInstance) {
        log.debug("merging PersonRoleRel instance");
        try {
            PersonRoleRel result = (PersonRoleRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PersonRoleRel instance) {
        log.debug("attaching dirty PersonRoleRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PersonRoleRel instance) {
        log.debug("attaching clean PersonRoleRel instance");
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
        log.debug("delete PersonRoleRel");
        try {
        	String queryString = "delete from PersonRoleRel where roleId= '"+roleId+"'";
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