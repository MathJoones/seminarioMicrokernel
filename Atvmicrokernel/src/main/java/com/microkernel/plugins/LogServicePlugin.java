package com.microkernel.plugins;

import com.microkernel.core.Plugin;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class LogServicePlugin implements Plugin {
    //formato hora
    private static final DateTimeFormatter FMT =
        DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public String getName() {
        return "log";
    }

    @Override
    public String handle(String action, Map<String, String> params) {
        if ("log".equals(action)) {
            String message   = params.getOrDefault("message", "");
            String level     = params.getOrDefault("level", "INFO").toUpperCase();
            String timestamp = LocalTime.now().format(FMT);
            return "[LogService] " + timestamp + " [" + level + "] " + message;
        }
        return "[LogService] Ação desconhecida: " + action;
    }
}
