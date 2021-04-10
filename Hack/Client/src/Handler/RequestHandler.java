package Handler;

import Helper.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class RequestHandler implements Runnable{
    public User user;

    private String username;
    private String password;
    String jsonString;
    ObjectMapper mapper;
    HttpClient client;
    HttpRequest request;
    HttpResponse<String> response;
    public RequestHandler() {
        Thread t = new Thread(this);
        t.start();
    }

    public RequestHandler(User user) {
        this.user = user;

        Thread t = new Thread(this);
        t.start();
    }

    public RequestHandler(String username, String password) {

        this.username = username;
        this.password = password;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

    }


    public User register_request(User user) throws JsonProcessingException {
        mapper = new ObjectMapper();
        jsonString = null;

        try {
            jsonString = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//                  System.out.println(jsonString);

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api2/register/"))
                .setHeader("content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(response.body());
        System.out.println(response.statusCode());
        int s = response.statusCode();
        if(s/100==4)
        {
            JOptionPane.showMessageDialog(null,response.body());
            return  null;
        }
        else
        {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            User user2 = mapper.readValue((response.body()),User.class);
            return user2;
        }


    }

    public User login_request(String username, String password) throws IOException {
        mapper = new ObjectMapper();
        jsonString = null;
        var values = new HashMap<String,String>(){{
            put("username",username);
            put("password",password);

        }};
        try {
            jsonString = mapper.writeValueAsString(values);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//                  System.out.println(jsonString);

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api2/login/"))
                .setHeader("content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        System.out.println(response.statusCode());
        int s = response.statusCode();
        if(s/100==4)
        {
            JOptionPane.showMessageDialog(null,response.body());
            return  null;
        }
        else
        {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            User user2 = mapper.readValue((response.body()),User.class);
            return user2;
        }

    }
}
