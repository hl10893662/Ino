package me.inox.framework.common.database;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public interface IDataProxy {
	Object insert(String sql);
	
	Object insert(String sql, Object obj);
	
	void batchInsert(String sql, Object obj);

	Object insert(String sql, List<Object> list);

	int update(String sql);

	int update(String sql, Object obj);

	int update(String sql, List<Object> list);
	
	void batchUpdate(String sql, Object obj);

	int delete(String sql);

	int delete(String sql, Object obj);

	int delete(String sql, List<Object> list);
	
	void batchDelete(String sql, Object obj);	

	List<Object> queryForList(String sql);

	List<Object> queryForList(String sql, Object obj);

	List<Object> queryForList(String sql, int start, int end);

	List<Object> queryForList(String sql, Object obj, int start, int end);

	Map<String, Object> queryForMap(String sql, Object obj, String arg1);

	Map<String, Object> queryForMap(String sql, Object obj, String arg1,
			String arg2);

	Object queryForObject(String sql);

	Object queryForObject(String sql, Object obj);

	Object queryForObject(String sql, Object obj1, Object obj2);

	DataSource getDataSource();

	Connection getConnection();

}
