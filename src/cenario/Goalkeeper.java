package cenario;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Goalkeeper {
	private ArrayList<SquareGoal> occupationArea;
	private SquareGoal positionGoalkeeper;
	private SquareGoal leftHand;
	private SquareGoal rightHand;
	
	public Goalkeeper() {
		occupationArea=new ArrayList<SquareGoal>();
		positions();
		formArea();
	}
	
	public void positions() {
		Random rand=new Random();
		do{
			this.leftHand=new SquareGoal(rand.nextInt(0, 9),rand.nextInt(0,17));
			this.rightHand=new SquareGoal(rand.nextInt(0, 9),rand.nextInt(0,17));
		}while(this.leftHand.getColumn()>= rightHand.getColumn() );
		this.positionGoalkeeper=new SquareGoal(8,rand.nextInt(leftHand.getColumn(), rightHand.getColumn()+1));
		}
	
	public void formArea() {
		int leftLine=leftHand.getLine();
		int leftColumn=leftHand.getColumn();
		int rightLine=rightHand.getLine();
		int rightColumn=rightHand.getColumn();
		int line;
		int column=rightColumn-leftColumn+1;
		
		if(leftHand.getLine()<=rightHand.getLine()) {
			line=9-leftHand.getLine();
			for(int i=0;i<line;i++) {
				for(int j=0;j<column;j++) {
					SquareGoal q =new SquareGoal(leftLine,leftColumn);
					occupationArea.add(q);
					leftColumn++;
				}
				leftLine++;
				leftColumn=leftHand.getColumn();
			}
		}
		else {
			line=9-rightHand.getLine();
			leftLine=rightLine;
			for(int i=0;i<line;i++) {
				for(int j=0;j<column;j++) {
					SquareGoal q =new SquareGoal(leftLine,leftColumn);
					occupationArea.add(q);
					leftColumn++;
				}
				leftLine++;
				leftColumn=leftHand.getColumn();
			}
		}
	}
	
	public SquareGoal getLeftHand() {
		return this.leftHand;
	}
	
	public SquareGoal getRightHand() {
		return this.rightHand;
	}
	
	public ArrayList<SquareGoal> getOccupationArea(){
		return occupationArea;
	}
	
	public SquareGoal getPositionGoalkeeper() {
		return this.positionGoalkeeper;
	}
}
