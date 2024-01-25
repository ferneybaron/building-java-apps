# @RequestParam:
Used to extract values from the query parameters of the URL or form data.
Suitable for simple data types like strings, numbers, and booleans.
The data is appended to the URL in the form of key-value pairs.

`@GetMapping("/api/v1/users")
public ResponseEntity<String> getUserById(@RequestParam Long userId) {
// Implementation
}`

# @RequestBody:
Used to extract the entire request body and bind it to a Java object.
Suitable for more complex data structures like JSON or XML payloads.
The data is sent in the body of the request and can be deserialized into a Java object.

`@PostMapping("/api/v1/users")
public ResponseEntity<String> createUser(@RequestBody User user) {
// Implementation
}`

# @PathVariable:
Extracts values from URI templates (parts of the URL enclosed in curly braces).

`@GetMapping("/api/v1/users/{userId}")
public ResponseEntity<String> getUserById(@PathVariable Long userId){
// Implementation
}`

# @RequestAttribute:
Retrieves values from request attributes.

`@GetMapping("/api/v1/users")
public ResponseEntity<String> getUserByAttribute(@RequestAttribute("attributeName") String attributeValue) {
// Implementation
}`

# @RequestPart:
Used in conjunction with the multipart/form-data content type to extract parts of a multipart request.

`@PostMapping("/api/v1/users/avatar")
public ResponseEntity<String> uploadAvatar(@RequestPart("avatar") MultipartFile avatar) {
// Implementation`
}
=======================================================================
# Objects.isNull
In Java, the Objects.isNull method is a static method introduced in the java.util package (starting from Java 7) to check whether an object reference is null or not. 
# isEmpty
Its method in String class, checks if the length of the string is 0.If you want to check if a string is empty and don't care about white spaces, use isEmpty()
# isBlank
isBlank() is a method introduced in Java 11 in the String class.It checks if the string is empty or contains only white spaces (spaces, tabs, or line breaks).

**Note:** Before using isBlank(), ensure that your codebase is compatible with Java 11 or later, as this method was introduced in Java 11. If you're working with an older version of Java, you can use trim().isEmpty() to achieve similar functionality.

========================================================================

# @ResponseBody Annotation:

@ResponseBody is a method-level annotation that is used to indicate that the return value of a method should be directly written to the response body.
It is commonly used in conjunction with the @Controller or @RestController annotations to indicate that the return value of a method should be serialized directly to the HTTP response body.

`@RestController
public class MyController {

    @RequestMapping("/example")
    @ResponseBody
    public String example() {
        return "This is the response body.";
    }
}`

# ResponseEntity Class:

ResponseEntity is a class that represents the entire HTTP response, including status code, headers, and body.
It allows you to have more fine-grained control over the response, including setting HTTP status codes, headers, and the response body.
It is commonly used to build responses with custom status codes, headers, and bodies.

`@RestController
public class MyController {

    @RequestMapping("/example")
    public ResponseEntity<String> example() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Custom-Value");

        return new ResponseEntity<>("This is the response body.", headers, HttpStatus.OK);
    }
}`

**Note:**
Use @ResponseBody when you want to indicate that the return value of a method should be directly written to the response body in a controller method.
Use ResponseEntity when you need more control over the entire HTTP response, including status codes, headers, and the response body. This is particularly useful when you want to handle different HTTP status codes or set custom headers.

========================================================================
# The SOLID principles 
are a set of five design principles that are commonly used in object-oriented programming to create more maintainable, flexible, and scalable software. These principles were introduced by Robert C. Martin and are widely adopted in Java and other object-oriented languages. Here's an overview of each SOLID principle:
## Single Responsibility Principle (SRP):
A class should have only one reason to change, meaning that it should have only one responsibility.
Each class should encapsulate a single functionality, and if a class has more than one reason to change, it should be split into multiple classes.
## Open/Closed Principle (OCP):
Software entities (classes, modules, functions) should be open for extension but closed for modification.
This means that you can add new features or functionality to a system without altering the existing code. This is typically achieved through the use of interfaces and abstract classes.
## Liskov Substitution Principle (LSP):
Subtypes should be substitutable for their base types without altering the correctness of the program.
If a class is a subtype of another class, it should be able to replace the parent class without affecting the correctness of the program.
## Interface Segregation Principle (ISP):
A class should not be forced to implement interfaces it does not use.
Instead of having a large, monolithic interface, it is better to have smaller, specific interfaces. Classes should implement only the interfaces that are relevant to them.
## Dependency Inversion Principle (DIP):
High-level modules should not depend on low-level modules; both should depend on abstractions.
Abstractions should not depend on details; details should depend on abstractions.
Dependency injection is a common technique used to implement this principle, allowing the inversion of the flow of control.
========================================================================
========================================================================
========================================================================