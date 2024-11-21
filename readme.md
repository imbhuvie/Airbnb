Airbnb Internship Spring Boot Assignment
Assignment Details
1. Setup the Project:
   • Create a Spring Boot application with Maven/Gradle.
   • Add dependencies for Spring Security, JWT, JPA, and a MySQL database.
2. Implement Authentication:
   • Signup API:  
   o Endpoint: POST /api/auth/signup
   o Request Body: { "username": "string", "password": "string",
   "email": "string", "fullName": "string", "phoneNumber": "string"
   }
   o Register new users with encrypted passwords.
   o add some validation(email should uniq, pasword long atlease 8 char)
   • Login API:  
   o Endpoint: POST /api/auth/login
   o Request Body: { "username": "string", "password": "string" }
   o Return a JWT token upon successful authentication.
3. Property Management:
   • CRUD Operations:  
   o Create Property:  
   ▪ Endpoint: POST /api/properties
   ▪ Request Body: { "name": "string", "description": "string",
   "address": "string", "pricePerNight": "decimal",
   "numberOfBedrooms": "int", "numberOfBathrooms": "int",
   "isAvailable": "boolean", "drinkAllowed": "boolean",
   "petAllowed": "boolean", "maxCheckoutTimeInNights": "int",
   "extraCharges": "decimal" }
   o Retrieve All Properties:  
   ▪ Endpoint: GET /api/properties
   o Get Property by ID:  
   ▪ Endpoint: GET /api/properties/{id}
   o Update Property:  
   ▪ Endpoint: PUT /api/properties/{id}
   ▪ Request Body: { "name": "string", "description": "string",
   "address": "string", "pricePerNight": "decimal",
   "numberOfBedrooms": "int", "numberOfBathrooms": "int",
   "isAvailable": "boolean", "drinkAllowed": "boolean",
   "petAllowed": "boolean", "maxCheckoutTimeInNights": "int",
   "extraCharges": "decimal" }
   o Delete Property:  
   ▪ Endpoint: DELETE /api/properties/{id}
   o Get User’s Properties:  
   ▪ Endpoint: GET /api/users/{userId}/properties
   ▪ Returns all properties owned by the specified user.
4. Define the Data Models:
   Property Model:
   javaCopy code
   @Entity
   public class Property {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private String address;
   private BigDecimal pricePerNight;
   private int numberOfBedrooms;
   private int numberOfBathrooms;
   private boolean isAvailable;
   private boolean drinkAllowed;
   private boolean petAllowed;
   private int maxCheckoutTimeInNights;
   private BigDecimal extraCharges;
   @OneToMany(mappedBy = "property")
   private List<Review> reviews;
   @ManyToOne
   @JoinColumn(name = "owner_id")
   private User owner;
   }
   User Model:
   javaCopy code
   @Entity
   public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(unique = true, nullable = false)
   private String username;
   @Column(nullable = false)
   private String password;
   @Column(nullable = false)
   private String email;
   @Column(nullable = false)
   private String fullName;
   private String phoneNumber;
   @OneToMany(mappedBy = "owner")
   private List<Property> properties;
   @OneToMany(mappedBy = "user")
   private List<Review> reviews;
   }
5. Implement JWT Authentication:
   • Configure Spring Security to use JWT for securing endpoints.
   • Create a filter for validating JWT tokens.

   Good luck, and we look forward to seeing your implementations!