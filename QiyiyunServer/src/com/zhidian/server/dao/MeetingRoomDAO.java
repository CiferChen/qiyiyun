package com.zhidian.server.dao;

import com.zhidian.server.model.MeetingRoom;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for MeetingRoom entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.MeetingRoom
  * @author MyEclipse Persistence Tools 
 */
public class MeetingRoomDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MeetingRoomDAO.class);
		//property constants
	public static final String MEETING_ROOM_NAME = "meetingRoomName";
	public static final String SPACE_ID = "spaceId";
	public static final String MEETING_ROOM_TYPE_ID = "meetingRoomTypeId";
	public static final String MEETING_ROOM_EQUIPMENT = "meetingRoomEquipment";
	public static final String MEETING_ROOM_STATUS = "meetingRoomStatus";
	public static final String MEETING_ROOM_IS_DELETE = "meetingRoomIsDelete";



    
    public void save(MeetingRoom transientInstance) {
        log.debug("saving MeetingRoom instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MeetingRoom persistentInstance) {
        log.debug("deleting MeetingRoom instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MeetingRoom findById( java.lang.String id) {
        log.debug("getting MeetingRoom instance with id: " + id);
        try {
            MeetingRoom instance = (MeetingRoom) getSession()
                    .get("com.zhidian.server.model.MeetingRoom", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(MeetingRoom instance) {
        log.debug("finding MeetingRoom instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.MeetingRoom")
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
      log.debug("finding MeetingRoom instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MeetingRoom as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMeetingRoomName(Object meetingRoomName
	) {
		return findByProperty(MEETING_ROOM_NAME, meetingRoomName
		);
	}
	
	public List findBySpaceId(Object spaceId
	) {
		return findByProperty(SPACE_ID, spaceId
		);
	}
	
	public List findByMeetingRoomTypeId(Object meetingRoomTypeId
	) {
		return findByProperty(MEETING_ROOM_TYPE_ID, meetingRoomTypeId
		);
	}
	
	public List findByMeetingRoomEquipment(Object meetingRoomEquipment
	) {
		return findByProperty(MEETING_ROOM_EQUIPMENT, meetingRoomEquipment
		);
	}
	
	public List findByMeetingRoomStatus(Object meetingRoomStatus
	) {
		return findByProperty(MEETING_ROOM_STATUS, meetingRoomStatus
		);
	}
	
	public List findByMeetingRoomIsDelete(Object meetingRoomIsDelete
	) {
		return findByProperty(MEETING_ROOM_IS_DELETE, meetingRoomIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all MeetingRoom instances");
		try {
			String queryString = "from MeetingRoom";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MeetingRoom merge(MeetingRoom detachedInstance) {
        log.debug("merging MeetingRoom instance");
        try {
            MeetingRoom result = (MeetingRoom) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MeetingRoom instance) {
        log.debug("attaching dirty MeetingRoom instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MeetingRoom instance) {
        log.debug("attaching clean MeetingRoom instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}