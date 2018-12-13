import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicate {
	
	
	public static int add(List numerList,Predicate predicate) {

		int sum =0;
		for(Object number : numerList) {
			if(predicate.test(number)) {
				
				//sum+=new Integer((int) number);
				sum+=(int) number;
			}
			
		}
		return sum;
	}
	
	public static void main(String [] args) {
		
		
		List numList =new ArrayList();
		numList.add(new Integer(10));
		numList.add(new Integer(20));
		numList.add(new Integer(30));
		numList.add(new Integer(40));
		numList.add(new Integer(50));
		
		System.out.println("Add Everything : "+add(numList,n->true));
		
		System.out.println("Add Nothing: "+add(numList, n -> false));
		System.out.println("Add Less Than 25: "+add(numList,  n->(int)n>25));		
		System.out.println("Add 3 Multiples: "+add(numList, n->(int)n % 3 == 0));
	
		
		
	}

	
	
}
