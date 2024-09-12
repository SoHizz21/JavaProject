import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Page extends JFrame
{  
    private Color color =  new Color(30,158,159); 
    private Font font1 = new Font("FC Galaxy",Font.BOLD,60);

    private JLabel total1 = new JLabel();
    private JLabel income1 = new JLabel() ;
    private JLabel expenses1  = new JLabel();

    private JLabel income2 = new JLabel(); 
    private JLabel expenses2 = new JLabel();
    
    private JLabel income3 = new JLabel(); 
    private JLabel expenses3 = new JLabel(); 
    private JLabel revenue1 = new JLabel("0.0");

    public Page() 
    {
        try 
        {
            File file = new File("Data.txt");
            Scanner scanner = new Scanner(file);
            total1.setText(scanner.nextLine());
            income1.setText(scanner.nextLine());
            expenses1.setText(scanner.nextLine());
            income2.setText(scanner.nextLine());
            expenses2.setText(scanner.nextLine());
            income3.setText(scanner.nextLine());
            expenses3.setText(scanner.nextLine());
            revenue1.setText(scanner.nextLine());
            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        FrameStarter();
        createPage();
    }

    private void FrameStarter()
    {
        setTitle("Ledger");
        Container c = getContentPane();
        setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        setSize(500, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createPage()
    {
        
        JPanel panelOverview = new JPanel();    
        JPanel panelHistory = new JPanel();    
        JPanel panelSummaries = new JPanel();   
        
        panelOverview .setBackground(color);
        panelHistory.setBackground(color);
        panelSummaries.setBackground(color);
        
     
        JPanel panelforbtnmenuOverview = new JPanel();
        JPanel panelforLabelOverview = new JPanel();
        JLabel labelOverview = new JLabel("Overview!");
        labelOverview.setFont(font1);
        labelOverview.setForeground(Color.WHITE);
        panelforLabelOverview.setBackground(color);
        
        panelforLabelOverview.add(labelOverview);
        

        buttonmenu btnmenu = new buttonmenu();
        panelforbtnmenuOverview.setBackground(color);
        panelforbtnmenuOverview.setLayout(new BoxLayout(panelforbtnmenuOverview,BoxLayout.X_AXIS));
        panelforbtnmenuOverview.add(btnmenu.getOverview(panelOverview,panelHistory,panelSummaries));
        panelforbtnmenuOverview.add(Box.createRigidArea(new Dimension(40,0)));
        panelforbtnmenuOverview.add(btnmenu.getHistory(panelOverview,panelHistory,panelSummaries));
        panelforbtnmenuOverview.add(Box.createRigidArea(new Dimension(40,0)));
        panelforbtnmenuOverview.add(btnmenu.getSummaries(panelOverview,panelHistory,panelSummaries));
        

        panelOverview.add(Box.createRigidArea(new Dimension(0,100)));
        panelOverview.add(panelforLabelOverview);
        panelOverview.add(Box.createRigidArea(new Dimension(0,20)));
        panelOverview.add(OverviewUpdate());
        panelOverview.add(Box.createRigidArea(new Dimension(0,180)));
        panelOverview.add(panelforbtnmenuOverview);
        panelOverview.add(Box.createRigidArea(new Dimension(0,25)));
        add(panelOverview);
        
        

            addTx process = new addTx();
            
            JPanel panelforbtnmenuHistory = new JPanel();
            JPanel panelforLabelHistory = new JPanel();
            JPanel panelforAdd = new JPanel();
            JPanel panelforListHistory = new JPanel();
            JPanel panelforbtn = new JPanel();
            
            JTextArea textArea = new JTextArea();
            textArea.setEditable( false );    

                    File file = new File("History.txt"); 
                    try 
                    {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) 
                        {
                            textArea.setFont(new Font("FC Galaxy",Font.BOLD,20));
                            textArea.setForeground(new Color(41, 128, 185 ));
                            textArea.append(line+"\n");
                        }
                        bufferedReader.close();
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }

            JLabel labelHistory = new JLabel("History!");
            labelHistory.setForeground(Color.WHITE);
            labelHistory.setFont(font1);
            
            panelforLabelHistory.setBackground(color);
            panelforListHistory.setBackground(color);
            panelforbtn.setBackground(color); 
            panelforbtnmenuHistory.setBackground(color);
            
            JScrollPane scrollFrameOpen = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollFrameOpen.setPreferredSize(new Dimension(400,360));
            
            panelforLabelHistory.add(labelHistory);
            panelforListHistory.add(scrollFrameOpen);
            panelforbtn.add(panelforAdd);


            buttonmenu btnmenuhis = new buttonmenu();
            panelforbtnmenuHistory.setLayout(new BoxLayout(panelforbtnmenuHistory,BoxLayout.X_AXIS));
            panelforbtnmenuHistory.add(btnmenuhis.getOverview(panelOverview,panelHistory,panelSummaries));
            panelforbtnmenuHistory.add(Box.createRigidArea(new Dimension(40,0)));
            panelforbtnmenuHistory.add(btnmenuhis.getHistory(panelOverview,panelHistory,panelSummaries));
            panelforbtnmenuHistory.add(Box.createRigidArea(new Dimension(40,0)));
            panelforbtnmenuHistory.add(btnmenuhis.getSummaries(panelOverview,panelHistory,panelSummaries));
            
  
            panelforbtn.setLayout(new BoxLayout(panelforbtn,BoxLayout.Y_AXIS));
            panelforbtn.add(Box.createRigidArea(new Dimension(0,20)));
            panelforbtn.add(panelforbtnmenuHistory);
            panelforAdd.setLayout(new BoxLayout(panelforAdd,BoxLayout.X_AXIS));
            panelforAdd.add(process.btnAdd(textArea,total1, income2 , income3,income1, expenses2 , expenses3,expenses1,revenue1));
            
    
            panelHistory.setLayout(new BoxLayout(panelHistory,BoxLayout.Y_AXIS));
            panelHistory.add(Box.createRigidArea(new Dimension(0,20)));
            panelHistory.add(panelforLabelHistory);
            panelHistory.add(Box.createRigidArea(new Dimension(0,20)));
            panelHistory.add(panelforListHistory);
            panelHistory.add(Box.createRigidArea(new Dimension( 0,50)));
            panelHistory.add(panelforbtn);
            panelHistory.add(Box.createRigidArea(new Dimension( 0,25)));
            add(panelHistory);
            panelHistory.setVisible(false);



        JPanel panelforbtnmenuSummaries = new JPanel();
        JPanel panelforLabelSummaries = new JPanel();
        Dimension maxLabelSize = new Dimension(500, 50); 
        
        JLabel labelSummaries = new JLabel("Summaries!");
        labelSummaries.setForeground(Color.WHITE);
        labelSummaries.setFont(font1);
        
        panelforLabelSummaries.setBackground(color);
        panelforLabelSummaries.add(labelSummaries);
        panelforLabelSummaries.setMaximumSize(maxLabelSize);
    
    
        buttonmenu btnmenusum = new buttonmenu();
        panelforbtnmenuSummaries.setBackground(color);
        panelforbtnmenuSummaries.setLayout(new BoxLayout(panelforbtnmenuSummaries,BoxLayout.X_AXIS));
        panelforbtnmenuSummaries.add(btnmenusum.getOverview(panelOverview,panelHistory,panelSummaries));
        panelforbtnmenuSummaries.add(Box.createRigidArea(new Dimension(40,0)));
        panelforbtnmenuSummaries.add(btnmenusum.getHistory(panelOverview,panelHistory,panelSummaries));
        panelforbtnmenuSummaries.add(Box.createRigidArea(new Dimension(40,0)));
        panelforbtnmenuSummaries.add(btnmenusum.getSummaries(panelOverview,panelHistory,panelSummaries));

    
        panelSummaries.setLayout(new BoxLayout(panelSummaries,BoxLayout.Y_AXIS));
        panelSummaries.add(Box.createRigidArea(new Dimension(0,20)));
        panelSummaries.add(panelforLabelSummaries);
        panelSummaries.add(UpdateSummaries());
        panelSummaries.add(Box.createRigidArea(new Dimension(0,70)));
        panelSummaries.add(panelforbtnmenuSummaries);
        panelSummaries.add(Box.createRigidArea(new Dimension(0,26)));
        add(panelSummaries);
        panelSummaries.setVisible(false);
    }

    public JPanel OverviewUpdate() 
    {
        JPanel panel = new JPanel(new GridLayout(3, 2,100,30));
        JPanel mainpanel = new JPanel();

        Font font1 = new Font("FC Galaxy",Font.BOLD,50);
        JLabel labelTotal = new JLabel("Total");
        JLabel labelIncome = new JLabel("Income");
        JLabel labelExpense = new JLabel("Expense");

        panel.setBackground(new Color(47,183,163));
        mainpanel.setBackground(new Color(22, 48, 70));

        labelTotal.setForeground(Color.WHITE);
        labelTotal.setFont(font1);
        labelIncome.setForeground(Color.GREEN);
        labelIncome.setFont(font1);
        labelExpense.setForeground(Color.RED);
        labelExpense.setFont(font1);

        total1.setFont(font1);
        income1.setFont(font1);
        expenses1.setFont(font1);

        panel.add(labelTotal);
        panel.add(total1);
        panel.add(labelIncome);
        panel.add(income1);
        panel.add(labelExpense);
        panel.add(expenses1);

        panel.setBorder(new EmptyBorder(0,70,0,10));
        panel.setPreferredSize(new Dimension(500, 400));
        panel.setSize(new Dimension(200, 500));


        setBackground(new Color(47,183,163));
        mainpanel.add(panel);
        return mainpanel;
    }

    private JPanel UpdateSummaries() 
    {
        Font font2 = new Font("FC Galaxy",Font.BOLD,40);
        
        JPanel panel = new JPanel(new GridLayout(2, 2,10,1));
        JPanel UpdateSummaries = new JPanel();
        
        UpdateSummaries.setBackground(new Color(22, 48, 70));
        panel.setBackground(new Color(47,183,163));


        JLabel labelLatest = new JLabel("Latest");
        JLabel labelIncome = new JLabel("Income");
        JLabel labelExpense = new JLabel("Expense");
        
        labelLatest.setForeground(Color.WHITE);
        labelLatest.setFont(font2);
        labelIncome.setForeground(Color.GREEN);
        labelIncome.setFont(font2);
        labelExpense.setForeground(Color.RED);
        labelExpense.setFont(font2);

        income2.setFont(font2);
        expenses2.setFont(font2);

        panel.add(labelIncome);
        panel.add(income2);
        panel.add(labelExpense);
        panel.add(expenses2);

        panel.setBorder(new EmptyBorder(10,120,10,10));
        panel.setPreferredSize(new Dimension(500, 150));
        panel.setSize(new Dimension(400, 400));
        UpdateSummaries.add(labelLatest);
        UpdateSummaries.add(panel);


 
        JPanel panel2 = new JPanel(new GridLayout(3, 2,10,1));
        panel2.setBackground(new Color(47,183,163));

        JLabel labelPercent = new JLabel("Percent %"); 
        JLabel labelIncomeweek = new JLabel("Income");
        JLabel labelExpenseweek = new JLabel("Expense");
        JLabel labelRevenueweek = new JLabel("Revenue");

        labelPercent.setForeground(Color.WHITE);
        labelIncomeweek.setForeground(Color.GREEN);
        labelExpenseweek.setForeground(Color.RED);
        labelRevenueweek.setForeground(Color.BLUE);

        labelPercent.setFont(font2);
        labelIncomeweek.setFont(font2);
        labelExpenseweek.setFont(font2);
        labelRevenueweek.setFont(font2);
        income3.setFont(font2);
        expenses3.setFont(font2);
        revenue1.setFont(font2);

        panel2.add(labelIncomeweek);
        panel2.add(income3);
        panel2.add(labelExpenseweek);
        panel2.add(expenses3);
        panel2.add(labelRevenueweek);
        panel2.add(revenue1);

        panel2.setBorder(new EmptyBorder(10,120,10,10));
        panel2.setPreferredSize(new Dimension(500, 165));
        panel2.setSize(new Dimension(400, 400));
        setBackground(new Color(38,70,83));
        UpdateSummaries.add(labelPercent);
        UpdateSummaries.add(panel2);

        return UpdateSummaries;
    }
}