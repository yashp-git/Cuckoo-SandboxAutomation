package com.dkpartners.sandboxinstance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class cuckooMain {

    public static void main (String[] args) throws IOException {
        String host = "";
        int port = 22;
        String user = "ubuntu";
        String pass ="";
        String remoteDir = "/home/"+user+"/cuckooWatcher/remoteDir/";
        dropPanel panel;
        panel = new dropPanel();

        panel.dragFile("infosecsandbox.ppk",host,22,user,pass,remoteDir);
    }
}