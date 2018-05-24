package com.dkpartners.sandboxwatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class createBash {



    public void setCuckoCmd(String path, String username){

        String cuckoCmd = "sudo runuser -l  "+username+" -c 'cuckoo -d submit \""+path+"\"'";

        try {
            FileWriter fw = new FileWriter("/home/"+username+"/cuckooWatcher/script/script.sh");
            PrintWriter pw = new PrintWriter(fw);
            pw.println("#!/bin/bash");
            pw.println(cuckoCmd);
            pw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Process proc = null;

        try {
            proc = Runtime.getRuntime().exec("sudo sh /home/"+username+"/cuckooWatcher/script/script.sh");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}