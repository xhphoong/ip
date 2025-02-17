//Class below reuse code from https://se-education.org/guides/tutorials/javaFxPart4.html with minor modification.
package anya;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(boolean isAnya, boolean hasResponseError, boolean hasLoadingError, String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/AnyaDialogBox.fxml"));
            if (isAnya == false) {
                fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/UserDialogBox.fxml"));
            }
            if (hasResponseError == true) {
                fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/ErrorDialogBox.fxml"));
            }
            if (hasLoadingError == true) {
                fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/LoadingErrorDialogBox.fxml"));
            }
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(false, false, false, text, img);
    }

    public static DialogBox getAnyaDialog(String text, Image img) {
        var db = new DialogBox(true, false, false, text, img);
        db.flip();
        return db;
    }

    public static DialogBox getErrorDialog(String text, Image img) {
        var db = new DialogBox(true, true, false, text, img);
        db.flip();
        return db;
    }

    public static DialogBox getLoadingErrorDialog(String text, Image img) {
        var db = new DialogBox(true, false, true, text, img);
        db.flip();
        return db;
    }

}


