package java8;


interface Phone{
	void call();
	default void message() {
		System.out.println("message");
	};
}



class AndroidPhone implements Phone{
	
	public void call() {
		System.out.println("call");
	}
}

public class DefaultMethodDefinition {

	public static void main(String[] args) {
	 
		Phone  p =  new AndroidPhone();
		p.call();
		p.message();
		 
	}

}
