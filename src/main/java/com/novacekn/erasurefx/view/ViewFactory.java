package com.novacekn.erasurefx.view;

import com.novacekn.erasurefx.controller.BaseController;
import com.novacekn.erasurefx.controller.ErasureConfirmationWindow;
import com.novacekn.erasurefx.controller.MainWindowController;
import com.novacekn.erasurefx.controller.NewErasureWindowController;
import com.novacekn.erasurefx.service.DeviceService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private DeviceService deviceService;

    public ViewFactory(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public void showMainWindow() {
        BaseController baseController = new MainWindowController(this, deviceService, "MainWindow.fxml");
        initializeStage(baseController);
    }

    public void showNewErasureWindow() {
        BaseController baseController = new NewErasureWindowController(this, deviceService, "NewErasureWindow.fxml");
        initializeStage(baseController);
    }

    public void showErasureConfirmationWindow() {
        BaseController baseController = new ErasureConfirmationWindow(this, deviceService, "ErasureConfirmationWindow.fxml");
        initializeStage(baseController);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/" + baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
    }
}
