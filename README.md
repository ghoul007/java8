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


## Method and Constructor References

Method references help to point to methods by their names. A method reference is described using "::" symbol. A method reference can be used to point the following types of methods
[see more](https://www.tutorialspoint.com/java8/java8_method_references.htm)

```java

List<String> list = Arrays.asList("d", "b", "c", "a");
// list.sort((a, b)->a.compareToIgnoreCase(b));

list.sort(String::compareToIgnoreCase);
System.out.println(list); // [a, b, c, d]
```

## Lambda Scope

Accessing local variables

```java
final int num = 1; // we can used without final
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3

```

## Optionals

Optional is a new core library data type that is designed to provide a better alternative to null

[See more](https://www.tutorialspoint.com/java8/java8_optional_class.htm)

```java 
Optional<String> optional = Optional.of("test");

optional.isPresent();           // true
optional.get();                 // "test"
optional.orElse("fallback");    // "test"

optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "t"

```

## Stream

In java, java.util.Stream represents a stream on which one or more operations can be performed. Stream operations are either intermediate or terminal. While terminal operations return a result of a certain type, intermediate operations return the stream itself so you can chain multiple method calls in a row. Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). Stream operations can either be executed sequential or parallel.

[See more](https://howtodoinjava.com/java8/java-streams-by-examples/)

[Tutorial](https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)


```java 
List<String> sc = new ArrayList<>();
sc.add("a2");
sc.add("b");
sc.add("c");
sc.add("a1");
```

we can create streams either by calling

```java
sc.stream()
sc.parallelStream()
```
 ### Filter 
Filter accepts a predicate to filter all elements of the stream
 ```java
 sc
    .stream()
    .filter((s) -> s.startsWith("a"))
    .forEach(System.out::println);
    // a2, a1
    
```

### Sorted 
Returns a sorted view of the stream

```java
stringCollection
    .stream()
    .sorted()
    .filter((s) -> s.startsWith("a"))
    .forEach(System.out::println);
      // a1, a2
```

### Map 
Converts each element into another object via the given function
```java
sc
    .stream()
    .map(String::toUpperCase)
    .sorted((a, b) -> b.compareTo(a))
    .forEach(System.out::println);
    // A1, A2
```