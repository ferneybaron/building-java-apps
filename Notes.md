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