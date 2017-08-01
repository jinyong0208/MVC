package factory;

import java.sql.Connection;

import dao.ICustomerDAO;
import dao.impl.CustomerDAOImpl;

public class DAOFactory {
	public static ICustomerDAO getICustomerDAOInstance(Connection conn) {
		return new CustomerDAOImpl(conn);
	}

}
