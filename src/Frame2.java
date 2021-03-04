
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yashpatel
 */
public class Frame2 extends JPanel implements ActionListener, FocusListener, ChangeListener, MouseListener {

    //common variables
    int idNum;
    int quantity = 1;
    ImageIcon img;
    double totalPrice;
    //variables for chair
    boolean armRest;
    char typeOfWood;
    //variables for table
    char base;
    double diameter;
    //variables for desk
    int numOfDrawers;
    double width;
    double depth;

    JFrame Frame2 = new JFrame("ROFC Application");//new Frame
    JPanel detailsPanel = new JPanel();//panel for the details of every product
    JPanel gridView;//panel for displaying products
    JLabel imgViewer = new JLabel();//image viewer
    JLabel greenBg = new JLabel();//side bar for main add options
    //labels for all the values
    JLabel IdLb, quantityLb, styleLb, baseLb, diameterLb, woodLb, priceLb, heightLb, widthLb, depthLb, numOfDrawersLb;
    //lables for the grid/prodcuts in cart
    JLabel item1, item2, item3, item4, item5, item6, item7, item8, item9;

    //text fields for all the values 
    JTextField quantityText, idText, diameterText, widthText, depthText;

    //sidebar/main buttons
    JButton addChair, addDesk, addTable, clearAll;

    //buttons for all the values/intputs
    JButton withoutArmRest, withArmRest, oak, walnut, plus, minus, chrome, wodden;

    //bottom buttons
    JButton addToCartChair, addToCartDesk, addToCartTable, goToCart, goToCart2;

    //slider for number of drawers
    JSlider drawerSlider;

    //imageicons; Bt = button; Cl = clicked
    //imageicons for side bar buttons
    ImageIcon addChairBt, addChairBtCl, addDeskBt, addDeskBtCl, addTableBt, addTableBtcl, clearAllBt, claerAllBtCl;
    //imageicons for common buttons
    ImageIcon plusBt, minusBt, walnutBt, walnutBtCl, oakBt, oakBtCl, addToCartBt, goToCartBt, productImg, goToCart2Bt;
    //imageicons for chair values
    ImageIcon withArmRestBt, withArmRestBtCl, withoutArmRestBt, withoutArmRestBtCl;
    //imageicons for table values
    ImageIcon chromeBt, chromeBtCl, woddenBt, woddenBtCl;
    //imageicons for displaying prodcut images
    ImageIcon prw1, prw2;
    //imageicons for products in cart
    ImageIcon item1IMG, item2IMG, item3IMG, item4IMG, item5IMG, item6IMG, item7IMG, item8IMG, item9IMG;

