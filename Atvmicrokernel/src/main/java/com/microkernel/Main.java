package com.microkernel;

import com.microkernel.core.*;

public class Main {

    public static void main(String[] args) {

        Microkernel kernel = new Microkernel();

        //usando loader
        PluginLoader.loadPlugins().forEach(kernel::registerPlugin);

        System.out.println("\n--- Executando Plugins ---\n");
        kernel.executePlugins();

        //disparando eventos
        kernel.notifyEvent("USER_LOGIN");
        System.out.println("Seja bem vindo Matheus");
        kernel.notifyEvent("FILE_UPLOAD");
        System.out.println("Negócio chato de mexer\n");

        /*kernel.unregisterPlugin("auth");
        System.out.println("Plugin removido com sucesso");*/

        
    }
}