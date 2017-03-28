package Clase1OPP.ChallengeLogger;

public interface LoggerSubj {

	public void addObserver(LoggerObserver loggerObserver);
	
	public void removeObserver(LoggerObserver loggerObserver);
	
	public void doNotify();

}
