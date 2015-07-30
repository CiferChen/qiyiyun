package com.zhidian.server.dao;
// default package


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.zhidian.server.model.MemberRelRecord;

/**
 	* A data access object (DAO) providing persistence and search support for MemberRelRecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .MemberRelRecord
  * @author MyEclipse Persistence Tools 
 */
public class MemberRelRecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = Logger.getLogger(MemberRelRecordDAO.class);
		//property constants
	public static final String MEMBER_ID = "memberId";
	public static final String ORGAN_ID = "organId";
	public static final String RECORD_DIRECTION = "recordDirection";
	public static final String RECORD_STATUS = "recordStatus";
	public static final String RECORD_CREATE_TIME = "recordCreateTime";
	public static final String RECORD_RESPOND_TIME = "recordRespondTime";
	public static final String RECORD_IS_DELETE = "recordIsDelete";



    
    public void save(MemberRelRecord transientInstance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("saving MemberRelRecord instance");
        try {
            getSession().save(transientInstance);
            tx.commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberRelRecord persistentInstance) {
		Transaction tx = getSession().beginTransaction();
        log.debug("deleting MemberRelRecord instance");
        try {
            getSession().delete(persistentInstance);
            tx.commit();
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberRelRecord findById( java.lang.String id) {
        log.debug("getting MemberRelRecord instance with id: " + id);
        try {
            MemberRelRecord instance = (MemberRelRecord) getSession()
                    .get("com.zhidian.server.model.MemberRelRecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MemberRelRecord instance) {
        log.debug("finding MemberRelRecord instance by example");
        try {
            List results = getSession()
                    .createCriteria("MemberRelRecord")
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
      log.debug("finding MemberRelRecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberRelRecord as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMemberId(Object memberId
	) {
		return findByProperty(MEMBER_ID, memberId
		);
	}
	
	public List findByOrganId(Object organId
	) {
		return findByProperty(ORGAN_ID, organId
		);
	}
	
	public List findByRecordDirection(Object recordDirection
	) {
		return findByProperty(RECORD_DIRECTION, recordDirection
		);
	}
	
	public List findByRecordStatus(Object recordStatus
	) {
		return findByProperty(RECORD_STATUS, recordStatus
		);
	}
	
	public List findByRecordCreateTime(Object recordCreateTime
	) {
		return findByProperty(RECORD_CREATE_TIME, recordCreateTime
		);
	}
	
	public List findByRecordRespondTime(Object recordRespondTime
	) {
		return findByProperty(RECORD_RESPOND_TIME, recordRespondTime
		);
	}
	
	public List findByRecordIsDelete(Object recordIsDelete
	) {
		return findByProperty(RECORD_IS_DELETE, recordIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MemberRelRecord instances");
		try {
			String queryString = "from MemberRelRecord";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberRelRecord merge(MemberRelRecord detachedInstance) {
        log.debug("merging MemberRelRecord instance");
        try {
            MemberRelRecord result = (MemberRelRecord) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberRelRecord instance) {
    	Transaction tx = getSession().beginTransaction();
        log.debug("attaching dirty MemberRelRecord instance");
        try {
            getSession().saveOrUpdate(instance);
            tx.commit();
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberRelRecord instance) {
        log.debug("attaching clean MemberRelRecord instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public List<MemberRelRecord> getUserApplyToOrganListByOrganId(String organId) {
		 log.debug("getUserApplyToOrganListByOrganId");
	     try {
	    	 String queryString = "from MemberRelRecord where organId='"+organId+"' and recordDirection='0' and recordStatus='0'";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
			 
	     } catch (RuntimeException re) {
	            log.error("get failed", re);
	            throw re;
	     }
		
	}

	public boolean checkInviteIsExsit(String personId, String organId) {
		log.debug("checkInviteIsExsit");
	     try {
	    	 String queryString = "from MemberRelRecord where memberId='"+personId+"' and organId='"+organId+"' and recordDirection='1'";
	         Query queryObject = getSession().createQuery(queryString);
	         if(queryObject.list().size()>0){
	        	 return true;
	         }
			 
	     } catch (RuntimeException re) {
	            log.error("checkInviteIsExsit failed", re);
	            throw re;
	     }
		return false;
	}
}