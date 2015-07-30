package com.zhidian.server.dao;

import com.zhidian.server.model.Activity;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Activity entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Activity
  * @author MyEclipse Persistence Tools 
 */
public class ActivityDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ActivityDAO.class);
		//property constants
	public static final String ACTIVITY_TITLE = "activityTitle";
	public static final String ACTIVITY_PURPOSE = "activityPurpose";
	public static final String ACTIVITY_PERSON_NUMBER = "activityPersonNumber";
	public static final String ACTIVITY_TIME = "activityTime";
	public static final String ACTIVITY_STATE = "activityState";
	public static final String ACTIVITY_LEADER_NAME = "activityLeaderName";
	public static final String ACTIVITY_LEADER_PHONE = "activityLeaderPhone";
	public static final String ACTIVITY_APPLICANTS_END_TIME = "activityApplicantsEndTime";
	public static final String USER_ID = "userId";
	public static final String USER_PERSON_ID = "userPersonId";
	public static final String ORGAN_ID = "organId";
	public static final String ACITIVTY_IS_DELETE = "acitivtyIsDelete";



    
    public void save(Activity transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving Activity instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Activity persistentInstance) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting Activity instance");
        try {
            getSession().delete(persistentInstance);
            tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Activity findById( java.lang.String id) {
        log.debug("getting Activity instance with id: " + id);
        try {
            Activity instance = (Activity) getSession()
                    .get("com.zhidian.server.model.Activity", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Activity instance) {
        log.debug("finding Activity instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Activity")
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
      log.debug("finding Activity instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Activity as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByActivityTitle(Object activityTitle
	) {
		return findByProperty(ACTIVITY_TITLE, activityTitle
		);
	}
	
	public List findByActivityPurpose(Object activityPurpose
	) {
		return findByProperty(ACTIVITY_PURPOSE, activityPurpose
		);
	}
	
	public List findByActivityPersonNumber(Object activityPersonNumber
	) {
		return findByProperty(ACTIVITY_PERSON_NUMBER, activityPersonNumber
		);
	}
	
	public List findByActivityTime(Object activityTime
	) {
		return findByProperty(ACTIVITY_TIME, activityTime
		);
	}
	
	public List findByActivityState(Object activityState
	) {
		return findByProperty(ACTIVITY_STATE, activityState
		);
	}
	
	public List findByActivityLeaderName(Object activityLeaderName
	) {
		return findByProperty(ACTIVITY_LEADER_NAME, activityLeaderName
		);
	}
	
	public List findByActivityLeaderPhone(Object activityLeaderPhone
	) {
		return findByProperty(ACTIVITY_LEADER_PHONE, activityLeaderPhone
		);
	}
	
	public List findByActivityApplicantsEndTime(Object activityApplicantsEndTime
	) {
		return findByProperty(ACTIVITY_APPLICANTS_END_TIME, activityApplicantsEndTime
		);
	}
	
	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List findByUserPersonId(Object userPersonId
	) {
		return findByProperty(USER_PERSON_ID, userPersonId
		);
	}
	
	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	
	public List findByAcitivtyIsDelete(Object acitivtyIsDelete
	) {
		return findByProperty(ACITIVTY_IS_DELETE, acitivtyIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Activity instances");
		try {
			String queryString = "from Activity";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Activity merge(Activity detachedInstance) {
        log.debug("merging Activity instance");
        try {
            Activity result = (Activity) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Activity instance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("attaching dirty Activity instance");
        try {
            getSession().saveOrUpdate(instance);
            tx.commit();
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Activity instance) {
        log.debug("attaching clean Activity instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}