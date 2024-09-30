package com.rays.test;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.user.UserDTO;



public class TestFlash {
public static void main(String[] args) {
	
	UserDTO dto = new UserDTO();
	
	dto.setFirstName("subhadra");
	dto.setLastName("chandel");
	dto.setLoginId("subh@gmail.com");
	dto.setPassword("124");
	dto.setDob(new Date());
	dto.setAddress("jaipur");
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	
	session.save(dto);
	//flush is chnage query sequence (jo first mai aana chahiye wahi aayega
	session.flush();
	
	System.out.println("first name = " + dto.getFirstName());
 tx.commit();
session.close();
}
}
