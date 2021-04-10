package Controllers;

import Handler.RequestHandler;
import Helper.FullUser;
import Helper.TravelAdd;
import Helper.TravelTable;
import Main.ClientMain;
import Main.SceneChanger;
import com.mysql.fabric.Response;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;

public class Profile implements Initializable {
    public TextField tf_state;
    public TextField tf_city;
    public Label pnrstatus;
    public Button bt_signout;
    public TextField phoneTF;
    public TextField nameTF;
    public TextField emailTF;
    public DatePicker dobDP;
    public TextField adress1TF;
    public TextField address2TF;
    public CheckBox confirm1TF;
    public Button basicSaveBT;
    public ComboBox educationCB;
    public ComboBox employmentCB;
    public CheckBox confirm2CB;
    public Button addTravelBT;
    public TableView travelTB;
    public TableColumn id;
    public TableColumn dateColumn;
    public TableColumn TicketNumberCL;
    public TableColumn sourceCL;
    public TableColumn destCL;
    public TableColumn journey_date;
    public TableColumn ticket_number;
    public TableColumn dest_city;
    public TableColumn source_city;
    public Label totalcountTF;
    List<String> employment;
    List<String> education;
    List<TravelTable> travelentry;
    @FXML
    private Button bt_basic, bt_employment, bt_travel;
    @FXML
    private TextField tf_pin;
    @FXML
    private Pane pane_basic, pane_employment, pane_travel;
    private FullUser fullUser;
    public void handleButtonActivity(javafx.event.ActionEvent event) {
        if (event.getSource() == bt_basic) {
            this.pane_basic.toFront();
        } else if (event.getSource() == bt_employment) {
            pane_employment.toFront();
        } else if (event.getSource() == bt_travel) {
            pane_travel.toFront();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {





        employment = new ArrayList<>(){{

            add("Business");
            add("Service");
            add("Public Servant");
            add("Student");
            add("Farmer");
            add("Unemployed");


        }};
        education = new ArrayList<>(){{
            add("Secondary");
            add("Senior Secondary");
            add("Graduate");
            add("Uneducated");


        }};
        educationCB.getItems().addAll(education);
        employmentCB.getItems().addAll(employment);


        String token = ClientMain.user.getToken();
        RequestHandler r = new RequestHandler();
        try {
            this.fullUser = r.fullUser_request();
            System.out.println(fullUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.fill_details();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        try {
            this.setTable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setTable() throws InterruptedException, JSONException, IOException {
        RequestHandler r = new RequestHandler();
        travelentry = r.getTable();

        if(travelentry!=null)
        {
            System.out.println(travelentry.size());
            totalcountTF.setText("Total Count: "+travelentry.size());
            ObservableList<TravelTable> observableList = FXCollections.observableArrayList(travelentry);
            System.out.println(travelentry);
            System.out.println(observableList);
//            travelTB.setItems(observableList);


            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            journey_date.setCellValueFactory(new PropertyValueFactory<>("journey_date"));
            ticket_number.setCellValueFactory(new PropertyValueFactory<>("ticket_number"));
            source_city.setCellValueFactory(new PropertyValueFactory<>("source_city"));
            dest_city.setCellValueFactory(new PropertyValueFactory<>("dest_city"));
            travelTB.setItems(observableList);

//            travelTB.getColumns().addAll(travelentry);
            travelTB.setVisible(true);
        }
        else
        {
            System.out.println("Wrong credentials");
        }
    }

    private void fill_details() throws java.text.ParseException {
        if(this.fullUser!=null) {
            nameTF.setText(fullUser.getName());
            emailTF.setText(fullUser.getEmail());
            phoneTF.setText(fullUser.getPhone_number());
//        dobDP.setDa;
            tf_pin.setText(fullUser.getPincode());
            tf_city.setText(fullUser.getCity());
            tf_state.setText(fullUser.getState());
            adress1TF.setText(fullUser.getAddress_1());
            address2TF.setText(fullUser.getAddress_2());
            String s = fullUser.getDob();
//            SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
//            Date datee = formatter1.parse(s);
            LocalDate d = LocalDate.parse(s);
            dobDP.setValue(d);
            String edu = this.fullUser.getEducation();
            if(edu.length()>0)
            {
                int i = education.indexOf(edu);
                educationCB.getSelectionModel().select(i);
            }
            String emp = this.fullUser.getEmployment();
            if(emp.length()>0)
            {
                int i = employment.indexOf(emp);
                employmentCB.getSelectionModel().select(i);
            }
        }
    }

    /**
     * Validate pin code to get State city
     * @param actionEvent
     * @throws IOException
     */
    public void validatePin(ActionEvent actionEvent) throws IOException{
        String pin = tf_pin.getText();
        if (pin.isEmpty()) {
            tf_pin.clear();
            pnrstatus.setText("Failed");

        } else {
            String url = "http://www.postalpincode.in/api/pincode/" + pin;
            JSONParser parser = new JSONParser();
            try {
                URL oracle = new URL(url); // URL to Parse
                URLConnection yc = oracle.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

                String inputLine;
                inputLine = in.readLine();
                //  System.out.println(inputLine);
                // Loop through each item
                JSONObject locatePin =(JSONObject) parser.parse(inputLine);
                try {
                    if (locatePin.get("Status").equals("Error")) {
                        pnrstatus.setText("Failed");
                        tf_city.setText("");
                        tf_state.setText("");
                    } else {
                        JSONArray pinarray =(JSONArray)locatePin.get("PostOffice");
                        JSONObject displaypin=(JSONObject)pinarray.get(0);
                        String state = displaypin.get("State").toString();
                        String district = displaypin.get("District").toString();
                        tf_city.setText(district);
                        tf_state.setText(state);
                        pnrstatus.setText("Success");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void signout(ActionEvent event) throws IOException, InterruptedException {
        RequestHandler r = new RequestHandler();
        r.signout_request();
        new SceneChanger().changeScene("../FXML/Login.fxml","Login",event);
    }

    public void addTravel(ActionEvent event) {
        new SceneChanger().changeScene("../FXMl/Travel.fxml","Travel",event);
    }

    public void updateBasic(ActionEvent event) throws IOException, InterruptedException {
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dobs;

        LocalDate date = dobDP.getValue();
        if (date != null) {
            dobs = formatter.format(date);
        } else {
            dobs = "";
        }
        String pincode = tf_pin.getText();
        String city = tf_city.getText();
        String state = tf_state.getText();
        String addresslane_1 = adress1TF.getText();
        String addresslane_2 = address2TF.getText();
        if(confirm1TF.isSelected())
        {

            this.fullUser.setName(name);
            this.fullUser.setEmail(email);
            this.fullUser.setPhone_number(phone);
            this.fullUser.setDob(dobs);
            this.fullUser.setPincode(pincode);
            this.fullUser.setCity(city);
            this.fullUser.setState(state);
            this.fullUser.setAddress_1(addresslane_1);
            this.fullUser.setAddress_2(addresslane_2);
            RequestHandler r = new RequestHandler();
            r.update_details(this.fullUser);
            new SceneChanger().changeScene("../FXML/Profile.fxml","Yaatra",event);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Check the confirm button");
        }
    }

    public void updateEmployment(ActionEvent event) throws IOException, InterruptedException {
        String emp = employmentCB.getSelectionModel().getSelectedItem().toString();
        String edu = educationCB.getSelectionModel().getSelectedItem().toString();
        if(confirm2CB.isSelected())
        {
            this.fullUser.setEducation(edu);
            this.fullUser.setEmployment(emp);
            RequestHandler r = new RequestHandler();
            r.update_details(this.fullUser);
            new SceneChanger().changeScene("../FXML/Profile.fxml","Yaatra",event);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Check the confirm button");
        }
    }
}
