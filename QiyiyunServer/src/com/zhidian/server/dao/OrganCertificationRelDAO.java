package com.zhidian.server.dao;

import com.zhidian.server.model.OrganCertificationRel;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for OrganCertificationRel entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.OrganCertificationRel
  * @author MyEclipse Persistence Tools 
 */
public class OrganCertificationRelDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(OrganCertificationRelDAO.class);
		//property constants
	public static final String ORGAN_ID = "organId";
	public static final String CERTIFICATION_ID = "certificationId";



    
    public void save(OrganCertificationRel transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving OrganCertificationRel instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OrganCertificationRel persistentInstance) {
        log.debug("deleting OrganCertificationRel instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OrganCertificationRel findById( java.lang.String id) {
        log.debug("getting OrganCertificationRel instance with id: " + id);
        try {
            OrganCertificationRel instance = (OrganCertificationRel) getSession()
                    .get("com.zhidian.server.model.OrganCertificationRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OrganCertificationRel instance) {
        log.debug("finding OrganCertificationRel instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.OrganCertificationRel")
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
      log.debug("finding OrganCertificationRel instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OrganCertificationRel as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	
	
	public List findByOrganIds(String organIds) {
		try{
			String queryString = "from OrganCertificationRel where organId in("+organIds+")";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		}catch(RuntimeException re){
			log.error("findByOrganIds failed", re);
	         throw re;
		}
	}
	
	
	public List findByCertificationId(Object certificationId
	) {
		return findByProperty(CERTIFICATION_ID, certificationId
		);
	}
	

	public List findAll() {
		log.debug("finding all OrganCertificationRel instances");
		try {
			String queryString = "from OrganCertificationRel";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OrganCertificationRel merge(OrganCertificationRel detachedInstance) {
        log.debug("merging OrganCertificationRel instance");
        try {
            OrganCertificationRel result = (OrganCertificationRel) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OrganCertificationRel instance) {
        log.debug("attaching dirty OrganCertificationRel instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OrganCertificationRel instance) {
        log.debug("attaching clean OrganCertificationRel instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}