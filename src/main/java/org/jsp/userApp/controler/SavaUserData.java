package org.jsp.userApp.controler;

import java.util.List;
import java.util.Scanner;

import org.jsp.userApp.dao.UserDao;
import org.jsp.userApp.dto.User;

public class SavaUserData {
	 static Scanner sc = new Scanner(System.in);
	
	public static void saveData() {
	    User u = new User();
	    UserDao ud = new UserDao();
	    
	    try {
	    	 System.out.println("Enter User Name");
		     String name=sc.next();
			 System.out.println("Enter User Password");
			 String pass= sc.next();
			 System.out.println("Enter User Email");
			 String mail=sc.next();
			 System.out.println("Enter User Phone");
			 long pho= sc.nextLong();
			
			u.setName(name);
			u.setPassword(pass);
			u.setPhone(pho);
			u.setMail(mail);

			ud.SaveUser(u);
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}
	
	public static void findAllUser() {
		  UserDao ud = new UserDao();
		  try {
			  List<User> u=  ud.findAllUser();
			  for(User e :u) {
				  System.out.println("-------------------");
				  System.out.println("ID : "+e.getId());
				  System.out.println("USER NAME : "+e.getName());
				  System.out.println("USER PASSWORD : "+e.getPassword());
				  System.out.println("EMAIL ID : "+e.getMail());
				  System.out.println("Phone No : "+e.getPhone());

				  System.out.println("-------------------");
			  
		  }
		 
		  }catch(Exception e) {
			 e.printStackTrace();
		  }
		
	}
	
	public static void DelteUserbyId() {
		try {
			System.out.println("Enter Id Number");
			int id = sc.nextInt();
			 User u = new User();
			 UserDao ud = new UserDao();
			 ud.DeleteUser(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void findbyId() {
		try {
			 System.out.println("Enter Id Number");
				int id = sc.nextInt();
				 User e = new User();
				 UserDao ud = new UserDao();
				 e= ud.findUserById(id);
				 
				 System.out.println("-------------------");
				  System.out.println("ID : "+e.getId());
				  System.out.println("USER NAME : "+e.getName());
				  System.out.println("USER PASSWORD : "+e.getPassword());
				  System.out.println("EMAIL ID : "+e.getMail());
				  System.out.println("Phone No : "+e.getPhone());
				  System.out.println("-------------------");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
      
		
	}
	// Its example to validate data
	public static void LoginUser() {
		try {
			System.out.println("Enter User Name");
			String username =sc.nextLine();
			System.out.println("Enter User Password");
			String passwrd= sc.nextLine();
		
			User u = new User();
			UserDao ud = new UserDao();
			 u=ud.VerfyUser(username, passwrd);
			if(u!=null) {
				System.out.println("Hello");
			}else {
				System.out.println("Bye");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//saveData();
		//findAllUser();
		//DelteUserbyId();
		//findbyId();
		 //LoginUser();
		System.out.println("Enter User Name");
		String username =sc.nextLine();
		System.out.println("Enter User Password");
		String passwrd= sc.nextLine();
		User u = new User();
		UserDao ud = new UserDao();
		 u=ud.VerfyUser(username, passwrd);
		 
		if(u!=null) {
			System.out.println("Login Successfully");
			  boolean exit = false;
			  
			  do {
			 
			  System.out.println("1: Save Date");
			  System.out.println("2: Show All User");
			  System.out.println("3: Delete User By ID");
			  System.out.println("4: Find User By Id");
			  System.out.println("5: User Exit");
			  int chose = sc.nextInt();
			  
			  switch (chose) {
			  
				case 1:
					saveData();
					System.out.println("Data Save Successfully");
					break;
			    case 2:
			    	findAllUser();
					
					break;
			    case 3:
			    	DelteUserbyId();
			    	System.out.println("Data Delete Successfully");
				break;
			    case 4:
			    	findbyId();
			    	System.out.println("Data Find Successfully");
				break;   	
			    case 5:
			    	System.out.println("Exit Successfully");
			    	System.exit(0);
				break;
				
				default:
					System.out.println("Please Select Valide Number");
					break;
			}
				 
			  }while(!false);
				 
			
			
			
		}else {
			System.out.println("Enter Valid user name And password");
		}
	 
	 
		 
		 
	}
	

}
