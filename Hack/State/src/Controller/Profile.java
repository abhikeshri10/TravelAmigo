package Controller;

import Handler.RequestHandler;
import Helper.TravelTable;
import Main.ClientMain;
import Main.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Profile implements Initializable {
    public Button bt_inflow;
    public Button bt_outflow;
    public Button bt_signout;
    public Pane pane;
    public ComboBox purposeCB;
    public Label countTF;
    public DatePicker startTimeTF;
    public DatePicker endTimeTF;
    public Button searchBT;
    public TextField endAgeTF;
    public TextField startAgeTF;
    public TableColumn id;
    public TableColumn journey_date;
    public TableColumn purpose;
    public TableColumn age;
    public TableColumn duration;
    public TableColumn travel_type;
    public TableView travelTB;
    public ComboBox dest_stateCB;
    public String s="inflow";
    public String lowAge = "0";
    public String highAge = "200";
    public String startDate = "1984-01-01";
    public String endDate = "2022-12-12";
    public String purposee = "";
    public String destState = "";
    public TableColumn source_state;
    List<TravelTable> tableEntry;
    public void handleButtonActivity(ActionEvent event) {
        if (event.getSource() == bt_inflow) {
            this.s = "inflow";

        } else if (event.getSource() == bt_outflow) {
            this.s="outflow";
        }

    }

    public void query_table(ActionEvent event) throws InterruptedException, JSONException, IOException {
        if(s.equals("inflow"))
        {
            if(purposeCB.getSelectionModel().getSelectedItem()!=null)
            purposee = purposeCB.getSelectionModel().getSelectedItem().toString();
            if(dest_stateCB.getSelectionModel().getSelectedItem()!=null)
            {

                destState = dest_stateCB.getSelectionModel().getSelectedItem().toString();
                String t = destState.replace(" ","%20");
                destState = t;
            }

            if(startAgeTF.getText().length()!=0)
                lowAge = startAgeTF.getText();
            if(endAgeTF.getText().length()!=0)
                highAge = endAgeTF.getText();


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String dobs;

            LocalDate date = startTimeTF.getValue();
            if (date != null) {
                startDate = formatter.format(date);
            }
            LocalDate date2 = endTimeTF.getValue();
            if (date2 != null) {
                endDate = formatter.format(date2);
            }

            travelTB.getItems().removeAll();
            RequestHandler r = new RequestHandler();
            tableEntry = r.inflow_request(lowAge,highAge,startDate,endDate,purposee,destState);
            if(tableEntry!=null)
            {
                System.out.println(tableEntry.size());
                countTF.setText("Total Count: "+tableEntry.size());
                ObservableList<TravelTable> observableList = FXCollections.observableArrayList(tableEntry);
                System.out.println(tableEntry);
                System.out.println(observableList);
//            travelTB.setItems(observableList);


                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                journey_date.setCellValueFactory(new PropertyValueFactory<>("journey_date"));
                purpose.setCellValueFactory(new PropertyValueFactory<>("purpose"));
                travel_type.setCellValueFactory(new PropertyValueFactory<>("travel_type"));
                duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
                age.setCellValueFactory(new PropertyValueFactory<>("age"));
                source_state.setCellValueFactory(new PropertyValueFactory<>("source_state"));
                travelTB.setItems(observableList);

//            travelTB.getColumns().addAll(travelentry);
                travelTB.setVisible(true);
            }
            else
            {
                System.out.println("Wrong credentials");
            }
        }
        else
        {
            if(purposeCB.getSelectionModel().getSelectedItem()!=null)
                purposee = purposeCB.getSelectionModel().getSelectedItem().toString();
            if(dest_stateCB.getSelectionModel().getSelectedItem()!=null)
            {

                destState = dest_stateCB.getSelectionModel().getSelectedItem().toString();
                String t = destState.replace(" ","%20");
                destState = t;
            }

            if(startAgeTF.getText().length()!=0)
                lowAge = startAgeTF.getText();
            if(endAgeTF.getText().length()!=0)
                highAge = endAgeTF.getText();


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String dobs;

            LocalDate date = startTimeTF.getValue();
            if (date != null) {
                startDate = formatter.format(date);
            }
            LocalDate date2 = endTimeTF.getValue();
            if (date2 != null) {
                endDate = formatter.format(date2);
            }

            travelTB.getItems().removeAll();
            RequestHandler r = new RequestHandler();
            tableEntry = r.outflow_request(lowAge,highAge,startDate,endDate,purposee,destState);
            if(tableEntry!=null)
            {
                System.out.println(tableEntry.size());
                countTF.setText("Total Count: "+tableEntry.size());
                ObservableList<TravelTable> observableList = FXCollections.observableArrayList(tableEntry);
                System.out.println(tableEntry);
                System.out.println(observableList);
//            travelTB.setItems(observableList);


                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                journey_date.setCellValueFactory(new PropertyValueFactory<>("journey_date"));
                purpose.setCellValueFactory(new PropertyValueFactory<>("purpose"));
                travel_type.setCellValueFactory(new PropertyValueFactory<>("travel_type"));
                duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
                age.setCellValueFactory(new PropertyValueFactory<>("age"));
                source_state.setCellValueFactory(new PropertyValueFactory<>("source_state"));
                travelTB.setItems(observableList);

//            travelTB.getColumns().addAll(travelentry);
                travelTB.setVisible(true);
            }
            else
            {
                System.out.println("Wrong credentials");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> purpose = new ArrayList<String>(){{
            add("Work");
            add("Education");
            add("HealthCare");
            add("Tourism");
        }};
        purposeCB.getItems().addAll(purpose);
        List<String> states = new ArrayList<>(){
            {
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
            }};
        states.remove(ClientMain.user.getFirst_name());
        dest_stateCB.getItems().addAll(states);

    }

    public void signOut(ActionEvent event) throws IOException, InterruptedException {
        RequestHandler r = new RequestHandler();
        r.signout_request();
        new SceneChanger().changeScene("../FXML/Login.fxml","Login",event);
    }
}
