package com.microkernel;

import com.microkernel.core.Microkernel;
import com.microkernel.plugins.AuthServicePlugin;
import com.microkernel.plugins.FileServicePlugin;
import com.microkernel.plugins.LogServicePlugin;

import java.util.Map;

//Ponto de entrada da aplicação, demonstra o funcionamento completo da arquitetura Microkernel
public class Main {

    public static void main(String[] args) {

        // 1. Inicializa o Microkernel (núcleo mínimo)
        Microkernel kernel = new Microkernel();

        // 2. Registra os plug-ins — podem ser trocados sem alterar o kernel
        kernel.registerPlugin(new FileServicePlugin());
        kernel.registerPlugin(new AuthServicePlugin());
        kernel.registerPlugin(new LogServicePlugin());

        System.out.println();

        // 3. Comunicação via IPC passa msg

        //autenticação
        System.out.println(kernel.sendMessage("auth", "login",
            Map.of("user", "admin", "password", "1234")));

        System.out.println(kernel.sendMessage("auth", "login",
            Map.of("user", "admin", "password", "errada")));

        //serviço de arquivo
        System.out.println(kernel.sendMessage("file", "read",
            Map.of("filename", "dados.txt")));

        System.out.println(kernel.sendMessage("file", "write",
            Map.of("filename", "saida.txt", "content", "Olá Matheus !")));

        //log eventos
        System.out.println(kernel.sendMessage("log", "log",
            Map.of("message", "Sistema iniciado", "level", "info")));

        System.out.println(kernel.sendMessage("log", "log",
            Map.of("message", "Falha ao conectar", "level", "error")));

        System.out.println();

        // 4. Demonstração, remoção de plug-in em tempo de execução, o kernel continua funcionando normalmente para os demais.
        kernel.unregisterPlugin("auth");

        System.out.println(kernel.sendMessage("auth", "login",
            Map.of("user", "admin", "password", "1234")));
    }
}
