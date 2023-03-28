package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {

	public JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_email;
	private JTextField textField_tel;
	private JTextField textField_rechercheContact;
	private JTextField textField_ID;

	private JButton btn_Ajouter;
	private JButton btn_Modifier;
	private JButton btn_Effacer;
	private JButton btn_Supprimer;
	private JButton btn_rechercher;

	private JList list_contact;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { View window = new View();
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 * 
	 * /** Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 516, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel donneesContact = new JPanel();
		donneesContact.setToolTipText("");
		donneesContact.setBorder(BorderFactory.createTitledBorder("Les données de contact :"));
		donneesContact.setBounds(10, 10, 228, 154);
		frame.getContentPane().add(donneesContact);
		donneesContact.setLayout(null);

		JLabel ID = new JLabel("ID :");
		ID.setBounds(10, 23, 45, 13);
		donneesContact.add(ID);

		JLabel Nom = new JLabel("Nom :");
		Nom.setBounds(10, 46, 45, 13);
		donneesContact.add(Nom);

		JLabel Prenom = new JLabel("Prénom :");
		Prenom.setBounds(10, 69, 45, 13);
		donneesContact.add(Prenom);

		JLabel Email = new JLabel("EMail :");
		Email.setBounds(10, 92, 45, 13);
		donneesContact.add(Email);

		JLabel Tel = new JLabel("Tel :");
		Tel.setBounds(10, 115, 45, 13);
		donneesContact.add(Tel);

		textField_nom = new JTextField();
		textField_nom.setBounds(84, 43, 134, 19);
		donneesContact.add(textField_nom);
		textField_nom.setColumns(10);

		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(84, 66, 134, 19);
		donneesContact.add(textField_prenom);

		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(84, 89, 134, 19);
		donneesContact.add(textField_email);

		textField_tel = new JTextField();
		textField_tel.setColumns(10);
		textField_tel.setBounds(84, 112, 134, 19);
		donneesContact.add(textField_tel);

		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setColumns(10);
		textField_ID.setBounds(84, 20, 134, 19);
		donneesContact.add(textField_ID);

		JPanel panel_contactList = new JPanel();
		panel_contactList.setBorder(BorderFactory.createTitledBorder("Liste des contacts :"));
		panel_contactList.setBounds(247, 10, 247, 265);
		frame.getContentPane().add(panel_contactList);
		panel_contactList.setLayout(null);

		list_contact = new JList();
		list_contact.setBounds(10, 22, 227, 233);
		panel_contactList.add(list_contact);

		btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.setBounds(20, 174, 89, 31);
		frame.getContentPane().add(btn_Ajouter);

		btn_Modifier = new JButton("Modifier");
		btn_Modifier.setBounds(126, 174, 89, 31);
		frame.getContentPane().add(btn_Modifier);

		btn_Effacer = new JButton("Effacer");
		btn_Effacer.setBounds(20, 215, 89, 31);
		frame.getContentPane().add(btn_Effacer);

		btn_Supprimer = new JButton("Supprimer");
		btn_Supprimer.setBounds(126, 215, 89, 31);
		frame.getContentPane().add(btn_Supprimer);

		JLabel lblRechercher = new JLabel("Rechercher un contact");
		lblRechercher.setBounds(20, 286, 146, 13);
		frame.getContentPane().add(lblRechercher);

		textField_rechercheContact = new JTextField();
		textField_rechercheContact.setBounds(13, 308, 391, 20);
		frame.getContentPane().add(textField_rechercheContact);
		textField_rechercheContact.setColumns(10);

		btn_rechercher = new JButton("Rechercher");
		btn_rechercher.setBounds(409, 308, 85, 21);
		frame.getContentPane().add(btn_rechercher);
	}

	public JTextField getTextField_rechercheContact() {
		return textField_rechercheContact;
	}

	public JTextField getTextField_ID() {
		return textField_ID;
	}

	public JButton getBtn_Ajouter() {
		return btn_Ajouter;
	}

	public void setBtn_Ajouter(JButton btn_Ajouter) {
		this.btn_Ajouter = btn_Ajouter;
	}

	public JList getList() {
		return list_contact;
	}

	public void setList(JList list_contact) {
		this.list_contact = list_contact;
	}

	public JTextField getTextField_nom() {
		return textField_nom;
	}

	public void setTextField_nom(JTextField textField_nom) {
		this.textField_nom = textField_nom;
	}

	public JTextField getTextField_prenom() {
		return textField_prenom;
	}

	public void setTextField_prenom(JTextField textField_prenom) {
		this.textField_prenom = textField_prenom;
	}

	public JTextField getTextField_email() {
		return textField_email;
	}

	public void setTextField_email(JTextField textField_email) {
		this.textField_email = textField_email;
	}

	public JTextField getTextField_tel() {
		return textField_tel;
	}

	public void setTextField_tel(JTextField textField_tel) {
		this.textField_tel = textField_tel;
	}

	public JButton getBtn_Modifier() {
		return btn_Modifier;
	}

	public void setBtn_Modifier(JButton btn_Modifier) {
		this.btn_Modifier = btn_Modifier;
	}

	public JButton getBtn_Effacer() {
		return btn_Effacer;
	}

	public void setBtn_Effacer(JButton btn_Effacer) {
		this.btn_Effacer = btn_Effacer;
	}

	public JButton getBtn_Supprimer() {
		return btn_Supprimer;
	}

	public void setBtn_Supprimer(JButton btn_Supprimer) {
		this.btn_Supprimer = btn_Supprimer;
	}

	public JButton getBtn_rechercher() {
		return btn_rechercher;
	}

	public void setBtn_rechercher(JButton btn_rechercher) {
		this.btn_rechercher = btn_rechercher;
	}

}
