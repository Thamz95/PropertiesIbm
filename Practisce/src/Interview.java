import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Interview {
	
	
	static String value = "daaabbbaaabbabddccc";
	/* remove the consecutive repeated characters in string
	 * Eg : daaabbbaaabbabddccc
	 * 
	 * result should be go by step by step  dabbbaaabbabddccc
	*/
	
	public static void main(String[] args) {
		
		
		occurenceOfCharInWord(); //completed
		//removeEvenConsecutiveRepeatedLettersInWord();
		
		//secondHighestValueWithOutComparator();
		
		
		//findOddOrEvenWithoutModulus(); //completed
		
		//StringReverseWithoutReverseMethod();//completed
		//swapEachtwoCharInString();//incomplete
		//checkThePossibleSubString();
		
		allPreMutationOfString();
		
		secondLargestNumberInArray();
		
		
	}
	
	private static void secondLargestNumberInArray() {
	
		int [] array = {1,2,3,4,5};
		
		int firstmax =Integer.MIN_VALUE; 
		int secondmax =Integer.MIN_VALUE;
		
		for(int i =0; i<array.length ; i++)
		{
			if(array[i] > firstmax)
			{
				secondmax = firstmax;
				firstmax = array[i];
			}
			else if(array[i] > secondmax  && array[i] != firstmax) {
					
				    secondmax =array[i];
			}
		}
		System.err.println("second lasrgest number is = "+secondmax);
		System.err.println("First lasrgest number is = "+firstmax);
		
		for(int i =0; i<array.length ; i++)
		{
			if(array[i] < firstmax)
			{
				secondmax = firstmax;
				firstmax = array[i];
			}
			else if(array[i] < secondmax  && array[i] != firstmax) {
					
				    secondmax =array[i];
			}
		}
		
		System.err.println("second smallest number is = "+secondmax);
		System.err.println("First smallest number is = "+firstmax);
	}

	/**
	 * EG i/o str="welcome" o/p = "elcomew","lcomewe ...
	 */
	private static void allPreMutationOfString() {
		
		String str= "welcome";
		
		StringBuilder builder = new StringBuilder(str);  
		
		List<String> list = new LinkedList<>();
		int length = str.length()-1;
		
		for(int i=0;i<length;i++) {
			
			char c =str.charAt(i);
			System.out.println(c+"--"+i);
			
			builder.append(c);
			builder.deleteCharAt(0);
			System.out.println(c+"--"+builder.toString());
			
			list.add(builder.toString());
		}
		System.out.println("Premutated Strings"+"--"+list.toString());
	}

	/**
	 * Eg : a= "acbd" b ="cdef"
	 *  opt = 1 //possible is "cd "
	 *  
	 */
	public static void checkThePossibleSubString() {
		
	}
	public static void StringReverseWithoutReverseMethod() {
		
		String input = "abcdefgh" ,reverse = "";
		
		System.out.println("intern " + input.intern() );
		/*Stack stk = new Stack();
		Queue que = new PriorityQueue<>();*/
		
		/*for(char c : input.toCharArray()) {
			
			stk.add(c);
			que.add(c);
		}*/
		
		for(int i= input.length(); i>0; i--) {
			
			reverse += input.charAt(i-1);
			
		}
		System.out.println("reversed = "+ reverse);
		/*System.out.println("reversed = "+stk );
		System.out.println("reversed = "+que );*/
	}
	/**
	 * find odd or even odd or even without using modolus operator 
	 */
	public static void findOddOrEvenWithoutModulus() {
		
		int input = 5;
		
		System.out.println("rmainder float" + input/2);
		int remainder = input/2;
		
		System.out.println("rmainder int" + input/2);
		
		if((remainder*2) == input) {
			System.out.println("even" +input);
		}else {
			System.out.println("odd" + input);
		}
	}
	/**
	 * swap each two char in string
	 * Eg : abcdegh
	 * opt :bcdchgeh
	 */
	public static void swapEachtwoCharInString() {
		
		String input = "abcdegh";
		
		//int length = ((input.length()%2)==0 ? input.length() :  input.length()-1  );
		//input ="changesof value";
		
		System.out.println("input = "+input);
		System.out.println("length in = "+input.length());
		System.out.println("length = "+input.substring(0, 2));
		
		String opt ="";
		for(int i= 0; i<input.length()-1; i++) {
			System.out.println("i = "+i);
			String temp  ="";
			//if(i!=input.length()/2) {
			/*opt +=	opt+input.replace(""+input.charAt(i)+input.charAt(i+1) +"", 
					input.charAt(i+1)+input.charAt(i)+"");*/
			temp = String.valueOf(input.charAt(i))+String.valueOf(input.charAt(i+1));
				opt += temp;
				System.out.println("input = "+input);
			//}
		}
		System.out.println("opt = "+opt);
		
	
	}
	/**
	 * find second lightest value without using comparator
	 */
	public static void secondHighestValueWithOutComparator() {
		long startTime = System.nanoTime();
		
		NavigableSet<Integer> sortedset = new TreeSet<>(Arrays.asList(10,2,8,5,7));
		
		long endTime = System.nanoTime();
		System.out.println("total Time  in sec ="+ (endTime-startTime));
		
		System.out.println("descending order ="+sortedset.descendingSet());
		System.out.println("second higjest ="+sortedset.lower(sortedset.last()));
		System.out.println(sortedset);
		
	}
	
	public static void removeEvenConsecutiveRepeatedLettersInWord() {
		
	
		
		System.out.println("index : "+value.charAt(0));
		System.out.println("modified 1: "+value);
		int length = value.length()-1;
		for(int i=0;i<value.length();i++) {
			
			if(length != i) {
			
				if(value.charAt(i)== value.charAt(i+1)) {
					
					System.out.println("value if same :" +"index "+i+ value.charAt(i) +" =="+ value.charAt(i+1));
					value =value.replaceFirst(value.substring(i, i+1), "");
					value =value.replaceFirst(value.substring(i, i+1), "");
					System.out.println("modified in: "+value);
					//stringCheck();
					//break;
				}
			}
		}
		System.out.println("modified : "+value);
		
	}
	
	private static void stringCheck() {
		// TODO Auto-generated method stub
		
	}

	public static void occurenceOfCharInWord() {
		
     String value1 = "daaabbbaaabbabddccc";
		
		System.out.println("sorted : "+value1.chars().sorted().skip(1).count());
		
		Map<Character, Integer> hashMap = new HashMap<>();
		
		String str = "";
		for(char ch : value1.toCharArray()) {
			
			hashMap.put(ch, hashMap.getOrDefault(ch, 0)+1);
			System.out.println("Ch : "+ ch+"-"+ hashMap.get(ch));
			
			int value = hashMap.get(ch)-1;
			String instr =value+""+String.valueOf(ch);
			if(str.contains(instr)) 
			{
				 str= str.replaceAll(instr, hashMap.get(ch)+""+String.valueOf(ch));
			}else {
				str +=hashMap.get(ch)+""+String.valueOf(ch);
			}
			System.out.println("frequency : "+ ""+"-"+ hashMap);
			System.out.println("frequency String : "+ str);
			
			
		}
		System.out.println("frequency String : "+ str);
		System.out.println("Result frequency : "+  hashMap);
		
	}

}
