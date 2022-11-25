package cenario;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame{
	public Window(Menu menu,Goal goal,Result result) {
		setLayout(new BorderLayout());
		add(menu,BorderLayout.NORTH);
		add(goal,BorderLayout.CENTER);
		add(result,BorderLayout.SOUTH);
		setSize(1400, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
