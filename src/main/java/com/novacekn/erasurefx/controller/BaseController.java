package com.novacekn.erasurefx.controller;

import com.novacekn.erasurefx.service.DeviceService;
import com.novacekn.erasurefx.view.ViewFactory;

public abstract class BaseController {

    protected ViewFactory viewFactory;
    protected DeviceService deviceService;
    private String fxmlName;

    public BaseController(ViewFactory viewFactory, DeviceService deviceService, String fxmlName) {
        this.viewFactory = viewFactory;
        this.deviceService = deviceService;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
