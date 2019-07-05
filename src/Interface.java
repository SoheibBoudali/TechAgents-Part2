import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField NomVendeur;
	private JTextField NomProduit;
	private JTextField Vend_Prix_Init;
	private JTextField Vend_Prix_Reserve;
	private JTextField nombre_itération;
	private JTextField Nbr_Acheteur;
	private JTextField Min_Mise;
	private JTextField Max_Mise;
	private JTextField Prix_Max_Min;
	private JTextField Prix_Max_Max;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Run = new JButton("Run >>");
		Run.setBackground(Color.DARK_GRAY);
		Run.setForeground(SystemColor.scrollbar);
		Run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Run();
			}
		});

		
		JLabel lblNewLabel = new JLabel("Enchere :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(60, 312, 74, 32);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Resultat :");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(60, 527, 74, 32);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 565, 535, 58);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Système d'enchère");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1.setBounds(306, 0, 448, 100);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblVendeur = new JLabel("Vendeur :");
		lblVendeur.setForeground(new Color(255, 255, 255));
		lblVendeur.setBounds(53, 97, 139, 15);
		contentPane.add(lblVendeur);
		
		JLabel lblProduit = new JLabel("Produit :\n");
		lblProduit.setForeground(new Color(255, 255, 255));
		lblProduit.setBounds(53, 153, 66, 15);
		contentPane.add(lblProduit);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(new Color(255, 255, 255));
		lblNom.setBounds(126, 174, 66, 15);
		contentPane.add(lblNom);
		
		JLabel lblPrixInitial = new JLabel("Prix initial :");
		lblPrixInitial.setForeground(new Color(255, 255, 255));
		lblPrixInitial.setBounds(126, 212, 129, 15);
		contentPane.add(lblPrixInitial);
		
		JLabel lblPrixDeReserve = new JLabel("Prix de reserve :");
		lblPrixDeReserve.setForeground(new Color(255, 255, 255));
		lblPrixDeReserve.setBounds(123, 252, 114, 15);
		contentPane.add(lblPrixDeReserve);
		
		NomVendeur = new JTextField();
		NomVendeur.setText("Mika\n");
		NomVendeur.setBounds(152, 107, 186, 19);
		contentPane.add(NomVendeur);
		NomVendeur.setColumns(10);
		
		
		NomProduit = new JTextField();
		NomProduit.setText("Voiture");
		NomProduit.setColumns(10);
		NomProduit.setBounds(191, 172, 186, 19);
		contentPane.add(NomProduit);
		
		Vend_Prix_Init = new JTextField();
		Vend_Prix_Init.setText("100\n");
		Vend_Prix_Init.setColumns(10);
		Vend_Prix_Init.setBounds(227, 210, 186, 19);
		contentPane.add(Vend_Prix_Init);
		
		Vend_Prix_Reserve = new JTextField();
		Vend_Prix_Reserve.setText("10000");
		Vend_Prix_Reserve.setColumns(10);
		Vend_Prix_Reserve.setBounds(255, 250, 186, 19);
		contentPane.add(Vend_Prix_Reserve);
		
		JLabel lblMaxIter = new JLabel("Nombre d'itération:");
		lblMaxIter.setForeground(new Color(255, 255, 255));
		lblMaxIter.setBounds(60, 279, 139, 15);
		contentPane.add(lblMaxIter);
		
		nombre_itération = new JTextField();
		nombre_itération.setText("0");
		nombre_itération.setColumns(10);
		nombre_itération.setBounds(217, 287, 96, 19);
		contentPane.add(nombre_itération);
		
		Nbr_Acheteur = new JTextField();
		Nbr_Acheteur.setText("5");
		Nbr_Acheteur.setColumns(10);
		Nbr_Acheteur.setBounds(815, 95, 66, 19);
		contentPane.add(Nbr_Acheteur);
		
		JLabel lblNombreDacheteurs = new JLabel("Nombre d'acheteurs :");
		lblNombreDacheteurs.setForeground(new Color(255, 255, 255));
		lblNombreDacheteurs.setBounds(637, 97, 186, 15);
		contentPane.add(lblNombreDacheteurs);
		
		JLabel lblLaMise = new JLabel("La mise :");
		lblLaMise.setForeground(new Color(255, 255, 255));
		lblLaMise.setBounds(637, 145, 186, 15);
		contentPane.add(lblLaMise);
		
		Min_Mise = new JTextField();
		Min_Mise.setText("100");
		Min_Mise.setColumns(10);
		Min_Mise.setBounds(688, 172, 66, 19);
		contentPane.add(Min_Mise);
		
		Max_Mise = new JTextField();
		Max_Mise.setText("200");
		Max_Mise.setColumns(10);
		Max_Mise.setBounds(873, 172, 66, 19);
		contentPane.add(Max_Mise);
		
		Prix_Max_Min = new JTextField();
		Prix_Max_Min.setText("15000");
		Prix_Max_Min.setColumns(10);
		Prix_Max_Min.setBounds(688, 262, 66, 19);
		contentPane.add(Prix_Max_Min);
		
		Prix_Max_Max = new JTextField();
		Prix_Max_Max.setText("20000");
		Prix_Max_Max.setColumns(10);
		Prix_Max_Max.setBounds(873, 262, 66, 19);
		contentPane.add(Prix_Max_Max);
		
		JLabel lblMaximum = new JLabel("Prix Max :");
		lblMaximum.setForeground(new Color(255, 255, 255));
		lblMaximum.setBounds(637, 223, 186, 15);
		contentPane.add(lblMaximum);
		
		JLabel lblMin = new JLabel("Min :");
		lblMin.setForeground(new Color(255, 255, 255));
		lblMin.setBounds(621, 163, 66, 15);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Max :");
		lblMax.setForeground(new Color(255, 255, 255));
		lblMax.setBounds(802, 163, 66, 15);
		contentPane.add(lblMax);
		
		JLabel lblMin_1 = new JLabel("Min :\n");
		lblMin_1.setForeground(new Color(255, 255, 255));
		lblMin_1.setBounds(621, 252, 66, 15);
		contentPane.add(lblMin_1);
		
		JLabel lblMax_1 = new JLabel("Max :\n");
		lblMax_1.setForeground(new Color(255, 255, 255));
		lblMax_1.setBounds(802, 250, 66, 15);
		contentPane.add(lblMax_1);
		
		JTextArea Execution = new JTextArea();
		Execution.setEnabled(false);
		Execution.setLineWrap(true);
		Execution.setBounds(152, 336, 787, 177);
		contentPane.add(Execution);

		JScrollPane scrollPane = new JScrollPane(Execution);
		scrollPane.setBounds(152, 336, 787, 177);
		contentPane.add(scrollPane);
		
		Run.setBounds(857, 581, 114, 25);
		contentPane.add(Run);
	}

	protected void Run() {
		Runtime runtime = Runtime.instance();
		ProfileImpl profile = new ProfileImpl();
		ContainerController CC = runtime.createMainContainer(profile);
		ArrayList<AgentController> acheteurs = new ArrayList<AgentController>();
		ArrayList<String> ListeNomAcheteurs = new ArrayList<String>();
		
		String Nom_Vend = NomVendeur.getText();
		
		String Nom_Prod = NomProduit.getText();
		float VendPrixInit = Float.valueOf(Vend_Prix_Init.getText()).floatValue();
		float VendPrixRes = Float.valueOf(Vend_Prix_Reserve.getText()).floatValue();
		
		Integer NbrItr = Integer.valueOf(nombre_itération.getText()).intValue();
		
		int NbrAch = Integer.valueOf(Nbr_Acheteur.getText()).intValue();	
		float MinMise = Float.valueOf(Min_Mise.getText()).floatValue();
		float MaxMise = Integer.valueOf(Max_Mise.getText()).floatValue();
		float Mise;
		
		float MaxPrixMin = Float.valueOf(Prix_Max_Min.getText()).floatValue();
		float MaxPrixMax = Float.valueOf(Prix_Max_Max.getText()).floatValue();
		float MaxPrix;
		
		int j= 1;
		for (int i = 0; i < NbrAch ; i++) {
			Mise =   (float) Math.floor(Math.random() * (MaxMise - MinMise) + MinMise);
			MaxPrix =  (float) Math.floor(Math.random() * (MaxPrixMax - MaxPrixMin) + MaxPrixMin);
			
			Object[] Argument_Ach =new Object[5];
			Argument_Ach[0]= Nom_Vend;
			Argument_Ach[1]= VendPrixInit;
			Argument_Ach[2]= Mise;
			Argument_Ach[3]= MaxPrix;
			Argument_Ach[4]= this;
			
			if(VendPrixInit < MaxPrix) {
				ListeNomAcheteurs.add("Ach"+j);
				try {
					acheteurs.add(CC.createNewAgent("Ach"+j,"Acheteur",Argument_Ach));
				} catch (StaleProxyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				j++;
			}
		}
		
		for (int i = 0; i < acheteurs.size(); i++) {
			try {
				acheteurs.get(i).start();
			} catch (StaleProxyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Object[] Argument_Vend = new Object[6];	
		Argument_Vend[0]=VendPrixInit;
		Argument_Vend[1]=VendPrixRes;
		Argument_Vend[2]=Nom_Prod;
		Argument_Vend[3]=NbrItr;
		Argument_Vend[4]=ListeNomAcheteurs;
		Argument_Vend[5]=this;
		
		AgentController Vendeur;
		try {
			Vendeur = CC.createNewAgent(Nom_Vend, "Vendeur" , Argument_Vend);
			Vendeur.start();
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getNomVendeur() {
		return NomVendeur;
	}

	public void setNomVendeur(JTextField nomVendeur) {
		NomVendeur = nomVendeur;
	}

	public JTextField getNomProduit() {
		return NomProduit;
	}

	public void setNomProduit(JTextField nomProduit) {
		NomProduit = nomProduit;
	}

	public JTextField getVend_Prix_Init() {
		return Vend_Prix_Init;
	}

	public void setVend_Prix_Init(JTextField vend_Prix_Init) {
		Vend_Prix_Init = vend_Prix_Init;
	}

	public JTextField getVend_Prix_Reserve() {
		return Vend_Prix_Reserve;
	}

	public void setVend_Prix_Reserve(JTextField vend_Prix_Reserve) {
		Vend_Prix_Reserve = vend_Prix_Reserve;
	}

	public JTextField getNombre_itération() {
		return nombre_itération;
	}

	public void setNombre_itération(JTextField nombre_itération) {
		this.nombre_itération = nombre_itération;
	}

	public JTextField getNbr_Acheteur() {
		return Nbr_Acheteur;
	}

	public void setNbr_Acheteur(JTextField nbr_Acheteur) {
		Nbr_Acheteur = nbr_Acheteur;
	}

	public JTextField getMin_Mise() {
		return Min_Mise;
	}

	public void setMin_Mise(JTextField min_Mise) {
		Min_Mise = min_Mise;
	}

	public JTextField getMax_Mise() {
		return Max_Mise;
	}

	public void setMax_Mise(JTextField max_Mise) {
		Max_Mise = max_Mise;
	}

	public JTextField getPrix_Max_Min() {
		return Prix_Max_Min;
	}

	public void setPrix_Max_Min(JTextField prix_Max_Min) {
		Prix_Max_Min = prix_Max_Min;
	}

	public JTextField getPrix_Max_Max() {
		return Prix_Max_Max;
	}

	public void setPrix_Max_Max(JTextField prix_Max_Max) {
		Prix_Max_Max = prix_Max_Max;
	}
	
}
