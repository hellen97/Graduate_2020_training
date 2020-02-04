package com.mastek.training.passportdetails;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Collection;
	import java.util.LinkedList;
	import java.util.List;

	public class PassportJDBCDAO implements PassportDetailsDataObject<Passport> {
		
		Connection conMysql;
		
		public PassportJDBCDAO() {
			//1. Load the databse server
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				//2 open connection to MySQL
				conMysql = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/graduate_2020_masteknet", //DataBase 
						"root", // userName 
						"root"); // password
				System.out.println("connnection succesful"); 
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		@Override
		public Passport add(Passport newPassport) {
			
			//1. define the query in SQL formmat with parameters if reuqired 
			String sqlInsert = "insert into jdbc_employees "
								+" (passport_id,name,date_of_birth,gender,place_of_birth) "
								+" values(?,?,?,?,?)";
			//2, prepare the statement object for the query 
			try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)){
				//data type, set / parameters to assing to. 
				
				psInsert.setInt(1,newPassport.getPassportid());
				psInsert.setString(2,newPassport.getName());
				psInsert.setDate(3,newPassport.getDate_of_birth());
				psInsert.setString(4,newPassport.getGenders().toString());
				psInsert.setString(5,newPassport.getPlace_of_birth().toString());
				// 4. execute the query on the database table return the rows affected
				
				int recordsAffected = psInsert.executeUpdate(); // INSERT/UPDATE/DELETE SQLS 
				System.out.println(recordsAffected+ "Passport Details inserted");
				
				
			}catch(Exception e) {
				e.printStackTrace();
				newPassport = null ; // return null in case of failure
								}
		return newPassport;
		}

		@Override
		public List<Passport> listAll() {
			String sqlSelectALL = "select * from jdbc_passport_details";
			List<Passport> passports = new LinkedList<Passport>();
			
			try (Statement stSelectAll = conMysql.createStatement()){
				ResultSet rsPassport = stSelectAll.executeQuery(sqlSelectALL);
				while(rsPassport.next()) { // loop untill result set has next record 
					//create object for each record in databsae 
					Passport p = new Passport();
					p.setPassportid(rsPassport.getInt("passport_id"));
					p.setName(rsPassport.getString("name"));
				//	p.setDate_Of_Birth(rsPassport.getDouble("date_of_birth"));
					p.setGender(Genders.valueOf(rsPassport.getString("genders")));
					p.setpalce_of_births(Place_of_births.valueOf(rsPassport.getString("place_of_birth")));
					
					// add the data to collection 
					passports.add(p); 
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return passports; // returns the collection with employess fetche from DB
		}

		@Override
		public Passport find(int key) {
		String findSQL = "Select * from jdbc_passport_details where passport_id=?";
		Passport pass = null; 
		try( PreparedStatement psFind = conMysql.prepareStatement(findSQL)) {
			
			
			psFind.setInt(1, key); // set the Passport for search 
			
			ResultSet rsFindResult = psFind.executeQuery();
			
			if (rsFindResult.next()){
				pass = new Passport();
				pass.setPassportid(rsFindResult.getInt("password_Id"));
				pass.setName(rsFindResult.getString("name"));
			//	pass.setDate_Of_Birth(rsFindResult.getDouble("date_of_birth"));
				pass.setGender(Genders.valueOf(rsFindResult.getString("genders")));
				pass.setPlace_of_birth(Place_of_births.valueOf(rsFindResult.getString("place_of_birth")));
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return pass;
		}

		@Override
		public Passport remove(int key) {
			Passport passToBeRemoved = find(key);
				if(passToBeRemoved!=null) {
					String sqlDelete = "delete from jdbc_passport_details where passport_id=?";
					 try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)){
						
						 psDelete.setInt(1,key);
						 
						 int rowsDeleted = psDelete.executeUpdate();
						 System.out.println (rowsDeleted +"passport deleted due to BREXIT");
						
					} catch (Exception e) {
					e.printStackTrace();
					}
					
			
				}
				return passToBeRemoved;
			}
			
		}

