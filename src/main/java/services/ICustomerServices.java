package services;

import java.util.List;
import java.util.Set;

import vo.Customer;
/**
 * Customer业务层操作标准
 * @author JINYONG
 *
 */
public interface ICustomerServices {
	/**
	 * 实现客户信息的增加操作，本次调用的ICustomerDAO的以下方法:<br>
	 * <li>调用ICustomerDAO的findById()方法,判断要增加的ID是否存在.
	 * <li>如果客户ID不存在则调用ICustomerDAO的doCreate()方法,来增加客户信息.
	 * 
	 * @param vo
	 *            要增加数据的VO对象
	 * @return 如果增加成功返回true,否则返回false.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public boolean insert(Customer vo) throws Exception;

	/**
	 * 实现客户信息的修改操作，调用ICustomerDAO的doUpdate()方法.
	 * 
	 * @param vo
	 *            需要修改的VO对象
	 * @return 修改成功返回true ，否则返回false.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public boolean update(Customer vo) throws Exception;

	/**
	 * 执行客户信息删除操作，可以删除多个客户信息调用ICustomerDAO的doRemoveBatch()方法
	 * 
	 * @param ids
	 *            包含了要删除的客户ID
	 * @return 删除成功返回true ，否则返回false.
	 * @throws Exception
	 *             SQL执行异常
	 */
	public boolean delete(Set<Integer> ids) throws Exception;

	/**
	 * 根据客户的ID查询客户的完整信息调用ICustomerDAO的findById()方法
	 * 
	 * @param id
	 *            要查询的客户ID
	 * @return 如果有数据以VO对象的形式返回,否则返回null
	 * @throws Exception
	 *             SQL执行异常
	 */
	public Customer get(Integer id) throws Exception;

	/**
	 * 查询所有雇员信息，调用的ICustomerDAO的findAll()方法
	 * 
	 * @return 如果有数据以List集合的形式返回
	 * @throws Exception
	 *             SQL执行异常
	 */
	public List<Customer> list() throws Exception;

}
