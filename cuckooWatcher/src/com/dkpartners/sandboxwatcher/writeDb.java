package com.dkpartners.sandboxwatcher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class writeDb {

    public writeDb(String timestamp,String md5hex,String email,String filename) throws IOException {
        write(timestamp,md5hex,email,filename);
    }

    public boolean write(String timestamp, String md5hex, String email,String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("db/files.txt", true));
        writer.append(timestamp+"::"+md5hex+"::"+email+"::"+filename+"\n");
        writer.close();
        return true;
    }

}
