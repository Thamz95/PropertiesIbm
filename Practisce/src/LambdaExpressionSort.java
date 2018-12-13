import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LambdaExpressionSort {
	
	public static void main(String [] args) {
		
		
		Animal [] animalArray= {new Animal("Lion"),
								new Animal("Crocodile"),
								new Animal("Tiger"),
								new Animal("Elephant")};
		
		System.out.println("Before Sort: "+Arrays.toString(animalArray));
		
		Arrays.sort(animalArray,Animal::animalCompare);
		
		System.out.println("After Sort: "+Arrays.toString(animalArray));
		
		
		List<String> strList = Arrays.asList("1","2","3","1","1");
		
		List<String> strngList = Arrays.asList("9","9","7","1","1");
		
		Map<String,String> map = new TreeMap<String,String>();
		
		//wrong 
		/*map = strList.stream().distinct()
				.collect(Collectors.toMap(key ->key, key ->"good"));
		
		map = strngList.stream().distinct()
				.collect(Collectors.toMap(key ->key, key ->"bad"));*/
		
		map.putAll(strList.stream().distinct()
				.collect(Collectors.toMap(key ->key, key ->"good")));
		
		
		map.putAll(strngList.stream().distinct()
				.collect(Collectors.toMap(key ->key, key ->"bad")));
		
		System.out.println("treeMap.toString(): "+map.toString());
		
	/*	Map<String,String> treeMap = new TreeMap<>(map);
		
		System.out.println("treeMap.toString(): "+treeMap.toString());
		//map.
		
		System.out.println("map.toString(): "+map.toString());*/
		
	}

}

class Animal{
	
	String name;
	
	Animal(String name){
		this.name=name;
		
	}
	
	public static int animalCompare(Animal a1,Animal a2) {
		
		return a1.name.compareTo(a2.name);
		
	}
	
	public String toString() {
		
		return name;	
	}
	
	
}
