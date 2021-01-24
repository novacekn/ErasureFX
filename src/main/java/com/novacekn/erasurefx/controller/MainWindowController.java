package com.novacekn.erasurefx.controller;

import com.novacekn.erasurefx.model.Device;
import com.novacekn.erasurefx.service.DeviceService;
import com.novacekn.erasurefx.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    public MainWindowController(ViewFactory viewFactory, DeviceService deviceService, String fxmlName) {
        super(viewFactory, deviceService, fxmlName);
    }

    @FXML
    private Button newErasureButton;

    @FXML
    private ListView<Device> drivesListView;

    @FXML
    void newErasureButtonAction() {
        viewFactory.showNewErasureWindow();
    }

    @FXML
    void mouseClickedAction() {
        int index = drivesListView.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            newErasureButton.setDisable(false);
            deviceService.setSelectedDevice(deviceService.getDevices().get(index));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newErasureButton.setDisable(true);
        setupDrivesListView();
    }

    private void setupDrivesListView() {
        drivesListView.setItems(FXCollections.observableList(deviceService.getDevices()));
    }

}
