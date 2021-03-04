
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
public class Frame1 extends JPanel implements ActionListener {

    //Buttons
    private final JButton newFile, load;
    //ImageIcons
    private final ImageIcon newFileImg, loadImg;
    JFrame mainFrame = new JFrame("ROFC Application");

    Frame1() throws IOException {
        //new file button
        newFileImg = new ImageIcon(this.getClass().getResource("Frame 1/Button.NewCart.png"));//getting image from the "src" folder and assiging it
        newFile = new JButton();
        newFile.setBounds(75, 65, 200, 70);
        newFile.setBorderPainted(false);//removing the default boders
        //to set the fit the image in the size of button
        int offset = newFile.getInsets().left;//this is to leave no space between img and border
        newFile.setIcon(resizeIcon(newFileImg, newFile.getWidth() - offset, newFile.getHeight() - offset));
        mainFrame.add(newFile);
        newFile.addActionListener(this);

        //load button
        loadImg = new ImageIcon(this.getClass().getResource("Frame 1/Button.Load.png"));//getting image from the "src" folder and assiging it
        load = new JButton();
        load.setBounds(75, 135, 200, 70);//removing the default boders//x,y,w,h
        load.setBorderPainted(false);
        //to set the fit the image in the size of button
        offset = load.getInsets().left;
        load.setIcon(resizeIcon(loadImg, load.getWidth() - offset, load.getHeight() - offset));
        mainFrame.add(load);
        load.addActionListener(this);

        mainFrame.getContentPane().setBackground(Color.decode("#c1c5c9"));
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(350, 300);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

    //Method to resize the immage according to the size of Button
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            //closes this frame
            mainFrame.dispose();
            //keeping the array clear 
            for(int i =0; i< calculations.getArraySize();i++){
                calculations.removeFurniture(i);
            }
            //opens new frame2
            Frame2 newFrame = new Frame2();
        } else if (e.getSource() == load) {
            //asking to enter file name
            String fileName = JOptionPane.showInputDialog(null, "Enter your FileName:");
            //checking if name entered has extension
            if (!fileName.endsWith(".dat")) {
                fileName = fileName + ".dat";//if not then adding the extension
            }
            FileReader f;
            BufferedReader br;
            int i = 0;//pointer
            String x = "";//temp String
            String[] values = new String[9];//array to store back the data of file

            try {
                f = new FileReader(fileName);
                br = new BufferedReader(f);
                //until the file has lines, this loop will run
                while ((x = br.readLine()) != null) {
                    if (x.contains("?")) {//if line contains "?" then, i++; add to next node of array now.
                        i++;
                    } else {//else keep adding to current node of array
                        values[i] += x + "\n";
                    }
                }
                br.close();
                mainFrame.dispose();//close this frame, open all data in new frame
                Frame3 loadFile = new Frame3(values, i);
            } catch (IOException et) {
                JOptionPane.showMessageDialog(null, "ERROR :Your File Cannot Be Found, Try Again" + "Furniture System " + JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
