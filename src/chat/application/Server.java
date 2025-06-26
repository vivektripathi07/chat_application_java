package chat.application;

import java.awt.*;
import javax.swing.*;

public class Server extends JFrame {

    Server() {
        setLayout(new BorderLayout());

        ImageIcon icon_image = new ImageIcon("src\\assets\\icons\\icon_header.png");
        setIconImage(icon_image.getImage());
        ImageIcon send_image = new ImageIcon("src\\assets\\icons\\send_image.png");

        Image img = send_image.getImage();
        Image resizedImage = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);


        JLabel heading_label = new JLabel();
        heading_label.setText("Chat Away");
        heading_label.setForeground(Color.WHITE);
        heading_label.setHorizontalAlignment(JLabel.CENTER);

        JLabel send_label = new JLabel(resizedIcon);
        send_label.setBounds(540, 8, 40, 35); 


        JPanel p1 = new JPanel();
        p1.setBackground(new Color(50, 50, 50));
        p1.setPreferredSize(new Dimension(getWidth(), 30)); 
        add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(60, 60, 60));
        p2.setPreferredSize(new Dimension(getWidth(), 50)); 
        p2.add(send_label);
        p2.setLayout(null);
        add(p2, BorderLayout.SOUTH);





        p1.add(heading_label);

        setSize(600, 500);
        setLocation(200, 50);
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        getContentPane().setBackground(new Color(84, 84, 84));

        setVisible(true);
    }

    public static void main(String[] args){
        new Server();
    }

}
