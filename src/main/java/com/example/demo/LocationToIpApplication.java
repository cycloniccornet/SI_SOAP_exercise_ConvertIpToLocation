package com.example.demo;

import mypackage.GeoIPServiceLocator;
import mypackage.GeoIPServiceSoap_PortType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationToIpApplication {

    public	static	void	main(String[]	args)
    {
        String	country;
        String ip = "5.179.80.205";
        try
        {
            GeoIPServiceLocator locator	= new GeoIPServiceLocator();
            GeoIPServiceSoap_PortType service =	locator.getGeoIPServiceSoap();

            country	=	service.getIpLocation(ip);
            System.out.println(country);
        }
        catch	(javax.xml.rpc.ServiceException	ex)
        {
            ex.printStackTrace();
        }
        catch	(java.rmi.RemoteException	ex)
        {
            ex.printStackTrace();
        }
    }
}
