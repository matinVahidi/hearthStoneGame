package hearth.stone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UserInterface {

    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Text entryText;
    @FXML
    private TextField name;
    @FXML
    private PasswordField pass;
    @FXML
    private Text settingsText;
    @FXML
    private TextField newName;
    @FXML
    private TextField newPass;


    public void play(ActionEvent event){
        switchScene(event, "style/play.fxml");
    }


    public void status(ActionEvent event){
        switchScene(event, "style/status.fxml");
    }


    public void shop(ActionEvent event){
        switchScene(event, "style/shop.fxml");
    }


    public void collections(ActionEvent event){
        switchScene(event, "style/collections.fxml");
    }



    public void settings(ActionEvent event) {
        switchScene(event, "style/settings.fxml");
    }


    public void setProps(){
        this.newPass.setText(AccountManager.getPass());
        this.newName.setText(AccountManager.getName());
    }



    public void changeName(){
        String newName = this.newName.getText();
        int cond = AccountManager.setName(newName);

        if (cond == 1)
            this.settingsText.setText("Enter new Name than hit the button");
        if (cond == 2)
            this.settingsText.setText("New Name isn't valid. Try again");
        if (cond == 3)
            this.settingsText.setText("Name successfully changed to " + newName);

        setProps();
    }


    public void changePass(){
        String newPass = this.newPass.getText();
        int cond = AccountManager.setPass(newPass);

        if (cond == 1)
            this.settingsText.setText("Enter new Password than hit the button");
        if (cond == 2)
            this.settingsText.setText("New Password isn't valid. Try again");
        if (cond == 3)
            this.settingsText.setText("Password successfully changed");

        setProps();
    }


    public void deleteAccount(ActionEvent event){
        AccountManager.deleteAccount();
        switchScene(event, "style/entry.fxml");
    }


    public void exit(ActionEvent event){
        switchScene(event, "style/exit.fxml");
    }


    public void back(ActionEvent event){
        switchScene(event, "style/main.fxml");
    }


    public void createAccount(ActionEvent event){
        String name = this.name.getText();
        String pass = this.pass.getText();
        int cond = AccountManager.addPlayer(name, pass);

        if (cond == 1)
            this.entryText.setText("UserName is not valid");
        else if (cond == 2)
            this.entryText.setText("Password is not valid");
        else
            switchScene(event, "style/main.fxml");
    }


    public void logIn(ActionEvent event){
        String name = this.name.getText();
        String pass = this.pass.getText();
        int cond = AccountManager.enterAccount(name, pass);

        if (cond == 2)
            this.entryText.setText("There isn't such a UserName");
        else if (cond == 3)
            this.entryText.setText("Password is wrong");
        else
            switchScene(event, "style/main.fxml");
    }


    private void switchScene(ActionEvent event, String windowName){
        try {
            this.root = FXMLLoader.load(getClass().getResource(windowName));
            this.scene = new Scene(root);
            this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            this.stage.setScene(this.scene);
            this.stage.show();
        }
        catch (Exception e){
            Alert err = new Alert(Alert.AlertType.ERROR, "Error in switchScene");
            err.show();
        }
    }
}
