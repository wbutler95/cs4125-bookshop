package CustomerUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import UICommon.ThreadedCurrentTime;

public class CreateAccount extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtCreateAccount;
        private JPanel menu;
	private JPanel buttons;
	private JPanel Personaldetails;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String fname;
	private String sname;
	private String email;
	private String Pid;
	private JLabel Fname;
	private JLabel Sname;
	private JLabel Email;
	private JTextField F;
	private JTextField S;
	private JTextField E;
	private int level = 1;

	
	public CreateAccount()
	{
		this.setTitle("Create Account");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(59, 89, 182));

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(500,500));
		TimeDate.setSize(100, 100);
        TimeDate.setLayout(new GridLayout(1,4));
		TimeDate.setBackground(new Color(59, 89, 182));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(2,1));
		
		buttons = new JPanel();
        buttons.setBounds(new Rectangle(10,10));
        buttons.setLayout(new GridLayout(1,2));
		
		Personaldetails = new JPanel();
        Personaldetails.setBounds(new Rectangle(10,10));
        Personaldetails.setLayout(new GridLayout(3,2));
		Personaldetails.setBackground(new Color(59, 89, 182));
        Personaldetails.setForeground(Color.WHITE);
		
        jlblTime = new JLabel("Current Time: ", SwingConstants.CENTER);
        //jlblTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblTime.setSize(40, 40);
		jlblTime.setBackground(new Color(59, 89, 182));
        jlblTime.setForeground(Color.WHITE);
		
		jlblDate = new JLabel("Current Date: ", SwingConstants.CENTER);
        //jlblDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate.setSize(40, 40);
		jlblDate.setBackground(new Color(59, 89, 182));
        jlblDate.setForeground(Color.WHITE);
		
		Date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		jlblDate2 = new JLabel(Date, SwingConstants.CENTER);
        //jlblDate2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate2.setSize(40, 40);
		jlblDate2.setBackground(new Color(59, 89, 182));
        jlblDate2.setForeground(Color.WHITE);
        
        int sleepinterval = 1;
        ThreadedCurrentTime tc = new ThreadedCurrentTime(sleepinterval);
        tc.start();
        jpnlTime = tc.getPanelT();
        jpnlTime.setBackground(new Color(59, 89, 182));
		jpnlTime.setForeground(Color.WHITE);

		
		jbtBack = new JButton("Back");
        jbtBack.setPreferredSize(new Dimension(100, 100));
        jbtBack.addActionListener(this);
		jbtBack.setBackground(new Color(59, 89, 182));
        jbtBack.setForeground(Color.WHITE);
		jbtBack.setToolTipText("Click to go back to main menu");
		
		jbtCreateAccount = new JButton("Create Account");
        jbtCreateAccount.setPreferredSize(new Dimension(100, 100));
        jbtCreateAccount.addActionListener(this);
		jbtCreateAccount.setBackground(new Color(59, 89, 182));
        jbtCreateAccount.setForeground(Color.WHITE);
		jbtCreateAccount.setToolTipText("Click to create a new account");
		jbtCreateAccount.setEnabled(false);
		
		Fname = new JLabel("Enter First Name: ", SwingConstants.CENTER);
        Fname.setSize(40, 40);
		Fname.setBackground(new Color(59, 89, 182));
        Fname.setForeground(Color.WHITE);
		
		Sname = new JLabel("Enter Surname Name: ", SwingConstants.CENTER);
        Sname.setSize(40, 40);
		Sname.setBackground(new Color(59, 89, 182));
        Sname.setForeground(Color.WHITE);
		
		Email = new JLabel("Enter Email: ", SwingConstants.CENTER);
        Email.setSize(40, 40);
		Email.setBackground(new Color(59, 89, 182));
        Email.setForeground(Color.WHITE);
		
		F = new JTextField(20);
		F.setText("First Name");
        F.setSize(40, 40);
		F.setBackground(new Color(59, 89, 182));
        F.setForeground(Color.WHITE);
		F.setHorizontalAlignment(SwingConstants.CENTER);
		
		S = new JTextField(20);
		S.setText("Surname");
        S.setSize(40, 40);
		S.setBackground(new Color(59, 89, 182));
        S.setForeground(Color.WHITE);
		S.setHorizontalAlignment(SwingConstants.CENTER);
		
		E = new JTextField(50);
		E.setText("Email");
        E.setSize(40, 40);
		E.setBackground(new Color(59, 89, 182));
        E.setForeground(Color.WHITE);
		E.setHorizontalAlignment(SwingConstants.CENTER);
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		buttons.add(jbtCreateAccount);
		buttons.add(jbtBack);
		
		Personaldetails.add(Fname);
		Personaldetails.add(F);
		Personaldetails.add(Sname);
		Personaldetails.add(S);
		Personaldetails.add(Email);
		Personaldetails.add(E);
		
		menu.add(TimeDate);
		//menu.add(Personaldetails);
		menu.add(buttons);
		
		this.add(menu);
		this.add(Personaldetails);
		
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
				F.setBackground(new Color(59, 89, 182));
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
				S.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		E.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				E.setForeground(Color.BLACK);
				E.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				E.setForeground(Color.WHITE);
				E.setBackground(new Color(59, 89, 182));
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
				jbtBack.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		jbtCreateAccount.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtCreateAccount.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtCreateAccount.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		F.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(F.getText().length() == 0)
				{
					jbtCreateAccount.setEnabled(false);
				}
				else
				{
					jbtCreateAccount.setEnabled(true);
				}
			}
		});
		
		S.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(S.getText().length() == 0)
				{
					jbtCreateAccount.setEnabled(false);
				}
				else
				{
					jbtCreateAccount.setEnabled(true);
				}
			}
		});

		E.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(E.getText().length() == 0)
				{
					jbtCreateAccount.setEnabled(false);
				}
				else
				{
					jbtCreateAccount.setEnabled(true);
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
            StaffMenu pmenu = new StaffMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtCreateAccount)) {
            //CreateAccount();
			//JOptionPane.showMessageDialog(null,Books[list.getSelectedIndex()]);
        }
		
	}
	

	public static void main(String args [])
	{
		CreateAccount cmenu = new CreateAccount();
	}
}
