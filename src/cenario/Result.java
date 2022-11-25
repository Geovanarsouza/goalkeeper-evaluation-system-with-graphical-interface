package cenario;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Result extends JPanel{
	private JLabel label;
	
	public Result(){
		this.setBackground(Color.ORANGE);
		this.label=new JLabel();
	}
	
	public void setLabel(String s) {
		this.label.setText(s);
		add(this.label);
	}
	public void clearLabel() {
		this.label.setText(null);
	}
	
}
