import java.util.concurrent.Callable;

public class LambdaInitialization {
	
	public static void main(String args[]) throws Exception{
		
		@SuppressWarnings("rawtypes")
		Callable[] animals = new Callable[]{()->"Lion", ()->"Crocodile"};
		
		System.out.println(animals[0].call());
	}

}
