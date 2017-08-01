package services;

import java.util.List;
import java.util.Set;

import vo.Customer;
/**
 * Customerҵ��������׼
 * @author JINYONG
 *
 */
public interface ICustomerServices {
	/**
	 * ʵ�ֿͻ���Ϣ�����Ӳ��������ε��õ�ICustomerDAO�����·���:<br>
	 * <li>����ICustomerDAO��findById()����,�ж�Ҫ���ӵ�ID�Ƿ����.
	 * <li>����ͻ�ID�����������ICustomerDAO��doCreate()����,�����ӿͻ���Ϣ.
	 * 
	 * @param vo
	 *            Ҫ�������ݵ�VO����
	 * @return ������ӳɹ�����true,���򷵻�false.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public boolean insert(Customer vo) throws Exception;

	/**
	 * ʵ�ֿͻ���Ϣ���޸Ĳ���������ICustomerDAO��doUpdate()����.
	 * 
	 * @param vo
	 *            ��Ҫ�޸ĵ�VO����
	 * @return �޸ĳɹ�����true �����򷵻�false.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public boolean update(Customer vo) throws Exception;

	/**
	 * ִ�пͻ���Ϣɾ������������ɾ������ͻ���Ϣ����ICustomerDAO��doRemoveBatch()����
	 * 
	 * @param ids
	 *            ������Ҫɾ���Ŀͻ�ID
	 * @return ɾ���ɹ�����true �����򷵻�false.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public boolean delete(Set<Integer> ids) throws Exception;

	/**
	 * ���ݿͻ���ID��ѯ�ͻ���������Ϣ����ICustomerDAO��findById()����
	 * 
	 * @param id
	 *            Ҫ��ѯ�Ŀͻ�ID
	 * @return �����������VO�������ʽ����,���򷵻�null
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public Customer get(Integer id) throws Exception;

	/**
	 * ��ѯ���й�Ա��Ϣ�����õ�ICustomerDAO��findAll()����
	 * 
	 * @return �����������List���ϵ���ʽ����
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public List<Customer> list() throws Exception;

}
