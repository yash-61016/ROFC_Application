
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
public class Desk extends Furniture {

    //attributes
    private double width;
    private double depth;
    private int numOfDrawers;
    private double finalPrice;

    //default constructor
    public Desk() {
        super();
        width = 0;
        depth = 0;
        numOfDrawers = 1;
    }

    //constructor
    public Desk(int idNum, char typeOfWood, int quantity, ImageIcon img, double width, double depth, int numOfDrawers) {
        super(idNum, typeOfWood, quantity, img);
        this.depth = depth;
        this.width = width;
        this.numOfDrawers = numOfDrawers;
        this.finalPrice = calculations.getDeskPrice(quantity, typeOfWood, width, depth, numOfDrawers);
        stringArray = new String[6];
        stringArray[0] = "" + this.idNum;
        stringArray[1] = "" + this.typeOfWood;
        stringArray[2] = "" + this.width;
        stringArray[3] = "" + this.depth;
        stringArray[4] = "" + this.numOfDrawers;
        stringArray[5] = "" + String.format("£%.2f", this.finalPrice / 100.00);
    }

    //getters
    public double getWidth() {
        return this.width;
    }

    public double getDepth() {
        return this.depth;
    }

    public int getNumOfDrawers() {
        return this.numOfDrawers;
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
        sb.append("Width          :" + this.width + ",");
        sb.append("\n\t");
        sb.append("Depth          :" + this.depth + ",");
        sb.append("\n\t");
        sb.append("Num Of Drawers :" + this.numOfDrawers + ",");
        sb.append("\n\t");
        sb.append("Price          :" + String.format("£%.2f", this.finalPrice / 100.00) + ", \n?");

        return sb.toString();
    }
}
