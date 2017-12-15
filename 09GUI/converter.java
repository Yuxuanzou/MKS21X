    
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
    private ButtonGroup CandF = new ButtonGroup();
    private JRadioButton FtoC;
    private JRadioButton CtoF;
    
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
    //d = new JCheckBox("Convert to Celsius");
	//c = new JCheckBox("Convert to Fahrenheit");
    CtoF = new JRadioButton("Celsius to Fahrenheit");
    FtoC = new JRadioButton("Fahrenheit to Celsius");
    CandF.add(CtoF);
    CandF.add(FtoC);
    f.addActionListener(this);
    t.addActionListener(this);
    //c.addActionListener(this);
    //d.addActionListener(this);
    CtoF.addActionListener(this);
    FtoC.addActionListener(this);
	pane.add(f);
	pane.add(t);
    //pane.add(d);
	//pane.add(c);
    pane.add(CtoF);
    pane.add(FtoC);
    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
	    try{
            if (s.equals("do it")){
                if(FtoC.isSelected()){
                    t.setText(FtoC(Double.parseDouble(t.getText())) + "");
                }
                else if (CtoF.isSelected()){
                    t.setText(CtoF(Double.parseDouble(t.getText())) + "");
                }
            }
        } catch (NumberFormatException b){
            t.setText("Need a number");
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