    Frame2() {
        
        //sidebar buttons and label

        addChairBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddChair.png"));//getting image from the "src" folder and assiging it
        addChair = new JButton();
        addChair.setBounds(10, 45, 180, 70);
        addChair.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = addChair.getInsets().left;//this is to leave no space between img and border
        addChair.setIcon(resizeIcon(addChairBt, addChair.getWidth() - offset, addChair.getHeight() - offset));
        addChair.addActionListener(this);

        addDeskBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddDesk.png"));//getting image from the "src" folder and assiging it
        addDesk = new JButton();
        addDesk.setBounds(10, 125, 180, 70);
        addDesk.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = addDesk.getInsets().left;//this is to leave no space between img and border
        addDesk.setIcon(resizeIcon(addDeskBt, addDesk.getWidth() - offset, addDesk.getHeight() - offset));
        addDesk.addActionListener(this);

        addTableBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddTable.png"));//getting image from the "src" folder and assiging it
        addTable = new JButton();
        addTable.setBounds(10, 205, 180, 70);
        addTable.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = addTable.getInsets().left;//this is to leave no space between img and border
        addTable.setIcon(resizeIcon(addTableBt, addTable.getWidth() - offset, addTable.getHeight() - offset));
        addTable.addActionListener(this);

        clearAllBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.ClearAll.png"));//getting image from the "src" folder and assiging it
        clearAll = new JButton();
        clearAll.setBounds(10, 285, 180, 70);
        clearAll.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = clearAll.getInsets().left;//this is to leave no space between img and border
        clearAll.setIcon(resizeIcon(clearAllBt, clearAll.getWidth() - offset, clearAll.getHeight() - offset));
        clearAll.addActionListener(this);
        
        goToCart2Bt = new ImageIcon(this.getClass().getResource("Frame 2/Button.GoToCart2.png"));//getting image from the "src" folder and assiging it
        goToCart2 = new JButton();
        goToCart2.setBounds(10, 365, 180, 70);
        goToCart2.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = goToCart2.getInsets().left;//this is to leave no space between img and border
        goToCart2.setIcon(resizeIcon(goToCart2Bt, goToCart2.getWidth() - offset, goToCart2.getHeight() - offset));
        goToCart2.addActionListener(this);
        
        //side bar
        greenBg.setBounds(0, 0, 200, 450);
        greenBg.add(addChair);
        greenBg.add(addDesk);
        greenBg.add(addTable);
        greenBg.add(clearAll);
        greenBg.add(goToCart2);
        greenBg.setOpaque(true);
        greenBg.setBackground(Color.decode("#41553F"));

        //panel to ask input for each product
        detailsPanel.setBounds(200, 0, 500, 450);
        detailsPanel.setBackground(Color.decode("#c1c5c9"));
        Frame2.add(detailsPanel);

        //grid of products
        gridView = new JPanel(new GridLayout(3, 3, 90, 5));
        gridView.setBounds(205, 460, 490, 320);
        gridView.setBackground(Color.decode("#c1c5c9"));
        item1 = new JLabel();//item1
        item1.setSize(120, 100);
        item1.setIcon(item1IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item1.getInsets().left;//this is to leave no space between img and border
        item1.setIcon(resizeIcon(item1IMG, item1.getWidth() - offset, item1.getHeight() - offset));
        item1.addMouseListener(this);
        gridView.add(item1);
        item2 = new JLabel();//item2
        item2.setSize(100, 100);
        item2.setIcon(item2IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item2.getInsets().left;//this is to leave no space between img and border
        item2.setIcon(resizeIcon(item2IMG, item2.getWidth() - offset, item2.getHeight() - offset));
        item2.addMouseListener(this);
        gridView.add(item2);
        item3 = new JLabel();//item3
        item3.setSize(100, 100);
        item3.setIcon(item3IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item3.getInsets().left;//this is to leave no space between img and border
        item3.setIcon(resizeIcon(item3IMG, item3.getWidth() - offset, item3.getHeight() - offset));
        item3.addMouseListener(this);
        gridView.add(item3);
        item4 = new JLabel();//item4
        item4.setSize(100, 100);
        item4.setIcon(item4IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item4.getInsets().left;//this is to leave no space between img and border
        item4.setIcon(resizeIcon(item4IMG, item4.getWidth() - offset, item4.getHeight() - offset));
        item4.addMouseListener(this);
        gridView.add(item4);
        item5 = new JLabel();//item5
        item5.setSize(100, 100);
        item5.setIcon(item5IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item5.getInsets().left;//this is to leave no space between img and border
        item5.setIcon(resizeIcon(item5IMG, item5.getWidth() - offset, item5.getHeight() - offset));
        item5.addMouseListener(this);
        gridView.add(item5);
        item6 = new JLabel();//item6
        item6.setSize(100, 100);
        item6.setIcon(item6IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item6.getInsets().left;//this is to leave no space between img and border
        item6.setIcon(resizeIcon(item6IMG, item6.getWidth() - offset, item6.getHeight() - offset));
        item6.addMouseListener(this);
        gridView.add(item6);
        item7 = new JLabel();//item7
        item7.setSize(100, 100);
        item7.setIcon(item7IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item7.getInsets().left;//this is to leave no space between img and border
        item7.setIcon(resizeIcon(item7IMG, item7.getWidth() - offset, item7.getHeight() - offset));
        item7.addMouseListener(this);
        gridView.add(item7);
        item8 = new JLabel();//item8
        item8.setSize(100, 100);
        item8.setIcon(item8IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item8.getInsets().left;//this is to leave no space between img and border
        item8.setIcon(resizeIcon(item8IMG, item8.getWidth() - offset, item8.getHeight() - offset));
        item8.addMouseListener(this);
        gridView.add(item8);
        item9 = new JLabel();//item9
        item9.setSize(100, 100);
        item9.setIcon(item9IMG = new ImageIcon(this.getClass().getResource("furnitures/waiting.png")));
        offset = item9.getInsets().left;//this is to leave no space between img and border
        item9.setIcon(resizeIcon(item9IMG, item9.getWidth() - offset, item9.getHeight() - offset));
        item9.addMouseListener(this);
        gridView.add(item9);
        
        Frame2.add(gridView);
        Frame2.add(greenBg);
        Frame2.setLayout(null);
        Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame2.setSize(700, 800);
        Frame2.getContentPane().setBackground(Color.decode("#c1c5c9"));
        Frame2.setVisible(true);
        Frame2.setResizable(false);

    }
    
 
    
    //method to add chair
    private void Frame2AddChair() {
        //making sure nothing is in panel
        detailsPanel.removeAll();//if anything removing it

        //lables
        IdLb = new JLabel("Chair Id :");
        IdLb.setBounds(10, 0, 150, 50);
        IdLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(IdLb);

        quantityLb = new JLabel("Quantity :");
        quantityLb.setBounds(10, 80, 150, 50);
        quantityLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(quantityLb);

        styleLb = new JLabel(" Style :");
        styleLb.setBounds(10, 165, 150, 50);
        styleLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(styleLb);

        woodLb = new JLabel("Wood :");
        woodLb.setBounds(10, 255, 150, 50);
        woodLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(woodLb);

        //textfeilds
        idText = new JTextField(20);
        idText.setText("product id");
        idText.setBounds(130, 5, 130, 40);
        detailsPanel.add(idText);
        idText.addFocusListener(this);
        
        quantityText = new JTextField(1);
        quantityText.setBounds(170, 80, 50, 50);
        quantityText.setText(Integer.toString(quantity));
        detailsPanel.add(quantityText);
        quantityText.addFocusListener(this);

        //all buttons
        minus = new JButton("-");
        minus.setBounds(135, 93, 25, 25);
        detailsPanel.add(minus);
        minus.addActionListener(this);

        plus = new JButton("+");
        plus.setBounds(230, 93, 25, 25);
        detailsPanel.add(plus);
        plus.addActionListener(this);

        withArmRestBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.WithArmset.png"));//getting image from the "src" folder and assiging it
        withArmRest = new JButton();
        withArmRest.setBounds(110, 160, 180, 60);
        withArmRest.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = withArmRest.getInsets().left;//this is to leave no space between img and border
        withArmRest.setIcon(resizeIcon(withArmRestBt, withArmRest.getWidth() - offset, withArmRest.getHeight() - offset));
        detailsPanel.add(withArmRest);
        withArmRest.addActionListener(this);

        withoutArmRestBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.WithoutArmset.png"));//getting image from the "src" folder and assiging it
        withoutArmRest = new JButton();
        withoutArmRest.setBounds(300, 160, 180, 60);
        withoutArmRest.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = withoutArmRest.getInsets().left;//this is to leave no space between img and border
        withoutArmRest.setIcon(resizeIcon(withoutArmRestBt, withoutArmRest.getWidth() - offset, withoutArmRest.getHeight() - offset));
        detailsPanel.add(withoutArmRest);
        withoutArmRest.addActionListener(this);

        oakBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Oak.png"));//getting image from the "src" folder and assiging it
        oak = new JButton();
        oak.setBounds(110, 250, 180, 60);
        oak.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = oak.getInsets().left;//this is to leave no space between img and border
        oak.setIcon(resizeIcon(oakBt, oak.getWidth() - offset, oak.getHeight() - offset));
        detailsPanel.add(oak);
        oak.addActionListener(this);

        walnutBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Walnut.png"));//getting image from the "src" folder and assiging it
        walnut = new JButton();
        walnut.setBounds(300, 250, 180, 60);
        walnut.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = walnut.getInsets().left;//this is to leave no space between img and border
        walnut.setIcon(resizeIcon(walnutBt, walnut.getWidth() - offset, walnut.getHeight() - offset));
        detailsPanel.add(walnut);
        walnut.addActionListener(this);

        addToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddToCart.png"));//getting image from the "src" folder and assiging it
        addToCartChair = new JButton();
        addToCartChair.setBounds(30, 400, 200, 60);
        addToCartChair.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = addToCartChair.getInsets().left;//this is to leave no space between img and border
        addToCartChair.setIcon(resizeIcon(addToCartBt, addToCartChair.getWidth() - offset, addToCartChair.getHeight() - offset));
        detailsPanel.add(addToCartChair);
        addToCartChair.addActionListener(this);

        goToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.GoToCart.png"));//getting image from the "src" folder and assiging it
        goToCart = new JButton();
        goToCart.setBounds(270, 400, 200, 60);
        goToCart.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = goToCart.getInsets().left;//this is to leave no space between img and border
        goToCart.setIcon(resizeIcon(goToCartBt, goToCart.getWidth() - offset, goToCart.getHeight() - offset));
        goToCart.addActionListener(this);
        detailsPanel.add(goToCart);

        //image
        productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_.png"));//getting image from the "src" folder and assiging it
        imgViewer = new JLabel();
        imgViewer.setBounds(320, 15, 120, 140);
        offset = imgViewer.getInsets().left;//this is to leave no space between img and border
        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
        detailsPanel.add(imgViewer);

        //updating the frame with new values
        Frame2.repaint();
    }
    //method to add table
    private void Frame2AddTable() {
        //making sure nothing is in panel
        detailsPanel.removeAll();//if anything removing it

        //labels
        IdLb = new JLabel(" Table Id :");
        IdLb.setBounds(5, 0, 150, 50);
        IdLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(IdLb);

        quantityLb = new JLabel(" Quantity :");
        quantityLb.setBounds(5, 60, 150, 50);
        quantityLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(quantityLb);

        diameterLb = new JLabel("Diameter :");
        diameterLb.setBounds(10, 120, 150, 50);
        diameterLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(diameterLb);

        baseLb = new JLabel("  Base :");
        baseLb.setBounds(10, 205, 150, 50);
        baseLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(baseLb);

        woodLb = new JLabel("Wood :");
        woodLb.setBounds(10, 305, 150, 50);
        woodLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(woodLb);

        //text fields
        idText = new JTextField(20);
        idText.setText("product id");
        idText.setBounds(130, 5, 130, 40);
        detailsPanel.add(idText);
        idText.addFocusListener(this);

        quantityText = new JTextField(1);
        quantityText.setBounds(180, 60, 50, 50);
        quantityText.setText(Integer.toString(quantity));
        detailsPanel.add(quantityText);
        quantityText.addFocusListener(this);

        diameterText = new JTextField(10);
        diameterText.setBounds(140, 125, 100, 40);
        detailsPanel.add(diameterText);
        diameterText.addFocusListener(this);

        //all the buttons
        minus = new JButton("-");
        minus.setBounds(145, 73, 25, 25);
        detailsPanel.add(minus);
        minus.addActionListener(this);

        plus = new JButton("+");
        plus.setBounds(240, 73, 25, 25);
        detailsPanel.add(plus);
        plus.addActionListener(this);

        chromeBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Chrome.png"));//getting image from the "src" folder and assiging it
        chrome = new JButton();
        chrome.setBounds(110, 205, 180, 60);
        chrome.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = chrome.getInsets().left;//this is to leave no space between img and border
        chrome.setIcon(resizeIcon(chromeBt, chrome.getWidth() - offset, chrome.getHeight() - offset));
        detailsPanel.add(chrome);
        chrome.addActionListener(this);

        woddenBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Wood.png"));//getting image from the "src" folder and assiging it
        wodden = new JButton();
        wodden.setBounds(300, 205, 180, 60);
        wodden.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = wodden.getInsets().left;//this is to leave no space between img and border
        wodden.setIcon(resizeIcon(woddenBt, wodden.getWidth() - offset, wodden.getHeight() - offset));
        detailsPanel.add(wodden);
        wodden.addActionListener(this);

        oakBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Oak.png"));//getting image from the "src" folder and assiging it
        oak = new JButton();
        oak.setBounds(110, 300, 180, 60);
        oak.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = oak.getInsets().left;//this is to leave no space between img and border
        oak.setIcon(resizeIcon(oakBt, oak.getWidth() - offset, oak.getHeight() - offset));
        detailsPanel.add(oak);
        oak.addActionListener(this);

        walnutBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Walnut.png"));//getting image from the "src" folder and assiging it
        walnut = new JButton();
        walnut.setBounds(300, 300, 180, 60);
        walnut.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = walnut.getInsets().left;//this is to leave no space between img and border
        walnut.setIcon(resizeIcon(walnutBt, walnut.getWidth() - offset, walnut.getHeight() - offset));
        detailsPanel.add(walnut);
        walnut.addActionListener(this);

        addToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddToCart.png"));//getting image from the "src" folder and assiging it
        addToCartTable = new JButton();
        addToCartTable.setBounds(30, 400, 200, 60);
        addToCartTable.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = addToCartTable.getInsets().left;//this is to leave no space between img and border
        addToCartTable.setIcon(resizeIcon(addToCartBt, addToCartTable.getWidth() - offset, addToCartTable.getHeight() - offset));
        detailsPanel.add(addToCartTable);
        addToCartTable.addActionListener(this);

        goToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.GoToCart.png"));//getting image from the "src" folder and assiging it
        goToCart = new JButton();
        goToCart.setBounds(270, 400, 200, 60);
        goToCart.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = goToCart.getInsets().left;//this is to leave no space between img and border
        goToCart.setIcon(resizeIcon(goToCartBt, goToCart.getWidth() - offset, goToCart.getHeight() - offset));
        goToCart.addActionListener(this);
        detailsPanel.add(goToCart);

        //image
        productImg = new ImageIcon(this.getClass().getResource("furnitures/Table_.png"));//getting image from the "src" folder and assiging it
        imgViewer = new JLabel();
        imgViewer.setBounds(320, 15, 120, 140);
        offset = imgViewer.getInsets().left;//this is to leave no space between img and border
        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
        detailsPanel.add(imgViewer);

        //updating the frame with new values
        Frame2.repaint();
    }
    //method to add desk
    private void Frame2AddDesk() {
        //making sure nothing is in panel
        detailsPanel.removeAll();//if anything removing it

        //labels
        IdLb = new JLabel(" Desk Id :");
        IdLb.setBounds(10, 0, 150, 50);
        IdLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(IdLb);

        quantityLb = new JLabel("Quantity :");
        quantityLb.setBounds(10, 60, 150, 50);
        quantityLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(quantityLb);

        heightLb = new JLabel("   Height :        80");
        heightLb.setBounds(10, 120, 250, 50);
        heightLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(heightLb);

        widthLb = new JLabel("    Width :");
        widthLb.setBounds(10, 165, 150, 50);
        widthLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(widthLb);

        depthLb = new JLabel("    Depth :");
        depthLb.setBounds(10, 215, 150, 50);
        depthLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(depthLb);

        numOfDrawersLb = new JLabel("Drawers :");
        numOfDrawersLb.setBounds(50, 270, 150, 50);
        numOfDrawersLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(numOfDrawersLb);

        woodLb = new JLabel("Wood :");
        woodLb.setBounds(10, 328, 150, 50);
        woodLb.setFont(new Font("Serif", Font.PLAIN, 30));
        detailsPanel.add(woodLb);

        //slider
        drawerSlider = new JSlider(1, 4, 1);
        drawerSlider.setBounds(180, 270, 300, 50);
        drawerSlider.setPaintTicks(true);
        drawerSlider.setPaintLabels(true);
        drawerSlider.setMajorTickSpacing(1);
        detailsPanel.add(drawerSlider);
        drawerSlider.addChangeListener(this);

        //textfields
        idText = new JTextField(20);
        idText.setBounds(130, 5, 130, 40);
        idText.setText("product id");
        detailsPanel.add(idText);
        idText.addFocusListener(this);

        quantityText = new JTextField(1);
        quantityText.setBounds(170, 60, 50, 50);
        quantityText.setText(Integer.toString(quantity));
        detailsPanel.add(quantityText);
        quantityText.addFocusListener(this);

        widthText = new JTextField(20);
        widthText.setBounds(140, 170, 100, 40);
        detailsPanel.add(widthText);
        widthText.addFocusListener(this);

        depthText = new JTextField(20);
        depthText.setBounds(140, 220, 100, 40);
        detailsPanel.add(depthText);
        depthText.addFocusListener(this);

        //all the buttons
        minus = new JButton("-");
        minus.setBounds(135, 73, 25, 25);
        detailsPanel.add(minus);
        minus.addActionListener(this);

        plus = new JButton("+");
        plus.setBounds(230, 73, 25, 25);
        plus.addActionListener(this);
        detailsPanel.add(plus);

        oak = new JButton();
        oakBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Oak.png"));//getting image from the "src" folder and assiging it
        oak = new JButton();
        oak.setBounds(110, 325, 180, 60);
        oak.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = oak.getInsets().left;//this is to leave no space between img and border
        oak.setIcon(resizeIcon(oakBt, oak.getWidth() - offset, oak.getHeight() - offset));
        detailsPanel.add(oak);
        oak.addActionListener(this);

        walnutBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.Walnut.png"));//getting image from the "src" folder and assiging it
        walnut = new JButton();
        walnut.setBounds(300, 325, 180, 60);
        walnut.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = walnut.getInsets().left;//this is to leave no space between img and border
        walnut.setIcon(resizeIcon(walnutBt, walnut.getWidth() - offset, walnut.getHeight() - offset));
        detailsPanel.add(walnut);
        walnut.addActionListener(this);

        addToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.AddToCart.png"));//getting image from the "src" folder and assiging it
        addToCartDesk = new JButton();
        addToCartDesk.setBounds(30, 400, 200, 60);
        addToCartDesk.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = addToCartDesk.getInsets().left;//this is to leave no space between img and border
        addToCartDesk.setIcon(resizeIcon(addToCartBt, addToCartDesk.getWidth() - offset, addToCartDesk.getHeight() - offset));
        detailsPanel.add(addToCartDesk);
        addToCartDesk.addActionListener(this);

        goToCartBt = new ImageIcon(this.getClass().getResource("Frame 2/Button.GoToCart.png"));//getting image from the "src" folder and assiging it
        goToCart = new JButton();
        goToCart.setBounds(270, 400, 200, 60);
        goToCart.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = goToCart.getInsets().left;//this is to leave no space between img and border
        goToCart.setIcon(resizeIcon(goToCartBt, goToCart.getWidth() - offset, goToCart.getHeight() - offset));
        goToCart.addActionListener(this);
        detailsPanel.add(goToCart);

        //image
        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_.png"));//getting image from the "src" folder and assiging it
        imgViewer = new JLabel();
        imgViewer.setBounds(280, 15, 200, 140);
        offset = imgViewer.getInsets().left;//this is to leave no space between img and border
        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
        detailsPanel.add(imgViewer);

        //updating the frame with new values
        Frame2.repaint();
    }
    //method to clear everything from screen
    private void Frame2ClearAll() {
        detailsPanel.removeAll();
        Frame2.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addChair) {
            //clearing variable values everytime they click the add button,
            //to avoid mixing of arrtributes for diff products
            idNum = 0;
            quantity = 1;
            armRest = false;
            typeOfWood = 'O';
            Frame2AddChair();
            addChair.setEnabled(false);
            addTable.setEnabled(true);
            addDesk.setEnabled(true);
        } else if (e.getSource() == addTable) {
            //clearing variable values everytime they click the add button,
            //to avoid mixing of arrtributes for diff products
            idNum = 0;
            quantity = 1;
            diameter = 0;
            base = 'W';
            Frame2AddTable();
            addTable.setEnabled(false);
            addChair.setEnabled(true);
            addDesk.setEnabled(true);
        } else if (e.getSource() == addDesk) {
            //clearing variable values everytime they click the add button,
            //to avoid mixing of arrtributes for diff products
            idNum = 0;
            quantity = 1;
            numOfDrawers = 1;
            width = 0;
            depth = 0;
            Frame2AddDesk();
            addDesk.setEnabled(false);
            addChair.setEnabled(true);
            addTable.setEnabled(true);
        } else if (e.getSource() == clearAll) {
            //calling the clear all function and enabling back all buttons
            Frame2ClearAll();
            addDesk.setEnabled(true);
            addChair.setEnabled(true);
            addTable.setEnabled(true);
        }else if(e.getSource() == goToCart2){
            //clearing all the "half filled data"
            clearAll.doClick();
            //closing current window
            Frame2.dispose();
            //opeing new frame with all values
            Frame3 cart = new Frame3();
        }else if (e.getSource() == minus) {
            //checking if the quantity doesn't goes below 0
            if (quantity > 1) {
                quantity--;
                quantityText.setText(Integer.toString(quantity));//setting the same amount in the text field
            }
        } else if (e.getSource() == plus) {
            //checking if the quantity doesn't goes above 9
            if (quantity < 9) {
                quantity++;
                quantityText.setText(Integer.toString(quantity));
                }
        } else if (e.getSource() == chrome) {
            //set base as chrome
            base = 'C';
            //set Image according
            oakOrWalnut();
            //setting Buttons
            chrome.setEnabled(false);
            wodden.setEnabled(true);
        } else if (e.getSource() == wodden) {
            //set base as wood
            base = 'W';
            //set Image according
            oakOrWalnut();
            //setting Buttons
            wodden.setEnabled(false);
            chrome.setEnabled(true);
        } else if (e.getSource() == withArmRest) {
            //setting value in variable
            armRest = true;
            //setting Image according
            if (typeOfWood == 'W') {
                productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WAR_W.png"));//getting image from the "src" folder and assiging it
                int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                detailsPanel.add(imgViewer);
            } else {
                productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WAR_O.png"));//getting image from the "src" folder and assiging it
                int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                detailsPanel.add(imgViewer);
            }
            //setting Buttons
            withArmRest.setEnabled(false);
            withoutArmRest.setEnabled(true);
        } else if (e.getSource() == withoutArmRest) {
            //setting value in variable
            armRest = false;
            //setting Image according
            if (typeOfWood == 'W') {
                productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WOAR_W.png"));//getting image from the "src" folder and assiging it
                int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                detailsPanel.add(imgViewer);
            } else {
                productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WOAR_O.png"));//getting image from the "src" folder and assiging it
                int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                detailsPanel.add(imgViewer);
            }
            //setting Buttons
            withoutArmRest.setEnabled(false);
            withArmRest.setEnabled(true);

        } else if (e.getSource() == oak) {
            //setting value in Variable
            typeOfWood = 'O';
            //setting Image
            oakOrWalnut();
            //setting Buttons
            oak.setEnabled(false);
            walnut.setEnabled(true);
        } else if (e.getSource() == walnut) {
            //setting value in Variable
            typeOfWood = 'W';
            //setting Image
            oakOrWalnut();
            //setting Buttons
            walnut.setEnabled(false);
            oak.setEnabled(true);
        } else if (e.getSource() == addToCartChair) {
            //setting value in Variable
            img = productImg;
            //creating new object; Chair
            Chair chair = new Chair(idNum, typeOfWood, quantity, img, armRest);
            //checking if the array has space
            if (calculations.hasSpace() == true) {
                    //if yes then adding it to array
                    calculations.addToCart(chair,quantity);
                    //setting Image
                    setImg();
            } else {
                    //if not then inform customer
                    JOptionPane.showMessageDialog(null, "Not allowed to add more than 9 Items. Remove some items to add more.");
                    }
            //after adding to the cart go back to default screen
            detailsPanel.removeAll();
            Frame2.repaint();
            //enabling all the buttons back 
            addDesk.setEnabled(true);
            addChair.setEnabled(true);
            addTable.setEnabled(true);
        } else if (e.getSource() == addToCartTable) {
            //setting values in Variables
            img = productImg;
            //creating new object; Table
            Table table = new Table(idNum, typeOfWood, quantity, img, diameter, base);
            //checking if the array has space
            if (calculations.hasSpace() == true) {
                    //if yes then adding it to array
                    calculations.addToCart(table,quantity);
                    //setting Image
                    setImg();
                } else {
                    //if not then inform customer
                    JOptionPane.showMessageDialog(null, "Not allowed to add more than 9 Items. Remove some items to add more.");
                }
            //after adding to the cart go back to defalut screen
            detailsPanel.removeAll();
            Frame2.repaint();
            //enabling all the buttons back
            addDesk.setEnabled(true);
            addChair.setEnabled(true);
            addTable.setEnabled(true);

        } else if (e.getSource() == addToCartDesk) {
            //setting values to Variable
            img = productImg;
            //creating new object; Desk
            Desk desk = new Desk(idNum, typeOfWood, quantity, img, width, depth, numOfDrawers);
            //checking if the array has space
            if (calculations.hasSpace() == true) {
                //if yes then adding it to array
                calculations.addToCart(desk, quantity);
                //setting Image
                setImg();
            } else {
                //if not then inform customer
                    JOptionPane.showMessageDialog(null, "Not allowed to add more than 9 Items. Remove some items to add more.");
            }
            //after adding to the cart go back to default screen
            detailsPanel.removeAll();
            Frame2.repaint();
            //enabling all the buttons back
            addDesk.setEnabled(true);
            addChair.setEnabled(true);
            addTable.setEnabled(true);
        }
        else if(e.getSource() == goToCart){
            //clearing all the half filled values
            clearAll.doClick();
            //closing current frame
            Frame2.dispose();
            //passing everything with values to last frame
            Frame3 frame3 = new Frame3();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        //if user wants to change the id number, dont have to delete everything again
        if (e.getSource() == idText) {
            idText.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == idText) {
            if((idText.getText().matches("\\d+"))){//checking if the text has any alphabets
                //temperoraly assigning the text to variable
                int IdNum = Integer.parseInt(idText.getText().trim());
                //check if number entered is not wrong
                if(IdNum == 101 || IdNum == 202 || IdNum == 303){
                    //if not then assing it to main variable
                    idNum = Integer.parseInt(idText.getText().trim());
                }else{
                    //if the id entered by user is not valid then propmt user
                    JOptionPane.showMessageDialog(null, "Enter vaild ID Number; \n Help: Chair - 101 \n Table - 202 \n Desk - 303");
                    idText.setText("");//set the textfeild to blank
                }
               }else{
                JOptionPane.showMessageDialog(null, "Enter vaild ID Number; \n Help: Chair - 101 \n Table - 202 \n Desk - 303");
                idText.setText("");
                }
            
        } else if (e.getSource() == quantityText) {
            if (calculations.valQuantity(Integer.parseInt(quantityText.getText().trim()))) {
                quantity = Integer.parseInt(quantityText.getText().trim());
            } else {
                quantityText.setText(Integer.toString(9));
                quantity = 9;
            }
        } else if (e.getSource() == diameterText) {
            if(diameterText.getText().matches("\\d+")){//checking if the text has any alphabets
                //if not then assing it to main variable
                diameter = Integer.parseInt(diameterText.getText().trim());
            }else{
                //if the diameter entered by user is not valid then propmt user
                JOptionPane.showMessageDialog(null, "Enter vaild Diameter; \n Help: Enter In Numbers");
                diameterText.setText("");
            }
            
        } else if (e.getSource() == widthText) {
            if(widthText.getText().matches("\\d+")){//checking if the text has any alphabets
                //if not then assing it to main variable
                width = Integer.parseInt(widthText.getText().trim());
            }else{
                //if the width entered by user is not valid then propmt user
                JOptionPane.showMessageDialog(null, "Enter vaild Width; \n Help: Enter In Numbers");
                widthText.setText("");
            }
        } else if (e.getSource() == depthText) {
            if(depthText.getText().matches("\\d+")){//checking if the text has any alphabets
                //if not then assing it to main variable
                 depth = Integer.parseInt(depthText.getText().trim());
            }else{
                //if the depth entered by user is not valid then propmt user
                JOptionPane.showMessageDialog(null, "Enter vaild Depth; \n Help: Enter In Numbers");
                depthText.setText("");
           
        }
    }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //set number of drawers
        switch (drawerSlider.getValue()) {
            case 1:
                numOfDrawers = 1;
                //setting Image
                oakOrWalnut();
                break;
            case 2:
                numOfDrawers = 2;
                //setting Image
                oakOrWalnut();
                break;
            case 3:
                numOfDrawers = 3;
                //setting Image
                oakOrWalnut();
                break;
            case 4:
                numOfDrawers = 4;
                //setting Image
                oakOrWalnut();
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //checking the item clicked
        if (e.getSource() == item1) {
            //check which button clicked
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(0, 1, item1);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(0, 2, item1);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(0, 3, item1);
            }

        } else if (e.getSource() == item2) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(1, 1, item2);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(1, 2, item2);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(1, 3, item2);
            }
        } else if (e.getSource() == item3) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(2, 1, item3);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(2, 2, item3);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(2, 3, item3);
            }
        } else if (e.getSource() == item4) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(3, 1, item4);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(3, 2, item4);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(3, 3, item4);
            }
        } else if (e.getSource() == item5) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(4, 1, item5);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(4, 2, item5);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(4, 3, item5);
            }
        } else if (e.getSource() == item6) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(5, 1, item6);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(5, 2, item6);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(5, 3, item6);
            }
        } else if (e.getSource() == item7) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(6, 1, item7);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(6, 2, item7);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(6, 3, item7);
            }
        } else if (e.getSource() == item8) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(7, 1, item8);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(7, 2, item8);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(7, 3, item8);
            }
        } else if (e.getSource() == item9) {
            if (e.getButton() == 1) {
                //pass variables to method accroding
                mouseClick(8, 1, item9);
            } else if (e.getButton() == 2) {
                //pass variables to method accroding
                mouseClick(8, 2, item9);
            } else if (e.getButton() == 3) {
                //pass variables to method accroding
                mouseClick(8, 3, item9);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //method to fit image in button size
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    //method to set oak and walnut 
    private void oakOrWalnut() {
        //check if type of wood is walnut
        if (typeOfWood == 'W') {
            //check type of furniture
            if (idNum == 101) {//if chair then
                if (armRest == true) {//check if arm rest or not
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WAR_W.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                } else {
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WOAR_W.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                }
            } else if (idNum == 202) {//if table
                if (base == 'C') {//check if base is chrome or not
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Table_C_W.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                } else {
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Table_W_W.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                }
            } else if (idNum == 303) { //if desk
                switch (numOfDrawers) {
                    case 1: {
                        //check if number of drawers
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_1_W.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 2: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_2_W.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 3: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_3_W.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 4: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_4_W.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                }
            }
        } else {//if oak
            //check type of furniture
            if (idNum == 101) {//if chair then
                if (armRest == true) {//check if arm rest or not
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WAR_O.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                } else {
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Chair_WOAR_O.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                }
            } else if (idNum == 202) {//if table
                if (base == 'C') {//check if base is chrome or not
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Table_C_O.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                } else {
                    productImg = new ImageIcon(this.getClass().getResource("furnitures/Table_W_O.png"));//getting image from the "src" folder and assiging it
                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    detailsPanel.add(imgViewer);
                }
            } else if (idNum == 303) { //if desk
                switch (numOfDrawers) {
                    case 1: {
                        //check if number of drawers
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_1_O.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 2: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_2_O.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 3: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_3_O.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                    case 4: {
                        productImg = new ImageIcon(this.getClass().getResource("furnitures/Desk_4_O.png"));//getting image from the "src" folder and assiging it
                        int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                        imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                        detailsPanel.add(imgViewer);
                        break;
                    }
                }
            }

        }

    }

    //method to set img in grid
    private void setImg() {
        
        int x = calculations.getArraySize();
        for (int i = 0; i <= x; i++) {
            if (i == 1) {
                int offset = item1.getInsets().left;//this is to leave no space between img and border
                item1.setIcon(resizeIcon(calculations.getArrayContent(0).img, item1.getWidth() - offset, item1.getHeight() - offset));
            } else if (i == 2) {
                int offset = item2.getInsets().left;//this is to leave no space between img and border
                item2.setIcon(resizeIcon(calculations.getArrayContent(1).img, item2.getWidth() - offset, item2.getHeight() - offset));
            } else if (i == 3) {
                int offset = item3.getInsets().left;//this is to leave no space between img and border
                item3.setIcon(resizeIcon(calculations.getArrayContent(2).img, item3.getWidth() - offset, item3.getHeight() - offset));
            } else if (i == 4) {
                int offset = item4.getInsets().left;//this is to leave no space between img and border
                item4.setIcon(resizeIcon(calculations.getArrayContent(3).img, item4.getWidth() - offset, item4.getHeight() - offset));
            } else if (i == 5) {
                int offset = item5.getInsets().left;//this is to leave no space between img and border
                item5.setIcon(resizeIcon(calculations.getArrayContent(4).img, item5.getWidth() - offset, item5.getHeight() - offset));
            } else if (i == 6) {
                int offset = item6.getInsets().left;//this is to leave no space between img and border
                item6.setIcon(resizeIcon(calculations.getArrayContent(5).img, item6.getWidth() - offset, item6.getHeight() - offset));
            } else if (i == 7) {
                int offset = item7.getInsets().left;//this is to leave no space between img and border
                item7.setIcon(resizeIcon(calculations.getArrayContent(6).img, item7.getWidth() - offset, item7.getHeight() - offset));
            } else if (i == 8) {
                int offset = item8.getInsets().left;//this is to leave no space between img and border
                item8.setIcon(resizeIcon(calculations.getArrayContent(7).img, item8.getWidth() - offset, item8.getHeight() - offset));
            } else if (i == 9) {
                int offset = item9.getInsets().left;//this is to leave no space between img and border
                item9.setIcon(resizeIcon(calculations.getArrayContent(8).img, item9.getWidth() - offset, item9.getHeight() - offset));
            }
        }

    }

    private void mouseClick(int x, int y, JLabel label) {
        int id;
        if (y == 1) {
            String sb = calculations.getArrayContent(x).toString();
            String[] parts = sb.split("\\,");
            String part1 = parts[0].replaceFirst("/", "");
            String part2 = parts[1].trim().replaceAll(" ", "");
            id = Integer.parseInt(part1.substring(9, 12));
            ImageIcon img = calculations.getArrayContent(x).img;
            if (id == 101) {
                String part3 = parts[2].trim().replaceAll(" ", "");
                String part4 = parts[3].trim().replaceAll(" ", "");

                JOptionPane.showMessageDialog(null,
                        part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n",
                        "Detials",
                        JOptionPane.OK_OPTION,
                        img);

            } else if (id == 202) {
                String part3 = parts[2].trim().replaceAll(" ", "");
                String part4 = parts[3].trim().replaceAll(" ", "");
                String part5 = parts[4].trim().replaceAll(" ", "");

                JOptionPane.showMessageDialog(null,
                        part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n" + part5 + "\n",
                        "Detials",
                        JOptionPane.OK_OPTION,
                        img);
            } else if (id == 303) {
                String part3 = parts[2].trim().replaceAll(" ", "");
                String part4 = parts[3].trim().replaceAll(" ", "");
                String part5 = parts[4].trim().replaceAll(" ", "");
                String part6 = parts[5].trim().replaceAll(" ", "");

                JOptionPane.showMessageDialog(null,
                        part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n" + part5 + "\n" + part6 + "\n",
                        "Detials",
                        JOptionPane.OK_OPTION,
                        img);

            }

        } else if (y == 2) {
            Object[] options = {"Yes, please", "No way!"};
            int answer = JOptionPane.showOptionDialog(null,
                    "Would you like to remove this item?",
                    "Remove Item",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (answer == 0) {
                if (calculations.removeFurniture(x) == true) {
                    JOptionPane.showMessageDialog(null, "Item as been removed from your cart.");
                    ImageIcon waiting = new ImageIcon(this.getClass().getResource("furnitures/waiting.png"));
                    label.setIcon(waiting);
                    int offset = label.getInsets().left;//this is to leave no space between img and border
                    label.setIcon(resizeIcon(waiting, label.getWidth() - offset, label.getHeight() - offset));
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Item can't be removed.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
              }
            

        } else if (y == 3) {
            Object[] options = {"Yes, I want something better", "No, this is good to go!"};
            int answer = JOptionPane.showOptionDialog(null,
                    "Would you like to edit this item?",
                    "Remove Item",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (answer == 0) {
                id = calculations.getArrayContent(x).idNum;
                if (id == 101) {
                    Chair xyz = (Chair) calculations.getArrayContent(x);
                    String[] temp = xyz.getValues();
                    Frame2AddChair();
                    idText.setText(temp[0]);
                    if (temp[1].equals("O")) {
                        oak.doClick();
                    } else {
                        walnut.doClick();
                    }
                    minus.setEnabled(false);
                    plus.setEnabled(false);
                    quantityText.setText("1");
                    quantityText.setEnabled(false);

                    if (temp[3].equals("true")) {
                        withArmRest.doClick();
                    } else {
                        withoutArmRest.doClick();
                    }
                    productImg = calculations.getArrayContent(x).img;

                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));

                    calculations.removeFurniture(x);

                } else if (id == 202) {
                    Table xyz = (Table) calculations.getArrayContent(x);
                    String[] temp = xyz.getValues();
                    System.out.println(Arrays.toString(temp));
                    Frame2AddTable();
                    idText.setText(temp[0]);
                    if (temp[1].equals("O")) {
                        oak.doClick();
                    } else {
                        walnut.doClick();
                    }

                    minus.setEnabled(false);
                    plus.setEnabled(false);
                    quantityText.setText("1");
                    quantityText.setEnabled(false);
                    diameterText.setText(temp[3]);
                    if (temp[4].equals("C")) {
                        chrome.doClick();
                    } else {
                        wodden.doClick();
                    }
                    productImg = calculations.getArrayContent(x).img;

                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    calculations.removeFurniture(x);

                } else if (id == 303) {
                    Desk xyz = (Desk) calculations.getArrayContent(x);
                    String[] temp = xyz.getValues();
                    System.out.println(Arrays.toString(temp));
                    Frame2AddDesk();
                    idText.setText(temp[0]);
                    if (temp[1].equals("O")) {
                        oak.doClick();
                    } else {
                        walnut.doClick();
                    }

                    minus.setEnabled(false);
                    plus.setEnabled(false);
                    quantityText.setText("1");
                    quantityText.setEnabled(false);
                    widthText.setText(temp[3]);
                    depthText.setText(temp[4]);
                    switch (temp[5]) {
                        case "1":
                            drawerSlider.setValue(1);
                            break;
                        case "2":
                            drawerSlider.setValue(2);
                            break;
                        case "3":
                            drawerSlider.setValue(3);
                            break;
                        case "4":
                            drawerSlider.setValue(4);
                            break;
                        default:
                            break;
                    }
                    productImg = calculations.getArrayContent(x).img;

                    int offset = imgViewer.getInsets().left;//this is to leave no space between img and border
                    imgViewer.setIcon(resizeIcon(productImg, imgViewer.getWidth() - offset, imgViewer.getHeight() - offset));
                    calculations.removeFurniture(x);

                }
            }
        }

    }
    
    
    
}
