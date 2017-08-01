package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dbc.JdbcUtils;

public class JdbcUtilsTest {

	@Test
	public void testGetConnection() {
		System.out.println(JdbcUtils.getConnection());
	}

	@Test
	public void testClose() {
		fail("Not yet implemented");
	}

}
