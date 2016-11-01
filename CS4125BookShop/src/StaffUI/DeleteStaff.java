package StaffUI;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import UICommon.ThreadedCurrentTime;

public class DeleteStaff extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtDeleteStaff;
    private JPanel menu;
	private JPanel buttons;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JScrollPane listScroller;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	private String staff [] = {"A","B","C","D","E","F","G","H","I","J","K","L"};
	private JList list;
	private int choice;
	
	public DeleteStaff()
	{
		this.setTitle("Delete Staff");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(1,1));
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
		
		jbtDeleteStaff = new JButton("Delete staff");
        jbtDeleteStaff.setPreferredSize(new Dimension(100, 100));
        jbtDeleteStaff.addActionListener(this);
		jbtDeleteStaff.setBackground(new Color(59, 89, 182));
        jbtDeleteStaff.setForeground(Color.WHITE);
		jbtDeleteStaff.setToolTipText("Click to delete staff selected from list");
		jbtDeleteStaff.setEnabled(false);
		
		list = new JList(staff);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(staff.length);
		list.setBackground(new Color(59, 89, 182));
		list.setForeground(Color.WHITE);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		buttons.add(jbtDeleteStaff);
		buttons.add(jbtBack);
		
		menu.add(TimeDate);
		menu.add(listScroller);
		menu.add(buttons);
		
		

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
		
		jbtDeleteStaff.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtDeleteStaff.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtDeleteStaff.setBackground(new Color(59, 89, 182));
			}
		}
		);
		
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (e.getValueIsAdjusting() == false)
					{
						if (list.getSelectedIndex() == -1 && choice ==-1)
						{
							//No selection.
							jbtDeleteStaff.setEnabled(false);
						}
						else 
						{
							//Selection.
							jbtDeleteStaff.setEnabled(true);
							choice = list.getSelectedIndex();
						}
					}
			}
		});
		
        this.add(menu);
        this.pack();
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{	
        JButton source = (JButton) ae.getSource();
        if(source.equals(jbtBack)) {
            StaffMenu smenu = new StaffMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtDeleteStaff)) {
            //DeleteStaff();
			JOptionPane.showMessageDialog(null,staff[list.getSelectedIndex()]);
        }
		
	}
	

	public static void main(String args [])
	{
		DeleteStaff dsmenu = new DeleteStaff();
	}
}