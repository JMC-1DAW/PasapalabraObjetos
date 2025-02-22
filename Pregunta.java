package pasapalabraObjetos;

public class Pregunta {

	private String pregunta;
	private String respuesta;
	private char letra;
	private char estado; // R = Right, W = Wrong, P = Pass (Not answered)
	
	Pregunta(String question, String answer, char letter){
		
		pregunta = question;
		respuesta = answer;
		letra = letter;
		estado = 'P';
		
	}
	
	boolean getQuestion() {
		
		 boolean showMe = false;
		
		if (estado == 'P') {
			System.out.println("Pregunta con " + letra + ": " + pregunta);
			showMe = true;
		}
		
		return showMe;
		
	}
	
	void answering(String answer) {
		
		if (answer.equals("Pasapalabra")) {
			System.out.println("Pasapalabra!");
			estado = 'P';
			System.out.println(" ");
		} else if (answer.equals(respuesta)) {
			System.out.println("Correcto!");
			estado = 'R';
			System.out.println(" ");
		} else {
			System.err.println("Incorrecto!");
			System.err.println("La respuesta era " + respuesta);
			estado = 'W';
			System.out.println(" ");
		}
		
	}
	
	boolean getResult () {
		
		boolean result = false;
		
		if (estado == 'R') {
			result = true;
		}
		
		return result;
	}
	
}
