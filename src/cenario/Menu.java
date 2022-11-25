package cenario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private Goal goal;
//	private JLabel label;
	private Result result2;
	
	public Menu() {
		goal=new Goal();
//		label=new JLabel();
		result2=new Result();
		setBackground(Color.lightGray);
		JButton result=new JButton("RESULTADO");
		result.setBackground(Color.ORANGE);
		result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				label.setText(showResult());
//				add(label);	
//				result2.setPrint(showResult());
				result2.setLabel(showResult());
			}
		});
		add(result);
		JButton novaPartida=new JButton("NOVA PARTIDA");
		novaPartida.setBackground(Color.ORANGE);
		novaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goal.clearAllButtons();
				goal.paintButton();
				goal.setResultMachine();
				goal.setResultPlayer();
				goal.setContClick();
				goal.setResultLeftHand();
				goal.setResultRightHand();
//				label.setText(null);
//				add(label);
				result2.clearLabel();
			}
		});
		add(novaPartida);
	}
	public String showResult() {
		String s="";
		s+="GOLS FEITOS:"+goal.getResultPlayer()+" ***** ";
		s+="GOLS DEFENDIDOS:"+goal.getResultMachine()+" ***** ";
		s+="CHUTE NA MÃO DIREITA:"+goal.getReturnRightHand()+" ***** ";
		s+="CHUTE NA MÃO ESQUERDA:"+goal.getResultLeftHand();
		return s;
	}
	
	public Goal getGoal() {
		return this.goal;
	}
	
	public Result getResult() {
		return this.result2;
	}
	
	
}
