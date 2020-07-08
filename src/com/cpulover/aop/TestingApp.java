package com.cpulover.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cpulover.aop.dao.AccountDAO;
import com.cpulover.aop.entity.Account;

public class TestingApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount(new Account(), true);
		accountDAO.setName("cpulover");
		accountDAO.findAccounts();
		
		try {
			accountDAO.sillyMethod();
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			System.out.println("Back to main program after @AfterThrowing");
		}
		context.close();
	}

}
