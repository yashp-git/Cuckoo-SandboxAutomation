package com.dkpartners.sandboxwatcher;

import java.io.File;

public class setupCuckoo {

    public String username;

    public setupCuckoo(String username){
        this.username=username;
    }

    public boolean run(){
        File dir1 = new File("/home/"+username+"/cuckooWatcher");
        File dir2 = new File("/home/"+username+"/cuckooWatcher/remoteDir");
        File dir3 = new File("/home/"+username+"/cuckooWatcher/script");
        boolean success = false;

        if (!dir1.exists()) {
            if (dir1.mkdir()) {
                if (dir2.mkdir()) {
                    if (dir3.mkdir()) {
                        success = true;
                    }
                }
            }
        }
        else{
            success = true;
        }
        return success;
    }
}
