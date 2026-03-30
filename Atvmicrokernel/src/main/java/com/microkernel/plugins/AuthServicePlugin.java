package com.microkernel.plugins;

import com.microkernel.core.Plugin;
import java.util.Map;

public class AuthServicePlugin implements Plugin {

    private final Map<String, String> users = Map.of(
        "admin", "1234",
        "matheus",  "senha"
    );

    @Override
    public String getName() {
        return "auth";
    }

    @Override
    public String handle(String action, Map<String, String> params) {
        return switch (action) {
            case "login" -> {
                String user     = params.getOrDefault("user", "");
                String password = params.getOrDefault("password", "");
                boolean ok      = password.equals(users.get(user));
                yield ok
                    ? "[AuthService] Login bem-sucedido: " + user
                    : "[AuthService] Credenciais inválidas.";
            }
            case "logout" -> {
                String user = params.getOrDefault("user", "?");
                yield "[AuthService] Logout efetuado: " + user;
            }
            default -> "[AuthService] Ação desconhecida: " + action;
        };
    }
}
