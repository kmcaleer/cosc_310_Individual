# Inventory-Management-System
We are building a generic inventory system, for our project, that could be used for any business. 
The system can be customized for, or by, a business to suit their specific type of inventory.
It can help to manage a business’ stock by keeping track of all inventory on hand,
the rate at which the inventory is reduced,and suggested dates to reorder new stock.
This allows the system to send alerts to warn of low inventory or reminders to place an order with a product vendor. 
Alerts can also be generated to warn of vendor changes such as price changes or new products added. 
The user can select specific inventory to generate an order to send out to product vendors and they can also generate reports with any pertinent information that the system stores about the inventory.

# Systems current functionalities
1. Creates a product
2. Stores the product on a file 
3. Loads the file with the product everytime the program is run
4. Print the products that are currently in the invenotry
5. Modify the quantity of products in the inventory
6. Print the products that are running low

# Setting up the database
1. Download docker desktop
2. Download visual studio code
3. Open your terminal and navigate it to the COSC 310 folder in you local repository of the project
4. Run the command: docker-compose up -d
 If everything is successful, the MySQL database will start on port 3306. If there is a port conflict, change the port to 3307 in the docker-compose.yml file in the COSC 310 folder
5. Run the command: docker exec -it inventorySystem-mysql bash
6. Run the command: mysql -u team22 -p
    The password is in the docker-compose.yml file
7. Enter password(The password is in the docker-compose.yml file)
If successful
Open VS code and create a connection to the database using the username and password from the docker-compose.yml file

# HOW TO COMPILE AND RUN THE PROGRAM
1. Clone the repository to your computer
2. Import the files in the repository as a project in you IDE that supports java preferebly VS CODE/eclipse
3. Open the COSC 310 Folder
4. Open the src folder
5. Open the proj folder
6. Run the java files in the proj folder. The program should execute


