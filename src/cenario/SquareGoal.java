package cenario;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SquareGoal {
	private int line;
	private int column;
	private JButton button;
	private Types type;
	
	
	public SquareGoal(int line,int column) {
		this.column=column;
		this.line=line;
		this.type=checkType();
		this.button=createButton();
	}
	
	public JButton createButton() {
		JButton button=new JButton();
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				button.setIcon(new ImageIcon(new ImageIcon("img/bola.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
//			}
//		});
		if(type==Types.BEAM) {
			button.setBackground(Color.WHITE);
			button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}
		else if(type==Types.OUTSIDE) {
			button.setBackground(Color.GREEN);
			button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		}
		else {
			button.setBackground(Color.GREEN);
			button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		}
		return button;
	}
	
	public Types checkType() {
		if(line==0 || column==0 || column==16) {
			this.type=Types.OUTSIDE;
		}
		else if(line==1 || column==1 || column==15) {
			this.type=Types.BEAM;
		}
		else {
			this.type=Types.GOAL;
		}
		return type;
	}
	
	public int getLine() {
		return this.line;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public JButton getButton() {
		return this.button;
	}
	
	public Types getType() {
		return this.type;
	}
}
