package chat.application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Server extends JFrame implements ActionListener{

    private static final Color MAIN_BACKGROUND_COLOR = new Color(84, 84, 84);
    private static final Color HEADER_BACKGROUND_COLOR = new Color(50, 50, 50);
    private static final Color CHAT_BOX_COLOR = new Color(255,253,	208);
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
        p3 = createPanel(MAIN_BACKGROUND_COLOR, 0, 30, 583, 395);

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

        JPanel local_panel = formatLabel(output);

        p3.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(local_panel, BorderLayout.LINE_END);
        right.setOpaque(false);


        vertical.add(right);
        vertical.add(Box.createVerticalStrut(20));
        vertical.setOpaque(false);

        p3.add(vertical, BorderLayout.PAGE_START);



        text.setText("");
        repaint();
        invalidate();
        validate();

    }

    public static JPanel formatLabel(String out){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        Border chat_box_border = new EmptyBorder(10,10,10,10);   
        
        JLabel output = new JLabel(out);
        output.setFont(new Font("Tahoma", Font.PLAIN, 12));
        output.setBackground(CHAT_BOX_COLOR);  
        output.setForeground(Color.black);
        output.setOpaque(true);
        output.setBorder(chat_box_border);  
        String labelText = String.format("<html><div WIDTH=%d>%s</div></html>", 400, out);
        output.setText(labelText);
        

        FontMetrics metrics = output.getFontMetrics(output.getFont());
        int textWidth = metrics.stringWidth(out);
        int height_req_factor = (textWidth/400)+1;

        
        System.out.println(textWidth);

        p.add(output);
        p.setBackground(MAIN_BACKGROUND_COLOR);

        return p;
    }

    public static void main(String[] args) {
        new Server();
    }
}
