package com.giftsdelivery.giftsitems.exeption;

public class ResourceNotFoundException extends Exception{

   public ResourceNotFoundException() {
        super("Doesn't Exists!");
    }
}
