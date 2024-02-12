package controral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Student;

public class StudentDAO {
	
	    private static String dburl="jdbc:mysql://localhost:3306/bestprogramming";
	    private static   String username="root";
	    private  static  String password="";
	    
	    public  String registerStudent(Student studentobject){
	        
	        try{
	            Connection con= DriverManager.getConnection(dburl,username,password);
	             String sql="insert into student values(?,?,?,?)";
	             PreparedStatement pst=con.prepareStatement(sql);
	             pst.setString(1,studentobject.getStudentid());
	             pst.setString(2,studentobject.getFullname());
	             pst.setString(3,studentobject.getFaculty());
	             pst.setString(4,studentobject.getDepartment());
	            int rowaffected=pst.executeUpdate();
	            con.close();
	            if(rowaffected>=1){
	                return"Registered Successful";
	                
		            }else{
	                return"Fail to Register";
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	        return"Server error";       
	    }
	    
	    public String updatestudent(Student studentobject) {
	    	   try{
	    	          Connection con= DriverManager.getConnection(dburl,username,password);
	    	            String sql="UPDATE STUDENT SET full_name=?,faculty=?,department=? where studentid=?";
	    	            PreparedStatement pst=con.prepareStatement(sql);
	    	            pst.setString(4,studentobject.getStudentid());
	   	                pst.setString(1,studentobject.getFullname());
	   	                pst.setString(2,studentobject.getFaculty());
	   	                pst.setString(3,studentobject.getDepartment());
	    	            int rowaffected=pst.executeUpdate();
	    	            con.close();
	    	            if(rowaffected>=1){
	    	                
	    	                 System.out.println("Update Successfulll");
	    	                
	    	               
	    	            }else{
	    	               System.out.println("Fail to updated");
	    	            }             
	    	         }catch(Exception e){
	    	         e.printStackTrace();
	           }
	    	   return null;
	    }
	    
	    
	    public String  deletestudent(Student studentobject){
	          try{
	          Connection con= DriverManager.getConnection(dburl,username,password);
	             String sql="DELETE FROM STUDENT  where studentid=?";
	             PreparedStatement pst=con.prepareStatement(sql);
	            pst.setString(1,studentobject.getStudentid());
	            int rowaffected=pst.executeUpdate();
	            con.close();
	            if(rowaffected>=1){
	                
	                 System.out.println("Data Deleted Successfulll");
	                
	                
	            }else{
	               System.out.println("your Id Is not Exist");
	            }
	    
	                     }catch(Exception e){
	                         e.printStackTrace();
	                     } 
	          return "";
	                }
	    
	      
	    public List<Student> searchData() {
	        List<Student> data = new ArrayList<>();
	           try{
	         Connection con= DriverManager.getConnection(dburl,username,password);
	          String query = "SELECT * FROM student";
	            PreparedStatement statement =con.prepareStatement(query);	            
	            ResultSet resultSet = statement.executeQuery();
	             while (resultSet.next()){ 
	            	 Student model = new Student();
	                 model.setStudentid(resultSet.getString("studentid"));
	                 model.setFullname(resultSet.getString("full_name"));
	                 model.setFaculty(resultSet.getString("faculty"));
	                 model.setDepartment(resultSet.getString("department"));
	                 data.add(model);  
   
	           }
	             return data;
	             
	        } catch (SQLException e) {
	             e.printStackTrace();
	             System.err.println("SQL Exception: " + e.getMessage());
	        }

	        return null;
	    
}
}

