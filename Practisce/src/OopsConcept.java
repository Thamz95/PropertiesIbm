

/**
 * interfaces conatines comman actions which that functionality might be 
 * different based on animal so it should be implemented and complete the method function
 * @author thamaraiselvan
 *
 */
interface AnimalActivities{
	
	void eat();
	void sleep();
	void hunt();
	
    static void animals() {
		
		System.out.println(" Functional interface in AnimalActivities Interace");
	}
	
	default String animals(String value) {
			
		System.out.println(" Functional interface AnimalActivities in animal Interace");
	return "Lamda Exp";
	}
	 
	
}

//abstract method will not implmenet the interaface methods
//child class of abstract class should implement all interface methods 
abstract class AnimalHabits implements AnimalActivities{
	
	//final methods cannot be inherited
	public final void speciesType() {
		System.out.println(" speciesType : is Animals  complete method in abstract class AnimalHabits ");
	}
	
	//abstract method should implemented in inherited class
	public abstract void animalName();
	
	/*public abstract static void animalName();*/ // C ERROR
	
	
	//**abstract methods should not  cannot be final
	/*public abstract final void animalName();*/ // C ERROR
}

class Cat extends AnimalHabits{

	@Override
	public void eat() {
		System.out.println("Eat : cat eats");
		
	}

	@Override
	public void sleep() {
		System.out.println("Sleep : cat sleep");
		
	}

	@Override
	public void hunt() {
		System.out.println("Hunt : cat hunt");
		
	}

	@Override
	public void animalName() {
		System.out.println("AnimalName :cat meow .,Actual Cat Method");
		
	}
	/*
	public static void main(String[] args) {
		System.out.println("main method in cat");
		new Cat().animalName() ;
	}
	*/
}

public class OopsConcept  extends Cat{
	
	
	private int m = 0;
	
	private static OopsConcept oopsObj = null;
	
	/**
	 * sinbleton eager initialization
	 * @param i
	 */
	//private static OopsConcept oopsObj = new OopsConcept();
	
	// once we declare the arg constructer declaring no-arg constructor 
	// is mandatory 
	/*singleton class*/
	private OopsConcept(final int i ){
		this.m = i;
	}
	
	public static OopsConcept oopsConcept() {
		
		if(oopsObj == null) {//singleton Lazy initialization
				oopsObj = new OopsConcept(0);
		}
		return oopsObj;
		
		//singleton Lazy initialization with Synchronizztion
		/* if(oopsObj == null) {
			 synchronized(OopsConcept.class) {
				oopsObj = new OopsConcept(0);
							
			  }
			}
		return oopsObj; */
	}
	
	public static void main(String[] args) {
		
		/* OopsConcept oops = new OopsConcept() this throw unsrolved type 
		error at compile time when arg contructer is created */
		/*singleton object*/
		AnimalHabits oops = OopsConcept.oopsConcept();
		oops.animalName();//this will call the ovverrided method
		
		AnimalHabits animalHabit = new Cat();
		animalHabit.speciesType();
		animalHabit.eat();
		animalHabit.sleep();
		animalHabit.hunt();
		animalHabit.animalName();//this will call the Actual method in Cat Class
		animalHabit.animals("value1");//complete method in interface
		
		//complete methods in Interfaces
		AnimalActivities.animals();
		String animalActivities  = oops.animals("value");//->{ "appending"+r};
		System.out.println(animalActivities +" ==lambda Expression animalActivities ");
	}
	
	public void animalName() {
		System.out.println("AnimalName :cat Ovverrided in OopsConcept");
		
	}

}
