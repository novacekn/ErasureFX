package com.novacekn.erasurefx.service;

import com.novacekn.erasurefx.model.Device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DeviceService {

    private ArrayList<Device> devices;
    private ArrayList<String> rawDevices;
    private Device selectedDevice;

    public DeviceService() throws IOException {
        devices = new ArrayList<>();
        rawDevices = new ArrayList<>();
        getRawDevices();
    }

    private void getRawDevices() throws IOException {
        String command = "lsblk -o NAME,SIZE,MODEL -np --nodeps";
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("/dev/sd") || line.contains("/dev/nvm")) {
                    rawDevices.add(line);
                }
            }
            parseRawDevices();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRawDevices() {
        String delimiter = "[ ]+";
        for (String deviceString : rawDevices) {
            String[] tokens = deviceString.split(delimiter);
            Device device = new Device(tokens[0], tokens[1], tokens[2]);
            devices.add(device);
        }
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public Device getDevice(String deviceString) {
        for (Device device : devices) {
            if (deviceString.contains(device.getDeviceName())) {
                return device;
            }
        }
        return null;
    }

    public Device getSelectedDevice() {
        return selectedDevice;
    }

    public void setSelectedDevice(Device selectedDevice) {
        this.selectedDevice = selectedDevice;
    }
}
