package com.dkpartners.sandboxinstance;

import java.io.*;

public class privateKey {

    public privateKey(){
    }


    public void create() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("infosecsandbox.ppk"));
        writer.println("PuTTY-User-Key-File-2: ssh-rsa");
        writer.println("Encryption: none");
        writer.println("Comment: imported-openssh-key");
        writer.println("");
        writer.close();
        System.out.println("Private key has created");
    }

    public void delete(){
        File file = new File("infosecsandbox.ppk");
        if(file.exists()){
            file.delete();
            System.out.println("Private key has deleted");
        }
    }
}
