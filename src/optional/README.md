# Optional

Optional is a generic class defined in the `java.util` package that got introduced in Java8.

It facilitates the handling of potentially absent values in a more concise and expressive manner. <br>
It provides a container-like structure to wrap objects, indicating the possibility of a value being present or absent. 

Its primary purpose is to provide a safer alternative to handling null values, thereby reducing the risk of **NullPointerExceptions**. 
By explicitly acknowledging the possibility of an absent value, Optional encourages developers to write more robust and error-resistant code.

## Creating Optional Instances:

To create an Optional instance, following methods are porvided :

1. `Optional.of(T value)`:
   - Creates an Optional object containing a non-null value.
   - Throws: **NullPointerException** if the value provided is null.
   - Example:
     ```java
     String name = "John Doe";
     Optional<String> optionalName = Optional.of(name);
     System.out.println("Optional Name: " + optionalName);
     ```
     Output:
     ```shell
     Optional Name: Optional[John Doe]
     ```

2. `Optional.ofNullable(T value)`:
   - Creates an Optional object containing the specified value.
   - The value can be null, in that case the Optional will be empty.
   - Example:
     ```java
     String city = null;
     Optional<String> optionalCity = Optional.ofNullable(city);
     System.out.println("Optional City: " + optionalCity);
     ```
     Output:
     ```shell
     Optional City: Optional.empty
     ```

3. `Optional.empty()`:
   - Creates an empty Optional object with no value/null value.
   - Example:
     ```java
     Optional<String> optionalEmail = Optional.empty();
     System.out.println("Empty Optional Email: " + optionalEmail);
     ```
     Output:
     ```shell
     Empty Optional Email: Optional.empty
     ```

## Methods and Usage:

using the Optional instance, following methods can be utilized to manipulate and retrieve values.

1. `boolean isPresent()`:
   - Returns true if the Optional contains a non-null value, false otherwise.
   - Example:
     ```java
     Optional<String> optionalName = Optional.of("John Doe");
     if (optionalName.isPresent()) {
        System.out.println("Name: " + optionalName.get());
     } else {
        System.out.println("No name found.");
     }
     ```
     Output:
     ```shell
     Name: John Doe
     ```

2. `T get()`:
   - Returns the value wrapped by the Optional if present.
   - Throws: **NoSuchElementException** if the Optional is empty.
   - Example:
     ```java
     Optional<String> optionalName = Optional.of("John Doe");
     String name = optionalName.get();
     System.out.println("Name: " + name);
     ```
     Output:
     ```shell
     Name: John Doe
     ```

3. `T orElse(T defaultValue)`:
   - Returns the value wrapped by the Optional if present.
   - Returns: defaultValue if the Optional is empty.
   - Example:
     ```java
     Optional<String> optionalCity = Optional.empty();
     String city = optionalCity.orElse("Unknown City");
     System.out.println("City: " + city);
     ```
     Output:
     ```shell
     City: Unknown City
     ```

4. `T orElseGet(Supplier<? extends T> supplier)`:
   - Returns the value wrapped by the Optional if present.
   - Invokes the supplier function to provide an alternative value if the Optional is empty.
   - Example:
     ```java
     Optional<String> optionalEmail = Optional.empty();
     String email = optionalEmail.orElseGet(() -> generateDefaultEmail());
     System.out.println("Email: " + email);
     ...
     public String generateDefaultEmail(){ return "abc@def.com"; }
     ```
     Output:
     ```shell
     Email: abc@def.com
     ```

5. `T orElseThrow(Supplier<? extends X> exceptionSupplier)`:
   - Returns the value wrapped by the Optional if present.
   - Throws an exception produced by the exceptionSupplier if the Optional is empty.
   - Example:
     ```java
     Optional<String> optionalName = Optional.empty();
     String name = optionalName.orElseThrow(() -> new IllegalArgumentException("Name is absent"));
     ```
     Output:
     ```shell
     Exception in thread "main" java.lang.IllegalArgumentException: Name is absent
     .....
     .....
     ```

6. `void ifPresent(Consumer<? super T> consumer)`:
- Executes the specified consumer function with the value wrapped by the Optional if present.
- Example:
  ```java
  Optional<String> optionalPhone = Optional.of("123456789");
  optionalPhone.ifPresent(phone -> System.out.println("Phone: " + phone));
  ```
  Output:
  ```shell
  Phone: 123456789
  ```

## Conclusion:
Optional in Java is a valuable tool for handling potentially absent values without relying on null references and null checks. 

without optional (custom null check):
```shell
public String getStudentName() {
  Student student = fetchStudent(); // can be null or non-null value
  if(student != null){
    return student.getName();
  }else {
    return null;
  }
}
```
with optional:
```shell
public Optional<String> getStudentName() {
  Optional<Student> student = Optional.ofNullable(fetchStudent()); // can be null or non-null value
  if(student.isPresent()){
    return Optional.of(student.getName());
  }
  return Optional.empty();
}
```


Note: <br>
when the value wrapped by an `Optional` is `null`, it is equivalent to using `Optional.empty()`. Both represent an empty `Optional` object with no value.

For example:

```java
String value = null;

Optional<String> optional1 = Optional.ofNullable(value);
Optional<String> optional2 = Optional.empty();

System.out.println(optional1.equals(optional2));  // Output: true
```

Both `Optional.empty()` and `Optional.ofNullable(null)` are commonly used to handle cases where a value might be absent or `null`.
They allow for more explicit and concise handling of null values, reducing the chances of `NullPointerExceptions` and making the code more readable and robust.