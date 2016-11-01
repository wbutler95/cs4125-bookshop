package WarehouseUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import UICommon.ThreadedCurrentTime;

public class AddStoreStock extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtAddStock;
    private JPanel menu;
	private JPanel lists;
	private JPanel Listnames;
	private JPanel buttons;
	private JLabel blank1;
	private JLabel blank2;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JLabel jlblStore;
	private JLabel jlblBook;
	private JScrollPane listScroller;
	private JScrollPane listScroller2;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private JTextField M;
	private String Date;
	private String Books [] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String Stores [] = {"A","B","C","D","E","F","G","H","I","J","K","L"};
	private JList list;
	private JList list2;
	private int choice = -1;
	private int choice2 = -1;
	
	private String pattern = "[0-9]+";
	
	public AddStoreStock()
	{
		this.setTitle("Add Stock to Store");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(35, 132, 30));

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(500,500));
		TimeDate.setSize(100, 100);
        TimeDate.setLayout(new GridLayout(2,4));
		TimeDate.setBackground(new Color(35, 132, 30));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(3,1));
		
		lists = new JPanel();
        lists.setBounds(new Rectangle(100,100));
        lists.setLayout(new GridLayout(1,2));
		
		buttons = new JPanel();
        buttons.setBounds(new Rectangle(10,10));
        buttons.setLayout(new GridLayout(1,3));
		
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
		
		jlblBook = new JLabel("Choose Book: ", SwingConstants.CENTER);
        //jlblBook.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblBook.setSize(40, 40);
		jlblBook.setBackground(new Color(35, 132, 30));
        jlblBook.setForeground(Color.WHITE);
		
		blank1 = new JLabel(" ", SwingConstants.CENTER);
        //blank1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        blank1.setSize(40, 40);
		blank1.setBackground(new Color(35, 132, 30));
        blank1.setForeground(Color.WHITE);
		
		blank2 = new JLabel(" ", SwingConstants.CENTER);
        //blank2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        blank2.setSize(40, 40);
		blank2.setBackground(new Color(35, 132, 30));
        blank2.setForeground(Color.WHITE);
		
		jlblStore = new JLabel("Choose Store: ", SwingConstants.CENTER);
        //jlblStore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblStore.setSize(40, 40);
		jlblStore.setBackground(new Color(35, 132, 30));
        jlblStore.setForeground(Color.WHITE);
		
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
		
		jbtAddStock = new JButton("Add Stock");
        jbtAddStock.setPreferredSize(new Dimension(100, 100));
        jbtAddStock.addActionListener(this);
		jbtAddStock.setBackground(new Color(35, 132, 30));
        jbtAddStock.setForeground(Color.WHITE);
		jbtAddStock.setToolTipText("Click to add stock to store");
		jbtAddStock.setEnabled(false);
		
		list = new JList(Books);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(Books.length);
		list.setBackground(new Color(35, 132, 30));
		list.setForeground(Color.WHITE);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		list2 = new JList(Stores);
		list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list2.setVisibleRowCount(Stores.length);
		list2.setBackground(new Color(35, 132, 30));
		list2.setForeground(Color.WHITE);
		listScroller2 = new JScrollPane(list2);
		listScroller2.setPreferredSize(new Dimension(250, 80));
		
		
		M = new JTextField(50);
		M.setText("Enter Amount here:");
        M.setSize(40, 40);
		M.setBackground(new Color(35, 132, 30));
        M.setForeground(Color.WHITE);
		M.setHorizontalAlignment(SwingConstants.CENTER);
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		TimeDate.add(jlblBook);
		TimeDate.add(blank1);
		TimeDate.add(jlblStore);
		TimeDate.add(blank2);

		buttons.add(M);
		buttons.add(jbtAddStock);
		buttons.add(jbtBack);
		
		lists.add(listScroller);
		lists.add(listScroller2);
		
		menu.add(TimeDate);
		menu.add(lists);
		menu.add(buttons);
		
		

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
		
		jbtAddStock.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtAddStock.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtAddStock.setBackground(new Color(35, 132, 30));
			}
		}
		);
		
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting() == false)
					{
						if (list.getSelectedIndex() == -1 && choice2 !=-1)
						{
							//No selection.
							jbtAddStock.setEnabled(false);
						}
						else 
						{
							//Selection.
							jbtAddStock.setEnabled(true);
							choice = list.getSelectedIndex();
						}
					}
			}
		});
		
		list2.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting() == false)
					{
						if (list2.getSelectedIndex() == -1)
						{
							//No selection.
							jbtAddStock.setEnabled(false);
						}
						else 
						{
							//Selection.
							jbtAddStock.setEnabled(true);
							choice2 = list2.getSelectedIndex();
						}
					}
			}
		});
		
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
		
		M.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent e)
			{ //watch for key strokes
				if(M.getText().length() == 0)
				{
					jbtAddStock.setEnabled(false);
				}
				else if(!(M.getText().matches(pattern)))
				{
					jbtAddStock.setEnabled(false);
				}
				else
				{
					jbtAddStock.setEnabled(true);
				}
			}
		});
		
        this.add(menu);
		//this.add(lists);
        this.pack();
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{	
        JButton source = (JButton) ae.getSource();
        if(source.equals(jbtBack)) {
            WarehouseMainMenu wmenu = new WarehouseMainMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtAddStock)) {
            //BuyBook();
			JOptionPane.showMessageDialog(null,Books[choice]);
			JOptionPane.showMessageDialog(null,Stores[choice2]);
        }
		
	}
	

	public static void main(String args [])
	{
		AddStoreStock ssmenu = new AddStoreStock();
	}
}