package Clase1OPP.ChallengeLogger;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class LoggerStation implements LoggerSubj{

	private List<LoggerObserver> loggerObservers = new ArrayList<LoggerObserver>();
	String operation;

	public LoggerStation() {
		loggerObservers = new ArrayList<LoggerObserver>();
		this.operation = operation;
	}

	public void addObserver(LoggerObserver loggerObserver) {
		loggerObservers.add(loggerObserver);
	}

	public void removeObserver(LoggerObserver loggerObserver) {
		loggerObservers.remove(loggerObserver);
	}

	public void doNotify() {
		Iterator<LoggerObserver> it = loggerObservers.iterator();
		while (it.hasNext()) {
			LoggerObserver loggerObserver = it.next();
			loggerObserver.doUpdate(operation);
		}
	}
}
