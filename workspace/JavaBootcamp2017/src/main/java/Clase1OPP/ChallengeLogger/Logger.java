package Clase1OPP.ChallengeLogger;

public class Logger implements LoggerObserver{
	public void update(LoggerStation operation){
		System.out.println("Executed " + operation.getQuery());
	}
}
