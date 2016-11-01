package WarehouseUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import UICommon.ThreadedCurrentTime;

public class ProcessOrder extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtProcessOrder;
    private JPanel menu;
	private JPanel buttons;
	private JPanel Orderdetails;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String fname;
	private String sname;
	private String address;
	private String Oid;
	private String amount;
	private String bname;
	private JLabel Fname;
	private JLabel Bname;
	private JLabel Sname;
	private JLabel Address;
	private JLabel Amount;
	private JTextField F;
	private JTextField S;
	private JTextField A;
	private JTextField B;
	private JTextField M;
	
	private String pattern = "[0-9]+";

	
	public ProcessOrder()
	{
		this.setTitle("Process Order");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(35, 132, 30));

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(500,500));
		TimeDate.setSize(100, 100);
        TimeDate.setLayout(new GridLayout(1,4));
		TimeDate.setBackground(new Color(35, 132, 30));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(2,1));
		
		buttons = new JPanel();
        buttons.setBounds(new Rectangle(10,10));
        buttons.setLayout(new GridLayout(1,2));
		
		Orderdetails = new JPanel();
        Orderdetails.setBounds(new Rectangle(10,10));
        Orderdetails.setLayout(new GridLayout(5,2));
		Orderdetails.setBackground(new Color(35, 132, 30));
        Orderdetails.setForeground(Color.WHITE);
		
        jlblTime = new JLabel("Current Time: ", SwingConstants.CENTER);
        //jlblTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblTime.setSize(40, 40);
		jlblTime.setBackground(new Color(35, 132, 30));
        jlblTime.setForeground(Color.WHITE);
		
		jlblDate = new JLabel("Current Date: ", SwingConstants.CENTER);
        //jlblDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate.setSize(40, 40);
		jlblDate.setBackground(new Color(35, 132, 30));
        jlblDate.setForeground(Color.WHITE);
		
		Date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		jlblDate2 = new JLabel(Date, SwingConstants.CENTER);
        //jlblDate2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate2.setSize(40, 40);
		jlblDate2.setBackground(new Color(35, 132, 30));
        jlblDate2.setForeground(Color.WHITE);
        
        int sleepinterval = 1;
        ThreadedCurrentTime tc = new ThreadedCurrentTime(sleepinterval);
        tc.start();
        jpnlTime = tc.getPanelT();
        jpnlTime.setBackground(new Color(35, 132, 30));
		jpnlTime.setForeground(Color.WHITE);

		
		jbtBack = new JButton("Back");
        jbtBack.setPreferredSize(new Dimension(100, 100));
        jbtBack.addActionListener(this);
		jbtBack.setBackground(new Color(35, 132, 30));
        jbtBack.setForeground(Color.WHITE);
		jbtBack.setToolTipText("Click to go back to main menu");
		
		jbtProcessOrder = new JButton("Process Order");
        jbtProcessOrder.setPreferredSize(new Dimension(100, 100));
        jbtProcessOrder.addActionListener(this);
		jbtProcessOrder.setBackground(new Color(35, 132, 30));
        jbtProcessOrder.setForeground(Color.WHITE);
		jbtProcessOrder.setToolTipText("Click to process the order");
		jbtProcessOrder.setEnabled(false);
		
		Fname = new JLabel("Enter First Name: ", SwingConstants.CENTER);
        Fname.setSize(40, 40);
		Fname.setBackground(new Color(35, 132, 30));
        Fname.setForeground(Color.WHITE);
		
		Sname = new JLabel("Enter Surname Name: ", SwingConstants.CENTER);
        Sname.setSize(40, 40);
		Sname.setBackground(new Color(35, 132, 30));
        Sname.setForeground(Color.WHITE);
		
		Address = new JLabel("Enter Address: ", SwingConstants.CENTER);
        Address.setSize(40, 40);
		Address.setBackground(new Color(35, 132, 30));
        Address.setForeground(Color.WHITE);
		
		Bname = new JLabel("Enter Book Name: ", SwingConstants.CENTER);
        Bname.setSize(40, 40);
		Bname.setBackground(new Color(35, 132, 30));
        Bname.setForeground(Color.WHITE);
		
		Amount = new JLabel("Enter Amount: ", SwingConstants.CENTER);
        Amount.setSize(40, 40);
		Amount.setBackground(new Color(35, 132, 30));
        Amount.setForeground(Color.WHITE);
		
		F = new JTextField(20);
		F.setText("First Name");
        F.setSize(40, 40);
		F.setBackground(new Color(35, 132, 30));
        F.setForeground(Color.WHITE);
		F.setHorizontalAlignment(SwingConstants.CENTER);
		
		S = new JTextField(20);
		S.setText("Surname");
        S.setSize(40, 40);
		S.setBackground(new Color(35, 132, 30));
        S.setForeground(Color.WHITE);
		S.setHorizontalAlignment(SwingConstants.CENTER);
		
		A = new JTextField(50);
		A.setText("Address");
        A.setSize(40, 40);
		A.setBackground(new Color(35, 132, 30));
        A.setForeground(Color.WHITE);
		A.setHorizontalAlignment(SwingConstants.CENTER);
		
		B = new JTextField(50);
		B.setText("Book Name");
        B.setSize(40, 40);
		B.setBackground(new Color(35, 132, 30));
        B.setForeground(Color.WHITE);
		B.setHorizontalAlignment(SwingConstants.CENTER);
		
		M = new JTextField(50);
		M.setText("Amount");
        M.setSize(40, 40);
		M.setBackground(new Color(35, 132, 30));
        M.setForeground(Color.WHITE);
		M.setHorizontalAlignment(SwingConstants.CENTER);
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		buttons.add(jbtProcessOrder);
		buttons.add(jbtBack);
		
		Orderdetails.add(Fname);
		Orderdetails.add(F);
		Orderdetails.add(Sname);
		Orderdetails.add(S);
		Orderdetails.add(Address);
		Orderdetails.add(A);
		Orderdetails.add(Bname);
		Orderdetails.add(B);
		Orderdetails.add(Amount);
		Orderdetails.add(M);
		
		menu.add(TimeDate);
		//menu.add(Orderdetails);
		menu.add(buttons);
		
		this.add(menu);
		this.add(Orderdetails);
		
		F.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				F.setForeground(Color.BLACK);
				F.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				F.setForeground(Color.WHITE);
				F.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		S.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				S.setForeground(Color.BLACK);
				S.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				S.setForeground(Color.WHITE);
				S.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		A.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				A.setForeground(Color.BLACK);
				A.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				A.setForeground(Color.WHITE);
				A.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		B.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				B.setForeground(Color.BLACK);
				B.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				B.setForeground(Color.WHITE);
				B.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		M.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				M.setForeground(Color.BLACK);
				M.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				M.setForeground(Color.WHITE);
				M.setBackground(new Color(35, 132, 30));
			}
		}
		);

		jbtBack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtBack.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtBack.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		jbtProcessOrder.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtProcessOrder.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtProcessOrder.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		F.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(F.getText().length() == 0)
				{
					jbtProcessOrder.setEnabled(false);
				}
				else
				{
					jbtProcessOrder.setEnabled(true);
				}
			}
		});
		
		S.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(S.getText().length() == 0)
				{
					jbtProcessOrder.setEnabled(false);
				}
				else
				{
					jbtProcessOrder.setEnabled(true);
				}
			}
		});

		A.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(A.getText().length() == 0)
				{
					jbtProcessOrder.setEnabled(false);
				}
				else
				{
					jbtProcessOrder.setEnabled(true);
				}
			}
		});
		
		B.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(B.getText().length() == 0)
				{
					jbtProcessOrder.setEnabled(false);
				}
				else
				{
					jbtProcessOrder.setEnabled(true);
				}
			}
		});
		
		M.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(M.getText().length() == 0)
				{
					jbtProcessOrder.setEnabled(false);
				}
				else if(!(M.getText().matches(pattern)))
				{
					jbtProcessOrder.setEnabled(false);
				}
				else
				{
					jbtProcessOrder.setEnabled(true);
				}
			}
		});
		
		
        this.pack();
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{	
        JButton source = (JButton) ae.getSource();
        if(source.equals(jbtBack)) {
            WarehouseMainMenu menu = new WarehouseMainMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtProcessOrder)) {
            //ProcessOrder();
			
        }
		
	}
	

	public static void main(String args [])
	{
		ProcessOrder omenu = new ProcessOrder();
	}
}