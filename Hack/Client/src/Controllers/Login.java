package Controllers;

import Handler.Request;
import Handler.RequestHandler;
import Helper.User;
import Main.ClientMain;
import Main.SceneChanger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.ResourceBundle;



public class Login implements Initializable {

    public CheckBox rememberChB;
    public TextField usernameTF;
    public Button signInBT;
    public PasswordField passwordTF;
    public Button signupBT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void login_request(ActionEvent event) throws IOException, InterruptedException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();

        if(username.length()>0&&password.length()>0)
        {
//                      new RequestHandler(Request.LOGIN,username,password);
            RequestHandler r = new RequestHandler();
            ClientMain.user = r.login_request(username,password);
            System.out.println(ClientMain.user);
            if(ClientMain.user!=null)
                new SceneChanger().changeScene("../FXML/Profile.fxml","Yaatra",event);
            else
                JOptionPane.showMessageDialog(null,"Wrong Credentials");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please Fill the username and password properly");
        }

    }

    /**
     * got to register page
     * @param event
     */
    public void register(ActionEvent event) {
        new SceneChanger().changeScene("../FXML/SignUp.fxml","Register",event);

    }
}
