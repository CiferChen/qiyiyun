package com.zhidian.server.dao;

import com.zhidian.server.model.Organization;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for Organization entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Organization
  * @author MyEclipse Persistence Tools 
 */
public class OrganizationDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(OrganizationDAO.class);
		//property constants
	public static final String ORGAN_NAME = "organName";
	public static final String CREATE_TIME = "createTime";
	public static final String CREATER_ID = "createrId";
	public static final String ORGAN_DESCRIPTION = "organDescription";
	public static final String ORGAN_ADDRESS = "organAddress";
	public static final String ORGAN_TYPE_ID = "organTypeId";
	public static final String CONTACT_NAME = "contactName";
	public static final String CONTACT_PHONE = "contactPhone";
	public static final String CONTACT_EMAIL = "contactEmail";



    
    public void save(Organization transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving Organization instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Organization persistentInstance) {
        log.debug("deleting Organization instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Organization findById( java.lang.String id) {
        log.debug("getting Organization instance with id: " + id);
        try {
            Organization instance = (Organization) getSession()
                    .get("com.zhidian.server.model.Organization", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Organization> findByIds(String strOrganId) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("finding Organization  by Ids");
        try {
        	String queryString = "from Organization where organId in("+strOrganId+")";
        //    String queryString1 = "from Organization where organId in(:organIds)";
        	Query query = getSession().createQuery(queryString);
           // log.info(query.getQueryString());
           // query.setParameter(0, strOrganId);
//            String[] organIds = strOrganId.split(",");
//            List<String> ids = new ArrayList<String>();
//            for(int i=0;i<organIds.length;i++){
//            	ids.add(organIds[i]);
//            }
//            log.info(ids.size());
//            query.setParameterList("organIds",organIds);
           log.debug("find by Ids successful" );
            tx.commit();
            return query.list();
        } catch (RuntimeException re) {
            log.error("find by Ids failed", re);
            throw re;
        }
    }   
    
    
    public List findByExample(Organization instance) {
        log.debug("finding Organization instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Organization")
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
      log.debug("finding Organization instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Organization as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByOrganName(Object organName
	) {
		return findByProperty(ORGAN_NAME, organName
		);
	}
	
	public List findByCreateTime(Object createTime
	) {
		return findByProperty(CREATE_TIME, createTime
		);
	}
	
	public List findByCreaterId(Object createrId
	) {
		return findByProperty(CREATER_ID, createrId
		);
	}
	
	public List findByOrganDescription(Object organDescription
	) {
		return findByProperty(ORGAN_DESCRIPTION, organDescription
		);
	}
	
	public List findByOrganAddress(Object organAddress
	) {
		return findByProperty(ORGAN_ADDRESS, organAddress
		);
	}
	
	public List findByOrganTypeId(Object organTypeId
	) {
		return findByProperty(ORGAN_TYPE_ID, organTypeId
		);
	}
	
	public List findByContactName(Object contactName
	) {
		return findByProperty(CONTACT_NAME, contactName
		);
	}
	
	public List findByContactPhone(Object contactPhone
	) {
		return findByProperty(CONTACT_PHONE, contactPhone
		);
	}
	
	public List findByContactEmail(Object contactEmail
	) {
		return findByProperty(CONTACT_EMAIL, contactEmail
		);
	}
	

	public List findAll() {
		log.debug("finding all Organization instances");
		try {
			String queryString = "from Organization";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Organization merge(Organization detachedInstance) {
        log.debug("merging Organization instance");
        try {
            Organization result = (Organization) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Organization instance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("attaching dirty Organization instance");
        try {
            getSession().saveOrUpdate(instance);
            tx.commit();
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Organization instance) {
        log.debug("attaching clean Organization instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}