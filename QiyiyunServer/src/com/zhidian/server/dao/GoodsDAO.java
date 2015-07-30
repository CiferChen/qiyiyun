package com.zhidian.server.dao;

import com.zhidian.server.model.Goods;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Goods entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.zhidian.server.model.Goods
  * @author MyEclipse Persistence Tools 
 */
public class GoodsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(GoodsDAO.class);
		//property constants
	public static final String GOODS_TYPE_ID = "goodsTypeId";
	public static final String GOODS_NAME = "goodsName";
	public static final String GOODS_UP_TIME = "goodsUpTime";
	public static final String GOODS_DOWN_TIME = "goodsDownTime";
	public static final String GOODS_PROVIDER = "goodsProvider";
	public static final String GOODS_KEY_WORDS = "goodsKeyWords";
	public static final String GOODS_PRICE = "goodsPrice";
	public static final String GOODS_THUMB = "goodsThumb";
	public static final String GOODS_IMG = "goodsImg";
	public static final String GOODS_ORIGINAL_IMG = "goodsOriginalImg";
	public static final String GOODS_DESCRIPTION = "goodsDescription";
	public static final String GOODS_BRIEF_DESCRIPTION = "goodsBriefDescription";
	public static final String GOODS_IS_DELETE = "goodsIsDelete";
	public static final String GOODS_SPACE_ID = "goodsSpaceId";
	public static final String GOODS_AREA_ID = "goodsAreaId";
	public static final String GOODS_STATUS = "goodsStatus";



    
    public void save(Goods transientInstance) {
        log.debug("saving Goods instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Goods persistentInstance) {
        log.debug("deleting Goods instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Goods findById( java.lang.String id) {
        log.debug("getting Goods instance with id: " + id);
        try {
            Goods instance = (Goods) getSession()
                    .get("com.zhidian.server.model.Goods", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Goods instance) {
        log.debug("finding Goods instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.zhidian.server.model.Goods")
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
      log.debug("finding Goods instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Goods as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGoodsTypeId(Object goodsTypeId
	) {
		return findByProperty(GOODS_TYPE_ID, goodsTypeId
		);
	}
	
	public List findByGoodsName(Object goodsName
	) {
		return findByProperty(GOODS_NAME, goodsName
		);
	}
	
	public List findByGoodsUpTime(Object goodsUpTime
	) {
		return findByProperty(GOODS_UP_TIME, goodsUpTime
		);
	}
	
	public List findByGoodsDownTime(Object goodsDownTime
	) {
		return findByProperty(GOODS_DOWN_TIME, goodsDownTime
		);
	}
	
	public List findByGoodsProvider(Object goodsProvider
	) {
		return findByProperty(GOODS_PROVIDER, goodsProvider
		);
	}
	
	public List findByGoodsKeyWords(Object goodsKeyWords
	) {
		return findByProperty(GOODS_KEY_WORDS, goodsKeyWords
		);
	}
	
	public List findByGoodsPrice(Object goodsPrice
	) {
		return findByProperty(GOODS_PRICE, goodsPrice
		);
	}
	
	public List findByGoodsThumb(Object goodsThumb
	) {
		return findByProperty(GOODS_THUMB, goodsThumb
		);
	}
	
	public List findByGoodsImg(Object goodsImg
	) {
		return findByProperty(GOODS_IMG, goodsImg
		);
	}
	
	public List findByGoodsOriginalImg(Object goodsOriginalImg
	) {
		return findByProperty(GOODS_ORIGINAL_IMG, goodsOriginalImg
		);
	}
	
	public List findByGoodsDescription(Object goodsDescription
	) {
		return findByProperty(GOODS_DESCRIPTION, goodsDescription
		);
	}
	
	public List findByGoodsBriefDescription(Object goodsBriefDescription
	) {
		return findByProperty(GOODS_BRIEF_DESCRIPTION, goodsBriefDescription
		);
	}
	
	public List findByGoodsIsDelete(Object goodsIsDelete
	) {
		return findByProperty(GOODS_IS_DELETE, goodsIsDelete
		);
	}
	
	public List findByGoodsSpaceId(Object goodsSpaceId
	) {
		return findByProperty(GOODS_SPACE_ID, goodsSpaceId
		);
	}
	
	public List findByGoodsAreaId(Object goodsAreaId
	) {
		return findByProperty(GOODS_AREA_ID, goodsAreaId
		);
	}
	
	public List findByGoodsStatus(Object goodsStatus
	) {
		return findByProperty(GOODS_STATUS, goodsStatus
		);
	}
	

	public List findAll() {
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Goods merge(Goods detachedInstance) {
        log.debug("merging Goods instance");
        try {
            Goods result = (Goods) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Goods instance) {
        log.debug("attaching dirty Goods instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Goods instance) {
        log.debug("attaching clean Goods instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}