import java.util.ArrayList;

import javax.swing.JFrame;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class ComportementVend extends Behaviour{
	Vendeur vendeur;	
	Interface in ;
	public static int cpt =1;
	public static float prix;
	public float receive ;
	public ComportementVend(Vendeur agent , Interface in ) {
		this.in=in;
		this.vendeur=agent;
		prix=vendeur.getVendPrixInit();
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage Amsg ;cpt++;
		while((Amsg=vendeur.receive())==null);
		receive= Float.valueOf(Amsg.getContent()).floatValue();
		while(cpt <vendeur.getListeNomAcheteurs().size())
		if(prix< receive) {
			prix=receive;
		}
		System.out.println("nv prix"+prix);
			/*if(prix< receive) 
				prix = receive;
		System.out.println("le nv prix est "+prix);
		cpt=0;
		
		/*cpt++;
		while(cpt<Liste_Ach.size());
		if(this.prix_init< Float.valueOf(Amsg.getContent()).floatValue()) {
			this.prix_init =Float.valueOf(Amsg.getContent()).floatValue();
		}
		if(Amsg.getContent().equals("-1")) {
			for (int i = 0; i < Liste_Ach.size() ;i++) {
				if(Liste_Ach.get(i).equals(Amsg.getSender().getLocalName())) {
					Liste_Ach.remove(i);
				}
			}
		}
		int i=0;
		for ( i = 0; i < Liste_Ach.size(); i++) {
			ACLMessage Vmsg =new ACLMessage(ACLMessage.INFORM);
			Vmsg.addReceiver(new AID(Liste_Ach.get(i),AID.ISLOCALNAME));
			Vmsg.setContent(String.valueOf(this.prix_init));
			vendeur.send(Vmsg);
		}
		cpt=0;
		if(i==0) {
			System.out.println("Produit non vendu");
			vendeur.doDelete();
		}
		if(i==1 && this.prix_reserve < this.prix_init) {
			System.out.println("Produit vendu");
			vendeur.doDelete();
		}*/
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub

		return false;
	}

}
