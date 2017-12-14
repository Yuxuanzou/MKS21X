    
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class converter extends JFrame implements ActionListener{
    private Container pane;
    private JButton b;
    private JLabel l;
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
	
	b = new JButton("Do Nothing");
	t = new JTextField(12);
	c = new JCheckBox("Overclock!!!");
    
    b.addActionListener(this);
    t.addActionListener(this);
    c.addActionListener(this);
    
	pane.add(l);
	pane.add(b);
	pane.add(t);
	pane.add(c);
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	
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
