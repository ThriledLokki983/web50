package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=dogs");
            // URI uri = url.toURI();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(15000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: \t" + responseCode);
            if(responseCode != 200){
                System.out.println("Error reading web page ");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = inputStream.readLine()) != null){
                System.out.println(line);
            }
            inputStream.close();



/*            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()){
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("---------Key: " + "\t" + key);
                for (String string : value){
                    System.out.println("Value: " + "\t" + value);
                }
            }*//*
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
