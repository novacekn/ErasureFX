package com.novacekn.erasurefx.model;

public class Device {

    private String deviceName;
    private String deviceSize;
    private String deviceModel;

    public Device(String deviceName, String deviceSize, String deviceModel) {
        this.deviceName = deviceName;
        this.deviceSize = deviceSize;
        this.deviceModel = deviceModel;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceSize() {
        return deviceSize;
    }

    public void setDeviceSize(String deviceSize) {
        this.deviceSize = deviceSize;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public String toString() {
        return deviceName + "    " + deviceSize + "    " + deviceModel;
    }
}
