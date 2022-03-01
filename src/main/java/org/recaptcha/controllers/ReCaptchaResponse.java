package org.recaptcha.controllers;

public class ReCaptchaResponse {

    private boolean success;
    private String challange_ts;
    private String hostname;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getChallange_ts() {
        return challange_ts;
    }

    public void setChallange_ts(String challange_ts) {
        this.challange_ts = challange_ts;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
