package Controllers;

import Handler.RequestHandler;
import Helper.FullUser;
import Main.ClientMain;
import Main.SceneChanger;
import com.mysql.fabric.Response;
import javafx.application.Application;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ResourceBundle;


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        this.fill_details();
    }

    private void fill_details() {
        if(this.fullUser!=null) {
            nameTF.setText(fullUser.getName());
            emailTF.setText(fullUser.getEmail());
            phoneTF.setText(fullUser.getPhone_number());
//        dobDP.setDa;
            tf_pin.setText(fullUser.getPincode());
            tf_city.setText(fullUser.getCity());
            tf_state.setText(fullUser.getState());

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
}
