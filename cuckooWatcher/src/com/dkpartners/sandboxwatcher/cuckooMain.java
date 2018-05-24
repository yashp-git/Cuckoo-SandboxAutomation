package com.dkpartners.sandboxwatcher;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class cuckooMain {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String username = System.getProperty("user.name");
        dirWatcher listner;
        setupCuckoo cuckoo;
        listner = new dirWatcher();
        String remoteDir = "remoteDir";
        //String remoteDir = "/home/"+username+"/cuckooWatcher/remoteDir";
       // cuckoo = new setupCuckoo(username);
       // if(cuckoo.run()){
            try {
                boolean uploadedFile = listner.watcher(remoteDir,username);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
        //    }
        }
    }
}