package chat.application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Server extends JFrame implements ActionListener{

    private static final Color MAIN_BACKGROUND_COLOR = new Color(84, 84, 84);
    private static final Color HEADER_BACKGROUND_COLOR = new Color(50, 50, 50);
    private static final Color HERO_BACKGROUND_COLOR = new Color(120, 120, 120, 120);
    private static final Color FOOTER_BACKGROUND_COLOR = new Color(50, 50, 50);

    JTextField text;
    JPanel p3;
    Box vertical = Box.createVerticalBox();

    Server() {
        setLayout(null); // layout for the frame

        setIconImage(new ImageIcon("src\\assets\\icons\\icon_header.png").getImage());
        ImageIcon backgroundIcon = new ImageIcon("src\\assets\\icons\\bg_main.jpeg");

        // Create heading label
        JLabel headingLabel = new JLabel("Chat Away", JLabel.CENTER);
        headingLabel.setForeground(Color.WHITE);

        JLabel main_background = new JLabel(backgroundIcon);
        main_background.setBounds(0, 25, 600, 395);


        // Create and position panels
        JPanel p1 = createPanel(HEADER_BACKGROUND_COLOR, 0, 0, 600, 25);
        JPanel p2 = createPanel(FOOTER_BACKGROUND_COLOR, 0, 420, 600, 40);
        p3 = createPanel(HERO_BACKGROUND_COLOR, 0, 25, 590, 395);

        // Positioning text field correctly
        text = new JTextField();
        text.setBounds(40, 427, 460, 30);

        JButton sendButton = new JButton("GO");
        sendButton.setBounds(510, 427, 60, 30);
        sendButton.addActionListener(this);

        p1.add(headingLabel);
        p2.setBounds(0,420, 600, 70);
        p3.setOpaque(false);

        add(p1);

        add(p3);
        add(text);
        add(sendButton);
        add(p2);

        

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

    public void actionPerformed(ActionEvent e) {
        String output = text.getText();

        JLabel output_label = new JLabel(output);
        Font chat_font = new Font("Arial",Font.PLAIN, 16);
        output_label.setFont(chat_font);
        output_label.setForeground(Color.white);

        JPanel local_panel = new JPanel();
        local_panel.add(output_label);
        local_panel.setBackground(MAIN_BACKGROUND_COLOR);
        
        p3.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(local_panel, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(20));

        p3.add(vertical, BorderLayout.PAGE_START);


        repaint();
        invalidate();
        validate();

    }

    public static void main(String[] args) {
        new Server();
    }
}
