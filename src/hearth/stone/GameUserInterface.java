package hearth.stone;

import hearth.stone.cards.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class GameUserInterface extends Game {

    private Parent root;
    private Scene scene;
    private Stage stage;
    private GameCollections collectionsCls;
    private GameLogic playCls;
    private GameStatus statusCls;
    private GameShop shopCls;
    private ImageView temp;
    private ImageView face;
    private Text name;
    private Text desc;
    private Text mana;
    private Text tribe;
    private Text health;
    private Text dam;
    private StackPane container;
    @FXML
    private Text collectionsText;
    @FXML
    private TextField searchBar;
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


    /**Collections Methods
     * ---displaying of a minion card*/
    private Pane showMinionCard(CardTemplate card){
        createCard(card);

        container.getChildren().addAll(temp, face, name, desc, tribe,mana, health, dam);

        setCard(,,,,,,,,,,,,,);

        return container;
    }

    private Pane showWeaponCard(CardTemplate card){
        createCard(card);

        container.getChildren().addAll(temp, face, name, desc, tribe,mana, health, dam);

        setCard(,,,,,,,,,,,,,);

        return container;
    }

    private Pane showSpellCard(CardTemplate card){
        createCard(card);

        container.getChildren().addAll(temp, face, name, desc, tribe,mana);

        setCard(,,,,,,,,,,-1,-1,-1,-1);

        return container;
    }

    private Pane showHeroCard(CardTemplate card){
        createCard(card);

        container.getChildren().addAll(temp, face, name);

        setCard(,,,,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1);

        return container;
    }

    private void createCard(CardTemplate cardTemp){
        this.container  =  new StackPane();

        if (cardTemp instanceof Heroes)
            this.temp = new ImageView(new Image(getImagePath("hero", "minion")));
        else{
            NeutralCardTemplate card = (NeutralCardTemplate) cardTemp;
            if (card.getCardClass().equals("Neutral"))
                this.temp = new ImageView(new Image(getImagePath("Neutral"+card.getRarity(), "minion")));
            else
                this.temp = new ImageView(new Image(getImagePath(card.getRarity(), "minion")));
            this.desc = new Text(card.getEffectDisc());
            this.mana = new Text(card.getMana());
            this.tribe = new Text(card.getTribe());
            this.health = new Text(card.getHealth());
            this.dam = new Text(card.getDamage());
        }
        this.face = new ImageView(new Image(getImagePath(cardTemp.getName(), "minion")));
        this.name = new Text(cardTemp.getName());
    }

    private void setCard(float... args){
        setAlignment(temp, 0, 0);
        setAlignment(face, args[0], args[1]);
        setAlignment(name, args[2], args[3]);
        if(args[4] != -1){
            setAlignment(desc, args[4], args[5]);
            setAlignment(mana, args[6], args[7]);
        }
        if (args[8] != -1){
            setAlignment(tribe, args[8], args[9]);
            setAlignment(health, args[10], args[11]);
            setAlignment(dam, args[12], args[13]);
        }
    }

    private void setAlignment(Node node, float x, float y){
        node.setLayoutY(y);
        node.setLayoutX(x);
    }

    /**---how cards must be shown on page in relation to each other*/
    private void showCards(ActionEvent event,ArrayList<CardTemplate> cards){
        try{
            Group group = new Group();
            this.root = loadFxml(getPath("collection"));
            group.getChildren().add(root);


            for (int i=0; i<8; i++) {
                CardTemplate card = cards.get(i);
                String methodName = "show"+card.getKind()+"card";
                Pane cardRep;

                cardRep = (Pane) Class.forName("hearth.stone." +
                        "GameUserInterface").getMethod(methodName).invoke(card);
                cardRep.setLayoutX();
                cardRep.setLayoutY();


                group.getChildren().add(cardRep);
            }

            this.stage = getStageFromEvent(event);
            this.scene = new Scene(group);
            this.stage.setScene(scene);
            this.stage.show();
        }catch (Exception e){
            sendAlert("showCards");
        }
    }

    /**---shows all cards of a class*/
    public void classBaseFilter(ActionEvent event){
        String className = getButtonId(event);

        ArrayList<CardTemplate>  cards = this.collectionsCls.classFilter(className);
        showCards(event,cards);

        setCollectionsText(className);
    }

    /**---shows all cards with specific mana cost*/
    public void manaBaseFilter(ActionEvent event){
        int mana = Integer.parseInt(getButtonId(event));

        ArrayList<CardTemplate> cards = this.collectionsCls.manaFilter(mana);
        showCards(event, cards);

        setCollectionsText(mana + " Mana");
    }

    /**---shows allCards*/
    public void allCards(ActionEvent event){
        ArrayList<CardTemplate> cards = this.collectionsCls.allCards();
        showCards(event, cards);
        setCollectionsText("All Cards");
    }

    /**---shows player'sCards*/
    public void playerCards(ActionEvent event){
        ArrayList<CardTemplate> cards = this.collectionsCls.playerCards();
        showCards(event, cards);
        setCollectionsText("My Cards");
    }

    /**---show notPlayer's*/
    public void notPlayerCards(ActionEvent event){
        ArrayList<CardTemplate> cards = this.collectionsCls.notPlayerCards();
        showCards(event, cards);
        setCollectionsText("Not MyCards");
    }

    /**---searches key in all card names*/
    public void search(ActionEvent event){
        String key = this.searchBar.getText();

        ArrayList<CardTemplate> cards = this.collectionsCls.search(key);
        showCards(event, cards);

        setCollectionsText("Search Result");
    }

    /**---sorts base on button pressed*/
    public void sort(ActionEvent event){
        String sortKey = getButtonId(event);
        ArrayList<CardTemplate> cards = this.collectionsCls.sort(sortKey);
        showCards(event, cards);
    }

    /**---sets collectionsText*/
    public void setCollectionsText(String text){
        this.collectionsText.setText(text);
    }

    public void newDeck(ActionEvent event){

    }





    /**Settings Methods
     * ---It suppose to set current name ang pass of player in a textField but doesn't work*/
    public void setProps(){
        this.newPass.setText(GameAccountManager.getPass());
        this.newUserName.setText(GameAccountManager.getName());
    }

    /**---changes name of player*/
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

    /**---changes password of player*/
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

    /**---deletes account and send back player to entry page*/
    public void deleteAccount(ActionEvent event){
        GameAccountManager.deleteAccount();
        switchScene(event, getPath("entry"));
    }


    /**Game Entry Methods
    ---opens a window to warn player about exiting game*/
    public void exit(ActionEvent event){
        newStage(event, getPath("exit"));
    }

    /**---exits game*/
    public void leave(){
        GameAccountManager.exit();
    }

    /**---backs to game*/
    public void stay(ActionEvent event){
        this.stage = getStageFromEvent(event);
        this.stage.close();
    }

    /**---creates account for first time players and show error in case of repeated or invalid userName ,
     *     insecure password*/
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

    /**---checks written pass with correct one and if right access player to account*/
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


    /**Common Methods
     * ---from each window back to main*/
    public void back(ActionEvent event){
        switchScene(event, getPath("main"));
    }

    /**---closes a window and add new one and also creates related object*/
    public void goToWindow(ActionEvent event){
        String windowName = getButtonId(event);

        switchScene(event, getPath(windowName));

        switch (windowName){
            case "collections": this.collectionsCls = new GameCollections();
//            case "play": this.play = new GameLogic();
//            case "status": this.status = new GameStatus();
//            case "shop": this.shop = new GameShop();
        }
    }

    /**---opens a window on top of old one*/
    public void openWindow(ActionEvent event){
        String windowName = getButtonId(event);
        newStage(event, getPath(windowName));
    }

    /**---opens a stage on top of old one*/
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

    /**---switches from one file.fxml to another*/
    public void switchScene(ActionEvent event, String windowName){
        try {
            this.root = loadFxml(windowName);
            this.scene = new Scene(root);
            this.stage = getStageFromEvent(event);
            this.stage.setScene(this.scene);
//            this.stage.setFullScreen(true);
            this.stage.show();
        }
        catch (Exception e){
            sendAlert("switchScene");
        }
    }

    /**---gets name and returns full path of file.fxml*/
    private String getPath(String name){
        return "style/" + name + ".fxml";
    }

    /**---creates new alert object and shows it*/
    private void sendAlert(String name) {
        Alert err = new Alert(Alert.AlertType.ERROR, "Error in "+ name);
        err.show();
    }

    /**---returns stage from actionEvent*/
    private Stage getStageFromEvent(ActionEvent event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    /**---gets full path of fxml and returns nodes related to it*/
    private Parent loadFxml(String windowName) {
        try {
            return FXMLLoader.load(getClass().getResource(windowName));
        }catch (Exception e){
            sendAlert("loadFxml");
            return null;
        }
    }

    /**---gets ActionEvent and returns id of button*/
    private String getButtonId(ActionEvent event){
        return ((Button) event.getSource()).getId();
    }

    private String getImagePath(String name, String kind){
        return "style/images/"+kind+name+".fxml";
    }
}
