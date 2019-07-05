import javax.swing.JFrame;
import javax.swing.JTextField;
import jade.core.Agent;
public class Acheteur extends Agent{
	protected void setup() {
		Object[] ArgsVend = getArguments();
		Interface in = (Interface) ArgsVend[4];
		addBehaviour(new ComportementAch(this,in));
	}
}
