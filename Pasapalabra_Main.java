package pasapalabraObjetos;

import java.util.Random;
import java.util.Scanner;

public class Pasapalabra_Main {

	private static final Scanner teclado = new Scanner(System.in);
	
	private static final QuestionBundle preguntas = new QuestionBundle();
	
	private static final Random BUNDLE = new Random();
	
	private static final int QUESTIONAMOUNT = 26;
	
	public static void main(String[] args) {

		//TODO (Añadir un temporizador)
		
		Pregunta[] pasapalabra = new Pregunta[QUESTIONAMOUNT];
		
		int bundleChoice;
		
		for (int i = 0; i < QUESTIONAMOUNT; i++) {
			bundleChoice = BUNDLE.nextInt(3) + 1;
			
			if (bundleChoice == 1) {
				pasapalabra[i] = new Pregunta(preguntas.qBundle1[i], preguntas.aBundle1[i], preguntas.alphabet[i]);
			} else if (bundleChoice == 2) {
				pasapalabra[i] = new Pregunta(preguntas.qBundle2[i], preguntas.aBundle2[i], preguntas.alphabet[i]);
			} else if (bundleChoice == 3) {
				pasapalabra[i] = new Pregunta(preguntas.qBundle3[i], preguntas.aBundle3[i], preguntas.alphabet[i]);
			}
			
		}
		
		String answer;
		int answereds = 0;
		int rights = 0;
		int wrongs = 0;
		int question = 0;
		
		do {
			
			if(pasapalabra[question].getQuestion()) {
				answer = teclado.next();
				pasapalabra[question].answering(answer);
				if (!answer.equals("Pasapalabra")) {
					answereds++;
				}
			}
			
			question++;
			
			if (question == QUESTIONAMOUNT) {
				question = 0;
			}
			
		} while (answereds != QUESTIONAMOUNT);
		
		for (int i = 0; i < QUESTIONAMOUNT; i++) {
			if (pasapalabra[i].getResult()) {
				rights++;
			} else {
				wrongs++;
			}
		}
		
		System.out.println(" ");
		System.out.println("[====================]");
		System.out.println("[ PASAPALABRA! ]");
		System.out.println("Correctas = " + rights + " / Incorrectas = " + wrongs);
		
	}

}
