package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * 定义公共的DAO层标准，实现CRUD的基本功能
 * 
 * @author JINYONG
 *
 * @param <K>主键类型
 * @param <V>VO对象
 */
public interface IDAO<K, V> {
	/**
	 * 数据增加操作
	 * 
	 * @param vo
	 *            需要操作的VO对象
	 * @return 如果返回true表示增加成功，否则返回false.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public boolean doCreate(V vo) throws Exception;

	/**
	 * 数据更新操作
	 * 
	 * @param vo
	 *            需要操作的VO对象
	 * @return 如果返回true表示更新成功，否则返回false.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public boolean doUpdate(V vo) throws Exception;

	/**
	 * 数据批量删除操作，要删除的对象以Set集合的方式保持.
	 * 
	 * @param ids
	 *            包含了所有要删除的数据ID，不包含重复内容.
	 * @return 如果返回true表示删除成功，(删除的数据个数要与删除的数据个数相同)否则返回false.
	 * @throws SQLException
	 *             SQL执行异常
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception;

	/**
	 * 根据ID查询制定的客户信息
	 * 
	 * @param id
	 *            要查询的客户ID
	 * @return 如果客户信息存以VO类对象的形式返回，如果客户信息不存在返回null.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public V findById(K id) throws Exception;

	/**
	 * 查询所有的客户信息
	 * 
	 * @return 如果有数据则封装成VO对象然后以List集合的形式返回
	 * @throws Exception
	 *             SQL执行异常
	 */
	public List<V> findAll() throws Exception;

	/**
	 * 分页进行的模糊查询，查询的结果以集合的形式返回
	 * 
	 * @param currentPage
	 *            当前所在的页
	 * @param lineSize
	 *            每页的数据显示行数
	 * @param column
	 *            模糊查询的数据列
	 * @param keyWord
	 *            模糊的查询的关键字
	 * @return 如果有数据则封装成VO对象然后以List集合的形式返回
	 * @throws Exception
	 *             SQL执行异常
	 */
	public List<V> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;

	/**
	 * 进行模糊查询的数据统计
	 * 
	 * @param column
	 *            模糊查询的数据列
	 * @param keyWord
	 *            模糊的查询的关键字
	 * @return 返回表中的数据量,如果没有数据返回0
	 * @throws Exception
	 *             SQL执行异常
	 */
	public Integer getAllCount(String column, String keyWord) throws Exception;
}
