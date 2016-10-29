package javazon;

import javax.swing.JOptionPane;

public class JavaZonApp {

	public static void main(String[] args) {

			//COLLECT INFORMATION USING JOPTIONPANE
			String firstName = Validator.getValidFirstName(JOptionPane.showInputDialog("Please enter First Name"));
			
			//Do the same for the other variables
			String lastName = Validator.getValidLastName(JOptionPane.showInputDialog("Please enter Last Name"));
			String street= Validator.getValidStreet(JOptionPane.showInputDialog("Please enter Street Name")); 
			String city= Validator.getValidCity(JOptionPane.showInputDialog("Please enter City Name"));
			String state= Validator.getValidState(JOptionPane.showInputDialog("Please enter 2 character State Name ...ex CA for California... "));
			String zip = Validator.getValidZip(JOptionPane.showInputDialog("Please enter Zip Code"));
			String phone= Validator.getValidPhoneNumber(JOptionPane.showInputDialog("Please enter Phone Number")); 
			String membership= Validator.getValidMembership(JOptionPane.showInputDialog("Please enter Membership Number")); 
			
			//CREATE A NEW CUSTOMER OBJECT (uncomment line below)
			Customer customer = new Customer(firstName,lastName,street,city,state,zip,phone,membership);

			//CREATE NEW ORDER OBJECT
			Order order = new Order();
			
			//SET ORDER CUSTOMER
			order.setOrderCustomer(customer);

			//LOOP TO COLLECT PRODUCTS SELECTED BY USER AND THEIR QUANTITIES
			do {
				//CREATE MENU OBJECT
				Menu menu = new Menu();
				
				//Get the items from the menu class, and load them into the
				//JOptionPane menu
				String menuItems[] = menu.getMenuDescriptions();
			
				int intCode = 0;
				intCode = JOptionPane.showOptionDialog(null, "Select an Option",
						"Menu Items", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, menuItems, menuItems[0]);
				
				//RETURN PRODUCT FROM MENU
				Product product = menu.getMenu()[intCode];

				//PROMPT USER TO ENTER QUANTITY
                                //Had to change this so it will validate and also change  variable type to int
				int qty = Validator.getValidQuantity(JOptionPane.showInputDialog("Enter Quantity"));

				//ADD PRODUCT AND QUANTITY TO ORDER
                                //changed this code also because it did not have to be converted to Integer as it is declared as one
				order.setOrderProduct(product, qty);


			}while (JOptionPane.showConfirmDialog(null,
					"Enter More Products?",
					"User Selection",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null) != JOptionPane.NO_OPTION);

			//CREATE A NEW JAVAZON STORE
			JavaZon jz = new JavaZon();
			
			//ADD THE ORDER TO THE STORE
			jz.setOrder(order);
			
			//ASSIGN A CLERK TO THE ORDER
			jz.setClerk();
			
			//PROCESS ORDER
			jz.processOrder();
			
			//DISPLAY THE RESULT
			JOptionPane.showMessageDialog(null,jz.getReceipt());


	}

}
