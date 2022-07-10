/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.managestudent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.IOException;
/**
 *
 * @author Admin
 */
public class ManageStudent {

    public static void main(String[] args){
    ArrayList<Student>array=new ArrayList<Student>();
    while (true) {
    //1. Viết hàm menu với các chức năng yêu cầu
    System.out.println();
    System.out.println ("--------- welcome to the student management system ------");
    System.out.println ("1. Enter student list");
    System.out.println("2. Look up student");
    System.out.println ("3. Display students list");
    System.out.println ("4. Exit");
    System.out.println ("please enter your choice");
    // 2. Sử dụng scanner để nhập option
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();

    //3. Goi các phương thức option
    switch (line) {
        case "1":
//                    System. out. Println ("add student");
            addStudent(array);
            StoreStudents storeStudents = new StoreStudents();
            try{
                storeStudents.writeToFile(array);
            }catch(IOException e){
                e.printStackTrace();
            }
            break;
        case "2": 
            findStudent(array);
            break;
        case "3":
//                    System. out. Println ("view all students");
            FindallStudent(array);
            break;
        case "4":
            System.out.println("thank you for using");
//                    break;
            System. exit(0); // JVM exit
    }
}
}
            public static void addStudent(ArrayList<Student> array) {
                //Enter the data required by the student object on the keyboard, display the prompt information, and prompt what information to enter
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter new student: ");
                //In order for Code to be accessed outside the while loop, we define it outside the loop
                String code;
                //In order to get the program back here, we implement it with a loop
                while (true) {
                    System.out.print("Student code:");
                     code=sc.nextLine();
        
                    boolean flag=isUsed(array,code);
                    if (flag) {
                        System.out.println("The student number you entered has been occupied, please re-enter");
                    } else {
                        break;
                    }
                }
        
        
        
                System.out.print("Student name: ");
                String name=sc.nextLine();
                System.out.print("Date of birth: ");
                String date=sc.nextLine();
                System.out.print("Learning point: ");
                float point=sc.nextFloat();
                //Create a student object and assign the data entered by the keyboard to the member variable of the student object
                Student s=new Student();
                s.setCode(code);
                s.setName(name);
                s.setDate(date);
                s.setPoint(point);
                //Add the student object to the collection
                array.add(s);
                //Give a prompt of successful addition
                System.out.println("Press enter continue, Esc to return the main menu");
            }
            //Define a method to judge whether the student number is used
    public static boolean isUsed(ArrayList<Student> array,String code) {
            //If it is the same as a student number in the set, return true, otherwise false
          boolean flag=false;
          for (int i=0;i< array.size();i++) {
              Student s=array.get(i);
              if (s.getCode().equals(code)) {
                  flag=true;
                  break;
              }
          }
          return flag;
    }
    public static void findStudent(ArrayList<Student> array){
        System.out.print("Please enter student name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(int i = 0; i < array.size(); i++){
            Student s = array.get(i);
            if(s.getName().toLowerCase().equals(name.toLowerCase())){
                System.out.println("\nIt found then display student information name " + s.getName());
                System.out.println("Student code: " + s.getCode());
                System.out.println("Student name: " + s.getName().toUpperCase());
                System.out.println("Date of birth: " + s.getDate());
                System.out.println("Learning point: " + s.getPoint());
                System.out.println("Press enter continue, Esc to return the main menu");
                break;
            }
            else{
                System.out.println("System not found this student");
            }
        }
    }
    public static void FindallStudent(ArrayList<Student> array) {
        //Nếu không có object nào trong mảng thì ko in
        if (array.size()==0){
            System.out.println("No information, please add information first in the query");
            //In order to prevent the program from executing further, return is given;
            return;
        }
        //Hiển thị thông tin đầu dòng của list 
        System.out.println("Student List:");
        System.out.println("-----------------------");
        //Take out the data in the set, display the student information in the corresponding format, and display the supplementary "date" in the date display
        for (int i=0;i< array.size();i++) {
            Student s= array.get(i);
                System.out.println("Student code: " + s.getCode());
                System.out.println("Student name: " + s.getName().toUpperCase());
                System.out.println("Date of birth: " + s.getDate());
                System.out.println("Learning point: " + s.getPoint());
                System.out.println("------------");
        }
        System.out.println("Press enter continue, Esc to return the main menu");
    }
    
}

