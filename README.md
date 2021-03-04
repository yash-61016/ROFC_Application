# :chair: ROFC_Application :chair:
 This is a prototype application for the Real Office Furniture Company (ROFC).  
 The application will allow ROFC staff to record details of individual orders.
 
## Basic Information:
The company offers furniture in oak or walnut.
The prices are based on the number of units (cubic centimetres) of wood required for each item
The current charge/price of each unit is 4p for oak and 3p for walnut.


### The prototype support the following furniture items:
#### Chairs: 
Only one chair style is available and it can come with optional armrests.
A standard chair uses 1625 units of wood and if the customer chooses armrests, it takes another 250 units.
#### Tables: 
A single circular table is available and it can come with a wooden or chrome base.
The customer can request any size (diameter) that is 50 centimeters or more.
ROFC assumes the table is square for the purpose of calculating the number of units of wood.
The following information is required to calculate the item price of the table:
Wooden base price:	£45.00
Chrome base price:	£35.00
Number of units formula:	diameter x diameter
Total table price is:	(number of units * charge) + price of the base
#### Desks: Customers can request desks with 1-4 draws and the total item price can be calculated using the following formula:
(((height + width + depth) * 12) + (depth * width) * price per unit) + (number of draws * £8.50)
Note: The height of all desks is 80cm

### Buttons:
#### 1.	Add a Chair
The user is prompted to input the chair’s id number, type of wood, quantity (number of items) and if armrests are required.
If there is an appropriate empty space on the GUI, a Chair is added to the order details and an appropriate image is displayed in the empty space.
If the area is full, a suitable message is displayed to the user and no further action taken.
#### 2.	Add a Table 
The user is prompted to input the table’s id number, type of wood, quantity and diameter required.
The table is processed using a similar method to the one described for the chair above.
#### 3.	Add a Desk
The user is prompted to input the desk’s id number, type of wood, quantity, depth and width.
The desk is processed using a similar method to the one described for the chair above.
#### 4. Clear All
Clears all items from the application and resets the total to zero.  
#### 5.	Total Price
Display the total price for all the items that have been added to the order.
#### 6.	Save 
The user is prompted to enter a file name (ending with the extension .dat) and all items in the order should be written to this file.  
#### 7.	Load  
The user is prompted to input the name of an existing data file.  The order details are read in from the file and the display updated. 
Before reading the data file, any existing order details should be cleared.  
#### 8.	Summary
Displays a summary of the items sorted into ascending order by total price.  The summary should be output to the console and include the id, type of item, the item price and the total price.


### Mouse Operation Requirements:

When the user clicks on an item the following operations should be performed:
- Left Click: Display details of the item.
- Right Click: Remove the item (after confirmation from the user).
- Middle Click: Change/update item attributes and update charge.  There is no need to move the image if the size change
