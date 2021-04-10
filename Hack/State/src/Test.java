
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://indianrailapi.com/api/v2/PNRCheck/apikey/51408a9a238b6c1f1724a824efd8e207/PNRNumber/6811895716/"))
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
////        HttpRequest request = HttpRequest.newBuilder()
////                .uri(URI.create("https://api.postalpincode.in/pincode/110001"))
////                .method("GET", HttpRequest.BodyPublishers.noBody())
////                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://127.0.0.1:8000/api/userView"))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());
//        File > Invalidate Caches > Invalidate and Restart
//        fullUser id_traveller = "admin";
//        String ticket_category = "PNR";
//        String ticket_number = "3928479832";
//        String source = "delhi";
//        String dest = "agra";
//        String duration_days = "10";
//        String purpose = "random";
//
//        var values = new HashMap<String, String>() {{
////            put("id_traveller", id_traveller);
//            put("ticket_category", ticket_category);
//            put ("ticket_number", ticket_number);
//            put ("source", source);
//            put ("dest", dest);
//            put ("duration_days", duration_days);
//            put ("purpose", purpose);
//        }};
//
//        var objectMapper = new ObjectMapper();
//        String requestBody = objectMapper
//                .writeValueAsString(values);
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://127.0.0.1:8000/api/create"))
//                .setHeader("content-type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.body());

//        User user = new User("Abhishek","Keshri","abhishekkeshri@gmail.com","abhi","12345678");
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(user);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://127.0.0.1:8000/api/usernameCreate"))
//                .setHeader("content-type","application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
//                .build();
//        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://127.0.0.1:8000/api/userView/abhi/"))
//                .build();
//        HttpResponse response = client.send(request,HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
//        TravelRequest travelRequest = new TravelRequest();
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = null;
//        try {
//            jsonString = objectMapper.writeValueAsString(travelRequest);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request1 = HttpRequest.newBuilder()
//                .uri(URI.create("apiaddressgoeshere"))
//                .setHeader("content-type","application/json")
//                .setHeader("query",jsonString)
//                .build();
//
//           HttpResponse response1 = client.send(request1,HttpResponse.BodyHandlers.ofString());

//        System.out.println(jsonString);

    }
}
