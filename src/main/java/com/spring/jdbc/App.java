package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		System.out.println("My jdbc program  stareted...");
		//with xml
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		//without xml
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfigWithoutXml.class);
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
//insert
        Student student=new Student();
        do {
        	 System.out.println("Enter Id:");
             int id=sc.nextInt();
             student.setId(id);
            
             System.out.println("Enter Name:");
             String name=sc.nextLine();
             name=sc.nextLine();
             student.setName(name);
             
             System.out.println("Enter City:");
             String city=sc.next();
             student.setCity(city);
             System.out.println("please enter 1->Entered Value otherwise exit program");
             x=sc.nextInt();
        	
        }while(x==1);
        
        int result=dao.insert(student); 
        System.out.println("Student Added Successfully..."+result);
        

		//update
//        Student student=new Student();
//        student.setId(6760);
//        student.setName("sandeep suruwat");
//        student.setCity("Amritsar");
//        
//        int result=dao.update(student);
//        System.out.println("Student Updated Successfully..."+result);

	//delete
//		System.out.println("Enter the id who want to delete?:");
//		int id=sc.nextInt();
//		
//		int res=dao.delete(id);
//		if(res==1)
//		System.out.println("Data Deleted Successfully..."+"rows:"+res);
//		else
//			System.err.println("Id is not present in given table.please pass valid id !!!");
		
		// select single data
//		do {
//			System.out.println("Enter the id who want to detail?");
//			int id=sc.nextInt();
//			Student student=dao.getStudent(id);
//			System.out.println(student);
//			System.out.println("1 to continue or any other enter to exit");
//			x=sc.nextInt();
//		}while(x==1);
//		System.out.println("Exit Successfully !!");
//		
		// get all data
		List<Student> students=dao.getAllStudents();
		for(Student s:students)
		{
			System.out.println(s);
		}
		
	}
}
