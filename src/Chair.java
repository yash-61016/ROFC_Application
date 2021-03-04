
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
public class Chair extends Furniture {

    //attributes
    private boolean armRest;
    private double finalPrice;
    protected String[] stringArray;

    //default constructor
    public Chair() {
        super();
        armRest = false;
        this.finalPrice = calculations.getChairPrice(quantity, typeOfWood, armRest);
    }

    //constructor
    public Chair(int idNum, char typeOfWood, int quantity, ImageIcon img, boolean armRest) {
        super(idNum, typeOfWood, quantity, img);
        this.armRest = armRest;
        this.finalPrice = calculations.getChairPrice(quantity, typeOfWood, armRest);
        this.stringArray = new String[4];
        this.stringArray[0] = "" + this.idNum;
        this.stringArray[1] = "" + this.typeOfWood;
        this.stringArray[2] = "" + this.armRest;
        this.stringArray[3] = "" + String.format("£%.2f", this.finalPrice / 100.00);
    }

    //getters
    public boolean getArmRest() {
        return this.armRest;
    }

    public double getPrice() {
        return this.finalPrice;
    }
    
    @Override
    public String[] getValues(){
        return this.stringArray;
    }

    //setters
    public void setArmRest(boolean armRest) {
        this.armRest = armRest;
    }

    public void setPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    //toString for saving information in file
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Arm Rest       :" + this.armRest + ",");
        sb.append("\n\t");
        sb.append("Price          :" + String.format("£%.2f", this.finalPrice / 100.00) + ", \n?");

        return sb.toString();
    }
}
