package test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import factory.ServiceFactory;
import junit.framework.TestCase;
import vo.Customer;

public class CustomerServicesImplTest {

	private static int id;
	static {
		id = new Random().nextInt(10000);
	}

	@Test
	public void testInsert() {
		Customer ct = new Customer();
		ct.setId(id);
		ct.setName("客户" + id);
		ct.setGender("男性");
		ct.setPhone("138888888");
		ct.setEmail("13714025@qq.com");
		ct.setDescription("非常有购买意向");
		try {
			TestCase.assertTrue(ServiceFactory.getICustomerServiceInstance().insert(ct));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Customer ct = new Customer();
		ct.setId(4352);
		ct.setName("王五");
		ct.setGender("女性");
		ct.setPhone("138888888");
		ct.setEmail("13714025@qq.com");
		ct.setDescription("非常有购买意向");
		try {
			TestCase.assertTrue(ServiceFactory.getICustomerServiceInstance().update(ct));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1499);
		try {
			TestCase.assertTrue(ServiceFactory.getICustomerServiceInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getICustomerServiceInstance().get(6666));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getICustomerServiceInstance().list().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
