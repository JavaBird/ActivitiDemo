package com.framework.core.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BasicType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.framework.core.util.page.Page;
import com.framework.core.util.page.PageEasyUI;
import com.framework.core.util.page.PageList;
import com.framework.core.util.page.PageUtil;


/**
 * database access base class
 * 
 * @author renhui
 * @version 1.0
 * 
 */
@Repository
public class BaseHibernateDaoImpl implements BaseDao { 
	
	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	

	public Session getManagedSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public Session getUnManagedSession(){
		return this.sessionFactory.openSession();
	}
	 
	
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#saveObject(java.lang.Object)
	 */
	public  void saveObject(Object entity)
	{
		getManagedSession().save(entity);
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#updateObject(java.lang.Object)
	 */
	public void updateObject(Object entity)
	{
		getManagedSession().update(entity);
		
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#saveOrUpdateObject(java.lang.Object)
	 */
	public void saveOrUpdateObject(Object entity)
	{
		getManagedSession().saveOrUpdate(entity);
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#deleteObject(java.lang.Object)
	 */
	public void deleteObject(Object entity)
	{
		getManagedSession().delete(entity); 
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#getObjectById(java.lang.Class, java.io.Serializable)
	 */
	public <T> T getObjectById(Class<T> entityClass,Serializable id)
	{
		return (T) getManagedSession().get(entityClass, id);
	}
	public <T> T getObjectByAnnCode(Class<T> entityClass,Serializable annCode)
	{
		return (T) getManagedSession().get(entityClass, annCode);
	}
	public <T> T getObjectByAnnTitle(Class<T> entityClass,Serializable annTitle)
	{
		return (T) getManagedSession().get(entityClass, annTitle);
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#findObjectByProperty(java.lang.Class, java.lang.String, java.lang.Object)
	 */
	 
	private List find(String queryString,Object value){
		if(queryString!=null || "".equals(queryString))
			return null;
		Query query = getManagedSession().createQuery(queryString);
		if(value!=null)
			query.setParameter(0, value);
		return query.list();
	}
	
	private List find(String queryString){
		if(queryString==null || "".equals(queryString))
			return null;
		Query query = getManagedSession().createQuery(queryString);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findObjectByProperty(Class<T> entityClass,String propertyName, Object value) {
 
			String queryString = "from "+entityClass.getName()+" as model where model."
					+ propertyName + "= ?";
			
			return (List<T>)find(queryString, value);
	}
	
	
	 /* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#findAllObject(java.lang.Class)
	 */
	public <T> List<T> findAllObject(Class<T> entityClass)
	{
		String queryString = "from "+entityClass.getName(); 
		return (List<T>)find(queryString);
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#executeWithoutResult(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void executeWithoutResult(final String hql)
	{
		Query queryObject =getManagedSession().createQuery(hql);
		queryObject.executeUpdate();
	}
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void executeWithoutResult(String hql, Object[] params) {
		 
		Query queryObject = getManagedSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
				 
			}
		}
		queryObject.executeUpdate(); 
		
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#executeWithUniqueResult(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Object executeWithUniqueResult(String hql)
	{
		Query queryObject =getManagedSession().createQuery(hql);
		return queryObject.uniqueResult(); 
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#executeWithUniqueResult(java.lang.Class, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public <T> T executeWithUniqueResult(Class<T> entityClass,String hql)
	{
		Query queryObject =getManagedSession().createQuery(hql);
		return  (T) queryObject.uniqueResult();
	 
	}
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#executeWithListResult(java.lang.String)
	 */
	public List executeWithListResult(String hql)
	{
		return find(hql);
	}
	
 
	
	/* (non-Javadoc)
	 * @see com.framework.dao.IBaseDao#executeWithListResult(java.lang.Class, java.lang.String)
	 */
	public <T> List<T> executeWithListResult(Class<T> entityClass,String hql){
		return (List<T>) find(hql);
	}
	public  void executeSQLWithoutResult(String sql){
		SQLQuery queryObject = getManagedSession().createSQLQuery(sql);
		queryObject.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public Object executeSQLWithUniqueResult(String sql) {
		SQLQuery queryObject = getManagedSession().createSQLQuery(sql);
		return queryObject.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public  List executeSQLWithListResult(String sql) {
		SQLQuery queryObject = getManagedSession().createSQLQuery(sql);
		return queryObject.list(); 
	}
	public void mergeObject(Object entity){
		getManagedSession().merge(entity);
	}

	 
	public List executeWithListResult(String hql,Object[] params){
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
 
		List list = query.list(); 
	    return  list; 
		
	}

	@SuppressWarnings("unchecked")
	public <T> T executeWithUniqueResult(Class<T> entityClass, String hql,Object[] params) {
		
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	    return (T) query.uniqueResult(); 
		
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> executeWithListResult(Class<T> entityClass, String hql,Object[] params) {
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	    return (List<T>) query.list();
		
	}

	@SuppressWarnings("unchecked")
	public Object executeWithUniqueResult(String hql, Object[] params) {
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
	    return   query.uniqueResult(); 
		
		
	}

	@SuppressWarnings("unchecked")
	public Object executeSQLWithUniqueResult(String sql, Object[] params) {
		SQLQuery queryObject = getManagedSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
			}
		}
		return queryObject.uniqueResult(); 
		
	}

	@SuppressWarnings("unchecked")
	public List executeSQLWithListResult(String sql, Object[] params) {
		SQLQuery queryObject = getManagedSession().createSQLQuery(sql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
			}
		}
		return queryObject.list(); 
		
	}
	
	public List queryHQLFirstMax(String hql,Integer f,Integer m,Object[] params){
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		query.setFirstResult(f);   
	    query.setMaxResults(m); 
		
	    return query.list();   
	}
	
	
	public int executeWithBatchUpdate(final String hql, final Object[] params) {
		Query query = getManagedSession().createQuery(hql);
		if(params!=null && params.length>0){
			query.setParameterList("ids", params);
		}
		return query.executeUpdate();
	}
	
	
	public List querySQLFirstMax(String sql,Integer f,Integer m,Object[] params,Map<String,Type> scalarType){
		SQLQuery query = (SQLQuery)getManagedSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		if (params != null && params.length > 0) {
			for (int i = 0; i <= params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		
		//
		if(scalarType!=null){
			for(Map.Entry<String, Type> map:scalarType.entrySet()){
				query.addScalar(map.getKey(), map.getValue());
			}
		}
		query.setFirstResult(f);   
	    query.setMaxResults(m); 
		
	    return query.list();   
	}
	
	
	/**
	 * 获取分页List
	 * @param page
	 * @param hql
	 * @param params
	 * @return PageList
	 */
	@SuppressWarnings("unchecked")
	public PageList queryForPageListResult(String hql, Object[] params,Page page) {
		
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		
		//获得总条数
		Long totalRecords = queryHqlCount(hql, params);
		
		Page pager = page;
		if(pager.getTotalCount()<=0){
			pager = PageUtil.createPage(page,totalRecords);
		}
		query.setFirstResult((pager.getCurrentPage()-1)*pager.getEveryPage());   
	    query.setMaxResults(pager.getEveryPage()); 
		
	    List list = query.list();   
	    
	    return  new PageList(pager,list);
		
	}

	
	@SuppressWarnings("unchecked")
	public <T> PageList<T> queryForPageListResult(Class<T> entityClass,Criterion[] params, Order[] orders, Page page) {
		
		Criteria criteria = getManagedSession().createCriteria(entityClass);
		 //设置参数
		 if(params!=null){
			 for(int i=0;i<params.length;i++){
				 criteria.add(params[i]);
			 }
		 }
		 //设置排序
		 if(orders!=null){
			 for(int i=0;i<orders.length;i++){
				 criteria.addOrder(orders[i]); 
			 }
		 }
		 
		//获得总条数
		Long totalRecords = queryHqlCount(" from "+entityClass, params);
		 
		 PageList<T> pageList = new PageList<T>();
		 pageList.setPage(null);
		 if(page!=null){
			 Page pager =page; 
			 //获取本次查询条件的满足记录条数
			 if(pager.getTotalCount()<=0){
				 pager = PageUtil.createPage(pager,totalRecords);
				} 
			 pageList.setPage(pager);
			// 设置分页参数
			 criteria.setFirstResult((page.getCurrentPage()-1)*page.getEveryPage());   
			 criteria.setMaxResults(page.getEveryPage()); 
		 }
		 pageList.setList(criteria.list());
		 
		 return pageList;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> queryForListResult(Class<T> entityClass,Criterion[] params,Order[] orders)
	{ 
		 Criteria criteria = getManagedSession().createCriteria(entityClass);
		 //设置参数
		 if(params!=null){
			 for(int i=0;i<params.length;i++){
				 criteria.add(params[i]);
			 }
		 }
		 //设置排序
		 if(orders!=null){
			 for(int i=0;i<orders.length;i++){
				 criteria.addOrder(orders[i]);
				 
			 }
		 } 
		return criteria.list();
		 
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> queryForListResult(Class<T> entityClass,Criterion[] params, Order[] orders,Integer begin,Integer count)
	{ 
		Criteria criteria = getManagedSession().createCriteria(entityClass);
		 //设置参数
		 if(params!=null){
			 for(int i=0;i<params.length;i++){
				 criteria.add(params[i]);
			 }
		 }
		 //设置排序
		 if(orders!=null){
			 for(int i=0;i<orders.length;i++){
				 criteria.addOrder(orders[i]);
				 
			 }
		 } 
		 if(begin!=null)
		 criteria.setFirstResult(begin);
		 if(count!=null)
		 criteria.setMaxResults(count);
		 
		return criteria.list();
		 
	}
	
	
	public PageList queryForSqlResultListMap(String sql,Object[] params, Page page,Map<String,Type> scalarType){
		SQLQuery query = (SQLQuery)getManagedSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		
		//
		if(scalarType!=null){
			for(Map.Entry<String, Type> m:scalarType.entrySet()){
				query.addScalar(m.getKey(), m.getValue());
			}
		}
		//获得总条数
		Long totalRecords = querySqlCount(sql, params);
		 
		 PageList pageList = new PageList();
		 pageList.setPage(null);
		 if(page!=null){
			 Page pager =page; 
			 //获取本次查询条件的满足记录条数
			 if(pager.getTotalCount()<=0){
				 pager = PageUtil.createPage(pager,totalRecords);
				} 
			 pageList.setPage(pager);
			// 设置分页参数
			 query.setFirstResult((page.getCurrentPage()-1)*page.getEveryPage());   
			 query.setMaxResults(page.getEveryPage()); 
		 }
		 pageList.setList(query.list());
		 
		 return pageList;
	}
	
	
	public Long querySqlCount(String sql,Object[] params){
		if(sql==null || "".equals(sql))
			return (long) 0;
		sql = sql.toLowerCase();
		if(sql.indexOf("count")==-1){
			sql = sql.replaceAll("(?<=select).*?(?=from)", " count(*) ");
		}
		SQLQuery query = (SQLQuery)getManagedSession().createSQLQuery(sql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		return ((Number)query.uniqueResult()).longValue();
	}
	
	public Long queryHqlCount(String hql,Object[] params){
		if(hql==null || "".equals(hql))
			return (long) 0;
		if(hql.indexOf("count")==-1){
			hql = "select count(*) "+hql;
		}
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		return ((Number)query.uniqueResult()).longValue();
	}
	
	/**
	 * @author zhangxh 2015/2/10
	 * @param count_sql
	 * @param hql
	 * @param params
	 * @return
	 */
	public PageEasyUI queryPageResult(String count_hql, String hql,
			Map<String, String> params) {
		PageEasyUI pageEasyUI = new PageEasyUI();
		String page = params.get("page");
		String rows = params.get("rows");
		int count = ((Long)this.executeWithUniqueResult(count_hql)).intValue();
	    List resultList = this.getManagedSession().createQuery(hql).setFirstResult((Integer.parseInt(page)-1)*Integer.parseInt(rows)).setMaxResults(Integer.parseInt(rows)).list();
		pageEasyUI.setTotal(String.valueOf(count));
		pageEasyUI.setRows(resultList);
		return pageEasyUI;
	}
	
	public PageEasyUI queryForPageEasyUIResult(String hql, Object[] params,Integer currentPage,Integer rows) {
		PageEasyUI pageEasyUI = new PageEasyUI();
		Query query = getManagedSession().createQuery(hql); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		//获得总条数
		Long totalRecords = queryHqlCount(hql, params);
		
		query.setFirstResult((currentPage-1)*rows);   
	    query.setMaxResults(rows); 
		
	    pageEasyUI.setTotal(String.valueOf(totalRecords));
		pageEasyUI.setRows(query.list());  
	    return  pageEasyUI;
	}
	
	public PageEasyUI queryForSqlPageEasyUIResultListMap(String sql,Object[] params,Integer currentPage,Integer rows,Map<String,Type> scalarType){
		PageEasyUI pageEasyUI = new PageEasyUI();
		SQLQuery query = (SQLQuery)getManagedSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		} 
		
		//
		if(scalarType!=null){
			for(Map.Entry<String, Type> m:scalarType.entrySet()){
				query.addScalar(m.getKey(), m.getValue());
			}
		}
		//获得总条数
		Long totalRecords = querySqlCount(sql, params);
		query.setFirstResult((currentPage-1)*rows);   
	    query.setMaxResults(rows); 
		
	    pageEasyUI.setTotal(String.valueOf(totalRecords));
		pageEasyUI.setRows(query.list());  
	    return  pageEasyUI;
	}
	
}