package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URI base = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri = base.resolve(uri);

            URL url = resolvedUri.toURL();
            System.out.println("URL = " + url);

/*            System.out.println("Scheme: " + uri.getScheme() +
                    "\nScheme-specific part: " + uri.getSchemeSpecificPart() +
                    "\nAuthority: " + uri.getAuthority() +
                    "\nUser info: " + uri.getUserInfo() +
                    "\nHost: " + uri.getHost() +
                    "\nPort: " + uri.getPort() +
                    "\nPath: " + uri.getPath() +
                    "\nQuery: " + uri.getQuery() +
                    "\nFragment: " + uri.getFragment());*/
        }catch (URISyntaxException e){
            System.out.println(e.getMessage());
        }catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }
}
