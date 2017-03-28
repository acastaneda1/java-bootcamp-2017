package Clase1OPP.ObserverExample;

public class Demo {
public static void main(String[] args) {
		
		WeatherStation weatherStation = new WeatherStation(33);
		
		WeatherCustomer1 wc1 = new WeatherCustomer1();
		WeatherCustomer2 wc2 = new WeatherCustomer2();
		weatherStation.addObserver(wc1);
		weatherStation.addObserver(wc2);
		
		weatherStation.setTemperature(34);
		
		weatherStation.removeObserver(wc1);
		
		weatherStation.setTemperature(35);
	}
}
