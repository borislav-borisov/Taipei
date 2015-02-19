package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Screen2Controller implements Initializable, ControlledScreen{
    public  Button throwDiceBtn;
    public  Label informationLabel;
    public  TextField player1Name;
    public  TextField player1Money;
    public  TextField player2Name;
    public  TextField player2Money;
    public Button startBtn;

    ScreensController myController;

    @Override
    public void setScreenParent(ScreensController screenParent) {

        myController = screenParent;

    }

    public void ev(WindowEvent windowEvent) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public void exit(KeyEvent event) {
        Platform.exit();
    }


    @FXML
    private  void goToScreen1(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen1ID);
    }
    @FXML
    private  void goToScreen3(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen3ID);
    }
    @FXML
    private void throwDices(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ThrowDices.fxml"));
        stage.setTitle("Throw Dices");
        stage.setScene(new Scene(root, 800, 400));
        stage.show();
    }
    @FXML
    private  void goToScreen4(ActionEvent event) {
        myController.setScreen(ScreensFramework.screen4ID);
//        ThrowDicesController clear = new ThrowDicesController();
//        clear.clear();
    }

    public  void main(String[] args) {
        if (SetPlayersController.listPlayer.size() >=2) {
            informationLabel.setVisible(false);
        }
    }
    public void exitPlatform(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    public void setPlaersName(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SetPlayers.fxml"));
        stage.setTitle("Set Players");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void checkForSetPlayers (){
        List<PlayersInfo> tempList = SetPlayersController.listPlayer;
        if (tempList.size() < 3){
            throwDiceBtn.setDisable(true);
//            informationLabel.setText("Set Players Information First!");
        }
    }
    @FXML
    public void starGame(ActionEvent event) {
        if (SetPlayersController.listPlayer.size() < 2) {
            informationLabel.setVisible(true);
        }else {
            player1Name.setText(SetPlayersController.listPlayer.get(0).getPlayerName());
            player1Name.setVisible(true);
            player1Money.setText(String.valueOf(SetPlayersController.listPlayer.get(0).getAmountOfMonew()));
            player1Money.setVisible(true);
            player2Name.setText(SetPlayersController.listPlayer.get(1).getPlayerName());
            player2Name.setVisible(true);
            player2Money.setText(String.valueOf(SetPlayersController.listPlayer.get(1).getAmountOfMonew()));
            player2Money.setVisible(true);
            informationLabel.setVisible(false);
            startBtn.setDisable(true);
            startBtn.setVisible(false);

            throwDiceBtn.setDisable(false);
            throwDiceBtn.setVisible(true);
        }
    }

    public void showPlayers(String player1Na, int player1Mo, String player2Na, int player2Mo) {
//        player1Name.setText("test");

//        player1Name.setText(player1Na);
//        player1Money.setText(String.valueOf(player1Mo));
//        player2Name.setText(player2Na);
//        player2Money.setText(String.valueOf(player2Mo));

    }


}
