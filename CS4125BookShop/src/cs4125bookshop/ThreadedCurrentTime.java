import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ThreadedCurrentTime extends Thread {
    
    private JPanel myPanelT;
    private JLabel myLabelT;
    private int sleepinterval;
    private String timestamp;
    
    public ThreadedCurrentTime(int s) {
        myPanelT = new JPanel();

        
		String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
		myLabelT = new JLabel(" ", SwingConstants.CENTER);
		myLabelT.setText(timestamp);
        //myLabelT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        myLabelT.setBackground(Color.BLACK);
		myLabelT.setForeground(Color.WHITE);
		
        myPanelT.setBounds(new Rectangle(40,40));
        myPanelT.setLayout(new BorderLayout());
        myPanelT.add(myLabelT, BorderLayout.CENTER);
		
        sleepinterval = s;
    }
    
    //Updates time as thread runs
    public void run()
	{
        while(true)
		{
			timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
			myLabelT.setText(timestamp);

             try {
                this.sleep(sleepinterval);
             } catch (Exception e){
            
            }
        }
    }
    
    //returns the panels that displays the time
    public JPanel getPanelT(){
        return myPanelT;
	}

}