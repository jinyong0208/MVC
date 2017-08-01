package services.impl;

import java.util.List;
import java.util.Set;

import dbc.JdbcUtils;
import factory.DAOFactory;
import services.ICustomerServices;
import vo.Customer;

public class CustomerServicesImpl implements ICustomerServices {

	@Override
	public boolean insert(Customer vo) throws Exception {
		try {
			if (DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).findById(vo.getId()) == null) {
				return DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtils.close();
		}
	}

	@Override
	public boolean update(Customer vo) throws Exception {
		try {
			return DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtils.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			return DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).doRemoveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtils.close();
		}
	}

	@Override
	public Customer get(Integer id) throws Exception {
		try {
			return DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtils.close();
		}
	}

	@Override
	public List<Customer> list() throws Exception {
		try {
			return DAOFactory.getICustomerDAOInstance(JdbcUtils.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			JdbcUtils.close();
		}
	}

}
