package com.zhidian.server.dao;

import com.zhidian.server.model.MeetingRoomRecord;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MeetingRoomRecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.MeetingRoomRecord
  * @author MyEclipse Persistence Tools 
 */
public class MeetingRoomRecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MeetingRoomRecordDAO.class);
		//property constants
	public static final String MEETING_ROOM_ID = "meetingRoomId";
	public static final String MEETING_ROOM_START_TIME = "meetingRoomStartTime";
	public static final String MEETING_ROOM_END_TIME = "meetingRoomEndTime";
	public static final String USER_ID = "userId";
	public static final String MEETING_ROOM_RECORD_URL = "meetingRoomRecordUrl";
	public static final String MEETING_ROOM_RECORD_IS_DELETE = "meetingRoomRecordIsDelete";



    
    public void save(MeetingRoomRecord transientInstance) {
        log.debug("saving MeetingRoomRecord instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MeetingRoomRecord persistentInstance) {
        log.debug("deleting MeetingRoomRecord instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MeetingRoomRecord findById( java.lang.String id) {
        log.debug("getting MeetingRoomRecord instance with id: " + id);
        try {
            MeetingRoomRecord instance = (MeetingRoomRecord) getSession()
                    .get("com.zhidian.server.model.MeetingRoomRecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MeetingRoomRecord instance) {
        log.debug("finding MeetingRoomRecord instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.MeetingRoomRecord")
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
      log.debug("finding MeetingRoomRecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MeetingRoomRecord as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMeetingRoomId(Object meetingRoomId
	) {
		return findByProperty(MEETING_ROOM_ID, meetingRoomId
		);
	}
	
	public List findByMeetingRoomStartTime(Object meetingRoomStartTime
	) {
		return findByProperty(MEETING_ROOM_START_TIME, meetingRoomStartTime
		);
	}
	
	public List findByMeetingRoomEndTime(Object meetingRoomEndTime
	) {
		return findByProperty(MEETING_ROOM_END_TIME, meetingRoomEndTime
		);
	}
	
	public List findByUserId(Object userId
	) {
		return findByProperty(USER_ID, userId
		);
	}
	
	public List findByMeetingRoomRecordUrl(Object meetingRoomRecordUrl
	) {
		return findByProperty(MEETING_ROOM_RECORD_URL, meetingRoomRecordUrl
		);
	}
	
	public List findByMeetingRoomRecordIsDelete(Object meetingRoomRecordIsDelete
	) {
		return findByProperty(MEETING_ROOM_RECORD_IS_DELETE, meetingRoomRecordIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MeetingRoomRecord instances");
		try {
			String queryString = "from MeetingRoomRecord";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MeetingRoomRecord merge(MeetingRoomRecord detachedInstance) {
        log.debug("merging MeetingRoomRecord instance");
        try {
            MeetingRoomRecord result = (MeetingRoomRecord) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MeetingRoomRecord instance) {
        log.debug("attaching dirty MeetingRoomRecord instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MeetingRoomRecord instance) {
        log.debug("attaching clean MeetingRoomRecord instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}