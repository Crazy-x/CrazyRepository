package com.crazy.coding.entity.common;

public class ErrorResult extends Result {

    private boolean error = true;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}
