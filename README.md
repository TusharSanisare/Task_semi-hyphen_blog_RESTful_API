Blog API Documentation

Authentication

The Blog API uses token-based authentication to secure access to its endpoints. Users are required to obtain a JWT (JSON Web Token) by authenticating with their credentials. This token must be included in the Authorization header of subsequent requests to protected endpoints.

Login

URL: /api/auth/login
Method: POST
Description: Authenticates the user and generates a JWT token.
Request Body: json
{
    "username": "admin",
    "password": "123"
}
Response:
Eg: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiJ9.rM5wRW6sK5T6ewUsLrXiAyl6_e2oXWg-lp_NiKcKgMc"

Logout

URL: /api/auth/logout
Method: POST
Description: Invalidates the user's JWT token.
Authorization Header: Bearer {JWT token}
Response: HTTP status 200 if successful

---- Blog Posts CRUD ----

Create a New Blog Post

URL: /api/posts
Method: POST
Description: Creates a new blog post.
Authorization Header: Bearer {JWT token}
Request Body: json
{
    "title": "New Blog Post",
    "content": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}
Response: The newly created blog post object.

Retrieve All Blog Posts

URL: /api/posts
Method: GET
Description: Retrieves a list of all blog posts.
Authorization Header: Bearer {JWT token}
Response: An array of blog post objects.

Retrieve a Single Blog Post

URL: /api/posts/{id}
Method: GET
Description: Retrieves a single blog post by its ID.
Authorization Header: Bearer {JWT token}
Response: The blog post object with the specified ID.

Update an Existing Blog Post

URL: /api/posts/{id}
Method: PUT
Description: Updates an existing blog post.
Authorization Header: Bearer {JWT token}
Request Body: json
{
    "title": "Updated Title",
    "content": "Updated content goes here."
}
Response: The updated blog post object.

Delete a Blog Post

URL: /api/posts/{id}
Method: DELETE
Description: Deletes a blog post by its ID.
Authorization Header: Bearer {JWT token}
Response: HTTP status 204 (No Content) if successful.
