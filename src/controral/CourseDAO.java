package controral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Course;
public class CourseDAO {
	
    private static String dburl="jdbc:mysql://localhost:3306/bestprogramming";
    private static   String username="root";
    private  static  String password="";
    
    public  String registerCourse(Course courseobject){
        
        try{
            Connection con= DriverManager.getConnection(dburl,username,password);
             String sql="insert into course values(?,?,?)";
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1,courseobject.getCoursecode());
             pst.setString(2,courseobject.getCoursename());
             pst.setString(3,courseobject.getCredit());
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
    
    public String updateCourse(Course courseobject) {
    	   try{
    	          Connection con= DriverManager.getConnection(dburl,username,password);
    	            String sql="UPDATE Course SET coursename=?,credit=? where coursecode=?";
    	            PreparedStatement pst=con.prepareStatement(sql);
    	            pst.setString(3,courseobject.getCoursecode());
   	                pst.setString(1,courseobject.getCoursename());
   	                pst.setString(2,courseobject.getCredit());
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
    	   return "";
    }
    
    
    public String  deletecourse(Course courseobject){
          try{
          Connection con= DriverManager.getConnection(dburl,username,password);
             String sql="DELETE FROM Course  where coursecode=?";
             PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,courseobject.getCoursecode());
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
    
      
    public List<Course> DisplayData() {
        List<Course> data = new ArrayList<>();
           try{
         Connection con= DriverManager.getConnection(dburl,username,password);
          String query = "SELECT * FROM Course";
            PreparedStatement statement =con.prepareStatement(query);	            
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()){ 
            	 Course model = new Course();
                 model.setCoursecode(resultSet.getString("Coursecode"));
                 model.setCoursename(resultSet.getString("coursename"));
                 model.setCredit(resultSet.getString("credit"));
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
