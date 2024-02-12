package View;

import java.util.List;
import java.util.Scanner;

import Model.Course;
import Model.Student;
import controral.CourseDAO;
import controral.StudentDAO;

public class SudentMsystem {
	
public static void main(String[] args) {
        
        boolean condition=true;
        String  studentId="";
        String fullname;
        String department;
        String faculty;
        String courseCode;
        String coursename;
        String credit;
        while(condition){
                         System.out.println("=====================================");
             System.out.println("STUDENT MANAGEMENT SYSTEM :");
             System.out.println("-------------------------");
             System.out.println("1.Register Student ");          
             System.out.println("2.Update Student ");
             System.out.println("3.Delete Student ");
             System.out.println("4.Retrive Student ");
             System.out.println("5.Register Course ");          
             System.out.println("6.Update Course ");
             System.out.println("7.Delete Course ");
             System.out.println("8.Retrive Course ");
              System.out.println("0. Exist");
             System.out.println("------------------------");
             System.out.print("Choose : ");
             int choice;
             Scanner input= new Scanner(System.in);
             StudentDAO upstudDao=new StudentDAO();
             Student stud= new Student();
             
             Course cours=new Course();
             CourseDAO courDao=new CourseDAO();
             String feedback;
             
             choice= input.nextInt();
             String answer;
              int count;
             boolean valid = false;

             switch(choice){
             case 1:
            	   System.out.print("\nSTUDENT REGISTERATION \n");
            	   System.out.print("_________________ \n\n");
                 while (!valid) {
                   System.out.print("Enter Student  ID :");
                    studentId=input.next();
                     count=studentId.length();
        
                     if(count==5){
                           System.out.println("Success your Id is 5 digit");
                           if (studentId.matches("\\d{5}")) {
                             valid = true;
                            System.out.println("Success You Student ID is only numbers : " );
                           }else{
                    System.err.println("You Student ID should be a number only Try Again !!!"); 
                    }
                    } else {
                    System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                    }
                    }
                 System.out.print("Enter Full Name :");
                 fullname=input.next();
                 
                 System.out.print("Enter  a Faculty :");
                 faculty=input.next();
                 
                 System.out.print("Enter a Department  :");
                 department=input.next();
                 
                 stud=new Student();
                 stud.setStudentid(studentId);
                 stud.setFullname(fullname);
                 stud.setDepartment(department);
                 stud.setFaculty(faculty);
                 StudentDAO stdao=new StudentDAO();
                 feedback=stdao.registerStudent(stud);
                 System.out.println(feedback);
                                     
                 System.out.println("Enter yes/No continues or exist  : ");
            
                     answer= input.next();
                     if(answer.equalsIgnoreCase("yes")){
                         condition=true;
                     }else{
                         
                         System.out.println("Thinks your using the system");
                         condition=false;
                     }
                     
                  break;
               case 2:
            	   System.out.print("\n UPDATE STUDENT \n");
            	   System.out.print("_________________ \n\n");
            	   while (!valid) {
                       System.out.print("Enter Student  ID :");
                        studentId=input.next();
                         count=studentId.length();
            
                         if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }
            	   System.out.print("Enter Full Name :");
                   fullname=input.next();
                   
                   System.out.print("Enter  a Faculty :");
                   faculty=input.next();
                   
                   System.out.print("Enter a Department  :");
                   department=input.next();
                   
                   stud=new Student();
                   stud.setStudentid(studentId);
                   stud.setFullname(fullname);
                   stud.setDepartment(department);
                   stud.setFaculty(faculty);
                   stdao=new StudentDAO();
                   feedback= upstudDao.updatestudent(stud);
                   System.out.println(feedback);
                    System.out.println("Enter yes/No continues or exist  : ");
                   
                       answer= input.next();
                       if(answer.equalsIgnoreCase("yes")){
                           condition=true;
                       }else{
                           
                           System.out.println("Thinks your using the system");
                           condition=false;
                       }
                   
            	   break;
               case 3:
            	   System.out.print("\nDELETE STUDENT \n");
            	   System.out.print("_________________ \n\n");
            	   while (!valid) {
                       System.out.print("Enter Student  ID :");
                        studentId=input.next();
                         count=studentId.length();
            
                         if(count==5){
                               System.out.println("Success your Id is 5 digit");
                               if (studentId.matches("\\d{5}")) {
                                 valid = true;
                                System.out.println("Success You Student ID is only numbers : " );
                               }else{
                        System.err.println("You Student ID should be a number only Try Again !!!"); 
                        }
                        } else {
                        System.err.println("Invalid input. Please enter a 5-digit number Try Again!!!");
                        }
                        }
                   
             stud=new Student();
             stud.setStudentid(studentId);
            
             feedback=upstudDao.deletestudent(stud);
             System.out.println(feedback);
              System.out.println("Enter yes/No continues or exist  : ");
                 answer= input.next();
                 if(answer.equalsIgnoreCase("yes")){
                     condition=true;
                 }else{
                     
                     System.out.println("Thinks your using the system");
                     condition=false;
                 }

                 break;
                 
               case 4:

             List<Student> thestudent=upstudDao.searchData();
             
             if(thestudent!=null) {
            	 System.out.println("LIST OF ALL STUDENT WE HAVE  ");
                 System.out.println("================================");
                 System.out.println( "STUDENT ID  \tLFULLNAME \tFACULTY \tDEPARTMENT");
                 for (Student student : thestudent) {
                    System.out.println(student.getStudentid()+"\t\t"+ student.getFullname()+"\t\t"+student.getFaculty()+"\t\t"+student.getDepartment());	
				}
            	 
             }else {
            	 System.out.println("No Data Found");
             }
            	   
             System.out.println("Enter yes/No continues or exist  : ");
             answer= input.next();
             if(answer.equalsIgnoreCase("yes")){
                 condition=true;
             }else{
                 
                 System.out.println("Thinks your using the system");
                 condition=false;
             }
	   
            break;
               case 5:
            	   System.out.print("\nCOURSE REGISTRATION \n");
            	   System.out.print("_________________ \n\n");
            	   System.out.print("Enter Course Code :");
                   courseCode=input.next();
                   
                   System.out.print("Enter  Course Name :");
                   coursename=input.next();
                   
                   System.out.print("Enter a Credit   :");
                   credit=input.next();
                   
                   cours.setCoursecode(courseCode);
                   cours.setCoursename(coursename);
                   cours.setCredit(credit);
                   feedback=courDao.registerCourse(cours);
                   System.out.println(feedback);
                    System.out.println("Enter yes/No continues or exist  : ");
                   
                       answer= input.next();
                       if(answer.equalsIgnoreCase("yes")){
                           condition=true;
                       }else{
                           
                           System.out.println("Thinks your using the system");
                           condition=false;
                       } 
                       
                       
                break;
                
               case 6:
            	   System.out.print("\nUPDATE COURSE\n");
            	   System.out.print("_________________ \n\n");
            	   System.out.print("Enter Course Code :");
                   courseCode=input.next();
                   
                   System.out.print("Enter  Course Name :");
                   coursename=input.next();
                   
                   System.out.print("Enter a Credit   :");
                   credit=input.next();
                   
                   cours.setCoursecode(courseCode);
                   cours.setCoursename(coursename);
                   cours.setCredit(credit);
                   feedback= courDao.updateCourse(cours);
                   System.out.println(feedback);
                    System.out.println("Enter yes/No continues or exist  : ");
                   
                       answer= input.next();
                       if(answer.equalsIgnoreCase("yes")){
                           condition=true;
                       }else{
                           
                           System.out.println("Thinks your using the system");
                           condition=false;
                       } 
            	   
                       break;
               case 7:
            	   System.out.print("\nCOURSE DELETION\n");
            	   System.out.print("_________________ \n\n");
            	   
            	   
            	   System.out.print("Enter Course Code :");
                   courseCode=input.next();
                   
                   cours.setCoursecode(courseCode);

                   feedback=courDao.deletecourse(cours);
                   System.out.println(feedback);
                    System.out.println("Enter yes/No continues or exist  : ");
                   
                       answer= input.next();
                       if(answer.equalsIgnoreCase("yes")){
                           condition=true;
                       }else{
                           
                           System.out.println("Thinks your using the system");
                           condition=false;
                       } 
               
                    
            	break;
               case 8:
            	   List<Course> thecourse=courDao.DisplayData();
                   
                   if(thecourse!=null) {
                  	 System.out.println("LIST OF ALL COURSE REGISTERED ");
                       System.out.println("================================");
                       System.out.println( "STUDENT ID  \tLFULLNAME \tFACULTY");
                       for (Course course : thecourse) {
                          System.out.println(course.getCoursecode()+"\t\t"+ course.getCoursename()+"\t"+course.getCredit());	
      				}
                  	 
                   }else {
                  	 System.out.println("No Data Found");
                   }
                  	   
                   System.out.println("Enter yes/No continues or exist  : ");
                   answer= input.next();
                   if(answer.equalsIgnoreCase("yes")){
                       condition=true;
                   }else{
                       
                       System.out.println("Thinks your using the system");
                       condition=false;
                   }
      	   
            	   
             }

}
        
        
}
}
