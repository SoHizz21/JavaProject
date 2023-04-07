import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.util.Date;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class addTx <T> extends JPanel
{
    int i = 0;
    private double amountDouble;
    private String datetime;
    private String notedatetime;
    private Date   date;
    private String amountdatetime1;
    private String amountdatetime2;

    private double income = 0.0;
    private double expreseslast = 0.0;
    private double expreses = 0.0;
    private double amountTotal = 0.0;

    private JFrame frame = new JFrame();
    private Font fontbtn = new Font("FC Galaxy",Font.BOLD,30);
    private Dimension maxLabelSize = new Dimension(500, 50);

    public JButton btnAdd(JTextArea listArea,JLabel total1,JLabel income2,JLabel income3,JLabel income1,JLabel expenses2,JLabel expenses3,JLabel expenses1 ,JLabel revenue1)
    {
        //เรียกข้อมูลใหม่ในData.txt
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
            income=(scanner.nextDouble());
            expreseslast=(scanner.nextDouble());
            expreses=(scanner.nextDouble());
            amountTotal=(scanner.nextDouble());

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        JButton addTx = new JButton("Add");//สร้างปุ่มadd
        setMaximumSize(maxLabelSize);

        addTx.setFont(fontbtn);
        setBackground(new Color(37,157,117));
        add(addTx);

        addTx.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Selector(listArea,total1,income2,income3,income1,expenses2,expenses3,expenses1,revenue1); //ส่งไปmethod Selector
                FrameStarter(); //กำหนดframe
            }
        });
        return addTx ;
    }

    public void FrameStarter()//กำหนดframe
    {
        frame.setTitle("ADD");
        frame.setSize(400, 250);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    //หน้าต่างSelector
    public void Selector(JTextArea listArea,JLabel total1,JLabel income2,JLabel income3,JLabel income1,JLabel expenses2,JLabel expenses3,JLabel expenses1 ,JLabel revenue1)
    {
        JPanel panelSelector = new JPanel();    //panelหน้าทั้งหมดของAdd
        JPanel panelbtnSelector = new JPanel(); //panelเชื่อมหน้าของปุ่ม income และ expenses
        JPanel panelIncome = new JPanel();      //panelปุ่มincome
        JPanel panelExpenses = new JPanel();    //panelปุ่มexpenses

        JToggleButton btnIncome = new JToggleButton("Income",true);
        JToggleButton btnExpenses = new JToggleButton("Expenses",false);
        btnExpenses.setMargin(new Insets(0, 60, 0, 60));    //ปรับขนาดปุ่ม
        btnIncome.setMargin(new Insets(0, 60, 0, 60));      //ปรับขนาดปุ่ม
        btnExpenses.setFont(fontbtn);
        btnIncome.setFont(fontbtn);

        panelSelector.setLayout(new BoxLayout(panelSelector,BoxLayout.Y_AXIS));
        panelbtnSelector.setLayout(new BoxLayout(panelbtnSelector,BoxLayout.X_AXIS));
        panelIncome.setLayout(new BoxLayout(panelIncome,BoxLayout.Y_AXIS));
        panelExpenses.setLayout(new BoxLayout(panelExpenses,BoxLayout.Y_AXIS));
        
        panelIncome.add(Income(listArea,total1,income2,income3,income1,expenses2,expenses3,expenses1,revenue1)); //จัดหน้าของIncome
        panelExpenses.add(Expenses(listArea,total1,income2,income3,income1,expenses2,expenses3,expenses1,revenue1)); //จัดหน้าของExpenese

        panelbtnSelector.add(btnIncome);
        panelbtnSelector.add(btnExpenses);

        //จัดหน้าของADD
        panelSelector.add(panelbtnSelector);
        panelSelector.add(Box.createRigidArea(new Dimension(0,10)));
        panelSelector.add(panelIncome);
        panelSelector.add(panelExpenses);
        panelExpenses.setVisible(false);

        btnIncome.addActionListener(new ActionListener()  //action btnIncome
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(btnIncome.isSelected())
                    btnExpenses.setSelected(false);
                    panelIncome.setVisible(true); //เปิดหน้าต่างIncome
                    panelExpenses.setVisible(false);  //ปิดหน้าต่างExpenese
            }
        });

        btnExpenses.addActionListener(new ActionListener() //action btnExpenese
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(btnExpenses.isSelected())
                    btnIncome.setSelected(false);
                    panelIncome.setVisible(false);  //ปิดหน้าต่างIncome
                    panelExpenses.setVisible(true); //เปิดหน้าต่างExpenese
            }
        });
        frame.add(panelSelector);
    }

    //หน้าต่างIncome
    public JPanel Income(JTextArea listArea,JLabel total1,JLabel income2,JLabel income3,JLabel income1,JLabel expenses2,JLabel expenses3,JLabel expenses1 ,JLabel revenue1) 
    {
        JPanel panel = new JPanel();
        Font fontlabel = new Font("FC Galaxy",Font.BOLD,25);
        JLabel time = new JLabel("Income date (dd/MM/yyyy) : ");
        JTextField timeTf = new JTextField(10);
        JLabel note = new JLabel("Income Note : ");
        JTextField noteTf = new JTextField(20);
        JLabel amount = new JLabel("amount (THB.) : ");
        JTextField amountTf = new JTextField(20);
        JButton Submitbtn = new JButton("Submit");

        time.setFont(fontlabel);
        timeTf.setFont(fontlabel);
        note.setFont(fontlabel);
        noteTf.setFont(fontlabel);
        amount.setFont(fontlabel);
        amountTf.setFont(fontlabel);
        
        panel.add(time);
        panel.add(timeTf);
        panel.add(note);
        panel.add(noteTf);
        panel.add(amount);
        panel.add(amountTf);
        panel.add(Submitbtn);

        Submitbtn.addActionListener(new ActionListener() //action btnSubmit
        {
            public void actionPerformed(ActionEvent e) 
            {
                ArrayList<T> arrData = new ArrayList<T>();
                datetime = timeTf.getText();
                notedatetime = noteTf.getText();
                amountdatetime1 = amountTf.getText();

                DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); //ฟิกค่าว่าให้เขียนเวลาตามนี้
                try
                {
                    amountDouble = Double.parseDouble(amountdatetime1);//ฟิกค่าว่าให้เขียนตัวเลข
                    date = dateFormat.parse(datetime);
                    arrData.add((T) date);
                    arrData.add((T) notedatetime);
                    arrData.add((T) Double.valueOf(amountDouble));

                    double incomeArr = (double)arrData.get(2); //รับค่าamoutของincome
                    income += incomeArr; //หาค่าincomeทั้งหมด
                    amountTotal = income - expreses;

                    double incomePercent =  (income/ (income + expreses)) * 100;
                    double expresesPercent =  (expreses / (income + expreses)) * 100;
                    double revenuePercent =  ((income - expreses) / (income + expreses)) * 100;
                       
                    String incomepercentstr = String.format("%.2f",incomePercent);
                    String expresespercentstr = String.format("%.2f",expresesPercent);
                    String revenuepercentstr = String.format("%.2f",revenuePercent);

                    total1.setText(String.valueOf(amountTotal));        //แสดงค่าtotalหน้าoverview
                    income1.setText(String.valueOf(income));            //แสดงค่าincomeหน้าoverview
                    expenses1.setText(String.valueOf(expreses));        //แสดงค่าexpensesหน้าoverview  
                    income2.setText(amountdatetime1);                   //แสดงค่าincomeหน้าSummaries
                    expenses2.setText(String.valueOf(expreseslast));    //แสดงค่าexpensesหน้าSummaries
                    income3.setText(incomepercentstr+"%");              //แสดงค่าincome%หน้าSummaries
                    expenses3.setText(expresespercentstr+"%");          //แสดงค่าexpenses%หน้าSummaries
                    revenue1.setText(revenuepercentstr+"%");            //แสดงค่าrevenue%หน้าSummaries

                    listArea.setFont(new Font("FC Galaxy",Font.BOLD,20));
                    listArea.setForeground(new Color(41, 128, 185 ));
                    listArea.append("Income -> "+" Date: "+dateFormat.format(arrData.get(0)) + " Note: " + arrData.get(1) + " Amount: " + arrData.get(2) +  "\n");
                    
                    //ทำการส่งค่าไปใส่ในData.txt
                    try   
                    {
                        File fileName = new File("Data.txt");
                        FileWriter writer = new FileWriter(fileName);
                        writer.write(total1.getText()+"\n");
                        writer.write(income1.getText()+"\n");
                        writer.write(expenses1.getText()+"\n");
                        writer.write(income2.getText()+"\n");
                        writer.write(expenses2.getText()+"\n");
                        writer.write(income3.getText()+"\n");
                        writer.write(expenses3.getText()+"\n");
                        writer.write(revenue1.getText()+"\n");
                        writer.write(income+"\n");
                        writer.write(expreseslast+"\n");
                        writer.write(expreses+"\n");
                        writer.write(amountTotal+"\n");
                        writer.close();
                    } catch (IOException a) 
                    {
                        a.printStackTrace();
                    }
                    //ทำการส่งค่าไปใส่ในHistory.txt
                    try 
                    {
                        File fileName = new File("History.txt");
                        FileWriter writer = new FileWriter(fileName);
                        writer.write(listArea.getText());
                        writer.close();
                    } 
                    catch (IOException a) 
                    {
                        a.printStackTrace();
                    }
                } 
                catch (ParseException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid date format!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Value!!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }});
        return panel;
    }

    //หน้าต่างExpenses
    public JPanel Expenses(JTextArea listArea,JLabel total1,JLabel income2,JLabel income3,JLabel income1,JLabel expenses2,JLabel expenses3,JLabel expenses1 ,JLabel revenue1) 
    {
        JPanel panel = new JPanel();
        Font fontlabel = new Font("FC Galaxy",Font.BOLD,25);
        JLabel time = new JLabel("Expenses date (dd/MM/yyyy) : ");
        JTextField timeTf = new JTextField(10);
        JLabel note = new JLabel("Expenses Note : ");
        JTextField noteTf = new JTextField(20);
        JLabel amount = new JLabel("amount (THB.) : ");
        JTextField amountTf2 = new JTextField(20);
        JButton Submitbtn = new JButton("Submit");

        time.setFont(fontlabel);
        timeTf.setFont(fontlabel);
        note.setFont(fontlabel);
        noteTf.setFont(fontlabel);
        amount.setFont(fontlabel);
        amountTf2.setFont(fontlabel);

        panel.add(time);
        panel.add(timeTf);
        panel.add(note);
        panel.add(noteTf);
        panel.add(amount);
        panel.add(amountTf2);
        panel.add(Submitbtn);

        Submitbtn.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                ArrayList<T> arrData2 = new ArrayList<T>();
                datetime = timeTf.getText();
                notedatetime = noteTf.getText();
                amountdatetime2 = amountTf2.getText();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                try
                {
                    expreseslast = Double.parseDouble(amountdatetime2);
                    date = format.parse(datetime);
                    amountDouble = Double.parseDouble(amountdatetime2);
                    arrData2.add((T) date);
                    arrData2.add((T) notedatetime);
                    arrData2.add((T) Double.valueOf(amountDouble));
                    double espensesArr = (double)  arrData2.get(2);
                    expreses += espensesArr;
                    amountTotal = income - expreses;

                    double incomePercent =  (income/ (income + expreses)) * 100;
                    double expresesPercent =  (expreses / (income + expreses)) * 100;
                    double revenuePercent =  ((income - expreses) / (income + expreses)) * 100;
                       
                    String incomepercentstr = String.format("%.2f",incomePercent);
                    String expresespercentstr = String.format("%.2f",expresesPercent);
                    String revenuepercentstr = String.format("%.2f",revenuePercent);

                    total1.setText(String.valueOf(amountTotal));            //แสดงค่าtotalหน้าoverview
                    income1.setText(String.valueOf(income));                //แสดงค่าincomeหน้าoverview
                    expenses1.setText(String.valueOf(expreses));            //แสดงค่าexpensesหน้าoverview 
                    income2.setText(amountdatetime1);                       //แสดงค่าincomeหน้าSummaries
                    expenses2.setText(String.valueOf(expreseslast));        //แสดงค่าexpensesหน้าSummaries
                    income3.setText(incomepercentstr+"%");                  //แสดงค่าincome%หน้าSummaries
                    expenses3.setText(expresespercentstr+"%");              //แสดงค่าexpenses%หน้าSummaries
                    revenue1.setText(revenuepercentstr+"%");                //แสดงค่าrevenue%หน้าSummaries
                    
                    listArea.setFont(new Font("FC Galaxy",Font.BOLD,20));
                    listArea.setForeground(new Color(41, 128, 185 ));
                    listArea.append("Expenses -> "+" Date: "+ format.format(arrData2.get(0))+ " Note: " + arrData2.get(1) + " Amount: " + arrData2.get(2) +  "\n");
                    
                    //ทำการส่งค่าไปใส่ในData.txt
                    try 
                    {
                        File fileName = new File("Data.txt");
                        FileWriter writer = new FileWriter(fileName);
                        writer.write(total1.getText()+"\n");
                        writer.write(income1.getText()+"\n");
                        writer.write(expenses1.getText()+"\n");
                        writer.write(income2.getText()+"\n");
                        writer.write(expenses2.getText()+"\n");
                        writer.write(income3.getText()+"\n");
                        writer.write(expenses3.getText()+"\n");
                        writer.write(revenue1.getText()+"\n");
                        writer.write(income+"\n");
                        writer.write(expreseslast+"\n");
                        writer.write(expreses+"\n");
                        writer.write(amountTotal+"\n");
                        writer.close();
                    } catch (IOException a) 
                    {
                        a.printStackTrace();
                    }
                    //ทำการส่งค่าไปใส่ในHistory.txt
                    try 
                    {
                        File fileName = new File("History.txt");
                        FileWriter writer = new FileWriter(fileName);
                        writer.write(listArea.getText());
                        writer.close();
                    } catch (IOException a) 
                    {
                        a.printStackTrace();
                    }
                } 
                catch (ParseException ex) //เขียนวันไม่ตรงจะแจ้งเตือน
                {
                    JOptionPane.showMessageDialog(null, "Invalid date format!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException ex) //เขียนเลขไม่ตรงจะแจ้งเตือน
                {
                    JOptionPane.showMessageDialog(null, "Invalid Value!!!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }});
        return panel;
    }
}