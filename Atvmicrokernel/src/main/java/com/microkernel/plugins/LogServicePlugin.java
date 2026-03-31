package com.microkernel.plugins;

import com.microkernel.core.Plugin;

public class LogServicePlugin implements Plugin {

    @Override
    public String getName() {
        return "Log Service";
    }

    @Override
    public void execute() {
        System.out.println("Registrando logs...");
    }

    @Override
    public void onEvent(String event) {
    System.out.println("[Log] Evento recebido: " + event);
}
}
