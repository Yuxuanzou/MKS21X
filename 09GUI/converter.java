    
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class converter extends JFrame implements ActionListener{
    private Container pane;
    private JButton f;
    private JCheckBox d;
    private JTextField t;
    private JCheckBox c;
	//CONSTRUCTOR SETS EVERYTHING UP
    public converter() {
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	
	f = new JButton("do it");
	t = new JTextField(12);
    d = new JCheckBox("Convert to Celsius");
	c = new JCheckBox("Convert to Farenheit");
    
    f.addActionListener(this);
    t.addActionListener(this);
    c.addActionListener(this);
    d.addActionListener(this);
	pane.add(f);
	pane.add(t);
    pane.add(d);
	pane.add(c);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
	    if (s.equals("do it")){
            if(d.isSelected()){
                t.setText(FtoC(Double.parseDouble(t.getText())) + "");
            }
            else if (c.isSelected()){
                t.setText(CtoF(Double.parseDouble(t.getText())) + "");
            }
        }
    }
    
    public static double CtoF(double c){
	   return c*9.0 / 5.0 + 32;
    }
    
    public static double FtoC(double f){
	   return (f - 32) * 5.0 / 9.0;
    }

    public static void main(String[] args){
	converter g = new converter();
	g.setVisible(true);
    }
}
