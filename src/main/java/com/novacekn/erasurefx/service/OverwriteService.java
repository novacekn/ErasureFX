package com.novacekn.erasurefx.service;

import com.novacekn.erasurefx.model.Device;
import com.novacekn.erasurefx.model.OverwriteMethod;

public class OverwriteService {

    private OverwriteMethod overwriteMethod;
    private Device device;

    public OverwriteService(OverwriteMethod overwriteMethod, Device device) {
        this.overwriteMethod = overwriteMethod;
        this.device = device;
    }
}
