import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class buttonmenu
{
    private JButton btnOverview = new JButton("Overview");   
    private JButton btnHistory = new JButton("History");     
    private JButton btnSummaries = new JButton("Summaries");   

    public buttonmenu() 
    {
        Font fontbtn = new Font("FC Galaxy",Font.BOLD,30);
        btnOverview.setFont(fontbtn);
        btnHistory.setFont(fontbtn);
        btnSummaries.setFont(fontbtn);
    }


    public JButton getOverview(JPanel page1,JPanel page2,JPanel page3)
    {
        btnOverview.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                page1.setVisible(true);
                page2.setVisible(false);
                page3.setVisible(false);
            }
        });
        return btnOverview;
    }



    public JButton getHistory(JPanel page1,JPanel page2,JPanel page3)
    {
        btnHistory.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                page1.setVisible(false);
                page2.setVisible(true);
                page3.setVisible(false);
            }
        });
        return btnHistory;
    }


    public JButton getSummaries(JPanel page1,JPanel page2,JPanel page3)
    {
        btnSummaries.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                page1.setVisible(false);
                page2.setVisible(false);
                page3.setVisible(true);
            }
        });
        return  btnSummaries;
    }
}