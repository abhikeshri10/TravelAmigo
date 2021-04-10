package Handler;


import Helper.TravelTable;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public List<TravelTable> inflow_request(String lowAge, String highAge, String startDate, String endDate, String purposee, String destState) throws IOException, InterruptedException, JSONException {
        String filter1 = "?lowAge="+lowAge;
        String filter2 = "&highAge="+highAge;
        String filter3 = "&startDate="+startDate;
        String filter4 = "&endDate="+endDate;
        String filter5 ="";
        String filter6 ="";
        if(purposee.length()!=0)
        {
            filter5 = "&purposee="+purposee;

        }
        if(destState.length()!=0)
        {
            filter6 = "&sourceState="+destState;
        }
        System.out.println(URI.create("http://127.0.0.1:8000/api/destStateView"+filter1+filter2+filter3+filter4+filter5+filter6));
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api/destStateView"+filter1+filter2+filter3+filter4+filter5+filter6))
                .header("Authorization","Token "+ClientMain.user.getToken())
                .build();
        response = null;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String string = response.body();
        System.out.println(string);
        JSONArray jsonArray = new JSONArray(string);
//        System.out.println(jsonArray);
        int n = jsonArray.length();
        List<TravelTable> travelTables = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String journey_date = jsonObject.getString("journey_date");
            String ticket_number = jsonObject.getString("ticket_number");
            String purpose = jsonObject.getString("purpose");
            Integer age = jsonObject.getInt("age");
            Integer duration_days = jsonObject.getInt("duration_days");
            String ticket_category = jsonObject.getString("ticket_category");
            String source_state = jsonObject.getString("source_state");
            TravelTable travelTable = new TravelTable(i+1,journey_date,ticket_number,purpose,age,duration_days,ticket_category,source_state);
            travelTables.add(travelTable);
        }
        return travelTables;

    }

    public List<TravelTable> outflow_request(String lowAge, String highAge, String startDate, String endDate, String purposee, String destState) throws JSONException, IOException, InterruptedException {
        String filter1 = "?lowAge="+lowAge;
        String filter2 = "&highAge="+highAge;
        String filter3 = "&startDate="+startDate;
        String filter4 = "&endDate="+endDate;
        String filter5 ="";
        String filter6 ="";
        if(purposee.length()!=0)
        {
            filter5 = "&purposee="+purposee;

        }
        if(destState.length()!=0)
        {
            filter6 = "&destState="+destState;
        }
        System.out.println(URI.create("http://127.0.0.1:8000/api/sourceStateView"+filter1+filter2+filter3+filter4+filter5+filter6));
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8000/api/sourceStateView"+filter1+filter2+filter3+filter4+filter5+filter6))
                .header("Authorization","Token "+ClientMain.user.getToken())
                .build();
        response = null;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String string = response.body();
        System.out.println(string);
        JSONArray jsonArray = new JSONArray(string);
//        System.out.println(jsonArray);
        int n = jsonArray.length();
        List<TravelTable> travelTables = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String journey_date = jsonObject.getString("journey_date");
            String ticket_number = jsonObject.getString("ticket_number");
            String purpose = jsonObject.getString("purpose");
            Integer age = jsonObject.getInt("age");
            Integer duration_days = jsonObject.getInt("duration_days");
            String ticket_category = jsonObject.getString("ticket_category");
            String source_state = jsonObject.getString("dest_state");
            TravelTable travelTable = new TravelTable(i+1,journey_date,ticket_number,purpose,age,duration_days,ticket_category,source_state);
            travelTables.add(travelTable);
        }
        return travelTables;
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
}
