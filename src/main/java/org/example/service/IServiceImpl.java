package org.example.service;

import org.example.annotation.LuisService;

@LuisService
public class IServiceImpl implements IService{
    @Override
    public String sayCustomMessage(String message) {
        return "LUIS "+message;
    }
}
