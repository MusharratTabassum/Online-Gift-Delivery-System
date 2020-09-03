package com.giftsdelivery.order_info.exception;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException() {
        super("doesn't Exists!");
    }
}