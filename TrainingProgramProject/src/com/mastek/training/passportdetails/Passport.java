package com.mastek.training.passportdetails;
	//location of the java class in the project structure 
	import java.io.Serializable;
	import java.io.StringReader;
import java.sql.Date;

import javax.json.JsonObject;
	import javax.json.JsonObjectBuilder;
	import javax.json.JsonReader;

import com.mastek.training.hrapp.Grades;

	//if the class is declared as final, we cannot subclass/ inherit/ extends the class
	public class Passport implements Serializable{
										//Serializable as marker interface to manage serialization
										// using ObjectOutStream/InputStream classes 
		
		private String name;
		private Date date_of_birth;
		private int passportid;
		private static Genders Gender;
		private transient static Place_of_births Place_of_birth; // transient keyword will denote the serializer to skip this
										// field while storing using binary file. 
		public static final int MAX_DATE_OF_BIRTH=99999;
		public static final int MIN_DATE_OF_BIRTH=00000;
		public static final int DEFAULT_ZERO=0;
		public static final int MAX_PASSPORTID=99999;
		public static final int MAX_PAID_DAYS=90;
		
		//blocks
		//static block: executed at class loading time for each class - once 
		//
		
		static {   //we usr static block to initialise all the static members of the class 
				System.out.println("Passport static block called");
		}
		
		
		//instance block: executed before the constructor is called for any object of the class 
		
		{
			setPassportid(9999);
			setName("example");
			//setDate_Of_Birth (MAX_DATE_OF_BIRTH);
			setGender(Genders.OTHER);
			System.out.println("Passport instance block caleed");
			
			
		}
			
		
		
		//default constructor : A class constructor without any arguements 
		// Constructor is a method  that creates usable objects as simulations
		// public <ClassName> 
		
		//polymorphism
		//Method/constructor overloading: we define same method/constructor 
		//with different number/type of parameter to allow multiple frms of the same method
		
		public Passport() {
			System.out.println("Passport Deafult Contrucotr Called");
			System.out.println("Passportid"+getPassportid()+ ",name"+getName()+
								",date_of_birth:"+getDate_of_birth()+",genders:"+getGenders());
							}


		// this is an internal method called by garbage collector before deleting the object 
		// you can notify to collect the garbage using System.gc();
		public void finalize() {
			setPassportid(0);
			setName(null);
			//setDate_Of_Birth(0);
			setGender(null);
			setPlace_of_birth(null);
			System.out.println("Password object finalized");		
		}
		
		
		
		
		public void setPlace_of_birth(Object object) {
			// TODO Auto-generated method stub
			
		}


		public Passport (int passportid) {
			this.setPassportid(passportid);
			System.out.println("Passport Deafult Contrucotr Called");
			System.out.println("passport"+getPassportid()+ ",name"+getName()+
					",date_of_birth"+getDate_of_birth()+",Genders:"+getGenders());
			
		}
		
		

		public Passport(int passportid, String name, double date_of_birth, Genders Genders) {
			this.setPassportid(passportid);
			this.setName(name);
		//	this.setDate_Of_Birth(date_of_birth);
			this.setGender(Genders);
			System.out.println("passport Deafult Contrucotr Called");
			System.out.println("passportID"+getPassportid()+ ",name"+getName()+
					",Date of birth:"+getDate_of_birth()+",Gender:"+getGenders());
	
		}
			
		public int getPassportid() {
			return passportid;
		}
		public void setPassportid(int passportid) {
			if (passportid>DEFAULT_ZERO && passportid < MAX_PASSPORTID) {
				this.passportid = passportid;
			}
			
			this.passportid = passportid;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getDate_of_birth() {
			
			return date_of_birth;
		}
		
		/*public void setDate_Of_Birth(double Date_Of_Birth, Date date_of_birth) {
			if(date_of_birth>MIN_DATE_OF_BIRTH && date_of_birth<MAX_DATE_OF_BIRTH) {
				this.date_of_birth = date_of_birth;
			}
		}*/
		public Place_of_births getPlace_of_birth() {
			return Place_of_birth;
		}
		public void setpalce_of_births(Place_of_births place_of_birth) {
			Passport.Place_of_birth = place_of_birth;
		}
		public  void setGender(Genders gender) {
			Passport.Gender = gender;
		}
		public Genders getGenders() {
			return Gender;
		}
		// final keyword on methods/
		// final method cannot be overridden in the derived class 
	/*	public double getPassportTravelTime(int noOfDays) throws Exception {
			if(noOfDays<DEFAULT_ZERO) {
				//raise a new exception on business conditions
				throw new Exception (" invalid number of Days"+ noOfDays); 
				
				// raise and unchecked exception on a bussiness condistion
				//throw new RuntimeException(" Invalid input for days"+ noOfDays);
				
			}
			if (noOfDays<DEFAULT_ZERO || noOfDays>MAX_DATE_OF_BIRTH) {
				noOfDays=DEFAULT_ZERO;
			}
			return getDate_of_birth()*noOfDays;
		
		}*/


		@Override
		public String toString() {
			return "Password [passportid=" + passportid + ", name=" + name + ", date_of_birth=" + date_of_birth + ", Gender="
					+ Gender + ", Place of birth=" + Place_of_birth + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + passportid;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Passport other = (Passport) obj;
			if (passportid != other.passportid)
				return false;
			return true;
		}
		
		public static String getJSONString(Passport pass) {
			JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
			jsonBuilder.add("passportid", pass.getPassportid());
			jsonBuilder.add("name", pass.getName());
			jsonBuilder.add("Genders",pass.getGenders().toString());
			jsonBuilder.add("place of birth",pass.getPlace_of_birth().toString());
			
			String jsonEmp= jsonBuilder.build().toString();
			System.out.println(jsonEmp);
			return jsonEmp;
			
		}
		
		public static Passport parseJSONString (String passJSON) {
			JsonReader reader = new JsonReader(new StringReader(passJSON));
			JsonObject passJSONobject = reader.readObject();
			
			Passport pass = new Passport();
			pass.setPassportid(passJSONobject.getIntValue("passportid"));
			pass.setName(passJSONobject.getStringValue("name"));
			pass.setGender(Genders.valueOf(passJSONobject.getStringValue("genders")));
			pass.setpalce_of_births(Place_of_births.valueOf(passJSONobject.getStringValue("place of births")));
			
			System.out.println("from Json:"+passJSON);
			System.out.println("To pass"+passJSON);
			
		
			reader.close();
		
			return pass;
		}
	}

