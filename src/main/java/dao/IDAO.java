package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * ���幫����DAO���׼��ʵ��CRUD�Ļ�������
 * 
 * @author JINYONG
 *
 * @param <K>��������
 * @param <V>VO����
 */
public interface IDAO<K, V> {
	/**
	 * �������Ӳ���
	 * 
	 * @param vo
	 *            ��Ҫ������VO����
	 * @return �������true��ʾ���ӳɹ������򷵻�false.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public boolean doCreate(V vo) throws Exception;

	/**
	 * ���ݸ��²���
	 * 
	 * @param vo
	 *            ��Ҫ������VO����
	 * @return �������true��ʾ���³ɹ������򷵻�false.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public boolean doUpdate(V vo) throws Exception;

	/**
	 * ��������ɾ��������Ҫɾ���Ķ�����Set���ϵķ�ʽ����.
	 * 
	 * @param ids
	 *            ����������Ҫɾ��������ID���������ظ�����.
	 * @return �������true��ʾɾ���ɹ���(ɾ�������ݸ���Ҫ��ɾ�������ݸ�����ͬ)���򷵻�false.
	 * @throws SQLException
	 *             SQLִ���쳣
	 */
	public boolean doRemoveBatch(Set<K> ids) throws Exception;

	/**
	 * ����ID��ѯ�ƶ��Ŀͻ���Ϣ
	 * 
	 * @param id
	 *            Ҫ��ѯ�Ŀͻ�ID
	 * @return ����ͻ���Ϣ����VO��������ʽ���أ�����ͻ���Ϣ�����ڷ���null.
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public V findById(K id) throws Exception;

	/**
	 * ��ѯ���еĿͻ���Ϣ
	 * 
	 * @return ������������װ��VO����Ȼ����List���ϵ���ʽ����
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public List<V> findAll() throws Exception;

	/**
	 * ��ҳ���е�ģ����ѯ����ѯ�Ľ���Լ��ϵ���ʽ����
	 * 
	 * @param currentPage
	 *            ��ǰ���ڵ�ҳ
	 * @param lineSize
	 *            ÿҳ��������ʾ����
	 * @param column
	 *            ģ����ѯ��������
	 * @param keyWord
	 *            ģ���Ĳ�ѯ�Ĺؼ���
	 * @return ������������װ��VO����Ȼ����List���ϵ���ʽ����
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public List<V> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception;

	/**
	 * ����ģ����ѯ������ͳ��
	 * 
	 * @param column
	 *            ģ����ѯ��������
	 * @param keyWord
	 *            ģ���Ĳ�ѯ�Ĺؼ���
	 * @return ���ر��е�������,���û�����ݷ���0
	 * @throws Exception
	 *             SQLִ���쳣
	 */
	public Integer getAllCount(String column, String keyWord) throws Exception;
}
