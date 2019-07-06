import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import jade.core.Agent;
public class Acheteur extends Agent{
	private String Nom_Vend;
	private float VendPrixInit;
	private float Mise;
	private float  MaxPrix;
	private int NbrAch;
	String Newligne=System.getProperty("line.separator");
	protected void setup() {
		Object[] ArgsAch = getArguments();
		Nom_Vend =String.valueOf(ArgsAch[0]);
		VendPrixInit =Float.valueOf(String.valueOf(ArgsAch[1])).floatValue();
		Mise =Float.valueOf(String.valueOf(ArgsAch[2])).floatValue();
		MaxPrix=Float.valueOf(String.valueOf(ArgsAch[3])).floatValue();
		NbrAch=Integer.valueOf(String.valueOf(ArgsAch[5])).intValue();
		Interface in = (Interface) ArgsAch[4];
		System.out.println("je suis" +getLocalName()+" mon prix max est "+MaxPrix+" Dollars, Je suis pret pour l'enchere");
		addBehaviour(new ComportementAch(this,in));
	}
	public String getNom_Vend() {
		return Nom_Vend;
	}
	public void setNom_Vend(String nom_Vend) {
		Nom_Vend = nom_Vend;
	}
	public float getVendPrixInit() {
		return VendPrixInit;
	}
	public void setVendPrixInit(float vendPrixInit) {
		VendPrixInit = vendPrixInit;
	}
	public float getMise() {
		return Mise;
	}
	public void setMise(float mise) {
		Mise = mise;
	}
	public float getMaxPrix() {
		return MaxPrix;
	}
	public void setMaxPrix(float maxPrix) {
		MaxPrix = maxPrix;
	}
	public int getNbrAch() {
		return NbrAch;
	}
	public void setNbrAch(int nbrAch) {
		NbrAch = nbrAch;
	}
	
}
