package com.novacekn.erasurefx.controller;

import com.novacekn.erasurefx.service.DeviceService;
import com.novacekn.erasurefx.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ErasureConfirmationWindow extends BaseController implements Initializable {

    @FXML
    private Label warningLabel;

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) warningLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void eraseButtonAction() {

    }

    public ErasureConfirmationWindow(ViewFactory viewFactory, DeviceService deviceService, String fxmlName) {
        super(viewFactory, deviceService, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
