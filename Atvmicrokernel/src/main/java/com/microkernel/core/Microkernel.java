package com.microkernel.core;

import java.util.HashMap;
import java.util.Map;

public class Microkernel {

    private final Map<String, Plugin> plugins = new HashMap<>();

    //Gerenciamento de plug-ins
    public void registerPlugin(Plugin plugin) {
        plugins.put(plugin.getName(), plugin);
        System.out.println("[Kernel] Plug-in registrado: '" + plugin.getName() + "'");
    }

    public void unregisterPlugin(String name) {
        if (plugins.remove(name) != null) {
            System.out.println("[Kernel] Plug-in removido: '" + name + "'");
        } else {
            System.out.println("[Kernel] AVISO: plug-in '" + name + "' não estava registrado.");
        }
    }

    public boolean hasPlugin(String name) {
        return plugins.containsKey(name);
    }

    //IPC — Passa msg
    public String sendMessage(String pluginName, String action, Map<String, String> params) {
        Plugin plugin = plugins.get(pluginName);

        if (plugin == null) {
            return "[Kernel] ERRO: plug-in '" + pluginName + "' não encontrado.";
        }

        return plugin.handle(action, params);
    }
}
