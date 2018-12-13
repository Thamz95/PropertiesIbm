

 class Parent{
	
	public void parentMethod() {
		
		System.out.println("parent class method ");
	}
}
 
 interface ChildInterface{
	 
	 default void interfaceMethod() {
			
			System.out.println("ChildInterface complete method ");
		}
	 
 }

 class Child extends Parent implements ChildInterface{
	 
	 public  void interfaceMethod() {
			
			System.out.println("ChildInterface complete method  overrided in implementation class");
		}
		
	public void parentMethod() {
		
		System.out.println("Child class method ");
	}
}
public class CheckOops {

	public static void main(String[] args) {
		
		Parent parent = new Child();
		parent.parentMethod(); //child method executed
		
		
		Child child = (Child) parent;
		child.parentMethod(); //child method executed
		child.interfaceMethod();
		
		Parent parent1 = new Parent();
		parent1.parentMethod(); //child method executed
		
		ChildInterface c;
		c.interfaceMethod();
		/*()->{
			System.out.println("----");
		}*/
		
		

	}
}
