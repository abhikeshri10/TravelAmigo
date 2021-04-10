package Controller;

import Handler.RequestHandler;
import Helper.User;
import Main.ClientMain;
import Main.SceneChanger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Login {
    public TextField usernameTF;
    public Button signInBT;
    public PasswordField passwordTF;
    public static User user;

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
}
