import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class StartPage extends JFrame
{
    private File iconImage = new File("image\\LOGO.png");
    private ImageIcon icon; 
    private Color color =  new Color(30,158,159); 

    public StartPage()
    {
        icon = (new ImageIcon(((new ImageIcon(iconImage.getAbsolutePath())).getImage()).getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH)));

        JPanel panel1 = new JPanel(); //panelsหลัก
        
        JLabel ImageLabel = new JLabel(icon); //icon
        JPanel panelForHoldIcon = new JPanel(); //รองรับpanel icon
        
        JPanel panelforlabel1= new JPanel(); // รองรับlabel
        JPanel panelforbutton1= new JPanel(); //รองรับbutton
        
        panel1.setBackground(color); 
        panelForHoldIcon.setBackground(color);
        panelforlabel1.setBackground(color);
        panelforbutton1.setBackground(color);

        Font fonthead = new Font("FC Galaxy",Font.BOLD,100);
        Font fontbtn = new Font("FC Galaxy",Font.BOLD,50);
        
        JLabel label1 = new JLabel("LEDGER!!"); 
        label1.setFont(fonthead);
        label1.setForeground(Color.WHITE);
        
        JButton button = new JButton("Let's Start");
        button.setFont(fontbtn);
        
        panelForHoldIcon.add(ImageLabel);
        panelforlabel1.add(label1);
        panelforbutton1.add(button);
        
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS)); //ใช้แบบboxlayout จัดเป็นแกนY
        panel1.add(Box.createRigidArea(new Dimension(0,30)));
        panel1.add(panelforlabel1);
        panel1.add(panelForHoldIcon);
        panel1.add(Box.createRigidArea(new Dimension(0,20)));
        panel1.add(panelforbutton1);
        
        button.addActionListener(new ActionListener()  //
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Page nextPage= new Page();
                nextPage.setVisible(true);
                panel1.setVisible(false);
                dispose();
            }
        });

        add(panel1);
        setTitle("Project Ledger");
        setSize(500, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
