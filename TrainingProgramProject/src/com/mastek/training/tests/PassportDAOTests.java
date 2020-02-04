package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.passportdetails.Genders;
import com.mastek.training.passportdetails.Passport;
import com.mastek.training.passportdetails.PassportDetailsDataObject;
import com.mastek.training.passportdetails.PassportJSONfileDAO;
import com.mastek.training.passportdetails.Place_of_births;




class PassportDAOTests {
	
	 PassportDetailsDataObject<Passport> passDAO;
	

	@BeforeEach
	void setUp() throws Exception {
		//empDAO = new EmployeeBinaryFileDAO("empdata.dat");
		//passDAO = new PassportJSONfileDAO("example.json");
		//empDAO = new EmployeeJDBCDAO();
		//passDAO = new PassportMongoDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPassportData() {
	Passport newPass = new Passport();
	newPass.setPassportid(1111);
	newPass.setName("Passport name");
	newPass.setPlace_of_birth(Place_of_births.ENGLAND);
	newPass.setGender(Genders.MALE);
//	newPass.setDate_Of_Birth(1999-03-01);
	
	newPass = passDAO.add(newPass); // returns the object if saved successfully 
	assertNotNull( newPass, "Passport details added");
	
	String jsonOBJ = Passport.getJSONString(newPass);
	System.out.println(jsonOBJ);
	Passport examp = Passport.parseJSONString(jsonOBJ);
	//System.out.println(examp);

	
	Passport fetchEmp = passDAO.find(1111);
	assertNotNull(fetchEmp,"Passport details could not added");
	
	}
	
	@Test
	void testListAllPassport() {
		Collection<Passport> passes = passDAO.listAll();
		for (Passport passports: passes) {
			System.out.println(passports);
		}
		
	}
 
	@Test 
	void testRemovePassport(){
		Passport newPass = new Passport();
		newPass.setPassportid(1);
		newPass.setName("ben");
		newPass.setPlace_of_birth(Place_of_births.ENGLAND);
		newPass.setGender(Genders.MALE);
	//	newPass.setDate_Of_Birth(1996-02-01);
		
		newPass = passDAO.add(newPass);
		assertNotNull(newPass,"Passport details not added");
		
		Passport removedPass = passDAO.remove(1111);
		assertNotNull(removedPass,"Passport detail removed");
		 
		Passport checkremovedPass = passDAO.find(1111);
		assertNull(checkremovedPass,"Passport added");
	
	}
}
