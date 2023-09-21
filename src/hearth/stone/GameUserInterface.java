package hearth.stone;

import hearth.stone.cards.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;


public class GameUserInterface extends Game implements Initializable {

    private final int NUMBER_OF_CARDS_ON_ROW = 4;
    private final float CARD_WIDTH = 196;
    private final float CARD_HEIGHT = 260;
    private final float CARDS_PANE_X = 219;
    private final float CARDS_PANE_Y = 150;
    private final float CARDS_PANE_WIDTH = 787;
    private final float CARDS_PANE_HEIGHT = 586;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private GameCollections collectionsCls;
    private GameLogic playCls;
    private GameStatus statusCls;
    private GameShop shopCls;
    private Node[] cardProps;
    private CardTemplate card;
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
    @FXML
    private ImageView temp;
    @FXML
    private ImageView face;
    @FXML
    private Text mana;
    @FXML
    private Text dam;
    @FXML
    private Text health;
    @FXML
    private Text cardName;
    @FXML
    private Text tribe;
    @FXML
    private TextField disc;


    /**Collections Methods
    * ---displaying of a card*/
    private Pane showCard(CardTemplate card){
        this.card = card;
        return (Pane) loadFxml(getPath(card.getKind()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.temp != null && this.card instanceof NeutralCardTemplate){
            NeutralCardTemplate card = (NeutralCardTemplate) this.card;
            if (this.card.getKind().equals("Minion")){
                this.tribe.equals(card.getTribe());
                this.dam.setText(card.getDamage());
                this.health.setText(card.getHealth());
            }
            else if (this.card.getKind().equals("Weapon")){
                this.dam.setText(card.getDamage());
                this.health.setText(card.getHealth());
            }
            this.temp = getTemp(card);
            this.mana.setText(card.getMana());
            this.disc.setText(card.getEffectDisc());
        }
        if (this.cardName != null){
            this.cardName.setText(this.card.getName());
            this.face = getImage(this.card.getName(), this.card.getKind());
        }
    }


    private ImageView getTemp(NeutralCardTemplate card){
        if (card.getCardClass().equals("Neutral"))
            return getImage("Neutral" + card.getRarity(), card.getKind());
        else
            return getImage(card.getRarity(), card.getKind());
    }


    private void setAlignment(Node node, float x, float y){
        node.setLayoutX(x);
        node.setLayoutY(y);
    }


    /**---how cards must be shown on page in relation to each other*/
    public void showCards(ActionEvent event, CardTemplate[] cards){
        try{
            Group group = new Group();

            this.root = loadFxml(getPath("collection"));
            group.getChildren().add(root);


            for (int i=0; i<NUMBER_OF_CARDS_ON_ROW*2; i++){
                float cardY = (float) (Math.floor(i/NUMBER_OF_CARDS_ON_ROW)*(CARD_HEIGHT+5))
                        + CARDS_PANE_Y;
                float cardX = (CARD_WIDTH+5)*(i%NUMBER_OF_CARDS_ON_ROW)
                        + CARDS_PANE_X;

                Pane cardRep = showCard(cards[i]);

                setAlignment(cardRep, cardX, cardY);

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

        Stream<CardTemplate>  cards = this.collectionsCls.classFilter(className);
//        showCards(event,cards);

        setCollectionsText(className);
    }

    /**---shows all cards with specific mana cost*/
    public void manaBaseFilter(ActionEvent event){
        int mana = Integer.parseInt(getButtonId(event));

        Stream<CardTemplate> cards = this.collectionsCls.manaFilter(mana);
//        showCards(event, cards);

        setCollectionsText(mana + " Mana");
    }

    /**---shows allCards*/
    public void allCards(ActionEvent event){
        Stream<CardTemplate> cards = this.collectionsCls.allCards();
//        showCards(event, cards);
        setCollectionsText("All Cards");
    }

    /**---shows player'sCards*/
    public void playerCards(ActionEvent event){
        Stream<CardTemplate> cards = this.collectionsCls.playerCards();
//        showCards(event, cards);
        setCollectionsText("My Cards");
    }

    /**---show notPlayer's*/
    public void notPlayerCards(ActionEvent event){
        Stream<CardTemplate> cards = this.collectionsCls.notPlayerCards();
//        showCards(event, cards);
        setCollectionsText("Not MyCards");
    }

    /**---searches key in all card names*/
    public void search(ActionEvent event){
        String key = this.searchBar.getText();

        Stream<CardTemplate> cards = this.collectionsCls.search(key);
//        showCards(event, cards);

        setCollectionsText("Search Result");
    }

    /**---sorts base on button pressed*/
    public void sort(ActionEvent event){
        String sortKey = getButtonId(event);
        Stream<CardTemplate> cards = this.collectionsCls.sort(sortKey);
//        showCards(event, cards);
    }

    /**---sets collectionsText*/
    public void setCollectionsText(String text){
        this.collectionsText.setText(text);
    }

    public void newDeck(ActionEvent event){
        NeutralCardTemplate[] stream = new NeutralCardTemplate[]{
           NeutralCardTemplate.ALUNETH,
                NeutralCardTemplate.HIGH_PRIEST_AMET,
                NeutralCardTemplate.ACTIVATE_THE_OBELISK,

                NeutralCardTemplate.ARCANITE_RIPPER,

                NeutralCardTemplate.BAZAAR_BURGLARY,

                NeutralCardTemplate.BLOOD_FURY,

                NeutralCardTemplate.BOOK_OF_SPECTERS,

                NeutralCardTemplate.CURIO_COLLECTOR,
        };
        showCards(event, stream);
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
            case "collection": this.collectionsCls = new GameCollections();
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

    private ImageView getImage(String name, String kind){
        return new ImageView("style/images/"+kind+"/"+name+".png");
    }
}
