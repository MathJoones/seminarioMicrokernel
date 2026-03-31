package com.microkernel.core;

import java.util.ArrayList;
import java.util.List;

public class Microkernel {

    private List<Plugin> plugins = new ArrayList<>();

    public void registerPlugin(Plugin plugin) {
        plugins.add(plugin);
        System.out.println("Plugin registrado: " + plugin.getName());
    }

    public void executePlugins() {
        for (Plugin plugin : plugins) {
            System.out.println("Executando: " + plugin.getName() + "\n");
            plugin.execute();
        }
    }

    
    /*public void unregisterPlugin(String name) {
        if (plugins.remove(name) != false) {
            System.out.println("[Kernel] Plug-in removido: '" + name + "'");
        } else {
            System.out.println("[Kernel] AVISO: plug-in '" + name +  "' não estava registrado.");
        }
    }*/

    //sistema de eventos
    public void notifyEvent(String event) {
        System.out.println("\n[Kernel] Disparando evento: " + event);

        for (Plugin plugin : plugins) {
            plugin.onEvent(event);
        }
    }
}