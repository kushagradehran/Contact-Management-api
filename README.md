# Contact Management RESTful API
This is a simple Spring Boot application that provides a RESTful API for managing contacts. The application stores contacts in an in-memory database and allows users to retrieve all contacts, filter contacts by zip code, and create new contacts.

API Endpoints
The following API endpoints are available:
REQUESTMAPPING("/contact")
# POST /createContact
Creates a new contact.
Request Body:

fullName String (Manadatory)
Dob(Date Of Birth) LocalDate (Manadatory)
address Address (Manadatory)
in address field :
 {
 city String (Manadatory)
 zipCode String (Manadatory)
 }
 
# create Contact Example:
 ![image](https://user-images.githubusercontent.com/61082684/236441151-1aae805c-982e-4973-95bd-c330cfba2ed8.png)
 
# Validation check Example:
 ![image](https://user-images.githubusercontent.com/61082684/236441641-6d7394fb-affe-4922-bfff-fe5e0a57891b.png)

# GET /findAllContact endpoint

 ![image](https://user-images.githubusercontent.com/61082684/236441934-e123ba7a-4cb9-4e2b-b1e6-469262acaa55.png)

# GET /findByZipCode/{zipCode} endpoint

![image](https://user-images.githubusercontent.com/61082684/236442204-1fb205bb-6179-4f6d-8c4a-7bd228022192.png)

# Logging
The application logs every time a new contact is created.
