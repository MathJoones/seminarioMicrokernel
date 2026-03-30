package com.microkernel.plugins;

import com.microkernel.core.Plugin;
import java.util.Map;

public class FileServicePlugin implements Plugin {

    @Override
    public String getName() {
        return "file";
    }

    @Override
    public String handle(String action, Map<String, String> params) {
        return switch (action) {
            case "read" -> {
                String filename = params.getOrDefault("filename", "?");
                yield "[FileService] Lendo arquivo: " + filename;
            }
            case "write" -> {
                String filename = params.getOrDefault("filename", "?");
                String content  = params.getOrDefault("content", "");
                yield "[FileService] Escrevendo em '" + filename + "': " + content;
            }
            case "delete" -> {
                String filename = params.getOrDefault("filename", "?");
                yield "[FileService] Arquivo deletado: " + filename;
            }
            default -> "[FileService] Ação desconhecida: " + action;
        };
    }
}
