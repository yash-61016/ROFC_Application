
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yashpatel
 */
public class Table extends Furniture {

    //attributes
    private double diameter;
    private char baseType;
    private double finalPrice;

    //default constructor
    public Table() {
        super();
        this.diameter = 0;
        this.baseType = 'C';
    }

    //constructor
    public Table(int idNum, char typeOfWood, int quantity, ImageIcon img, double diameter, char baseType) {
        super(idNum, typeOfWood, quantity, img);
        this.diameter = diameter;
        this.baseType = baseType;
        this.finalPrice = calculations.getTablePrice(quantity, typeOfWood, baseType, diameter);
        stringArray = new String[5];
        stringArray[0] = "" + this.idNum;
        stringArray[1] = "" + this.typeOfWood;
        stringArray[2] = "" + this.diameter;
        stringArray[3] = "" + this.baseType;
        stringArray[4] = "" + String.format("£%.2f", this.finalPrice / 100.00);
        
    }

    //getters
    public double getDiameter() {
        return this.diameter;
    }

    public char getBaseType() {
        return this.baseType;
    }

    public double getPrice() {
        return this.finalPrice;
    }
    @Override
    public String[] getValues(){
        
        return stringArray;
    }

    //toString for saving information in file
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Diameter       :" + this.diameter + ",");
        sb.append("\n\t");
        sb.append("Base Type      :" + this.baseType + ",");
        sb.append("\n\t");
        sb.append("Price          :" + String.format("£%.2f", this.finalPrice / 100.00) + ", \n?");
        return sb.toString();
    }
}
