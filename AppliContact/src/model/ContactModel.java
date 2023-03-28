package model;

public class ContactModel {

	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String tel;

	// constructeur pour initialiser

	public ContactModel() {
		id = 0;
		nom = "";
		prenom = "";
		mail = "";
		tel = "";
	}

	public String toString() {
		return id + " " + nom + " " + prenom + " " + mail + " " + tel;
	}

	public ContactModel(int id, String nom, String prenom, String mail, String tel) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
