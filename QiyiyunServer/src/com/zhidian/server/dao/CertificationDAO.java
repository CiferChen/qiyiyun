package com.zhidian.server.dao;

import com.zhidian.server.model.Certification;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Certification entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.zhidian.server.model.Certification
 * @author MyEclipse Persistence Tools
 */
public class CertificationDAO extends BaseHibernateDAO {
	private static final Logger log = Logger
			.getLogger(CertificationDAO.class);
	// property constants
	public static final String CERTIFICATION_TYPE_ID = "certificationTypeId";
	public static final String CERTIFICATION_OBJECT = "certificationObject";
	public static final String CERTIFICATION_TIME = "certificationTime";
	public static final String CERTIFICATION_NAME = "certificationName";
	public static final String CERTIFICATION_NUMBER = "certificationNumber";
	public static final String CERTIFICATION_IMAGE = "certificationImage";
	public static final String CERTIFICATION_STATUS = "certificationStatus";

	@SuppressWarnings("unchecked")
	public List<Certification> findByCertificationTypeInIds(String ids,String certificationTypeId){
		Transaction tx =getSession().beginTransaction();
		log.debug("findByCertificationTypeInIds");
		try{
			String queryString = "from Certification where certificationId in("+ids+") and certificationTypeId = '"+certificationTypeId+"'";
			Query query = getSession().createQuery(queryString);
			tx.commit();
			log.debug("find by Ids successful" );
			return query.list();
			
		}catch(RuntimeException re){
			 log.error("find by Ids failed", re);
	            throw re;
		}
	
	}
	
	
	public void save(Certification transientInstance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("saving Certification instance");
		try {
			getSession().save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Certification persistentInstance) {
		log.debug("deleting Certification instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Certification findById(java.lang.String id) {
		log.debug("getting Certification instance with id: " + id);
		try {
			Certification instance = (Certification) getSession().get(
					"com.zhidian.server.model.Certification", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Certification instance) {
		log.debug("finding Certification instance by example");
		try {
			List results = getSession()
					.createCriteria("com.zhidian.server.model.Certification")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Certification instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Certification as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCertificationTypeId(Object certificationTypeId) {
		return findByProperty(CERTIFICATION_TYPE_ID, certificationTypeId);
	}

	public List findByCertificationObject(Object certificationObject) {
		return findByProperty(CERTIFICATION_OBJECT, certificationObject);
	}

	public List findByCertificationTime(Object certificationTime) {
		return findByProperty(CERTIFICATION_TIME, certificationTime);
	}

	public List findByCertificationName(Object certificationName) {
		return findByProperty(CERTIFICATION_NAME, certificationName);
	}

	public List findByCertificationNumber(Object certificationNumber) {
		return findByProperty(CERTIFICATION_NUMBER, certificationNumber);
	}

	public List findByCertificationImage(Object certificationImage) {
		return findByProperty(CERTIFICATION_IMAGE, certificationImage);
	}

	public List findByCertificationStatus(Object certificationStatus) {
		return findByProperty(CERTIFICATION_STATUS, certificationStatus);
	}

	public List findAll() {
		log.debug("finding all Certification instances");
		try {
			String queryString = "from Certification";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Certification merge(Certification detachedInstance) {
		log.debug("merging Certification instance");
		try {
			Certification result = (Certification) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Certification instance) {
		Transaction tx = getSession().beginTransaction();
		log.debug("attaching dirty Certification instance");
		try {
			getSession().saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Certification instance) {
		log.debug("attaching clean Certification instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Certification> findByIds(String certificationIds) {
		Transaction tx =getSession().beginTransaction();
		log.debug("findInIds");
		try{
			String queryString = "from Certification where certificationId in("+certificationIds+")";
			Query query = getSession().createQuery(queryString);
			tx.commit();
			log.debug("find by Ids successful" );
			return query.list();
			
		}catch(RuntimeException re){
			 log.error("find by Ids failed", re);
	            throw re;
		}
	}

}