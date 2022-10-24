# ProgIzs_libAPI

## Details

**Database** : PostgreSQL

**Host** : azure.com

## How to start

1. Download Java v17+ on your computer
2. Use IntelliJ IDEA, Eclipse, Visual Studio Code or another IDE
3. Run project
4. If project is successfully compiled then it will start on http://localhost:8080

## Use of endpoint

* Base URL : http://localhost:8080

### Requests for signUp

#### Method POST

1. **SignUp for user or worker**

   * Base URL : http://localhost:8080/auth/signup
   * Required JSON properties : name(String), surname(Stirng), contactPhone(int), email(String), password(String), isWorker(boolean)(false if user), library(UUID)(if it is worker)
   * Optional JSON properties : none

### Requests for signIn

#### Method POST

1. **SignIp for user or worker**

   * Base URL : http://localhost:8080/auth/signin
   * Required JSON properties : email(String), password(String), isWorker(boolean)(false if user)
   * Optional JSON properties : none

### Requests for users

#### Method GET

1. **Get all users**

   * Base URL : http://localhost:8080/users

2. **Get one user**

   * Base URL : http://localhost:8080/users/id
   * Parameter `id` in url is id of the user

#### Method POST

1. **Add user**

   * Base URL : http://localhost:8080/users
   * Required body JSON properties : name(String), surname(String), contactPhone(int), email(String)
   * Optional body JSON properties : password(String)
   * There is SignUp request(see above)

#### Method PUT

1. **Update user**

   * Base URL : http://localhost:8080/users/id
   * Parameter `id` in url is id of the user
   * Required body JSON properties : name(String), surname(String), contactPhone(int), email(String)
   * Optional body JSON properties : password(String)

#### Method DELETE

1. **Delete user**

   * Base URL : http://localhost:8080/users/id
   * Parameter `id` in url is id of the user

### Requests for workers

#### Method GET

1. **Get all workers**

   * Base URL : http://localhost:8080/workers

2. **Get one worker**

   * Base URL : http://localhost:8080/workers/id
   * Parameter `id` in url is id of the worker

#### Method POST

1. **Add worker**

   * Base URL : http://localhost:8080/workers
   * Required body JSON properties : name(String), surname(String), contactPhone(int), email(String), libraryId(UUID)
   * Optional body JSON properties : password(String)
   * There is SignUp request(see above)

#### Method PUT

1. **Update worker**

   * Base URL : http://localhost:8080/workers/id
   * Parameter `id` in url is id of the worker
   * Required body JSON properties : name(String), surname(String), contactPhone(int), email(String), libraryId(UUID)
   * Optional body JSON properties : password(String)

#### Method DELETE

1. **Delete worker**

   * Base URL : http://localhost:8080/workers/id
   * Parameter `id` in url is id of the worker

### Requests for books

#### Method GET

1. **Get all books**

   * Base URL : http://localhost:8080/books

2. **Get one book**

   * Base URL : http://localhost:8080/books/id
   * Parameter `id` in url is id of the book

#### Method POST

1. **Add book**

   * Base URL : http://localhost:8080/books
   * Required body JSON properties : title(String), genre(String), pages(int), author(String), publisher(String), copies(int), releaseDate(String), libraryId(UUID)
   * Optional body JSON properties : none

#### Method PUT

1. **Update book**

   * Base URL : http://localhost:8080/books/id
   * Parameter `id` in url is id of the book
   * Required body JSON properties : title(String), genre(String), pages(int), author(String), publisher(String), copies(int), releaseDate(String), libraryId(UUID)
   * Optional body JSON properties : none

#### Method DELETE

1. **Delete book**

   * Base URL : http://localhost:8080/books/id
   * Parameter `id` in url is id of the book

### Requests for libraries

#### Method GET

1. **Get all libraries**

   * Base URL : http://localhost:8080/libraries

2. **Get one library**

   * Base URL : http://localhost:8080/libraries/id
   * Parameter `id` in url is id of the library

#### Method POST

1. **Add library**

   * Base URL : http://localhost:8080/libraries
   * Required body JSON properties : name(String), address(String), contactPhone(int)
   * Optional body JSON properties : none

#### Method PUT

1. **Update library**

   * Base URL : http://localhost:8080/libraries/id
   * Parameter `id` in url is id of the library
   * Required body JSON properties : name(String), address(String), contactPhone(int)
   * Optional body JSON properties : none

#### Method DELETE

1. **Delete library**

   * Base URL : http://localhost:8080/libraries/id
   * Parameter `id` in url is id of the library

### Requests for bookReservations

#### Method GET

1. **Get all bookReservations**

   * Base URL : http://localhost:8080/bookReservations

2. **Get one bookReservation**

   * Base URL : http://localhost:8080/bookReservations/id
   * Parameter `id` in url is id of the bookReservation

#### Method POST

1. **Add bookReservation**

   * Base URL : http://localhost:8080/bookReservations
   * Required body JSON properties : borrowDate(String), isReturned(boolean), bookId(UUID), userId(UUID)
   * Optional body JSON properties : workerId(UUID), returnDate(String)(Always adds 1 week to borrow date)
   * Date string must be in format "yyyy-MM-dd"

#### Method PUT

1. **Update bookReservation**

   * Base URL : http://localhost:8080/bookReservations/id
   * Parameter `id` in url is id of the bookReservation
   * Required body JSON properties : borrowDate(String), isReturned(boolean), bookId(UUID), userId(UUID)
   * Optional body JSON properties : workerId(UUID), returnDate(String)(Always adds 1 week to borrow date)
   * Date string must be in format "yyyy-MM-dd"

#### Method DELETE

1. **Delete bookReservation**

   * Base URL : http://localhost:8080/bookReservations/id
   * Parameter `id` in url is id of the bookReservation
