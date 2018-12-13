import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import  java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
	
public static void main(String[] args) {
		
		
		
		
	System.out.println("Initial DATA LIST :" +getDummyData());
	
    List<Student> studenList = getDummyData();
	//String Joining using Java 8
	
	String joining = studenList
					.stream()
					.map(Student::getStudentname)
					.collect(Collectors.joining(","));
	System.out.println("------String Joining :" +joining);
		//collection collector functionalities
		
		System.out.println(getDummyData().stream().map(Student::getRollno).collect(toList()));
		
		//adding list element without mutating/changing parent object/list object
		//mutating is bad practise while working with concurrency
		//this is the internal functionality happens when we call toList() in Collector
		List<String>  studentNameList = getDummyData().stream()
					    		.map(Student::getStudentname)
					    		.collect(()-> new ArrayList<>(),
					    				(list,name)->list.add(name),
					    				(list1,list2)->list1.addAll(list2));
		
		//we can use tolist() method above implemnetation will automatically done by collectors class
		List<String>  studentNameList1 = getDummyData().stream()
	    		.map(Student::getStudentname)
	    		.collect(Collectors.toList());
		
	    System.out.println("List : "+studentNameList1);

	    //this is how we have to use Map

	    Map<String,Student>  studentMap = studenList
	    								 .stream()
	    								 .filter(student -> student.getMarks()>40)
	    								 .collect(
	    										 Collectors.
	    										 toMap(person -> person.getStudentname(), person -> person));
	    
	    System.out.println("Map : "+studentMap);
	    
	    //this is how we have to use groupBy from Collectors
	    Map<Integer, List<Student>> studentGrouping = studenList
	    								 .stream()
	    								 .collect(
	    										 Collectors.groupingBy(Student::getStudentage));
		
	    System.out.println("GroupByAge : "+studentGrouping);
	    
	    //Sorting using comparator and Functional Interface
	    
	    Function<Student, Integer> studentAgeList= Student::getStudentage;
	    
	    System.out.println("List using Function Interface "+studentAgeList);
	    
	    System.out.println("Find value using key object :AGE is  "+studentAgeList.apply(studenList.get(0)));

	    List<Student> sortedStudents =  compareMethod(studenList,
	    								Comparator.comparing(studentAgeList));
	    
	    System.out.println("Sorted By Age Using Function Interface & comaparator :  ");
	    sortedStudents.forEach(System.out::println);
	    
	    List<Student> sortedThen =  compareMethod(studenList,
	    							Comparator.comparing(studentAgeList)
	    							.thenComparing(Student::getStudentname));	
	    
	    System.out.println("-----------------------Sorted By Age Using Function Interface & comaparator &TheNCompare :  " );
	    sortedThen.forEach(System.out::println);
	    
	    List<Student> reversedSorting =  compareMethod(studenList,
								Comparator.comparing(studentAgeList)
								.thenComparing(Student::getStudentname).reversed());	

			System.out.println("----------------------------------------reversed Order :  " );
			reversedSorting.forEach(System.out::println);
		
			 List<String> chromosomes = Arrays.asList("","","","");
			 List<String> genes = Arrays.asList("sf","1e3d","jkf","116");
			
			/* Stream
			 .iterate(0, e->chromo.length()).filter(predicate)*/
			 
			 
			 String chromo ="12sd78f";
			 char[] chromoArray = chromo.toCharArray();
			 List<String> chromoList = Arrays.asList(String.valueOf(chromoArray, 0, chromoArray.length));
			 
			 String gene ="sf";
			 char[] geneArray = chromo.toCharArray();
			 List<String> genesList = Arrays.asList(String.valueOf(geneArray, 0, geneArray.length));
			 
			 genesList.stream().forEach(e ->{
				 chromoList.stream().filter(c -> c.equals(e));
			 });
		
		/*	 Scanner ch = new Scanner(System.in);
			String chr =  ch.next();
			String gen =  ch.next();*/
			 
		System.out.println("--"+	 (followsPattern("1111456","116") ? "YES" : "NO"));
		System.out.println("--2 "+	 containsUnordered("12345efd", "1e3d") );
		System.out.println("--2 "+	 containsUnordered("1111456", "116") );
}

public static boolean followsPattern(String str, String pattern) 
{ 
    // Insert all characters of pattern in a hash set, 
    List<Character> patternSet = new ArrayList<>(); 
    for (int i=0; i<pattern.length(); i++) 
        patternSet.add(pattern.charAt(i)); 
    System.out.println("Lsit -"+patternSet);

    // Build modified string (string with characters only from 
    // pattern are taken) 
    StringBuilder modifiedString = new StringBuilder(str); 
    for (int i=str.length()-1; i>=0; i--) 
        if (!patternSet.contains(modifiedString.charAt(i))) 
            modifiedString.deleteCharAt(i); 
    System.out.println("modifiedString -"+modifiedString);
    // Remove more than one consecutive occurrences of pattern 
    // characters from modified string. 
    /*for (int i=modifiedString.length()-1; i>0; i--) 
        if (modifiedString.charAt(i) == modifiedString.charAt(i-1)) */
            //modifiedString.deleteCharAt(i); 
    System.out.println("modifiedString 1 -"+modifiedString);
    // After above modifications, the length of modified string 
    // must be same as pattern length 
   /* if (pattern.length() != modifiedString.length()) 
        return false; */

    // And pattern characters must also be same as modified string 
    // characters 
    for (int i=0; i<pattern.length(); i++) 
        if (pattern.charAt(i) != modifiedString.charAt(i)) 
            return false; 

    return true; 
} 
public static boolean containsUnordered(String input, String searchFor){
    char[] characters = searchFor.toCharArray();
    for (char c: characters)
        if (!input.contains(String.valueOf(c)))
            return false;
    return true;
}
public static List<Student> compareMethod(
		List<Student> studentList,
		Comparator<Student> comparator) {
	
	return studentList.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	
} 

public static List<Student> getDummyData() {
	
	List<Student>  studentList= Arrays.asList(
			new Student(1, "oswin", 24, 50),
			new Student(2, "arun", 23, 60),
			new Student(3, "pav", 25, 40),
			new Student(4, "patrick", 23, 30),
			new Student(5, "Pavduplicate", 23, 30));
	
	return studentList;
	
}

}


 class Student{
	
	    private String studentname;
	    private int rollno;
	    private int studentage;
	    private double marks;
	    
	   

	    public Student(int rollno, String studentname, int studentage,double marks) {
	         this.rollno = rollno;
	         this.studentname = studentname;
	         this.studentage = studentage;
	         this.marks =marks;
	    }

	    public String getStudentname() {
	         return studentname;
	    }
	    public void setStudentname(String studentname) {
		this.studentname = studentname;
	    }
	    public int getRollno() {
		return rollno;
	    }
	    public void setRollno(int rollno) {
		this.rollno = rollno;
	    }
	    public int getStudentage() {
		return studentage;
	    }
	    public void setStudentage(int studentage) {
	 	this.studentage = studentage;
	    }	
	    public double getMarks() {
			return marks;
		}

		public void setMarks(double marks) {
			this.marks = marks;
		}

	    @Override
	    public String toString() {
	        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage +", marks=" + marks + "]";
	    }
}