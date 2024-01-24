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