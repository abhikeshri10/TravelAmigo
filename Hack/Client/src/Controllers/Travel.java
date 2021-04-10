package Controllers;

import Handler.RequestHandler;
import Helper.TravelAdd;
import Main.ClientMain;
import Main.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Travel implements Initializable {

    public TextField sourceTF;
    public TextField destTF;
    public ComboBox purposeCB;
    public Spinner durationSP;
    public CheckBox personal;
    public CheckBox declareChB;
    public Button saveBT;
    public ComboBox destStateCB;
    public ComboBox sourceStateCB;
    public ComboBox ticketTypeCB;
    public TextField ticketNumberTF;
    public Spinner ageSP;
    public DatePicker datePicker;
    public TextField ageTF;
    public TextField durationTF;

    public void addTravel(ActionEvent event) throws IOException, InterruptedException {
            String ticket_type = ticketTypeCB.getSelectionModel().getSelectedItem().toString();
            String ticket_number = ticketNumberTF.getText();
            String source_city = sourceTF.getText();
            String dest_city = destTF.getText();
            String source_state = sourceStateCB.getSelectionModel().getSelectedItem().toString();
            String dest_state = destStateCB.getSelectionModel().getSelectedItem().toString();
            Integer duration = Integer.parseInt(durationTF.getText()) ;
            String purpose = purposeCB.getSelectionModel().getSelectedItem().toString();
            Integer age = Integer.parseInt(ageTF.getText());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String journey_date;

        LocalDate date = datePicker.getValue();
        if (date != null) {
            journey_date = formatter.format(date);
        } else {
            journey_date = "";
        }

//        TravelAdd travelAdd = new TravelAdd("abhikeshri10",ticket_type,ticket_number,source_city,source_state,dest_city,dest_state,duration,purpose,age,journey_date);
//          TravelAdd travelAdd = new TravelAdd(ClientMain.user.getUsername(),ticket_type,ticket_number,source_city,source_state,dest_city,dest_state,duration,purpose,age,journey_date);
            TravelAdd travelAdd = new TravelAdd(ClientMain.user.getUsername(),ticket_type,ticket_number,source_city,journey_date,source_state,dest_city,dest_state,duration,purpose,age);
        System.out.println(travelAdd);
        RequestHandler r = new RequestHandler();
        r.travelAdd_request(travelAdd);
        new SceneChanger().changeScene("../FXML/Profile.fxml","Yaatra",event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> states = new ArrayList<>(){{
           add("Andhra Pradesh");
            add("Arunachal Pradesh");
            add("Assam");
            add("Bihar");
            add("Chhattisgarh");
            add("Goa");
            add("Gujarat");
            add("Haryana");
            add("Himachal Pradesh");
            add("Jharkhand");
            add("Karnataka");
            add("Kerala");
            add("Madhya Pradesh");
            add("Maharashtra");
            add("Manipur");
            add("Meghalaya");
            add("Mizoram");
            add("Nagaland");
            add("Odisha");
            add("Punjab");
            add("Rajasthan");
            add("Sikkim");
            add("Tamil Nadu");
            add("Telangana");
            add("Tripura");
            add("Uttar Pradesh");
            add("Uttarakhand");
            add("West Bengal");
//            add("Andhra Pradesh");

        }};
        List<String> ticketType = new ArrayList<String>(){{
            add("Train");
            add("Air");
        }};
        sourceStateCB.getItems().addAll(states);
        destStateCB.getItems().addAll(states);
        ticketTypeCB.getItems().addAll(ticketType);
        List<String> purpose = new ArrayList<String>(){{
            add("Work");
            add("Education");
            add("HealthCare");
            add("Tourism");
        }};
        purposeCB.getItems().addAll(purpose);
    }
}
