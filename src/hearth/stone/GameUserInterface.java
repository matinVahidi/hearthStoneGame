package hearth.stone;

import hearth.stone.cards.CardTemplate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class GameUserInterface extends Game {

    private Parent root;
    private Scene scene;
    private Stage stage;
    private GameCollections collections;
    @FXML
    private Text entryText;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField pass;
    @FXML
    private Text settingsText;
    @FXML
    private TextField newUserName;
    @FXML
    private TextField newPass;


    private void showCard(String name){
        CardTemplate card = CardTemplate.valueOf(name);
    }


    private void showCards(String[] cardsName){
        for (String cardName: cardsName)
            showCard(cardName);
    }


    public void classBaseFilter(ActionEvent event){
        Button
        String className = "Neutral";

        this.collections.classFilter(className);
    }


    public void play(ActionEvent event){
        switchScene(event, getPath("play"));
    }


    public void status(ActionEvent event){
        switchScene(event, getPath("status"));
    }


    public void shop(ActionEvent event){
        switchScene(event, getPath("shop"));
    }


    public void collections(ActionEvent event){
        this.collections = new GameCollections();
        switchScene(event, getPath("collections"));
    }



    public void settings(ActionEvent event) {
        switchScene(event, getPath("settings"));
    }


    public void setProps(){
        this.newPass.setText(GameAccountManager.getPass());
        this.newUserName.setText(GameAccountManager.getName());
    }



    public void changeName(){
        String newName = this.newUserName.getText();
        int cond = GameAccountManager.setName(newName);

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
        int cond = GameAccountManager.setPass(newPass);

        if (cond == 1)
            this.settingsText.setText("Enter new Password than hit the button");
        if (cond == 2)
            this.settingsText.setText("New Password isn't valid. Try again");
        if (cond == 3)
            this.settingsText.setText("Password successfully changed");

        setProps();
    }


    public void deleteAccount(ActionEvent event){
        GameAccountManager.deleteAccount();
        switchScene(event, getPath("entry"));
    }


    public void exit(ActionEvent event){
        newStage(event, getPath("exit"));
    }


    public void leave(){
        GameAccountManager.exit();
    }


    public void stay(ActionEvent event){
        this.stage = getStageFromEvent(event);
        this.stage.close();
    }


    public void back(ActionEvent event){
        switchScene(event, getPath("main"));
    }


    public void createAccount(ActionEvent event){
        String name = this.userName.getText();
        String pass = this.pass.getText();
        int cond = GameAccountManager.addPlayer(name, pass);

        if (cond == 1)
            this.entryText.setText("UserName is not valid");
        else if (cond == 2)
            this.entryText.setText("Password is not valid");
        else
            switchScene(event, getPath("main"));
    }


    public void logIn(ActionEvent event){
        String name = this.userName.getText();
        String pass = this.pass.getText();
        int cond = GameAccountManager.enterAccount(name, pass);

        if (cond == 2)
            this.entryText.setText("There isn't such a UserName");
        else if (cond == 3)
            this.entryText.setText("Password is wrong");
        else
            switchScene(event, getPath("main"));
    }


    public void newStage(ActionEvent event,String windowName){
        try {
            this.stage = getStageFromEvent(event);
            this.root = loadFxml(windowName);
            this.scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(this.scene);

            newStage.initOwner(this.stage);
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.initModality(Modality.APPLICATION_MODAL);

            newStage.show();
        }
        catch (Exception e){
            sendAlert("newStage");
        }
    }


    private void switchScene(ActionEvent event, String windowName){
        try {
            this.root = loadFxml(windowName);
            this.scene = new Scene(root);
            this.stage = getStageFromEvent(event);
            this.stage.setScene(this.scene);
            this.stage.setFullScreen(true);
            this.stage.show();
        }
        catch (Exception e){
            sendAlert("switchScene");
        }
    }

    private String getPath(String name){
        return "style/" + name + ".fxml";
    }

    private void sendAlert(String name) {
        Alert err = new Alert(Alert.AlertType.ERROR, "Error in "+ name);
        err.show();
    }

    private Stage getStageFromEvent(ActionEvent event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private Parent loadFxml(String windowName) throws IOException {
        return FXMLLoader.load(getClass().getResource(windowName));
    }
}
