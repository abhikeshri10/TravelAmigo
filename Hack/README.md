# Instructions to run the project
## Instructions to run the Django modules
  ### Requirements
  Make sure you have python installed in your system. After that install the following requirements
  1) pip install django
  2) pip install django-filter
  3) pip install drf-registration
  4) pip install django-phone-field
  5) pip install djangorestframework
  
  After that move to Server/hack-server and fire the commands
  1) python manage.py makemigrations
  2) python manage.py migrate
  3) python manage.py runserver

  Open localhost/admin and enter superuser id = admin passwd = 1234
  
  
## Instructions to run the Java modules
  1) First Start the server.
  2) The project contains two main modules Client and State
  3) First open the project in IntelliJ and then add the [libraries](#dependancies) 
  4) To run any of the two module move to Client/Main or State/Main.
  5) Run the ClientMain.java file after adding --module-path /path/to/javafx/sdk --add-modules javafx.controls,javafx.fxml
 in VM options in edit configuration.

## Dependancies

[Jar Files](https://drive.google.com/drive/folders/1tlm62iKEToaP7eCsf0qQLcmtaMB97WN5?usp=sharing)
