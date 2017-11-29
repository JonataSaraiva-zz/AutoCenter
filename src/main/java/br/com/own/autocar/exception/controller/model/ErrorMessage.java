package br.com.own.autocar.exception.controller.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorMessage {

    private List<String> messages;

    public ErrorMessage(List<String> messages) {
        this.messages = messages;
    }
}
