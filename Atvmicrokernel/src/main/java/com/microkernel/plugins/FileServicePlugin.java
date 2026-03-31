package com.microkernel.plugins;

import com.microkernel.core.Plugin;

public class FileServicePlugin implements Plugin {

    @Override
    public String getName() {
        return "File Service";
    }

    @Override
    public void execute() {
        System.out.println("Manipulando arquivos...\n");
    }
    @Override
    public void onEvent(String event) {
        
    if (event.equals("FILE_UPLOAD")) {
        System.out.println("[File] Arquivo processado!");
    }
}
    
}