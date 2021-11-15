package com.test.api.common;

import lombok.Data;

@Data
public class ResponseMessage {
    private StatusEnum status;
    private String message;
    private Object data;

    public ResponseMessage() {
        this.status = StatusEnum.BAD_REQUEST;
        this.data = null;
        this.message = null;
    }
}