package chat.application;

import java.awt.*;
import javax.swing.*;


public class Server extends JFrame {

    private static final Color MAIN_BACKGROUND_COLOR = new Color(84, 84, 84);
    private static final Color HEADER_BACKGROUND_COLOR = new Color(50, 50, 50);
    private static final Color FOOTER_BACKGROUND_COLOR = new Color(50, 50, 50);

    Server() {
        setLayout(null); // layout for the frame

        setIconImage(new ImageIcon("src\\assets\\icons\\icon_header.png").getImage());

        ImageIcon sendImageIcon = new ImageIcon("src\\assets\\icons\\send_image.png");
        Image resizedImage = sendImageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);


        // Create heading label
        JLabel headingLabel = new JLabel("Chat Away", JLabel.CENTER);
        headingLabel.setForeground(Color.WHITE);

        // Create send button icon label
        JLabel sendLabel = new JLabel(resizedIcon);


        JPanel p1 = createPanel(HEADER_BACKGROUND_COLOR, 0, 0, 600, 25);
        JPanel p2 = createPanel(FOOTER_BACKGROUND_COLOR, 0, 420, 600, 40);

        JTextField text = new JTextField();
        text.setBounds(20, 430, 560, 20);



        p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));
        p2.add(sendLabel);

        // Add heading label to p1
        p1.add(headingLabel);

        // Add panels to frame
        add(p1);
        add(p2);
        p2.add(text);

        // Frame properties
        setSize(600, 500);
        setLocation(200, 50);
        setTitle("Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(MAIN_BACKGROUND_COLOR);

        setVisible(true);
    }

    private JPanel createPanel(Color color, int x_cor, int y_cor, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x_cor, y_cor, width, height);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    public static void main(String[] args){
        new Server();
    }

}
