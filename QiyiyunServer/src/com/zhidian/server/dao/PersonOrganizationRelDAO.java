package com.zhidian.server.dao;

import com.zhidian.server.model.PersonOrganizationRel;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PersonOrganizationRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.PersonOrganizationRel
  * @author MyEclipse Persistence Tools 
 */
public class PersonOrganizationRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(PersonOrganizationRelDAO.class);
		//property constants
	public static final String PERSON_ID = "personId";
	public static final String ORGAN_ID = "organId";



    
    public void save(PersonOrganizationRel transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving PersonOrganizationRel instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PersonOrganizationRel persistentInstance) {
        log.debug("deleting PersonOrganizationRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PersonOrganizationRel findById( java.lang.String id) {
        log.debug("getting PersonOrganizationRel instance with id: " + id);
        try {
            PersonOrganizationRel instance = (PersonOrganizationRel) getSession()
                    .get("com.zhidian.server.model.PersonOrganizationRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PersonOrganizationRel instance) {
        log.debug("finding PersonOrganizationRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.PersonOrganizationRel")
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
      log.debug("finding PersonOrganizationRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PersonOrganizationRel as model where model." 
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
	
	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	

	public List findAll() {
		log.debug("finding all PersonOrganizationRel instances");
		try {
			String queryString = "from PersonOrganizationRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PersonOrganizationRel merge(PersonOrganizationRel detachedInstance) {
        log.debug("merging PersonOrganizationRel instance");
        try {
            PersonOrganizationRel result = (PersonOrganizationRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PersonOrganizationRel instance) {
        log.debug("attaching dirty PersonOrganizationRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PersonOrganizationRel instance) {
        log.debug("attaching clean PersonOrganizationRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public boolean checkIsExsit(String personId, String organId) {
		log.debug("checkIsExsit");
		try {
			String queryString = "from PersonOrganizationRel where personId = '"+personId+"' and organId = '"+organId+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         if(queryObject.list().size()>0){
	        	 return true;
	         }
		} catch (RuntimeException re) {
			log.error("checkIsExsit failed", re);
			throw re;
		}
		return false;
	}

	public void deleteByPersonIdAndOrganId(String personId, String organId) {
		Transaction tx = getSession().beginTransaction();
		log.debug("deleteByPersonIdAndOrganId");
		try {
			String queryString = "delete from PersonOrganizationRel where personId = '"+personId+"' and organId = '"+organId+"'";
	        getSession().createQuery(queryString).executeUpdate();
	        tx.commit();
		} catch (RuntimeException re) {
			log.error("deleteByPersonIdAndOrganId failed", re);
			throw re;
		}		
	}
}