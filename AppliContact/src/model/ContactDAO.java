package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactDAO {
	private Connection conn;

	// Constructeur
	public ContactDAO() {
		conn = MaConnexion.getConnection();
	}

	public void ajouterContact(ContactModel contM) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"insert into contacts(nom_cont, prenom_cont, mail_cont, tel_cont) values (?,?,?,?)");

			preparedStatement.setString(1, contM.getNom());
			preparedStatement.setString(2, contM.getPrenom());
			preparedStatement.setString(3, contM.getMail());
			preparedStatement.setString(4, contM.getTel());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException : " + ex.getMessage());
			System.out.println("SQLState : " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}

	public void modifierContact(ContactModel contM, int contactID) {

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"update contacts set nom_cont = ?, prenom_cont= ?, mail_cont= ?, tel_cont= ? where id_cont = "
							+ contactID);

			preparedStatement.setString(1, contM.getNom());
			preparedStatement.setString(2, contM.getPrenom());
			preparedStatement.setString(3, contM.getMail());
			preparedStatement.setString(4, contM.getTel());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException : " + ex.getMessage());
			System.out.println("SQLState : " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}

	}

	public void supprimerContact(ContactModel contM, int contactID) {

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("delete from contacts where id_cont = " + contactID);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException : " + ex.getMessage());
			System.out.println("SQLState : " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}

	}

	public ArrayList<ContactModel> getAllContacts() {
		ArrayList<ContactModel> contMListe = new ArrayList<ContactModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from contacts order by id_cont");
			while (resultats.next()) {
				ContactModel contM = new ContactModel();
				contM.setId(resultats.getInt("id_cont"));
				contM.setNom(resultats.getString("nom_cont"));
				contM.setPrenom(resultats.getString("prenom_cont"));
				contM.setMail(resultats.getString("mail_cont"));
				contM.setTel(resultats.getString("tel_cont"));
				contMListe.add(contM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contMListe;
	}

	public ArrayList<ContactModel> getselectedContacts(String rechercher) {

		ArrayList<ContactModel> contMListe = new ArrayList<ContactModel>();
		try {
			Statement statement = conn.createStatement();
			String SQL = "select * from contacts where nom_cont = '" + rechercher + "' or prenom_cont = '" + rechercher
					+ "' or mail_cont = '" + rechercher + "' or tel_cont = '" + rechercher + "' order by id_cont";

			ResultSet resultats = statement.executeQuery(SQL);
			while (resultats.next()) {
				ContactModel contM = new ContactModel();
				contM.setId(resultats.getInt("id_cont"));
				contM.setNom(resultats.getString("nom_cont"));
				contM.setPrenom(resultats.getString("prenom_cont"));
				contM.setMail(resultats.getString("mail_cont"));
				contM.setTel(resultats.getString("tel_cont"));
				contMListe.add(contM);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contMListe;
	}

}
