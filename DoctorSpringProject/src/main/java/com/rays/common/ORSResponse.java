package com.rays.common;

import java.util.*;

public class ORSResponse {

    private boolean success = true;
    private String message;
    private List<String> messages = new ArrayList<>();
    private Object data;

    public ORSResponse() {}

    public ORSResponse(boolean success) {
        this.success = success;
    }

    public void addMessage(String msg) {
        this.messages.add(msg);
    }

    public void addData(Object obj) {
        this.data = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
