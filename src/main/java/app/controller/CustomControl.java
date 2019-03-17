/**
 * 
 */
package app.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import app.tiktok.search.UserSearchResult;
import app.tiktok.user.UserProfile;
import app.utils.TiktokAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author tuanhiep225
 *
 */
@Controller
public class CustomControl extends HBox {
    @FXML
    private Label tblIdTiktok;

    @FXML
    private Label lblName;

    @FXML
    private ImageView imageView;
    
    @FXML
    private JFXButton btnViewAllVideo;
    

    private TiktokAPI tiktokAPI;
    
    
    private UserProfile userProfile;
    
    public CustomControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        tiktokAPI = new TiktokAPI();
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public CustomControl(UserProfile userProfile) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/custom_control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        tiktokAPI = new TiktokAPI();
        try {
            fxmlLoader.load();
            this.setIdTiktok(userProfile.getUnique_id());
            this.setImageView(userProfile.getAvatar_thumb().getUrl_list().get(0).replace(".webp", ""));
            this.setName(userProfile.getNickname());
            this.setUserProfile(userProfile);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

	public String getIdTiktok() {
		return tblIdTiktok.getText();
	}

	public void setIdTiktok(String idTiktok) {
		this.tblIdTiktok.setText(idTiktok);
	}

	public String getName() {
		return lblName.getText();
	}

	public void setName(String name) {
		this.lblName.setText(name);
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(String url) {
		imageView.setImage(new Image(url));
	}
	
	
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@FXML
    void viewAllVideo(ActionEvent event) throws Exception {
    	
    	Scene scene = this.getScene();
    	StackPane stackPane = (StackPane) scene.lookup("#stackPanel");
    	stackPane.getChildren().get(0).setVisible(false);
    	stackPane.getChildren().add(new ResutlSearchController(userProfile));
    	System.out.println("name: "+ lblName.getText());

    }
    
    
}