import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingStudent implements Comparable{
	
	    private String studentname;
	    private int rollno;
	    private int studentage;
	    private double marks;
	    
	   

	    public SortingStudent(int rollno, String studentname, int studentage,double marks) {
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

		public int compareTo(Object comparestu) {
	        int compareage=((SortingStudent)comparestu).getStudentage();
	        /* For Ascending order*/
	        return this.studentage-compareage;

	        /* For Descending order do like this */
	        //return compareage-this.studentage;
	    }

	    /*Comparator for sorting the list by Student Name*/
	 /*   public static Comparator<SortingStudent> StuNameComparator = new Comparator<SortingStudent>() {

		public int compare(SortingStudent s1, SortingStudent s2) {
		   String StudentName1 = s1.getStudentname().toUpperCase();
		   String StudentName2 = s2.getStudentname().toUpperCase();

		   //ascending order
		   return StudentName1.compareTo(StudentName2);

		   //descending order
		   //return StudentName2.compareTo(StudentName1);
	    }};*/

	    /*Comparator for sorting the list by roll no*/
	/*    public static Comparator<SortingStudent> StuRollno = new Comparator<SortingStudent>() {

		public int compare(SortingStudent s1, SortingStudent s2) {

		   int rollno1 = s1.getRollno();
		   int rollno2 = s2.getRollno();

		   For ascending order
		   return rollno1-rollno2;

		   For descending order
		   //rollno2-rollno1;
	   }};
	   
	   public static Comparator<SortingStudent> stunarks = new Comparator<SortingStudent>() {

		@Override
		public int compare(SortingStudent o1, SortingStudent o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getMarks() - o2.getMarks());
		}
	};*/
	
	public static Comparator<SortingStudent> customComparator(final String fieldName,boolean isReverse){
		
		return new Comparator<SortingStudent>() {
			int result = 0;
			public int compare(SortingStudent o1, SortingStudent o2) {
				
				switch(fieldName){
				
				case "MARKS":
					System.out.println("inside Sorting ");
					//result = (int) (o1.getMarks() - o2.getMarks());
					result =  compare(o1.getMarks(),o2.getMarks());
					break;
				}
				if (isReverse) {
					result *= -1;
				}
				return result;
			}
			private int compare(Comparable t1, Comparable t2) {
			
					if ((null == t1) && (null == t2)) {
						return 0;
					} else if (null == t1) {
						return -1;
					} else if (null == t2) {
						return 1;
					}
					return t1.compareTo(t2);
				}
		};
	}
	    
	    @Override
	    public String toString() {
	        return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage +", marks=" + marks + "]";
	    }

	
		public static void main(String[] args) {
	    	 List<SortingStudent> arraylist = new ArrayList<>();
	  	   arraylist.add(new SortingStudent(223, "Chaitanya", 26,40.00));
	  	   arraylist.add(new SortingStudent(245, "Rahul", 24,35.00));
	  	   arraylist.add(new SortingStudent(209, "Ajeet", 32,20.00));
	  	   
	  	
		    Map<String,SortingStudent>  studentMap = arraylist
		    								 .stream()
		    								 .collect(Collectors.toMap(
		    										 keyMapper ->keyMapper.getStudentname(), person -> person));
			

	  	  // Collections.sort(arraylist);
	  	  /* Sorting on Rollno property*/
		   /*System.out.println("RollNum Sorting:");
		   Collections.sort(arraylist, SortingStudent.StuRollno);*/
		   System.out.println("Mark Sorting:");
		   Collections.sort(arraylist, SortingStudent.customComparator("MARKS", false));
	  	   for(SortingStudent str: arraylist){
	  			System.out.println(str);
	  	   }
		}
}

/* class ArrayListSorting  {

       public static void main(String[] args) {
	    	 List<SortingStudent> arraylist = new ArrayList<>();
	  	   arraylist.add(new SortingStudent(223, "Chaitanya", 26));
	  	   arraylist.add(new SortingStudent(245, "Rahul", 24));
	  	   arraylist.add(new SortingStudent(209, "Ajeet", 32));

	  	   Collections.sort(arraylist);

	  	   for(SortingStudent str: arraylist){
	  			System.out.println(str);
	  	   }
			
		}
}*/