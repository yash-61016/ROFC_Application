
import java.util.ArrayList;
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
public abstract class Furniture {

    //attributes
    protected int idNum;
    protected char typeOfWood;
    protected int quantity;
    protected ImageIcon img;
    protected String[] stringArray;

    //default constructor
    protected Furniture() {

        typeOfWood = 'W';
        quantity = 1;
    }

    //constructor
    protected Furniture(int idNum, char typeOfWood, int quantity, ImageIcon img) {
        this.idNum = idNum;
        this.typeOfWood = typeOfWood;
        this.quantity = quantity;
        this.img = img;
        this.stringArray = new String[2];
        this.stringArray[0] = "" + this.idNum;
        this.stringArray[1] = "" + this.typeOfWood;
        
    }

    //getters
    public int getIdNum() {
        return this.idNum;
    }

    public int getTypeOfWood() {
        return this.typeOfWood;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String[] getValues() {
        
        return this.stringArray;
    }

    //setters
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setTypeOfWood(char typeOfWood) {
        this.typeOfWood = typeOfWood;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("/ Id Num :" + this.idNum + ",");
        sb.append("\n\t");
        sb.append("Type Of Wood   :" + this.typeOfWood + ",");
        sb.append("\n\t");

        return sb.toString();
    }

}
