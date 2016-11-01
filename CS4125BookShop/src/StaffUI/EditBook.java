package StaffUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import UICommon.ThreadedCurrentTime;

public class EditBook extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtEditBook;
    private JPanel menu;
	private JPanel buttons;
	private JPanel Bookdetails;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String Bookname;
	private String Publisher;
	private String Author;
	private String Genre;
	private String ISBN;
	private JLabel Bname;
	private JLabel Aname;
	private JLabel Pname;
	private JLabel Gname;
	private JLabel isbn;
	private JTextField B;
	private JTextField A;
	private JTextField P;
	private JTextField I;
	private JTextField G;
	private JScrollPane listScroller;
	private String Books [] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private JList list;
	private int choice;

	
	public EditBook()
	{
		this.setTitle("Edit Book");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(600,600));
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
        menu.setLayout(new GridLayout(3,1));
		
		buttons = new JPanel();
        buttons.setBounds(new Rectangle(10,10));
        buttons.setLayout(new GridLayout(1,2));
		
		Bookdetails = new JPanel();
        Bookdetails.setBounds(new Rectangle(10,10));
        Bookdetails.setLayout(new GridLayout(5,2));
		Bookdetails.setBackground(new Color(59, 89, 182));
        Bookdetails.setForeground(Color.WHITE);
		
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
		
		jbtEditBook = new JButton("Save Changes");
        jbtEditBook.setPreferredSize(new Dimension(100, 100));
        jbtEditBook.addActionListener(this);
		jbtEditBook.setBackground(new Color(59, 89, 182));
        jbtEditBook.setForeground(Color.WHITE);
		jbtEditBook.setToolTipText("Click to edit book in the database");
		jbtEditBook.setEnabled(false);
		
		Bname = new JLabel("Enter Book Name: ", SwingConstants.CENTER);
        Bname.setSize(40, 40);
		Bname.setBackground(new Color(59, 89, 182));
        Bname.setForeground(Color.WHITE);
		
		Pname = new JLabel("Enter Publisher's Name: ", SwingConstants.CENTER);
        Pname.setSize(40, 40);
		Pname.setBackground(new Color(59, 89, 182));
        Pname.setForeground(Color.WHITE);
		
		Aname = new JLabel("Enter Author's Name: ", SwingConstants.CENTER);
        Aname.setSize(40, 40);
		Aname.setBackground(new Color(59, 89, 182));
        Aname.setForeground(Color.WHITE);
		
		Gname = new JLabel("Enter Genre Name: ", SwingConstants.CENTER);
        Gname.setSize(40, 40);
		Gname.setBackground(new Color(59, 89, 182));
        Gname.setForeground(Color.WHITE);
		
		isbn = new JLabel("Enter ISBN: ", SwingConstants.CENTER);
        isbn.setSize(40, 40);
		isbn.setBackground(new Color(59, 89, 182));
        isbn.setForeground(Color.WHITE);
		
		B = new JTextField(20);
		B.setText("Book Name");
        B.setSize(40, 40);
		B.setBackground(new Color(59, 89, 182));
        B.setForeground(Color.WHITE);
		B.setHorizontalAlignment(SwingConstants.CENTER);
		
		P = new JTextField(20);
		P.setText("Publisher");
        P.setSize(40, 40);
		P.setBackground(new Color(59, 89, 182));
        P.setForeground(Color.WHITE);
		P.setHorizontalAlignment(SwingConstants.CENTER);
		
		A = new JTextField(50);
		A.setText("Author");
        A.setSize(40, 40);
		A.setBackground(new Color(59, 89, 182));
        A.setForeground(Color.WHITE);
		A.setHorizontalAlignment(SwingConstants.CENTER);
		
		G = new JTextField(50);
		G.setText("Genre");
        G.setSize(40, 40);
		G.setBackground(new Color(59, 89, 182));
        G.setForeground(Color.WHITE);
		G.setHorizontalAlignment(SwingConstants.CENTER);
		
		I = new JTextField(50);
		I.setText("ISBN");
        I.setSize(40, 40);
		I.setBackground(new Color(59, 89, 182));
        I.setForeground(Color.WHITE);
		I.setHorizontalAlignment(SwingConstants.CENTER);
		
		list = new JList(Books);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(Books.length);
		list.setBackground(new Color(59, 89, 182));
		list.setForeground(Color.WHITE);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		buttons.add(jbtEditBook);
		buttons.add(jbtBack);
		
		Bookdetails.add(Bname);
		Bookdetails.add(B);
		Bookdetails.add(Aname);
		Bookdetails.add(A);
		Bookdetails.add(Pname);
		Bookdetails.add(P);
		Bookdetails.add(Gname);
		Bookdetails.add(G);
		Bookdetails.add(isbn);
		Bookdetails.add(I);
		
		menu.add(TimeDate);
		//menu.add(Bookdetails);
		menu.add(buttons);
		menu.add(listScroller);
		
		this.add(menu);
		this.add(Bookdetails);
		
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
				B.setBackground(new Color(59, 89, 182));
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
				A.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		P.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				P.setForeground(Color.BLACK);
				P.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				P.setForeground(Color.WHITE);
				P.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		G.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				G.setForeground(Color.BLACK);
				G.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				G.setForeground(Color.WHITE);
				G.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		I.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				I.setForeground(Color.BLACK);
				I.setBackground(Color.WHITE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				I.setForeground(Color.WHITE);
				I.setBackground(new Color(59, 89, 182));
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
		
		jbtEditBook.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtEditBook.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtEditBook.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		B.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(B.getText().length() == 0)
				{
					jbtEditBook.setEnabled(false);
				}
				else
				{
					jbtEditBook.setEnabled(true);
				}
			}
		});
		
		A.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(A.getText().length() == 0)
				{
					jbtEditBook.setEnabled(false);
				}
				else
				{
					jbtEditBook.setEnabled(true);
				}
			}
		});

		P.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(P.getText().length() == 0)
				{
					jbtEditBook.setEnabled(false);
				}
				else
				{
					jbtEditBook.setEnabled(true);
				}
			}
		});
		
		I.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(I.getText().length() == 0)
				{
					jbtEditBook.setEnabled(false);
				}
				else
				{
					jbtEditBook.setEnabled(true);
				}
			}
		});
		
		G.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(G.getText().length() == 0)
				{
					jbtEditBook.setEnabled(false);
				}
				else
				{
					jbtEditBook.setEnabled(true);
				}
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting() == false)
					{
						if (list.getSelectedIndex() == -1 && choice ==-1)
						{
							//No selection.
							jbtEditBook.setEnabled(false);
						}
						else 
						{
							//Selection.
							jbtEditBook.setEnabled(true);
							choice = list.getSelectedIndex();
						}
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
            BookMenu bmenu = new BookMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtEditBook)) {
            //;EditBook
			JOptionPane.showMessageDialog(null,Books[list.getSelectedIndex()]);
        }
		
	}
	

	public static void main(String args [])
	{
		EditBook ebmenu = new EditBook();
	}
}