package com.framework.core.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.type.Type;

import com.framework.core.util.page.Page;
import com.framework.core.util.page.PageEasyUI;
import com.framework.core.util.page.PageList;


/**
 * <pre>
 * Copy right information:
 * Project:
 * JDK version used:1.5+
 * Commends:database access interface
 * Modification history	:
 * date			ver.	author			what is modified
 * ---------	----	---------	---------------------------
 * 2015-4-6		1.0		zhangxh		 new
 * 
 * @author renhui
 * @version 2.1
 */
public interface BaseDao {

	 
	/**
	 * 获得当前会话中的session,该session有容器自行维护管理，Spring可以代理事务
	 * @return
	 */
	public Session getManagedSession();
	/**
	 * 调用函数自行创建一个数据库的连接，并将其打开，
	 * 在使用Spring操作非查询语句的请况下，Spring的事务对该session对象不起到事务管理的作用，
	 * 所以该session对象应当由程序员自己关闭，释放连接资源
	 * @return
	 */
	public Session getUnManagedSession();
	
	/****************************************************************
	 * 
	 *   base operate
	 *   
	 ****************************************************************/
	public abstract void saveObject(Object entity);
	/**
	 * 
	 *
	 * make by Administrator on 2013-12-10 下午10:19:37
	 * @param entity
	 */
	public abstract void updateObject(Object entity);

	public abstract void saveOrUpdateObject(Object entity);

	public abstract void deleteObject(Object entity);

	public abstract void mergeObject(Object entity);
	
	public abstract <T> T getObjectById(Class<T> entityClass, Serializable id);
	public abstract <T> T getObjectByAnnCode(Class<T> entityClass,Serializable annCode);
	public abstract <T> T getObjectByAnnTitle(Class<T> entityClass,Serializable annTitle);

	public abstract <T> List<T> findObjectByProperty(Class<T> entityClass,
			String propertyName, Object value);

	public abstract <T> List<T> findAllObject(Class<T> entityClass);

	/****************************************************************
	 * 
	 *  below method is execute with hql
	 *  
	 *  
	 ****************************************************************/
	public abstract void executeWithoutResult(String hql);
	
	public abstract void executeWithoutResult(String hql,Object[] params);
	
	public abstract Object executeWithUniqueResult(String hql);
	
	public abstract Object executeWithUniqueResult(String hql,Object[] params);
	
	public abstract <T> T executeWithUniqueResult(Class<T> entityClass,
			String hql);
	public abstract <T> T executeWithUniqueResult(Class<T> entityClass,String hql,Object[] params); 

	public abstract List executeWithListResult(String hql);
 
	public abstract <T> List<T> executeWithListResult(Class<T> entityClass,
			String hql);
	
	public abstract List executeWithListResult(String hql,Object[] params);
	
	public abstract <T> List<T> executeWithListResult(Class<T> entityClass,String hql,Object[] params);
	
	/****************************************************************
	 *   below method is execute with raw sql
	 *   
	 ****************************************************************/
	/**
	 * 
	 *
	 * make by Administrator on 2013-12-10 下午10:20:10
	 * @param sql
	 * @return
	 */
	public abstract void executeSQLWithoutResult(String hql);
	public abstract Object executeSQLWithUniqueResult(String sql);
	public abstract Object executeSQLWithUniqueResult(String sql,Object[] params);
	public abstract List executeSQLWithListResult(String sql);
	public abstract List executeSQLWithListResult(String sql,Object[] params);
	
	
	/**
	 * hql查询前几条数据
	 *
	 * make by dongxh on 2015-2-10 下午5:17:01
	 * @param hql
	 * @param f
	 * @param m
	 * @param params
	 * @return
	 */
	public List queryHQLFirstMax(String hql,Integer f,Integer m,Object[] params);
	
	/**
	 * <pre>
	 * 批量删除\修改 hql语句
	 * 1、"delete 【TableName】 where id in (:ids) "; 
	 * 2、"update 【TableName】 set 条件 where id in (:ids) "; 只把表明换了就OK
	 * 
	 * make by dongxh on 2015-3-6 上午11:20:58
	 * @param hql
	 * @param params
	 * @return
	 * </pre>
	 */
	public int executeWithBatchUpdate(String hql,Object[] params);

