package com.OnlineWallet.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.OnlineWallet.DAO.AdminDAO;

public class AdminDAOTest {
	AdminDAO admin =null;

	@Before
	public void setUp() throws Exception {
		admin = new AdminDAO();
	}

	@After
	public void tearDown() throws Exception {
		admin = null;
	}

	@Test
	public void testVerified_users() throws SQLException {
        assertNotNull(admin.verified_users());		
	}

	@Test
	public void testUnverified_users() throws SQLException {
		assertNotNull(admin.unverified_users());
	}

	@Test
	public void testAdminappprove() {
		//fail("Not yet implemented");
		//user = new
		//assertTrue(admin.Adminappprove('a', user, key));
		
	}

	@Test
	public void testDeleteTemp() {
		//fail("Not yet implemented");
	}

	@Test
	public void testWalletAccount() {
		//fail("Not yet implemented");
	}

}
