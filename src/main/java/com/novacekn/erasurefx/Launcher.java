package com.novacekn.erasurefx;

import com.novacekn.erasurefx.service.DeviceService;
import com.novacekn.erasurefx.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public Launcher() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    private DeviceService deviceService = new DeviceService();

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(deviceService);
        viewFactory.showMainWindow();
    }
}
