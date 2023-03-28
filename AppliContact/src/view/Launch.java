package view;

import controller.controller;

public class Launch {

	public static void main(String[] args) {

		View vue = new View();
		controller controleur1 = new controller(vue);
		try {
			vue.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
