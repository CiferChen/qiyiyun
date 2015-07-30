package com.zhidian.server.dao;

import com.zhidian.server.model.PersonCertificationRel;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for PersonCertificationRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.PersonCertificationRel
  * @author MyEclipse Persistence Tools 
 */
public class PersonCertificationRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(PersonCertificationRelDAO.class);
		//property constants
	public static final String PERSON_ID = "personId";
	public static final String CERTIFICATION_ID = "certificationId";



    
    public void save(PersonCertificationRel transientInstance) {
        log.debug("saving PersonCertificationRel instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PersonCertificationRel persistentInstance) {
        log.debug("deleting PersonCertificationRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PersonCertificationRel findById( java.lang.String id) {
        log.debug("getting PersonCertificationRel instance with id: " + id);
        try {
            PersonCertificationRel instance = (PersonCertificationRel) getSession()
                    .get("com.zhidian.server.model.PersonCertificationRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PersonCertificationRel instance) {
        log.debug("finding PersonCertificationRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.PersonCertificationRel")
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
      log.debug("finding PersonCertificationRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PersonCertificationRel as model where model." 
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
	
	public List findByCertificationId(Object certificationId
	) {
		return findByProperty(CERTIFICATION_ID, certificationId
		);
	}
	

	public List findAll() {
		log.debug("finding all PersonCertificationRel instances");
		try {
			String queryString = "from PersonCertificationRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PersonCertificationRel merge(PersonCertificationRel detachedInstance) {
        log.debug("merging PersonCertificationRel instance");
        try {
            PersonCertificationRel result = (PersonCertificationRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PersonCertificationRel instance) {
        log.debug("attaching dirty PersonCertificationRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PersonCertificationRel instance) {
        log.debug("attaching clean PersonCertificationRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}