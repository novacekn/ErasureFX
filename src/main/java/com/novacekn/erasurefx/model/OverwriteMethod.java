package com.novacekn.erasurefx.model;

import java.util.ArrayList;

public enum OverwriteMethod {
    ZERO,
    ONE,
    RANDOM,
    DOD_THREE_PASS,
    DOD_SEVEN_PASS;

    public static ArrayList<OverwriteMethod> getOverwriteMethods() {
        ArrayList<OverwriteMethod> methods = new ArrayList<OverwriteMethod>();
        methods.add(ZERO);
        methods.add(ONE);
        methods.add(RANDOM);
        methods.add(DOD_THREE_PASS);
        methods.add(DOD_SEVEN_PASS);
        return methods;
    }

    public static String getOverwriteMethodName(OverwriteMethod overwriteMethod) {
        return switch (overwriteMethod) {
            case ZERO -> "Zero Overwrite";
            case ONE -> "One Overwrite";
            case RANDOM -> "Random Overwrite";
            case DOD_THREE_PASS -> "DoD 5220.22-M";
            case DOD_SEVEN_PASS -> "DoD 5220.22-M ECE";
        };
    }

    public static ArrayList<Byte> getOverwriteMethodData(OverwriteMethod overwriteMethod) {
        ArrayList<Byte> bytesList = new ArrayList<Byte>();
        switch (overwriteMethod) {
            case ZERO:
                bytesList.add(Byte.valueOf("0"));
                return bytesList;
            case ONE:
                bytesList.add(Byte.valueOf("1"));
                return bytesList;
            case RANDOM:
                bytesList.add(Byte.valueOf("2"));
                return bytesList;
            case DOD_THREE_PASS:
                bytesList.add(Byte.valueOf("0"));
                bytesList.add(Byte.valueOf("1"));
                bytesList.add(Byte.valueOf("2"));
                return bytesList;
            case DOD_SEVEN_PASS:
                bytesList.add(Byte.valueOf("0"));
                bytesList.add(Byte.valueOf("1"));
                bytesList.add(Byte.valueOf("2"));
                bytesList.add(Byte.valueOf("0"));
                bytesList.add(Byte.valueOf("0"));
                bytesList.add(Byte.valueOf("1"));
                bytesList.add(Byte.valueOf("2"));
                return bytesList;
            default:
                return null;
        }
    }
}