	/**
	 * SQL查询前几条数据
	 *
	 * make by dongxh on 2015-2-10 下午5:21:48
	 * @param sql
	 * @param f
	 * @param m
	 * @param params
	 * @param StandardBasicTypes     返回字段别名、类型
	 * @return
	 */
	public List querySQLFirstMax(String sql,Integer f,Integer m,Object[] params,Map<String,Type> scalarType);
	
	
	/**
	 *  分页查询
	 *
	 * make by renhui on 2012-11-24 下午10:47:11
	 * @param page
	 * @param hql
	 * @param params
	 * @return
	 */
	public PageList queryForPageListResult(String hql,Object[] params,Page page);
	
	/**
	 * Criteria方式查询
	 * @param entityClass
	 * @param params
	 * @param orders
	 * @return
	 */
	public <T> List<T> queryForListResult(final Class<T> entityClass,final Criterion[] params,final Order[] orders);
	/**
	 * Criteria方式查询
	 *
	 * make by Administrator on 2014-1-5 下午10:09:46
	 * @param entityClass 实体类
	 * @param params 参数
	 * @param orders 排序
	 * @param begin 开始索引
	 * @param count 最大记录数
	 * @return
	 */
	public <T> List<T> queryForListResult(final Class<T> entityClass,final Criterion[] params,final Order[] orders,final Integer begin,final Integer count);
	/**
	 * Criteria方式查询
	 * @param entityClass
	 * @param params
	 * @param orders
	 * @param page
	 * @return
	 */
	public <T> PageList<T> queryForPageListResult(final Class<T> entityClass,final Criterion[] params,final Order[] orders,final Page page);
	

	/**
	 * 原SQL语句查询
	 * 返回List<map>
	 * make by Administrator on 2014-10-31 上午10:00:26
	 * @param sql                    原sql语句
	 * @param params                 sql条件
	 * @param StandardBasicTypes     返回字段别名、类型 【Map<String, Type> scalarType = new HashMap<String, Type>();scalarType.put("id", StandardBasicTypes.INTEGER);】
	 * @return
	 */
	public PageList queryForSqlResultListMap(final String sql,final Object[] params, Page page, final Map<String,Type> scalarType);
	
	/**
	 * 根据原sql获得总条数
	 *
	 * make by dongxh on 2015-1-22 下午5:28:46
	 * @param sql
	 * @param params
	 * @return
	 */
	public Long querySqlCount(String sql,Object[] params);
	
	/**
	 * 根据hql语句获得总条数
	 *
	 * make by dongxh on 2015-1-22 下午5:29:10
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long queryHqlCount(String hql,Object[] params);
	
	/**
	 * jqueryEasyUI dataGrid
	 * @author zhangxh
	 * 获取分页数据
	 */
	public PageEasyUI queryPageResult(String count_sql,String hql,Map<String,String> params);
	
	/**
	 * HQL分页查询获得PageEasyUI
	 *
	 * make by dongxh on 2015-3-6 上午10:59:46
	 * @param hql               hql语句
	 * @param params            查询条件
	 * @param currentPage       当前页
	 * @param rows              每页显示数
	 * @return
	 */
	public PageEasyUI queryForPageEasyUIResult(String hql, Object[] params,Integer currentPage,Integer rows);
	
	/**
	 * SQL分页查询获得PageEasyUI
	 *
	 * make by dongxh on 2015-3-6 上午11:00:17
	 * @param sql               原sql语句
	 * @param params            查询条件
	 * @param currentPage       当前页
	 * @param rows              每页显示数
	 * @param scalarType        原sql查询指定字段 【Map<String, Type> scalarType = new HashMap<String, Type>();scalarType.put("id", StandardBasicTypes.INTEGER);】
	 * 
	 * @return
	 */
	public PageEasyUI queryForSqlPageEasyUIResultListMap(String sql,Object[] params,Integer currentPage,Integer rows,Map<String,Type> scalarType);
	
}
