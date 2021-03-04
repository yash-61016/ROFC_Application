
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yashpatel
 */
public class Frame3 implements ActionListener {

    JFrame totalBill = new JFrame();
    JLabel title = new JLabel();
    JLabel items = new JLabel();
    JLabel item1, item2, item3, item4, item5, item6, item7, item8, item9;
    JButton details1, details2, details3, details4, details5, details6, details7, details8, details9, save, close;
    ImageIcon saveBt, closeBt;

    Frame3() {
        //setting title
        title.setText("CART");
        title.setBounds(215, 0, 200, 100);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        totalBill.add(title);
        //setting buttons
        saveBt = new ImageIcon(this.getClass().getResource("Frame 3/Button.Save.png"));//getting image from the "src" folder and assiging it
        save = new JButton();
        save.setBounds(50, 430, 190, 70);
        save.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = save.getInsets().left;//this is to leave no space between img and border
        save.setIcon(resizeIcon(saveBt, save.getWidth() - offset, save.getHeight() - offset));
        save.addActionListener(this);
        totalBill.add(save);

        closeBt = new ImageIcon(this.getClass().getResource("Frame 3/Button.Close.png"));//getting image from the "src" folder and assiging it
        close = new JButton();
        close.setBounds(300, 430, 190, 70);
        close.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        offset = close.getInsets().left;//this is to leave no space between img and border
        close.setIcon(resizeIcon(closeBt, close.getWidth() - offset, close.getHeight() - offset));
        close.addActionListener(this);
        totalBill.add(close);
        //getting array size
        int x = calculations.getArraySize();
        for (int i = 0; i <= x - 1; i++) {
            int id = calculations.getArrayContent(i).idNum;
            //adding items in order
            if (i == 0) {
                item1 = new JLabel();
                item1.setBounds(0, 0, 500, 30);
                item1.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item1);
                details1 = new JButton("Details");
                details1.setBounds(440, 5, 60, 20);
                item1.add(details1);
                details1.addActionListener(this);
                items.add(item1);
            } else if (i == 1) {
                item2 = new JLabel();
                item2.setBounds(0, 30, 500, 30);
                item2.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item2);
                details2 = new JButton("Details");
                details2.setBounds(440, 5, 60, 20);
                item2.add(details2);
                details2.addActionListener(this);
                items.add(item2);
            } else if (i == 2) {
                item3 = new JLabel();
                item3.setBounds(0, 60, 500, 30);
                item3.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item3);
                details3 = new JButton("Details");
                details3.setBounds(440, 5, 60, 20);
                item3.add(details3);
                details3.addActionListener(this);
                items.add(item3);
            } else if (i == 3) {
                item4 = new JLabel();
                item4.setBounds(0, 90, 500, 30);
                item4.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item4);
                details4 = new JButton("Details");
                details4.setBounds(440, 5, 60, 20);
                item4.add(details4);
                details4.addActionListener(this);
                items.add(item4);
            } else if (i == 4) {
                item5 = new JLabel();
                item5.setBounds(0, 120, 500, 30);
                item5.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item5);
                details5 = new JButton("Details");
                details5.setBounds(440, 5, 60, 20);
                item5.add(details5);
                details5.addActionListener(this);
                items.add(item5);
            } else if (i == 5) {
                item6 = new JLabel();
                item6.setBounds(0, 150, 500, 30);
                item6.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item6);
                details6 = new JButton("Details");
                details6.setBounds(440, 5, 60, 20);
                item6.add(details6);
                details6.addActionListener(this);
                items.add(item6);
            } else if (i == 6) {
                item7 = new JLabel();
                item7.setBounds(0, 180, 500, 30);
                item7.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item7);
                details7 = new JButton("Details");
                details7.setBounds(440, 5, 60, 20);
                item7.add(details7);
                details7.addActionListener(this);
                items.add(item7);
            } else if (i == 7) {
                item8 = new JLabel();
                item8.setBounds(0, 210, 500, 30);
                item8.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item8);
                details8 = new JButton("Details");
                details8.setBounds(440, 5, 60, 20);
                item8.add(details8);
                details8.addActionListener(this);
                items.add(item8);
            } else if (i == 8) {
                item9 = new JLabel();
                item9.setBounds(0, 240, 500, 30);
                item9.setFont(new Font("Serif", Font.PLAIN, 20));
                showItem(i, id, item9);
                details9 = new JButton("Details");
                details9.setBounds(440, 5, 60, 20);
                item9.add(details9);
                details9.addActionListener(this);
                items.add(item9);
            }
        }

        items.setBackground(Color.decode("#c1c5c9"));
        items.setBounds(25, 100, 500, 300);
        items.setOpaque(true);
        totalBill.add(items);

        totalBill.getContentPane().setBackground(Color.decode("#c1c5c9"));
        totalBill.setLayout(null);
        totalBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        totalBill.setSize(550, 600);
        totalBill.setVisible(true);
        totalBill.setResizable(false);
    }

    Frame3(String[] cart, int x) {
        title.setText("CART");
        title.setBounds(215, 0, 200, 100);
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        totalBill.add(title);

        closeBt = new ImageIcon(this.getClass().getResource("Frame 3/Button.Close.png"));//getting image from the "src" folder and assiging it
        close = new JButton();
        close.setBounds(170, 430, 190, 70);
        close.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = close.getInsets().left;//this is to leave no space between img and border
        close.setIcon(resizeIcon(closeBt, close.getWidth() - offset, close.getHeight() - offset));
        close.addActionListener(this);
        totalBill.add(close);

        for (int i = 0; i <= x - 1; i++) {

            if (i == 0) {
                item1 = new JLabel();
                item1.setBounds(70, 0, 500, 30);
                item1.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 0, item1);
                items.add(item1);
            } else if (i == 1) {
                item2 = new JLabel();
                item2.setBounds(70, 30, 500, 30);
                item2.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 1, item2);
                items.add(item2);
            } else if (i == 2) {
                item3 = new JLabel();
                item3.setBounds(70, 60, 500, 30);
                item3.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 2, item3);
                items.add(item3);
            } else if (i == 3) {
                item4 = new JLabel();
                item4.setBounds(70, 90, 500, 30);
                item4.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 3, item4);
                items.add(item4);
            } else if (i == 4) {
                item5 = new JLabel();
                item5.setBounds(70, 120, 500, 30);
                item5.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 4, item5);
                items.add(item5);
            } else if (i == 5) {
                item6 = new JLabel();
                item6.setBounds(70, 150, 500, 30);
                item6.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 5, item6);
                items.add(item6);
            } else if (i == 6) {
                item7 = new JLabel();
                item7.setBounds(70, 180, 500, 30);
                item7.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 6, item7);
                items.add(item7);
            } else if (i == 7) {
                item8 = new JLabel();
                item8.setBounds(70, 210, 500, 30);
                item8.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 7, item8);
                items.add(item8);
            } else if (i == 8) {
                item9 = new JLabel();
                item9.setBounds(70, 240, 500, 30);
                item9.setFont(new Font("Serif", Font.PLAIN, 20));
                loadItem(cart, 8, item9);
                items.add(item9);
            }
        }

        items.setBackground(Color.decode("#c1c5c9"));
        items.setBounds(25, 100, 500, 300);
        items.setOpaque(true);
        totalBill.add(items);

        totalBill.getContentPane().setBackground(Color.decode("#c1c5c9"));
        totalBill.setLayout(null);
        totalBill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        totalBill.setSize(550, 600);
        totalBill.setVisible(true);
        totalBill.setResizable(false);
    }

    private void showItem(int item, int id, JLabel label) {

        if (id == 101) {
            Chair temp = (Chair) calculations.getArrayContent(item);
            String[] values = temp.getValues();
            String typeOfWood = (values[1].equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = values[3];
            label.setText("Chair                  " + typeOfWood + price);
        } else if (id == 202) {
            Table temp = (Table) calculations.getArrayContent(item);
            String[] values = temp.getValues();
            String typeOfWood = (values[1].equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = values[4];
            label.setText("Table                  " + typeOfWood + price);
        } else if (id == 303) {
            Desk temp = (Desk) calculations.getArrayContent(item);
            String[] values = temp.getValues();
            String typeOfWood = (values[1].equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = values[5];
            label.setText("Desk                   " + typeOfWood + price);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == details1) {
            viewDetails(0);
        } else if (e.getSource() == details2) {
            viewDetails(1);
        } else if (e.getSource() == details3) {
            viewDetails(2);
        } else if (e.getSource() == details4) {
            viewDetails(3);
        } else if (e.getSource() == details5) {
            viewDetails(4);
        } else if (e.getSource() == details6) {
            viewDetails(5);
        } else if (e.getSource() == details7) {
            viewDetails(6);
        } else if (e.getSource() == details8) {
            viewDetails(7);
        } else if (e.getSource() == details9) {
            viewDetails(8);
        } else if (e.getSource() == save) {

            String fileName = JOptionPane.showInputDialog("Enter the File name:");
            if (!fileName.endsWith(".dat")) {
                fileName = fileName + ".dat";
            }
            try {
                PrintWriter file = new PrintWriter(fileName);
                for (int i = 0; i < calculations.getArraySize(); i++) {
                    file.println(calculations.getArrayContent(i));
                }
                JOptionPane.showMessageDialog(null, "Your File Is Saved By Name " + fileName, " Furniture System ", JOptionPane.CLOSED_OPTION);
                try {
                    Frame1 frame1 = new Frame1();
                    totalBill.dispose();
                } catch (IOException ex1) {
                    Logger.getLogger(Frame3.class.getName()).log(Level.SEVERE, null, ex1);
                }
                file.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERROR :Your File Cannot Be Saved, Try Again" + "Furniture System " + JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == close) {
            System.exit(0);
        }
    }

    private void viewDetails(int x) {
        int id;
        String sb = calculations.getArrayContent(x).toString();
        String[] parts = sb.split("\\,");
        String part1 = parts[0];
        String part2 = parts[1].trim().replaceAll(" ", "");
        id = Integer.parseInt(part1.substring(10, 13));
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
    }

    //method to fit image in button size
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void loadItem(String[] cart, int x, JLabel label) {
        System.out.println(x);
        String sb = cart[x];
        String[] parts = sb.split("\\,");
        String part1 = parts[0];
        String part2 = parts[1].trim().replaceAll(" ", "").replaceFirst("TypeOfWood:", "");
        int id = Integer.parseInt(part1.substring(14, 17));

        if (id == 101) {
            String part3 = parts[2].trim().replaceAll(" ", "");
            String part4 = parts[3].trim().replaceAll(" ", "").replaceFirst("Price:", "");

            String typeOfWood = (part2.equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = part4;
            label.setText("Chair                  " + typeOfWood + price);

        } else if (id == 202) {
            String part3 = parts[2].trim().replaceAll(" ", "");
            String part4 = parts[3].trim().replaceAll(" ", "");
            String part5 = parts[4].trim().replaceAll(" ", "").replaceFirst("Price:", "");

            String typeOfWood = (part2.equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = part5;
            label.setText("Table                  " + typeOfWood + price);

        } else if (id == 303) {
            String part3 = parts[2].trim().replaceAll(" ", "");
            String part4 = parts[3].trim().replaceAll(" ", "");
            String part5 = parts[4].trim().replaceAll(" ", "");
            String part6 = parts[5].trim().replaceAll(" ", "").replaceFirst("Price:", "");

            String typeOfWood = (part2.equals("O")) ? ("Oak                    ") : ("Walnut               ");
            String price = part6;
            label.setText("Desk                   " + typeOfWood + price);

        }
    }
}
