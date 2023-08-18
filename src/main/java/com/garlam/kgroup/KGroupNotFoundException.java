package com.garlam.kgroup;

public class KGroupNotFoundException extends  RuntimeException{
    public KGroupNotFoundException(){
        super("Group not found");
    }
}
