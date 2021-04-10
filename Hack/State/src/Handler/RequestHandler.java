package Handler;

import Helper.FullUser;
import Helper.User;
import Main.ClientMain;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    public User register_request(User user) throws IOException, InterruptedException {
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
        System.out.println(response.body());
        System.out.println(response.statusCode());
        int s = response.statusCode();
        System.out.println(s);
        if(s/100==4||s/100==5)
        {
            JOptionPane.showMessageDialog(null,response.body());
            return  null;
        }
        else
        {
            System.out.println("Success Login");

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            User user2 = mapper.readValue((response.body()),User.class);
            ClientMain.user = user2;
            this.create_fulluser();
            return user2;
//            return  null;
        }

//        return  null;

    }

    private void create_fulluser() throws IOException, InterruptedException {
        String username = ClientMain.user.getUsername();
        String name = ClientMain.user.getFirst_name()+" "+ClientMain.user.getLast_name();
        String email = ClientMain.user.getEmail();
        String phone_number = "";
//        String str= "2021-10-04";
//        java.sql.Date dob = null;
        String address_1 = "";
        String address_2 = "";
        String city = "";
        String state = "";
        String pincode = "";
        String education = "";
        String employment = "";
        Boolean married = false;
        System.out.println(username);
//        System.out.println(dob);
        FullUser fullUser = new FullUser(username,name,email,phone_number,address_1,address_2,city,state,pincode,education,employment,married);
        mapper = new ObjectMapper();
        jsonString = null;

        try {
            jsonString = mapper.writeValueAsString(fullUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//                  System.out.println(jsonString);

        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api/fullUserCreate"))
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

    }

    public User login_request(String username, String password) throws IOException, InterruptedException {
        mapper = new ObjectMapper();
        jsonString = null;
        var values = new HashMap<String,String>(){{
            put("username",username);
            put("password",password);

        }};

            jsonString = mapper.writeValueAsString(values);

//                  System.out.println(jsonString);
        System.out.println(jsonString);
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api2/login/"))
                .setHeader("content-type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();
        response = null;

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

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

    public void signout_request() throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request =  HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api2/logout/"))
                .header("Authorization","Token "+ClientMain.user.getToken())
                .method("POST",HttpRequest.BodyPublishers.noBody())
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }

    /**
     * @// TODO: 4/10/2021 deserialize jsonobject
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @throws JSONException
     */
    public FullUser fullUser_request() throws IOException, InterruptedException, JSONException {
        System.out.println(ClientMain.user.getToken());
        mapper = new ObjectMapper();
        client = HttpClient.newHttpClient();
        request =  HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api/fullUserView"))
                .header("Authorization","Token "+ClientMain.user.getToken())
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        if(response.statusCode()/100==4)
        {
            System.out.println("Error fetching full user");
            return  null;
        }
        System.out.println(response.body());

//        FullUser fullUser = mapper.readValue((response.body()),FullUser.class);
//        System.out.println(fullUser);
        ObjectMapper map = new ObjectMapper();
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String string = (String) response.body();
        JSONArray jsonArray = new JSONArray(string);
//        System.out.println(jsonObject);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String s = jsonObject.toString();
//        FullUser fullUser = map.convertValue(s,FullUser.class);
//        List<FullUser> fullUser = map.readValue((response.body()),FullUser.class);
        return null;
    }
}
