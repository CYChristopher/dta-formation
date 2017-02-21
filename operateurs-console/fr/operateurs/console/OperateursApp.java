/**
 * 21 févr. 2017 Christopher CHARLERY
 */
package fr.operateurs.console;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Application Opérateurs
 * @author Christopher CHARLERY
 *
 */
public class OperateursApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double nombre1;
		double nombre2;
		String readLine;
		System.out.print("Veuillez saisir le premier nombre : ");
		readLine = new Scanner(System.in).nextLine();
		nombre1 = Double.parseDouble(readLine);
		
		System.out.print("Veuillez saisir le deuxième nombre : ");
		readLine = new Scanner(System.in).nextLine();
		nombre2 = Double.parseDouble(readLine);
		
		//Addition
		System.out.println(nombre1 + " + " + nombre2 + " = " + (nombre1 + nombre2));
		
		//Soustraction
		System.out.println(nombre1 + " - " + nombre2 + " = " + (nombre1 - nombre2));
		
		//Multiplication
		System.out.println(nombre1 + " * " + nombre2 + " = " + (nombre1 * nombre2));
		
		//Division
		System.out.println(nombre1 + " / " + nombre2 + " = " + (nombre1 / nombre2));
		
		//Modulo
		System.out.println(nombre1 + " % " + nombre2 + " = " + (nombre1 % nombre2));
	}

}
