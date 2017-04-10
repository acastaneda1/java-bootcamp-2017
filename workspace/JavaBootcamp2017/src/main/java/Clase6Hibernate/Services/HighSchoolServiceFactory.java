package Clase6Hibernate.Services;

import Clase6Hibernate.ServicesImp.HighSchoolServiceImp;

public class HighSchoolServiceFactory {

	public static HighSchoolServiceImp getService(){  
        return new HighSchoolServiceImp ();  
	}
}
