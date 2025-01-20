package pasapalabraObjetos;

import java.util.Scanner;

public class Pasapalabra_Main {

	private static final Scanner teclado = new Scanner(System.in);
	
	private static final int QUESTIONAMOUNT = 5;
	
	public static void main(String[] args) {

		//TODO (Añadir un temporizador)
		//TODO (Añadir todo el abecedario)
		
		Pregunta[] pasapalabra = new Pregunta[QUESTIONAMOUNT];
		
		pasapalabra[0] = new Pregunta("Ave de gran tamaño.", "Avestruz", 'A');
		pasapalabra[1] = new Pregunta("Mamífero pequeño recubierto de púas.", "Erizo", 'E');
		pasapalabra[2] = new Pregunta("Reptil normalmente mantenido como mascota.", "Iguana", 'I');
		pasapalabra[3] = new Pregunta("Mamífero de gran tamaño", "Oso", 'O');
		pasapalabra[4] = new Pregunta("Animal ficticio asociado con la magia.", "Unicornio", 'U');
		
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
