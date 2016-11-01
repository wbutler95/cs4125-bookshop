package CustomerUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import UICommon.ThreadedCurrentTime;

public class ReturnBook extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtReturnBook;
        private JPanel menu;
	private JPanel buttons;
	private JPanel bookdetails;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String BookName;
	private String email;
	private String Reason;
	private JLabel Bname;
	private JLabel Rreason;
	private JLabel Email;
	private JTextField B;
	private JTextField R;
	private JTextField E;

	
	public ReturnBook()
	{
		this.setTitle("Return Book");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(158, 36, 36));

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(500,500));
		TimeDate.setSize(100, 100);
        TimeDate.setLayout(new GridLayout(1,4));
		TimeDate.setBackground(new Color(158, 36, 36));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(2,1));
		
		buttons = new JPanel();
        buttons.setBounds(new Rectangle(10,10));
        buttons.setLayout(new GridLayout(1,2));
		
		bookdetails = new JPanel();
        bookdetails.setBounds(new Rectangle(10,10));
        bookdetails.setLayout(new GridLayout(3,3));
		bookdetails.setBackground(new Color(158, 36, 36));
        bookdetails.setForeground(Color.WHITE);
		
        jlblTime = new JLabel("Current Time: ", SwingConstants.CENTER);
        //jlblTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblTime.setSize(40, 40);
		jlblTime.setBackground(new Color(158, 36, 36));
        jlblTime.setForeground(Color.WHITE);
		
		jlblDate = new JLabel("Current Date: ", SwingConstants.CENTER);
        //jlblDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate.setSize(40, 40);
		jlblDate.setBackground(new Color(158, 36, 36));
        jlblDate.setForeground(Color.WHITE);
		
		Date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		jlblDate2 = new JLabel(Date, SwingConstants.CENTER);
        //jlblDate2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate2.setSize(40, 40);
		jlblDate2.setBackground(new Color(158, 36, 36));
        jlblDate2.setForeground(Color.WHITE);
        
        int sleepinterval = 1;
        ThreadedCurrentTime tc = new ThreadedCurrentTime(sleepinterval);
        tc.start();
        jpnlTime = tc.getPanelT();
        jpnlTime.setBackground(new Color(158, 36, 36));
		jpnlTime.setForeground(Color.WHITE);

		
		jbtBack = new JButton("Back");
        jbtBack.setPreferredSize(new Dimension(100, 100));
        jbtBack.addActionListener(this);
		jbtBack.setBackground(new Color(158, 36, 36));
        jbtBack.setForeground(Color.WHITE);
		jbtBack.setToolTipText("Click to go back to main menu");
		
		jbtReturnBook = new JButton("Return Book");
        jbtReturnBook.setPreferredSize(new Dimension(100, 100));
        jbtReturnBook.addActionListener(this);
		jbtReturnBook.setBackground(new Color(158, 36, 36));
        jbtReturnBook.setForeground(Color.WHITE);
		jbtReturnBook.setToolTipText("Click to create a new account");
		jbtReturnBook.setEnabled(false);
		
		Bname = new JLabel("Enter Name of Book: ", SwingConstants.CENTER);
        Bname.setSize(40, 40);
		Bname.setBackground(new Color(158, 36, 36));
        Bname.setForeground(Color.WHITE);
		
		Rreason = new JLabel("Enter Reason for Return: ", SwingConstants.CENTER);
        Rreason.setSize(40, 40);
		Rreason.setBackground(new Color(158, 36, 36));
        Rreason.setForeground(Color.WHITE);
		
		Email = new JLabel("Enter Email: ", SwingConstants.CENTER);
        Email.setSize(40, 40);
		Email.setBackground(new Color(158, 36, 36));
        Email.setForeground(Color.WHITE);
		
		B = new JTextField(20);
		B.setText("Name of Book");
        B.setSize(40, 40);
		B.setBackground(new Color(158, 36, 36));
        B.setForeground(Color.WHITE);
		B.setHorizontalAlignment(SwingConstants.CENTER);
		
		R = new JTextField(20);
		R.setText("Reason for Return");
        R.setSize(40, 40);
		R.setBackground(new Color(158, 36, 36));
        R.setForeground(Color.WHITE);
		R.setHorizontalAlignment(SwingConstants.CENTER);
		
		E = new JTextField(50);
		E.setText("Email");
        E.setSize(40, 40);
		E.setBackground(new Color(158, 36, 36));
        E.setForeground(Color.WHITE);
		E.setHorizontalAlignment(SwingConstants.CENTER);
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		buttons.add(jbtReturnBook);
		buttons.add(jbtBack);
		
		bookdetails.add(Bname);
		bookdetails.add(B);
		bookdetails.add(Rreason);
		bookdetails.add(R);
		bookdetails.add(Email);
		bookdetails.add(E);
		
		menu.add(TimeDate);
		//menu.add(bookdetails);
		menu.add(buttons);
		
		this.add(menu);
		this.add(bookdetails);
		
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
				B.setBackground(new Color(158, 36, 36));
			}
		}
		);
		
		R.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				R.setForeground(Color.BLACK);
				R.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				R.setForeground(Color.WHITE);
				R.setBackground(new Color(158, 36, 36));
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
				E.setBackground(new Color(158, 36, 36));
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
				jbtBack.setBackground(new Color(158, 36, 36));
			}
		}
		);
		
		jbtReturnBook.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtReturnBook.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtReturnBook.setBackground(new Color(158, 36, 36));
			}
		}
		);
		
		B.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(B.getText().length() == 0)
				{
					jbtReturnBook.setEnabled(false);
				}
				else
				{
					jbtReturnBook.setEnabled(true);
				}
			}
		});
		
		R.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(R.getText().length() == 0)
				{
					jbtReturnBook.setEnabled(false);
				}
				else
				{
					jbtReturnBook.setEnabled(true);
				}
			}
		});

		E.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(E.getText().length() == 0)
				{
					jbtReturnBook.setEnabled(false);
				}
				else
				{
					jbtReturnBook.setEnabled(true);
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
            CustomerMainMenu menu = new CustomerMainMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtReturnBook)) {
            //ReturnBook();
			
        }
		
	}
	

	public static void main(String args [])
	{
		ReturnBook rmenu = new ReturnBook();
	}
}