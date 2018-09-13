package org.csu.travelbyex.core;

public class Result<T> {

    private int status;
    private T message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getMessage() {
        return message;
    }

    public Result setMessage(T message) {
        this.message = message;
        return this;
    }

}
