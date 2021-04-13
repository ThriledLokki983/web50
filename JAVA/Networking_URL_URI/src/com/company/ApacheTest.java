package com.company;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Gideon Nimoh
 * Date: 4/13/21
 * Time: 7:11 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ApacheTest {

    public static void main(String[] args) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("Http://example.org");
        request.addHeader("User-Agent", "Chrome");

        CloseableHttpResponse response = response = httpClient.execute(request);
        try {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = inputStream.readLine()) != null){
                System.out.println(line);
            }
            inputStream.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            response.close();
        }
    }
}
