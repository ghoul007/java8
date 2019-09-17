# JAVA 8 FEATURES

## Default Method Defintion

Enables  to add non-abstract method implementations to interfaces by utilizing the default keyword

```JAVA
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


```


## Lambda expressions

Lambda expressions are introduced in Java 8 and are touted to be the biggest feature of Java 8. Lambda expression facilitates functional programming, and simplifies the development a lot.
A lambda expression is characterized by the following syntax.
``` 
parameter -> expression body
```

Following are the important characteristics of a lambda expression.

  - Optional type declaration − No need to declare the type of a parameter. The compiler can inference the same from the value of the parameter.

  - Optional parenthesis around parameter − No need to declare a single parameter in parenthesis. For multiple parameters, parentheses are required.

  - Optional curly braces − No need to use curly braces in expression body if the body contains a single statement.

 - Optional return keyword − The compiler automatically returns the value if the body has a single expression to return the value. Curly braces are required to indicate that expression returns a value.

[See more](https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm)

before
```JAVA
Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});
```

after
```java
Collections.sort(names, (a, b) -> a.compareTo(b) );

```


other example using Anonymous Inner Class
```java


// Functional interface : it has only 1 abstract method

interface A {
	void show(String s);
}

public class Lambda2 {

	public static void main(String[] args) {
	 A obj;
	 
	 obj = s ->  System.out.println("Hi " + s);
	 obj.show("ahmed");
	}
}

```


## Functional Interfaces

Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a single method ‘compareTo’ is used for comparison purpose. Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions. Following is the list of functional interfaces defined in java.util.Function package.

[See more](https://www.tutorialspoint.com/java8/java8_functional_interfaces.htm)

```java

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
Integer converted = converter.convert("123");
System.out.println(converted);    // 123

```