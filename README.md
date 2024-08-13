# Moviemania
## API Endpoints

### AuthController

- **Register User**

  - **Endpoint:** `POST /api/v1/auth/register`
  - **Request Body:** `RegisterRequest`
  - **Response:** `AuthResponse`

- **Login User**

  - **Endpoint:** `POST /api/v1/auth/login`
  - **Request Body:** `LoginRequest`
  - **Response:** `AuthResponse`

- **Refresh Token**

  - **Endpoint:** `POST /api/v1/auth/refresh`
  - **Request Body:** `RefreshTokenRequest`
  - **Response:** `AuthResponse`

### FileController

- **Upload File**

  - **Endpoint:** `POST /file/upload`
  - **Request Body:** Multipart file
  - **Response:** Success or error message

- **Download File**

  - **Endpoint:** `GET /file/{fileName}`
  - **Path Variable:** `fileName`
  - **Response:** File resource

### MovieController

- **Add Movie**

  - **Endpoint:** `POST /movies/add`
  - **Request Parameters:** Multipart file and JSON string of `MovieDTO`
  - **Response:** `MovieDTO`

- **Get Movie by ID**

  - **Endpoint:** `GET /movies/{movieId}`
  - **Path Variable:** `movieId`
  - **Response:** `Optional<Movie>`

- **Get All Movies**

  - **Endpoint:** `GET /movies/all`
  - **Response:** List of `MovieDTO`

## Running the Application

After setting up the environment variables and running the application, you can access the API at `http://localhost:8080`.

## Technologies Used

- **Spring Boot** for building the REST API.
- **JWT** for authentication.
- **MultipartFile** for file uploads.
- **MySQL** (or any preferred database) for data storage.
- **Maven** for project build and dependency management.
