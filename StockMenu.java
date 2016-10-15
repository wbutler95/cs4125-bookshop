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

public class StockMenu extends JFrame implements ActionListener
{
	private JButton jbtBack;
	private JButton jbtAddStock;
	private JButton jbtRemoveStock;
	private JButton jbtEx;
    private JPanel menu;
	private JLabel jlblTime;
	private JLabel jlblDate;
	private JPanel jpnlTime;
	private JLabel jlblDate2;
	private JPanel TimeDate;
	private String Date;
	
	public StockMenu ()
	{
		this.setTitle("Stock Menu");
        this.setBounds(100,100,500,300);
        this.setPreferredSize(new Dimension(500,500));
        this.setLayout(new GridLayout(1,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TimeDate = new JPanel();
        TimeDate.setBounds(new Rectangle(50,50));
		TimeDate.setSize(40, 40);
        TimeDate.setLayout(new GridLayout(1,4));
		TimeDate.setBackground(new Color(81, 158, 36));
        TimeDate.setForeground(Color.WHITE);
		
        menu = new JPanel();
        menu.setBounds(new Rectangle(100,100));
        menu.setLayout(new GridLayout(5,1));
		
        jlblTime = new JLabel("Current Time: ", SwingConstants.CENTER);
        //jlblTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblTime.setSize(40, 40);
		jlblTime.setBackground(new Color(81, 158, 36));
        jlblTime.setForeground(Color.WHITE);
		
		jlblDate = new JLabel("Current Date: ", SwingConstants.CENTER);
        //jlblDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate.setSize(40, 40);
		jlblDate.setBackground(new Color(81, 158, 36));
        jlblDate.setForeground(Color.WHITE);
		
		Date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		jlblDate2 = new JLabel(Date, SwingConstants.CENTER);
        //jlblDate2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlblDate2.setSize(40, 40);
		jlblDate2.setBackground(new Color(81, 158, 36));
        jlblDate2.setForeground(Color.WHITE);
        
        int sleepinterval = 1;
        ThreadedCurrentTime tc = new ThreadedCurrentTime(sleepinterval);
        tc.start();
        jpnlTime = tc.getPanelT();
        jpnlTime.setBackground(new Color(81, 158, 36));
		jpnlTime.setForeground(Color.WHITE);
		
		
		jbtBack = new JButton("Back");
        jbtBack.setPreferredSize(new Dimension(100, 100));
        jbtBack.addActionListener(this);
		jbtBack.setBackground(new Color(81, 158, 36));
		jbtBack.setForeground(Color.WHITE);
		jbtBack.setToolTipText("Click to go back to main menu");
		
		jbtAddStock = new JButton("Add Stock");
        jbtAddStock.setPreferredSize(new Dimension(100, 100));
        jbtAddStock.addActionListener(this);
		jbtAddStock.setBackground(new Color(81, 158, 36));
		jbtAddStock.setForeground(Color.WHITE);
		jbtAddStock.setToolTipText("Click to open add stock menu");
		
		jbtRemoveStock = new JButton("Remove Stock");
        jbtRemoveStock.setPreferredSize(new Dimension(100, 100));
        jbtRemoveStock.addActionListener(this);
		jbtRemoveStock.setBackground(new Color(81, 158, 36));
		jbtRemoveStock.setForeground(Color.WHITE);
		jbtRemoveStock.setToolTipText("Click to open remove stock menu");
		
		jbtEx = new JButton("Extra ?");
        jbtEx.setPreferredSize(new Dimension(100, 100));
        jbtEx.addActionListener(this);
		jbtEx.setBackground(new Color(81, 158, 36));
		jbtEx.setForeground(Color.WHITE);
		jbtEx.setToolTipText("Click to open ?");
		
		TimeDate.add(jlblTime);
		TimeDate.add(jpnlTime);
		TimeDate.add(jlblDate);
		TimeDate.add(jlblDate2);
		
		menu.add(TimeDate);
		menu.add(jbtAddStock);
		menu.add(jbtRemoveStock);
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
				jbtBack.setBackground(new Color(81, 158, 36));
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
				jbtAddStock.setBackground(new Color(81, 158, 36));
			}
		}
		);
		
		jbtRemoveStock.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseEntered(java.awt.event.MouseEvent evt)
			{
				jbtRemoveStock.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				jbtRemoveStock.setBackground(new Color(81, 158, 36));
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
				jbtEx.setBackground(new Color(81, 158, 36));
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

        if(source.equals(jbtAddStock)) {
            //ManageBooksMenu();
        }
		
		if(source.equals(jbtRemoveStock)) {
            //ManageStockMenu();
        }
		
		if(source.equals(jbtEx)) {
            //ManageStaffMenu();
        }
	}

	public static void main(String args [])
	{
		StockMenu smenu = new StockMenu();
	}
}