import java.util.ArrayList;

import jade.core.Agent;

public class Vendeur extends Agent{
	private float VendPrixInit;
	private float VendPrixRes;
	private String Nom_Prod;
	private int  NbrItr;
	ArrayList<String>  ListeNomAcheteurs;
	protected void setup() { 
		Object[] ArgsVend = getArguments();
		VendPrixInit =Float.valueOf(String.valueOf(ArgsVend[0])).floatValue();
		VendPrixRes =Float.valueOf(String.valueOf(ArgsVend[1])).floatValue();
		Nom_Prod =String.valueOf(ArgsVend[2]);
		NbrItr=Integer.valueOf(String.valueOf(ArgsVend[3])).intValue();
		ListeNomAcheteurs= (ArrayList<String>) ArgsVend[4];
		Interface in = (Interface) ArgsVend[5];
		addBehaviour(new ComportementVend(this,in));
	}
	public float getVendPrixInit() {
		return VendPrixInit;
	}
	public void setVendPrixInit(float vendPrixInit) {
		VendPrixInit = vendPrixInit;
	}
	public float getVendPrixRes() {
		return VendPrixRes;
	}
	public void setVendPrixRes(float vendPrixRes) {
		VendPrixRes = vendPrixRes;
	}
	public String getNom_Prod() {
		return Nom_Prod;
	}
	public void setNom_Prod(String nom_Prod) {
		Nom_Prod = nom_Prod;
	}
	public int getNbrItr() {
		return NbrItr;
	}
	public void setNbrItr(int nbrItr) {
		NbrItr = nbrItr;
	}
	public ArrayList<String> getListeNomAcheteurs() {
		return ListeNomAcheteurs;
	}
	public void setListeNomAcheteurs(ArrayList<String> listeNomAcheteurs) {
		ListeNomAcheteurs = listeNomAcheteurs;
	}
}
