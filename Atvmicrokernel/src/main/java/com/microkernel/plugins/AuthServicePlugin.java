package com.microkernel.plugins;

import com.microkernel.core.Plugin;

public class AuthServicePlugin implements Plugin {

    @Override
    public String getName() {
        return "Auth Service";
    }

    @Override
    public void execute() {
        System.out.println("Executando autenticação...\n");
    }

    @Override
    public void onEvent(String event) {
        if (event.equals("USER_LOGIN")) {
            System.out.println("[Auth] Usuário autenticado!");
        }
    }
}