E-Commerce-Database
-------------------
It is an E-Commerce Console Application
Go to an App.Java File And Run.
For User login: 
      email: selvin@user.com
      password: selvin

For Admin login: 
      email: admin@admin.com
      password: admin

Admin can able to:
          View user
          Add products
          Edit products
          Delete products
          Add categories
          Edit categories
          Delete categories

Users can able to :
          Register
          View products
          View Categories
          Add to cart 
          View cart 
          Checkout
          Place orders
          View orders


Requirements
------------

        --> * Welcome page
        --> * Login Page
        --> * Register Page
        --> * Cart Page 
        --> * Order Page
        --> * Categary Page
        --> * Product Page

It has three main components:
        --> * Model
        --> * View
        =-> * Controller

Model:
------
        --> * Handles data logic
View:
-----
        --> * It displays the information from the model to the user 
Controller: 
-----------
        --> * It controls the data flow into a model object and updates the view whenever data changes 

Utils:
------
        Repeated methods
        ----------------
                --> * AppCustomException
                --> * AppScanner
                --> * AppInput

Asserts:
-------
        --> * csv files

Technology Used:
----------------
                  Class
                  Object
                  Constructed
                  Interface
                  Abstraction --> Achieve using an Interface
                  Exception --> throws and try-catch, Custom Exception
                  Collection --> ArrayList
                  For Each Loop
                  If, else If, else
                  Scanner Class
                  Bean Class
                  Dependencies --> Mysql-connector-j

Faced Challenges :
------------------
                  Exception --> NullPointerException, NumberFormatterException, ArrayIndexOutOfBoundsException, FileNotFoundException
                  Object --> Null

Dependency :
-----------
Add dependency for CSVReader.
         <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.33</version>
        </dependency>

