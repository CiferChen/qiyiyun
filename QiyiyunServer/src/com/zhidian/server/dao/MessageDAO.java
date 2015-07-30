package com.zhidian.server.dao;

import com.zhidian.server.model.Message;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Message entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Message
  * @author MyEclipse Persistence Tools 
 */
public class MessageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MessageDAO.class);
		//property constants
	public static final String MESSAGE_TITLE = "messageTitle";
	public static final String CONTENT = "content";
	public static final String CREATE_TIME = "createTime";
	public static final String SEND_TIME = "sendTime";
	public static final String MESSAGE_CREATOR_ID = "messageCreatorId";
	public static final String MESSAGE_RECEIVER_ID = "messageReceiverId";
	public static final String MESSAGE_IS_DELETE = "messageIsDelete";

    public void save(Message transientInstance) {
        log.debug("saving Message instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Message persistentInstance) {
        log.debug("deleting Message instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Message findById( java.lang.String id) {
        log.debug("getting Message instance with id: " + id);
        try {
            Message instance = (Message) getSession()
                    .get("com.zhidian.server.model.Message", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<Message> findByIds(String ids){
          try {
             String queryString = "from Message where messageId in(?)";
             Query query = getSession().createQuery(queryString);
             query.setParameter(0, ids);
             return query.list();
          } catch (RuntimeException re) {
              log.error("get failed", re);
              throw re;
          }
    }
    
    public List findByExample(Message instance) {
        log.debug("finding Message instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Message")
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
      log.debug("finding Message instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Message as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMessageTitle(Object messageTitle
	) {
		return findByProperty(MESSAGE_TITLE, messageTitle
		);
	}
	
	public List findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List findByCreateTime(Object createTime
	) {
		return findByProperty(CREATE_TIME, createTime
		);
	}
	
	public List findBySendTime(Object sendTime
	) {
		return findByProperty(SEND_TIME, sendTime
		);
	}
	
	public List findByMessageCreatorId(Object messageCreatorId
	) {
		return findByProperty(MESSAGE_CREATOR_ID, messageCreatorId
		);
	}
	
	public List findByMessageReceiverId(Object messageReceiverId
	) {
		return findByProperty(MESSAGE_RECEIVER_ID, messageReceiverId
		);
	}
	
	public List findByMessageIsDelete(Object messageIsDelete
	) {
		return findByProperty(MESSAGE_IS_DELETE, messageIsDelete
		);
	}
	

	public List findAll() {
		log.debug("finding all Message instances");
		try {
			String queryString = "from Message";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Message merge(Message detachedInstance) {
        log.debug("merging Message instance");
        try {
            Message result = (Message) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Message instance) {
        log.debug("attaching dirty Message instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Message instance) {
        log.debug("attaching clean Message instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public int deleteById(String messageId) {
		try {
            String queryString = "delete from Message where messageId=?";
            Query query = getSession().createQuery(queryString);
            query.setParameter(0, messageId);
            return query.executeUpdate();
         } catch (RuntimeException re) {
             log.error("get failed", re);
             throw re;
         }
	}
}