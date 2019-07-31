package com.dieznote.ks_internship.models;

import java.util.Objects;

public class ResponseErrorItem {

    private String message;
    private String documentation_url;

    public ResponseErrorItem(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDocumentation_url() {
        return documentation_url;
    }

    public void setDocumentation_url(String documentation_url) {
        this.documentation_url = documentation_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseErrorItem that = (ResponseErrorItem) o;

        return Objects.equals(message, that.message);

    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }
}
