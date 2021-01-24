package com.novacekn.erasurefx.model;

import java.util.ArrayList;

public enum VerificationMethod {
    FULL,
    SAMPLING,
    NONE;

    public static ArrayList<VerificationMethod> getVerificationMethods() {
        ArrayList<VerificationMethod> methods = new ArrayList<>();
        methods.add(FULL);
        methods.add(SAMPLING);
        methods.add(NONE);
        return methods;
    }

    public static String getVerificationMethodName(VerificationMethod verificationMethod) {
        return switch (verificationMethod) {
            case FULL -> "Full";
            case SAMPLING -> "Random Sampling";
            case NONE -> "No Verification";
        };
    }
}
