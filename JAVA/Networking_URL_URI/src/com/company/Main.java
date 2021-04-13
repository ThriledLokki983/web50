package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");
            // URI uri = url.toURI();
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

/*
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";
            while (line!=null){
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();
*//*

            URI base = new URI("http://username:password@mynewserver.com:5000");

            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?os=manufacturer#samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");
            URI resolvedUri1 = base.resolve(uri1);
            URI resolvedUri2 = base.resolve(uri2);
            URI resolvedUri3 = base.resolve(uri3);


            URL url1 = resolvedUri1.toURL();
            URL url2 = resolvedUri2.toURL();
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 1 = " + url1);
            System.out.println("URL 2 = " + url2);
            System.out.println("URL 3 = " + url3);

            URI relative = base.relativize(resolvedUri2);
            System.out.println("Relative URI: = " + relative);



           System.out.println("Scheme: " + uri.getScheme() +
                    "\nScheme-specific part: " + uri.getSchemeSpecificPart() +
                    "\nAuthority: " + uri.getAuthority() +
                    "\nUser info: " + uri.getUserInfo() +
                    "\nHost: " + uri.getHost() +
                    "\nPort: " + uri.getPort() +
                    "\nPath: " + uri.getPath() +
                    "\nQuery: " + uri.getQuery() +
                    "\nFragment: " + uri.getFragment());*/
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
