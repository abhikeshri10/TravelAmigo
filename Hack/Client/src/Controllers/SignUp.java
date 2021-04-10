package Controllers;

import Handler.RequestHandler;
import Helper.User;
import Main.ClientMain;
import Main.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SignUp implements Initializable {

    public TextField first_nameTF;
    public Button singInBT;
    public PasswordField passwordTF;
    public Button signUpBT;
    public TextField usernameTF;
    public TextField emailTF;
    public TextField phoneTF;
    public PasswordField password2TF;
    public CheckBox agreeChB;
    public TextField last_nameTF;

    public void login(ActionEvent event) {
        new SceneChanger().changeScene("..\\FXML\\Login.fxml","LoginPage",event);
    }

    public void register_request(ActionEvent event) throws IOException, InterruptedException {

        String first_name = first_nameTF.getText();
        String last_name = last_nameTF.getText();
        String email = emailTF.getText();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String password2 = password2TF.getText();
        if(agreeChB.isSelected())
        {

            if(first_name.length()>0&&last_name.length()>0&&email.length()>0&&username.length()>0&&password.length()>0)
            {
                if(password.length()>8)
                {
                    if (password.equals(password2))
                    {
                        User user = new User(first_name,last_name,email,username,password);

                         RequestHandler r = new RequestHandler();
                         ClientMain.user = r.register_request(user);
                         System.out.println(ClientMain.user);
                         if(ClientMain.user!=null)
                             new SceneChanger().changeScene("../FXML/Profile.fxml","Yaatra",event);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Password mismatch");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password length too short");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please input all the fields");
            }




        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select the checkbox");
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
