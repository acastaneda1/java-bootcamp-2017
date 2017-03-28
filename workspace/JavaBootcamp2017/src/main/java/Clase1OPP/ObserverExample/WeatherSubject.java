package Clase1OPP.ObserverExample;

public interface WeatherSubject {

	public void addObserver(WeatherObserver weatherObserver);

	public void removeObserver(WeatherObserver weatherObserver);

	public void doNotify();

}
