import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffMenu extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtAddStaff;
	private JButton jbtRemoveStaff;
	private JButton jbtEx;
    private JPanel menu;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	
	public StaffMenu ()
	{
		this.setTitle("Staff Menu");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(50,50));
		TimeDate.setSize(40, 40);
        TimeDate.setLayout(new GridLayout(1,4));
		TimeDate.setBackground(new Color(182, 166, 18));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(5,1));
		
        jlblTime = new JLabel("Current Time: ", SwingConstants.CENTER);
        //jlblTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblTime.setSize(40, 40);
		jlblTime.setBackground(new Color(182, 166, 18));
        jlblTime.setForeground(Color.WHITE);
		
		jlblDate = new JLabel("Current Date: ", SwingConstants.CENTER);
        //jlblDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate.setSize(40, 40);
		jlblDate.setBackground(new Color(182, 166, 18));
        jlblDate.setForeground(Color.WHITE);
		
		Date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		jlblDate2 = new JLabel(Date, SwingConstants.CENTER);
        //jlblDate2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate2.setSize(40, 40);
		jlblDate2.setBackground(new Color(182, 166, 18));
        jlblDate2.setForeground(Color.WHITE);
        
        int sleepinterval = 1;
        ThreadedCurrentTime tc = new ThreadedCurrentTime(sleepinterval);
        tc.start();
        jpnlTime = tc.getPanelT();
        jpnlTime.setBackground(new Color(182, 166, 18));
		jpnlTime.setForeground(Color.WHITE);
		
		jbtBack = new JButton("Back");
        jbtBack.setPreferredSize(new Dimension(100, 100));
        jbtBack.addActionListener(this);
		jbtBack.setBackground(new Color(182, 166, 18));
		jbtBack.setForeground(Color.WHITE);
		jbtBack.setToolTipText("Click to go back to main menu");
		
		jbtAddStaff = new JButton("Add Staff");
        jbtAddStaff.setPreferredSize(new Dimension(100, 100));
        jbtAddStaff.addActionListener(this);
		jbtAddStaff.setBackground(new Color(182, 166, 18));
		jbtAddStaff.setForeground(Color.WHITE);
		jbtAddStaff.setToolTipText("Click to open add staff menu");
		
		jbtRemoveStaff = new JButton("Remove Staff");
        jbtRemoveStaff.setPreferredSize(new Dimension(100, 100));
        jbtRemoveStaff.addActionListener(this);
		jbtRemoveStaff.setBackground(new Color(182, 166, 18));
		jbtRemoveStaff.setForeground(Color.WHITE);
		jbtRemoveStaff.setToolTipText("Click to open remove staff menu");
		
		jbtEx = new JButton("Extra ?");
        jbtEx.setPreferredSize(new Dimension(100, 100));
        jbtEx.addActionListener(this);
		jbtEx.setBackground(new Color(182, 166, 18));
		jbtEx.setForeground(Color.WHITE);
		jbtEx.setToolTipText("Click to open ?");
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		menu.add(TimeDate);
		menu.add(jbtAddStaff);
		menu.add(jbtRemoveStaff);
		menu.add(jbtEx);
		menu.add(jbtBack);
		
		jbtBack.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtBack.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtBack.setBackground(new Color(182, 166, 18));
			}
		}
		);
		
		jbtAddStaff.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtAddStaff.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtAddStaff.setBackground(new Color(182, 166, 18));
			}
		}
		);
		
		jbtRemoveStaff.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtRemoveStaff.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtRemoveStaff.setBackground(new Color(182, 166, 18));
			}
		}
		);

		jbtEx.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtEx.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtEx.setBackground(new Color(182, 166, 18));
			}
		}
		);
		
        this.add(menu);
        this.pack();
        this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
        JButton source = (JButton) ae.getSource();
        if(source.equals(jbtBack)) {
            MainMenu menu = new MainMenu();
			this.setVisible(false);
        }

        if(source.equals(jbtAddStaff)) {
            //ManageBooksMenu();
        }
		
		if(source.equals(jbtRemoveStaff)) {
            //ManageStockMenu();
        }
		
		if(source.equals(jbtEx)) {
            //ManageStaffMenu();
        }
	}
	

	public static void main(String args [])
	{
		StaffMenu pmenu = new StaffMenu();
	}
}