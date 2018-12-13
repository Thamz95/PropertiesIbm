import java.util.Arrays;
import java.util.List;

 public class SortingJava8 {
	
	 private String studentname;
	    private int rollno;
	    private int studentage;
	    private double marks;
	    
	  public SortingJava8() {
		  
	  } 

	    public SortingJava8(int rollno, String studentname, int studentage,double marks) {
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


public static List<SortingJava8> getDummyData() {
	
	List<SortingJava8>  studentList= Arrays.asList(
			new SortingJava8(1, "oswin", 24, 50),
			new SortingJava8(2, "arun", 23, 60),
			new SortingJava8(3, "pav", 25, 40),
			new SortingJava8(4, "patrick", 23, 30));
	
	return studentList;
	
}
}

