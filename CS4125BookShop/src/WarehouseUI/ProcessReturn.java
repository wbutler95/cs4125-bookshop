package WarehouseUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import UICommon.ThreadedCurrentTime;

public class ProcessReturn extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtProcessReturn;
    private JPanel menu;
	private JPanel buttons;
	private JPanel Returndetails;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String Mid;
	private String Oid;
	private String amount;
	private String bname;
	private JLabel Fname;
	private JLabel Bname;
	private JLabel Sname;
	private JLabel Order;
	private JLabel Amount;
	private JTextField F;
	private JTextField S;
	private JTextField O;
	private JTextField B;
	private JTextField M;
	
	private String pattern = "[0-9]+";
	
	public ProcessReturn()
	{
		this.setTitle("Process Return");
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
		
		Returndetails = new JPanel();
        Returndetails.setBounds(new Rectangle(10,10));
        Returndetails.setLayout(new GridLayout(5,2));
		Returndetails.setBackground(new Color(35, 132, 30));
        Returndetails.setForeground(Color.WHITE);
		
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
		
		jbtProcessReturn = new JButton("Process Return");
        jbtProcessReturn.setPreferredSize(new Dimension(100, 100));
        jbtProcessReturn.addActionListener(this);
		jbtProcessReturn.setBackground(new Color(35, 132, 30));
        jbtProcessReturn.setForeground(Color.WHITE);
		jbtProcessReturn.setToolTipText("Click to process the return");
		jbtProcessReturn.setEnabled(false);
		
		Fname = new JLabel("Enter First Name: ", SwingConstants.CENTER);
        Fname.setSize(40, 40);
		Fname.setBackground(new Color(35, 132, 30));
        Fname.setForeground(Color.WHITE);
		
		Sname = new JLabel("Enter Surname Name: ", SwingConstants.CENTER);
        Sname.setSize(40, 40);
		Sname.setBackground(new Color(35, 132, 30));
        Sname.setForeground(Color.WHITE);
		
		Order = new JLabel("Enter Order ID: ", SwingConstants.CENTER);
        Order.setSize(40, 40);
		Order.setBackground(new Color(35, 132, 30));
        Order.setForeground(Color.WHITE);
		
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
		
		O = new JTextField(50);
		O.setText("Order ID");
        O.setSize(40, 40);
		O.setBackground(new Color(35, 132, 30));
        O.setForeground(Color.WHITE);
		O.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		buttons.add(jbtProcessReturn);
		buttons.add(jbtBack);
		
		Returndetails.add(Fname);
		Returndetails.add(F);
		Returndetails.add(Sname);
		Returndetails.add(S);
		Returndetails.add(Order);
		Returndetails.add(O);
		Returndetails.add(Bname);
		Returndetails.add(B);
		Returndetails.add(Amount);
		Returndetails.add(M);
		
		menu.add(TimeDate);
		//menu.add(Returndetails);
		menu.add(buttons);
		
		this.add(menu);
		this.add(Returndetails);
		
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
		
		O.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				O.setForeground(Color.BLACK);
				O.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				O.setForeground(Color.WHITE);
				O.setBackground(new Color(35, 132, 30));
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
		
		jbtProcessReturn.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtProcessReturn.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtProcessReturn.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		F.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(F.getText().length() == 0)
				{
					jbtProcessReturn.setEnabled(false);
				}
				else
				{
					jbtProcessReturn.setEnabled(true);
				}
			}
		});
		
		S.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(S.getText().length() == 0)
				{
					jbtProcessReturn.setEnabled(false);
				}
				else
				{
					jbtProcessReturn.setEnabled(true);
				}
			}
		});

		O.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(O.getText().length() == 0)
				{
					jbtProcessReturn.setEnabled(false);
				}
				else
				{
					jbtProcessReturn.setEnabled(true);
				}
			}
		});
		
		B.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(B.getText().length() == 0)
				{
					jbtProcessReturn.setEnabled(false);
				}
				else
				{
					jbtProcessReturn.setEnabled(true);
				}
			}
		});
		
		M.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(M.getText().length() == 0)
				{
					jbtProcessReturn.setEnabled(false);
				}
				else if(!(M.getText().matches(pattern)))
				{
					jbtProcessReturn.setEnabled(false);
				}
				else
				{
					jbtProcessReturn.setEnabled(true);
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

        if(source.equals(jbtProcessReturn)) {
            //ProcessReturn();
			
        }
		
	}
	

	public static void main(String args [])
	{
		ProcessReturn rmenu = new ProcessReturn();
	}
}