import java.sql.*;
import java.util.Scanner;
import java.util.TimeZone;
public class Book{
	public Connection getconn()
	{
	Connection con = null;
	try
	{
	String url= "jdbc:mysql://localhost:3306/prodapt";
	String username="root";
	String pass="root";
	con = DriverManager.getConnection(url,username,pass);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return con;
	}


	Scanner sc1 = new Scanner(System.in);
	
	public void Signup() throws SQLException{
		 Connection con = getconn();
		 System.out.println("Enter SignUP_Username");
         String SignUP_Username =sc1.next();
         System.out.println("Enter SignUP_Password");
         String SignUP_Password =sc1.next();
         String s1 = "insert into Signup(SignUP_Username,SignUP_Password) values(?,?)";
		 PreparedStatement stmt = con.prepareStatement(s1);
         stmt.setString(1,SignUP_Username );
	     stmt.setString(2,SignUP_Password );
	     int a = stmt.executeUpdate();
	     System.out.println("Account Created");
		 Login();
	}
	public void Login() throws SQLException{
		 System.out.println("Login");
		 Scanner l= new Scanner(System.in);
		System.out.println("Enter Login_Username");
        String Username =l.next();
        System.out.println("Enter Login_Password");
        String Password =l.next();
        Connection con = getconn();
        String s1 = "select * from Signup where SignUP_Username='"+Username+"' and SignUP_Password='"+Password+"';" ;
		 PreparedStatement stmt = con.prepareStatement(s1);
	   ResultSet rs= stmt.executeQuery(s1);
	   String user=" ",pass=" ";
	   while(rs.next())
	   {
		   user=rs.getString(1);
		   pass=rs.getString(2);
	   }
	   if(Username.equals(user)&&Password.equals(pass)) {
		   System.out.println("You logged into the portal start booking your token");
	   }
	   else
	   {
		   System.out.println("Enter valid login details");
		   Book q=new Book();
		   q.Login();
	   }
	}



	public void token_booking() throws SQLException {
			System.out.println("***Please enter User details***");
			 Connection con = getconn();
			 String s1 = "insert into tokenbooking(Patient_id,Patient_name,Date,Number,Disease) values(?,?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(s1);
                         System.out.println("Enter Patient_id");
                         int Patient_id=sc1.nextInt();
			             System.out.println("Enter Patient_name");
			             String Patient_name =sc1.next();
			             System.out.println("Enter Date");
			             String Date =sc1.next();
			             System.out.println("Enter Number");
			             String Number =sc1.next();
			             System.out.println("Enter Disease");
			             String Disease= sc1.next();
			             System.out.println("The Patient visiting is only 8am to 10am,12pm to 2pm or 6pm to 9pm ");
			             System.out.println("press 1 for  booking token from 8am to 10am");
			             System.out.println("press 2 for  booking token from 12pm to 2pm");
			             System.out.println("press 3 for  booking token from 6pm to 9pm");
			             System.out.println("press 4 to exit");
			             System.out.println("Enter Token time:");
			        
			             int timing=sc1.nextInt();
			             String time=null;
			             switch(timing) {
			             case 1:
			            	 time="8-10am";
			            	 break;
			             case 2:
			            	 time="12-2pm";
			            	 break;
			             case 3:
			            	 time="6-9pm";
			            	 break;
			             case 4:
			            	 System.exit(0);
			             default:
			            	 System.out.println("Wrong Choice");
			            	 break;      	 
			            }
			            try { 
			       stmt.setInt(1,Patient_id);
			       stmt.setString(2,Patient_name);
			       stmt.setString(3,Date);
			       stmt.setString(4,Number);
			       stmt.setString(5,Disease);
			       int a = stmt.executeUpdate();
			            }
			            catch(SQLIntegrityConstraintViolationException e)
			            {
			            	System.out.println("The slot is booked please choose another timings");
			            	
			            }
			            
			       System.out.println("***Slot booked***");
			       }


	public void diabetuscheck_booking() throws SQLException {
		System.out.println("***Please enter your details***");
		 Connection con = getconn();
		 String s1 = "insert into diabetuscheck_booking (Patient_id,Patient_name,Number,Date,Time) values(?,?,?,?,?)";
		 PreparedStatement stmt = con.prepareStatement(s1);

		             System.out.println("Enter Patient_id");
                     int Patient_id=sc1.nextInt();
		             System.out.println("Enter ur Patient_Name:");
		             String Patient_name =sc1.next();
		             System.out.println("Enter Number");
		             String Number =sc1.next();
		             System.out.println("Enter ur Date:");
		             String Date =sc1.next();
		             System.out.println("Enter ur Time");
		             String Time = sc1.next();
		             System.out.println("The Checkup centre open from 9.00am to 6.00pm");
		             System.out.println("Press 1 to book token between 9.00am to 11.00am");
		             System.out.println("Press 2 to book token between 11.30am to 1.00pm");
		             System.out.println("Press 3 to book token between 2.00am to 4.00am");
		             System.out.println("Press 4 to book token between 4.00pm to 6.00pm");
		             System.out.println("Enter your token timing:");
		             int timing=sc1.nextInt();
		             String time=null;
		             switch(timing) {
		             case 1:
		            	 time="9-11am";
		            	 break;
		             case 2:
		            	 time="11.30-1.00pm";
		            	 break;
		             case 3:
		            	 time="2-4.00pm";
		            	 break;
		             case 4:
		            	 time="4-6.00pm";
		            	 break;
		            default:
		            	System.out.println("Wrong Choice");
		            	break;
		             }
		             try {
		            	 
		       stmt.setInt(1,Patient_id);     
		       stmt.setString(2,Patient_name);
		       stmt.setString(3,Number);
		       stmt.setString(4,Date);
		       stmt.setString(5,Time);
		       int a = stmt.executeUpdate();
		             }catch(SQLIntegrityConstraintViolationException e)
			            {
			            	System.out.println("The slot is booked please choose another timings");
			            }
			            
		       System.out.println("***Slot booked***");
		
	}

	public void fullbodycheckup_booking() throws SQLException {
			System.out.println("***Please enter your details***");
			 Connection con = getconn();
			 String s1 = "insert into fullbodycheckup_booking (Patient_id,Patient_name,address,Number,day) values(?,?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(s1);
			             System.out.println("The Patient_id given in the prescription");
			             System.out.println("Enter Patient_id:");
                         int Patient_id =sc1.nextInt();
			             System.out.println("Enter Patient_Name:");
			             String Patient_name =sc1.next();
			             System.out.println("Enter address:");
			             String address =sc1.next();
			             System.out.println("Enter Number");
			             String Number =sc1.next();
			             System.out.println("Enter Day");
			             String day = sc1.next();
			             System.out.println("The FullBody Checkup only available on Special days");
			             System.out.println("Press 1 to book on Monday");
			             System.out.println("Press 2 to book token Wednesday");
			             System.out.println("Press 3 to book token Friday");
			             System.out.println("Press 4 to book token Sunday");
			             System.out.println("Press 5 to exit");
			             System.out.println("Enter the day you choose:");
			             int days=sc1.nextInt();
			             String Day=null;
			             switch(days)
			             {
			             case 1:
			            	 Day="Monday";
			            	 break;
			             case 2:
			            	 Day="Wednesday";
			            	 break;
			             case 3:
				             Day="Friday";
				             break;
				         case 4:
					          Day="Sunday";
					          break;
				        
				         default:
				        	 System.out.println("Wrong Choice");
				        	 break;
			           }
			             try {
			       stmt.setInt(1,Patient_id);  
			       stmt.setString(2,Patient_name);
			       stmt.setString(3,address);
			       stmt.setString(4,Number);
			       stmt.setString(5,day);
			       int a = stmt.executeUpdate();
			             }catch(SQLIntegrityConstraintViolationException e)
				            {
				            	System.out.println("The slot is booked please choose another timings");
				            }     
			       System.out.println("***Slot booked***");
			
		}


	}
		