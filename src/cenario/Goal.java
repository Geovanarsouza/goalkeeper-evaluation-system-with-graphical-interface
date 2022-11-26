package cenario;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Goal extends JPanel{
	private ArrayList<SquareGoal> goal;
	private Goalkeeper goalkeeper;
	private ArrayList<SquareGoal> clearSquare;
	private int contClick;
	private int resultMachine;
	private int resultPlayer;
	private int resultLeftHand;
	private int resultRightHand;
	private int resultPosition;
	
	public Goal() {
		this.contClick=0;
		this.resultMachine=0;
		this.resultPlayer=0;
		this.resultLeftHand=0;
		this.resultRightHand=0;
		resultPosition=0;
		goal=new ArrayList<SquareGoal>();
		clearSquare=new ArrayList<SquareGoal>();
		this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout(9, 17));
		createGoal();
		createButtonsAndEvents();
	}
	
	public void createGoal() {
		for(int i=0;i<=8;i++) {
			for(int j=0;j<=16;j++) {
				goal.add(new SquareGoal(i,j));
			}
		}
	}
	
	public void createButtonsAndEvents() {
		for (SquareGoal square : goal) {
			square.getButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contClick++;
					clearGoal();
					paintButton();
					goalkeeper=new Goalkeeper();
					square.getButton().setIcon(new ImageIcon(new ImageIcon("img/bola.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
					if(square.getType()==Types.BEAM || square.getType()==Types.OUTSIDE) {
						square.getButton().setIcon(new ImageIcon(new ImageIcon("img/defesa.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
						resultMachine++;

					}
					else {
						for (SquareGoal squareGoal : goalkeeper.getOccupationArea()) {
							if(square.getLine()==squareGoal.getLine() && square.getColumn()==squareGoal.getColumn()) {
								square.getButton().setIcon(new ImageIcon(new ImageIcon("img/defesa.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
								resultMachine++;	
							}
						}
					}
					resultLeft(goalkeeper, square);
					resultRight(goalkeeper, square);
					resultPosition(goalkeeper,square);
					putIconsGoalkeeper(goalkeeper);
					paintOccupationArea(goalkeeper);
				}
			});
			add(square.getButton());
		}
	}
	
	public void putIconsGoalkeeper(Goalkeeper g) {
		for (SquareGoal square : goal) {
			if(square.getColumn()==goalkeeper.getLeftHand().getColumn()&& square.getLine()==goalkeeper.getLeftHand().getLine()) {
				square.getButton().setIcon(new ImageIcon(new ImageIcon("img/mão esquerda.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
				clearSquare.add(square);
			}
			if(square.getColumn()==goalkeeper.getRightHand().getColumn()&& square.getLine()==goalkeeper.getRightHand().getLine()) {
				square.getButton().setIcon(new ImageIcon(new ImageIcon("img/mão direita.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
				clearSquare.add(square);
			}
			if(square.getColumn()==goalkeeper.getPositionGoalkeeper().getColumn() && square.getLine()==goalkeeper.getPositionGoalkeeper().getLine()) {
				square.getButton().setIcon(new ImageIcon(new ImageIcon("img/goleiro.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				clearSquare.add(square);
			}
		}
	}
	
	public void clearGoal() {
		for (SquareGoal square1 : clearSquare) {
			for (SquareGoal square : goal) {
				if(square.getLine()==square1.getLine() && square.getColumn()==square1.getColumn()) {
					square.getButton().setIcon(null);
				}
			}
		}
	}
	
	public void clearAllButtons() {
		for (SquareGoal squareGoal : goal) {
			squareGoal.getButton().setIcon(null);
		}
	}
	
	public void paintButton() {
		for (SquareGoal squareGoal : goal) {
			if(squareGoal.getType()==Types.BEAM) {
				squareGoal.getButton().setBackground(Color.WHITE);
				squareGoal.getButton().setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			}
			else if(squareGoal.getType()==Types.OUTSIDE) {
				squareGoal.getButton().setBackground(Color.GREEN);
				squareGoal.getButton().setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}
			else {
				squareGoal.getButton().setBackground(Color.GREEN);
				squareGoal.getButton().setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			}
		}
	}
	
	public void paintOccupationArea(Goalkeeper g) {
		for (SquareGoal squareGoal : goal) {
			for (SquareGoal square : g.getOccupationArea()) {
				if(square.getLine()==squareGoal.getLine() && square.getColumn()==squareGoal.getColumn()) {
					squareGoal.getButton().setBackground(Color.pink);
				}
			}
		}
	}
	
	public void resultLeft(Goalkeeper g,SquareGoal s) {
			if(g.getLeftHand().getLine()==s.getLine() && g.getLeftHand().getColumn()==s.getColumn()) {
				this.resultLeftHand++;
			}
	}
	
	public void resultRight(Goalkeeper g,SquareGoal s) {
		if(g.getRightHand().getLine()==s.getLine() && g.getRightHand().getColumn()==s.getColumn()) {
			this.resultRightHand++;
		}
	}
	public void resultPosition(Goalkeeper g,SquareGoal s) {
		if(g.getPositionGoalkeeper().getLine()==s.getLine() && g.getPositionGoalkeeper().getColumn()==s.getColumn()) {
			this.resultPosition++;
		}
	}
	
	public int getResultMachine() {
		return resultMachine;
	}
	
	public int getResultPlayer() {
		this.resultPlayer=contClick-resultMachine;
		return resultPlayer;
	}
	
	public int getResultLeftHand() {
		return this.resultLeftHand;
	}
	
	public int getResultRightHand() {
		return this.resultRightHand;
	}
	public int getResultPosition() {
		return this.resultPosition;
	}
	
	public void setResultMachine() {
		this.resultMachine=0;
	}
	
	public void setContClick() {
		this.contClick=0;
	}
	
	public void setResultPlayer() {
		this.resultPlayer=0;
	}
	
	public void setResultLeftHand() {
		this.resultLeftHand=0;
	}
	
	public void setResultRightHand() {
		this.resultRightHand=0;
	}
	
	public void setResultPosition() {
		this.resultPosition=0;
	}
}

