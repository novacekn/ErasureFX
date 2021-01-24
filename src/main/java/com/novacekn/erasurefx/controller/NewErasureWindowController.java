package com.novacekn.erasurefx.controller;

import com.novacekn.erasurefx.model.OverwriteMethod;
import com.novacekn.erasurefx.model.VerificationMethod;
import com.novacekn.erasurefx.service.DeviceService;
import com.novacekn.erasurefx.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewErasureWindowController extends BaseController implements Initializable {

    public NewErasureWindowController(ViewFactory viewFactory, DeviceService deviceService, String fxmlName) {
        super(viewFactory, deviceService, fxmlName);
    }

    @FXML
    private Label newErasureTitleLabel;

    @FXML
    private ComboBox<String> erasureMethodBox;

    @FXML
    private ComboBox<String> verificationMethodBox;

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) newErasureTitleLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void eraseButtonAction() {
        Stage stage = (Stage) newErasureTitleLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
        viewFactory.showErasureConfirmationWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupErasureMethodBox();
        setupVerificationMethodBox();
        setupNewErasureTitleLabel();
    }

    private void setupNewErasureTitleLabel() {
        newErasureTitleLabel.setText("New Erasure for " + deviceService.getSelectedDevice().getDeviceName());
    }

    private void setupErasureMethodBox() {
        ArrayList<String> methods = new ArrayList<>();
        for (OverwriteMethod overwriteMethod : OverwriteMethod.getOverwriteMethods()) {
            methods.add(OverwriteMethod.getOverwriteMethodName(overwriteMethod));
        }
        erasureMethodBox.setItems(FXCollections.observableList(methods));
    }

    private void setupVerificationMethodBox() {
        ArrayList<String> methods = new ArrayList<>();
        for (VerificationMethod verificationMethod : VerificationMethod.getVerificationMethods()) {
            methods.add(VerificationMethod.getVerificationMethodName(verificationMethod));
        }
        verificationMethodBox.setItems(FXCollections.observableList(methods));
    }
}
