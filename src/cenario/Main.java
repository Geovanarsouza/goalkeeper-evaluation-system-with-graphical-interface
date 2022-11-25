package cenario;

public class Main {

	public static void main(String[] args) {
		Menu menu=new Menu();
//		Goal goal=new Goal();
		Window window=new Window(menu,menu.getGoal(),menu.getResult());
}
}