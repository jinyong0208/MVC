package factory;

import services.ICustomerServices;
import services.impl.CustomerServicesImpl;

public class ServiceFactory {
	public static ICustomerServices getICustomerServiceInstance() {
		return new CustomerServicesImpl();
	}

}
