package framesystem;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;

import lib.MySQL;




public class FrameSystemView extends Frame implements ActionListener,WindowListener

 {  
	private int[] id ;
	private String[] name ;
	private int[] weight;
	private int[] lenth;
	private Button button1 =new Button("平均体重"); 
	private TextField heikin1= new TextField("", 10);
	private Button button2 =new Button("平均身長"); 
	private TextField heikin2= new TextField("", 10);
    
   
	
    public void getdb(){
    	int i=0;
    	this.id=new int[100];
    	this.name=new String[255];
    	this.weight=new int[100];
    	this.lenth=new int[100];
       
    	MySQL last_kadai =new MySQL();
        ResultSet rs;
        rs = last_kadai.selectAll();
    	try {
			while(rs.next()){
				this.id[i] = rs.getInt("id");
				this.name[i] = rs.getString("name");
				this.weight[i]= rs.getInt("weight");
				this.lenth[i]=rs.getInt("lenth");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //try catchで囲む
    	
    	
    }
    public FrameSystemView(FrameSystemController controller) {
	// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("FrameSystem");
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		getdb();
		int i=0;
		ResultSet rs;
		MySQL last_kadai =new MySQL();
		rs = last_kadai.selectAll();
		try {
			while(rs.next()){
		    add(new Label("学籍番号 "+String.valueOf(id[i])+" 名前 "+name[i]+" 体重 "+String.valueOf(weight[i])+" 身長 "+String.valueOf(lenth[i])));
		    i++;
		
		   
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		add(button1);
        add(new Label("平均体重"));
        add(heikin1);
        button1.addActionListener(this);
        add(button2);
        add(new Label("平均身長"));
        add(heikin2);
        button2.addActionListener(this);	
				
			
   }

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    if(e.getSource() == button1){
		getdb();
		int i=0;
    	int val1 =0;
	    MySQL last_kadai =new MySQL();
        ResultSet rs;
        rs = last_kadai.selectAll();
    	try {
			while(rs.next()){
				this.weight[i]= rs.getInt("weight");
				val1+=this.weight[i];
				i++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  //try catchで囲む
    	heikin1.setText(String.valueOf(val1/i));
	  }
    else if(e.getSource() == button2){
		getdb();
		int i=0;
    	int val2 =0;
	    MySQL last_kadai =new MySQL();
        ResultSet rs;
        rs = last_kadai.selectAll();
    	try {
			while(rs.next()){
				this.lenth[i]= rs.getInt("lenth");
				val2+=this.lenth[i];
				i++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  //try catchで囲む
    	heikin2.setText(String.valueOf(val2/i));
	  }
     
    }
    	 


	

}
