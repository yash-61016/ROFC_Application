
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yashpatel
 */
public class calculations {

    //array
    static Furniture[] cart = new Furniture[9];
    //pointer for array
    static int pnt = 0;

    //methods for price calculations
    //chair final price
    public static double getChairPrice(int quantity, char typeOfWood, boolean armRest) {
        // calculation = quantity x (units x price of type of wood)
        // units : without armrest = 1625; with armrest = 1625+250;
        // price of type of wood: Walnut = 3p; Oak = 4p;

        double price = 0;

        if (armRest == true) {//check if armrest is there or not
            if (typeOfWood == 'O') {//check for type of wood
                price = quantity * ((1625 + 250) * 4);
            } else {
                price = quantity * ((1625 + 250) * 3);
            }
        } else {//if no armrest
            if (typeOfWood == 'O') {//check for type of wood
                price = quantity * (1625 * 4);
            } else {
                price = quantity * (1625 * 3);
            }
        }
        return price;
    }

    //table final price
    public static double getTablePrice(int quantity, char typeOfWood, char baseType, double diameter) {
        // calculation = quantity x ((diameter * diameter) x price of type of wood + price of type of base)
        // prices of type of base: Chrome = 3500p; Wodden = 4500p;
        // prices of type of wood: Walnut = 3p; Oak = 4p;

        double price = 0;

        if (baseType == 'W') {//check if wooden base or not
            if (typeOfWood == 'O') {//check for type of wood
                price = quantity * ((diameter * diameter) * 4 + 4500);
            } else {
                price = quantity * ((diameter * diameter) * 3 + 4500);
            }
        } else {//if not wooden base
            if (typeOfWood == 'O') {//check for type of wood
                price = quantity * ((diameter * diameter) * 4 + 3500);
            } else {
                price = quantity * ((diameter * diameter) * 3 + 3500);
            }
        }
        return price;
    }

    //desk final price
    public static double getDeskPrice(int quantity, char typeOfWood, double width, double depth, int numOfDrawer) {
        // calculation = quantity x ((height (80) + width + depth) * 12) + ((depth * width) * price per unit) + (number of draws * £8.50)
        // prices of type of wood: Walnut = 3p; Oak = 4p;

        double price = 0;

        if (typeOfWood == 'O') {//check for type of wood; if Oak
            price = quantity * (((80 + width + depth) * 12) + ((depth * width) * 4) + (numOfDrawer * 850));
        } else {//if walnut
            price = quantity * (((80 + width + depth) * 12) + ((depth * width) * 3) + (numOfDrawer * 850));
        }

        return price;
    }

    //adding to array
    public static void addToCart(Furniture product,int quantity) {
        int emptyCells = 9-pnt;
        for (int i = 1; i <= quantity; i++) {
            if (hasSpace() == true) {
                cart[pnt] = product;
                pnt++;
            }
            else{
                JOptionPane.showMessageDialog(null,"Sorry, you've reached your cart limit. Can only add " + emptyCells + " items.");
            }
        }

    }

    public static boolean valQuantity(int quantity) {
        return (quantity <= 9) ? (true) : (false);
    }

    public static int getArraySize() {
        return pnt;
    }

    public static Furniture getArrayContent(int x) {
        return cart[x];
    }

    public static boolean hasSpace() {
        if (pnt < 9) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean removeFurniture(int x) {
        for (int i = x; i <= cart.length - 2; i++) {
            cart[i] = cart[i + 1];
        }
        cart[pnt - 1] = null;
        pnt--;
        return true;
    }

}
