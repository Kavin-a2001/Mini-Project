
import java.util.Scanner;
import java.sql.*;
public class Services {
	       
	public static void main(String[] args) throws SQLException {
		String p="y";
		String s = "y";
		String username,password;
		outer: while (p.equals("y")) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("........ WELCOME TO ONLINE HOSPITAL PORTAL............");
		System.out.println("Please select the usertype:Admin or User");
	    String Usertype= sc1.next();
	    if(Usertype.equals("Admin"))
	    {
	    	System.out.println("Enter Username: ");
	    	username = sc1.next();
	    	System.out.println("Enter password: ");
	    	password = sc1.next();
	    
		if(username.equals("kavin") && password.equals("kavin123"))
		{
		System.out.println("your authentication is successfull you are a admin");
		break;
		}
		else
		{
			System.out.println("You are not a admin");
			break;
		}
	    }
	  
	    else if(Usertype.equals("User"))
	    {   
	    	System.out.println("Press 1 for signup");
	    	System.out.println("Press 2 for login");
	    	Scanner r=new Scanner(System.in);
	    	int p1=r.nextInt();
	    	Book b1=new Book();
	    	switch(p1)
	    	{
	    	case 1:
	        b1.Signup();
	        break;
	    	case 2:
	    	b1.Login();
	    	break;
	    	default:
	    	System.out.println("Invalid Choice");
	    	}
	        
			while(s.equals("y")) {
	System.out.println("SERVICES PROVIDED BY HOSPITAL ONLINE PORTAL");
	System.out.println("press 1 to choose TOKEN_BOOKING");
	System.out.println("press 2 to choose DIABETUS_CHECK_BOOKING");
	System.out.println("press 3 to choose FULL BODY CHECK_UP");
	System.out.println("press 4 to choose EXIT");

	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();

	Book b2s= new Book();

	switch (i) {
	case 1: 
		b2s.token_booking();
	    break;
	case 2:
		b2s.diabetuscheck_booking();
	    break;
	case 3: 
		b2s.fullbodycheckup_booking();
	    break;
	case 4:
		System.exit(0);
	default : 
		System.out.println("Wrong Choice");
		 break;
	}
	
	System.out.println("Do you want to continue then press yes/no");
	s = sc.next();
	if (s.equals("sc"))
	{
	    
		System.out.println("******Session closed*******");

	    break outer ;
	}
			
	
			}
		}
		}
	
	}
	}












	
