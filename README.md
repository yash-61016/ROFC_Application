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
### Preview :-
<img width="812" alt="2" src="https://user-images.githubusercontent.com/73232849/130649429-668162b7-96e5-4404-bb5d-fdc77c81249b.png">

### Buttons:
#### 1.	Add a Chair
<img width="812" alt="3" src="https://user-images.githubusercontent.com/73232849/130649529-f9b5cb86-86bd-4787-9fcb-b5ed503160ea.png">

The user is prompted to input the chair’s id number, type of wood, quantity (number of items) and if armrests are required.
If there is an appropriate empty space on the GUI, a Chair is added to the order details and an appropriate image is displayed in the empty space.
If the area is full, a suitable message is displayed to the user and no further action taken.
#### 2.	Add a Table 
<img width="812" alt="5" src="https://user-images.githubusercontent.com/73232849/130649560-d724839e-7d2f-45e5-980e-5282701324b9.png">

The user is prompted to input the table’s id number, type of wood, quantity and diameter required.
The table is processed using a similar method to the one described for the chair above.
#### 3.	Add a Desk
<img width="812" alt="4" src="https://user-images.githubusercontent.com/73232849/130649589-59ea6b69-0359-4ce0-a14c-57a1ad9bd913.png">

The user is prompted to input the desk’s id number, type of wood, quantity, depth and width.
The desk is processed using a similar method to the one described for the chair above.
#### 4. Clear All
Clears all items from the application and resets the total to zero.  
#### 5.	Go to Cart
<img width="662" alt="6" src="https://user-images.githubusercontent.com/73232849/130649752-1660fe40-e0c0-4c18-9a52-558e798bb89b.png">

Display all the items that have been added to the order with their price and a button to view detials.

Once you click details:-
<img width="801" alt="7" src="https://user-images.githubusercontent.com/73232849/130649856-32d7176c-299b-4542-af61-4865757bd713.png">

#### 6.	Save 
<img width="382" alt="8" src="https://user-images.githubusercontent.com/73232849/130649877-bf076677-baa0-414f-8903-ca1db610f680.png">

The user is prompted to enter a file name (ending with the extension .dat) and all items in the order should be written to this file.  
#### 7.	Load  
The user is prompted to input the name of an existing data file.  The order details are read in from the file and the display updated. 
Before reading the data file, any existing order details should be cleared.  



### Mouse Operation Requirements:

When the user clicks on an item the following operations should be performed:
- Left Click: Display details of the item.
<img width="630" alt="9" src="https://user-images.githubusercontent.com/73232849/130650019-6f5fd4a6-623d-44f0-aa30-9c9045667516.png">

- Right Click: Remove the item (after confirmation from the user).
- Middle Click: Change/update item attributes and update charge.  There is no need to move the image if the size change
