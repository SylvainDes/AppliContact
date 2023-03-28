package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ContactDAO;
import model.ContactModel;
import view.View;

public class controller {

	private ContactModel modele;
	private View vue;
	private ContactDAO contactDao;
	private ArrayList<ContactModel> arrayContacts = null;

	public controller(View vue) {
		this.vue = vue;
		contactDao = new ContactDAO();
		arrayContacts = contactDao.getAllContacts();
		vue.getList().setListData(arrayContacts.toArray());
		initController();
	}

	public void initController() {
		vue.getBtn_Ajouter().addActionListener(ActionEvent -> ajouterContact());
		vue.getBtn_Effacer().addActionListener(ActionEvent -> effacer());
		vue.getList().addListSelectionListener(ActionEvent -> selectionnerContact());
		vue.getBtn_Modifier().addActionListener(ActionEvent -> modifierContact());
		vue.getBtn_Supprimer().addActionListener(ActionEvent -> supprimerContact());
		vue.getBtn_rechercher().addActionListener(ActionEvent -> rechercherContact());
	}

	private void ajouterContact() {

		String nom = vue.getTextField_nom().getText();
		String prenom = vue.getTextField_prenom().getText();
		String email = vue.getTextField_email().getText();
		String tel = vue.getTextField_tel().getText();

		modele = new ContactModel();
		modele.setNom(nom);
		modele.setPrenom(prenom);
		modele.setMail(email);
		modele.setTel(tel);
		contactDao.ajouterContact(modele);

		// actualiser Jlist

		arrayContacts = contactDao.getAllContacts();
		vue.getList().setListData(arrayContacts.toArray());

		// vue.getLblMessage().setText("Contact ajouté");
	}

	private void effacer() {

		vue.getTextField_nom().setText("");
		vue.getTextField_prenom().setText("");
		vue.getTextField_email().setText("");
		vue.getTextField_tel().setText("");
	}

	private void selectionnerContact() {

		int id = vue.getList().getSelectedIndex();
		if (id == -1)
			return;

		ContactModel modele = (ContactModel) arrayContacts.get(id);

		vue.getTextField_ID().setText(modele.getId() + "");
		vue.getTextField_nom().setText(modele.getNom());
		vue.getTextField_prenom().setText(modele.getPrenom());
		vue.getTextField_email().setText(modele.getMail());
		vue.getTextField_tel().setText(modele.getTel());

	}

	private void modifierContact() {

		int option = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier le contact ?");
		if (option == JOptionPane.OK_OPTION) {
			try {
				String id = vue.getTextField_ID().getText();
				int contactID = Integer.parseInt(id);
				String nom = vue.getTextField_nom().getText();
				String prenom = vue.getTextField_prenom().getText();
				String email = vue.getTextField_email().getText();
				String tel = vue.getTextField_tel().getText();

				modele = new ContactModel();
				modele.setId(contactID);
				modele.setNom(nom);
				modele.setPrenom(prenom);
				modele.setMail(email);
				modele.setTel(tel);
				contactDao.modifierContact(modele, contactID);

				arrayContacts = contactDao.getAllContacts();
				vue.getList().setListData(arrayContacts.toArray());

			} catch (NumberFormatException nfe) {
				return;
			}
		}
	}

	private void supprimerContact() {
		int option = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer le contact ?");
		if (option == JOptionPane.OK_OPTION) {

			String id = vue.getTextField_ID().getText();
			int contactID = Integer.parseInt(id);
			String nom = vue.getTextField_nom().getText();
			String prenom = vue.getTextField_prenom().getText();
			String email = vue.getTextField_email().getText();
			String tel = vue.getTextField_tel().getText();

			modele = new ContactModel();
			modele.setId(contactID);
			modele.setNom(nom);
			modele.setPrenom(prenom);
			modele.setMail(email);
			modele.setTel(tel);
			contactDao.supprimerContact(modele, contactID);

			arrayContacts = contactDao.getAllContacts();
			vue.getList().setListData(arrayContacts.toArray());

		}
	}

	private void rechercherContact() {

		String rechercher = vue.getTextField_rechercheContact().getText();

		arrayContacts = contactDao.getselectedContacts(rechercher);
		vue.getList().setListData(arrayContacts.toArray());

	}
}
