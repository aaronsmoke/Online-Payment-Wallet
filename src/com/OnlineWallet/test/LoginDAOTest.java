package com.OnlineWallet.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.OnlineWallet.DAO.LoginDAO;
import com.OnlineWallet.bean.User;

public class LoginDAOTest {
LoginDAO  dao ;
User user;

	
	@Before
	public void setUp() throws Exception {
	   dao=new LoginDAO();
	}

	@After
	public void tearDown() throws Exception {
	dao=null;
	}

	@Test
	public void testLoginService() throws SQLException {
		
		//fail("Not yet implemented");
		assertNotNull(dao.LoginService("ultra12", "ultra"));
	}

	@Test
	public void testLoginAdmin() throws SQLException {
		assertTrue(dao.LoginAdmin("admin", "admin"));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetWalletAccount() throws SQLException {
		//fail("Not yet implemented");
		user = dao.LoginService("ultra12", "ultra");
		assertNotNull(dao.getWalletAccount(user));
	}

}
