
package KK;
import java.util.Scanner;
public class Kkk {
	  int s1, s2;
  public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  
  String name=sc.next();
  String school=sc.next();//=============		  ==_1
  int grade=sc.nextInt();  //입력받는 변수&타입  정의
   
  Student s1 = new Student(name, school, grade);
 //Student s1 = new Student(); 뉴 1번 인스턴스
  
  s1.name = name;
  s1.school = school;  //================			==_1
  s1.grade = grade;        //1번 변수 명명
  
System.out.println("Name :" + s1.name);
System.out.println("School :" + s1.school);			 //출력
System.out.println("Grade :" + s1.grade);
  
 Student s2 = new Student(name, school, grade);  
//  Student s2 = new Student();  뉴 2번 인스턴스
 name= sc.next();
 school= sc.next();   //====================			===_2
 grade= sc.nextInt();     //입력받는 변수2 정의
 sc.close();
  
  s2.name = name;
  s2.school = school; //===================			===_2
  s2.grade = grade;        // 2번 변수 명명
  
//System.out.println("Name :"+s2.name);
//System.out.println("School :"+s2.school); 	 //출력
//System.out.println("Grade :"+s2.grade);
	}
}














