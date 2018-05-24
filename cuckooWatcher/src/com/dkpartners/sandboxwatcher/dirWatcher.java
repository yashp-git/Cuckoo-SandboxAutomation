package com.dkpartners.sandboxwatcher;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class dirWatcher {

    private String dir = null;
    String path = null;
    public dirWatcher(){}

    public boolean watcher(String dir,String username) throws IOException, InterruptedException, NoSuchAlgorithmException {

        createBash bash = new createBash();
        Path folder = Paths.get(dir);
        WatchService watchService;
        watchService = FileSystems.getDefault().newWatchService();
        folder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        MessageDigest md = MessageDigest.getInstance("MD5");
        Pattern p = Pattern.compile("^([a-zA-Z]+)(\\_)(.*)");
        boolean valid = true;
        String md5hex = null;
        String timestamp = null;
        String email= null;
        do {
            WatchKey watchKey = watchService.take();
            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString().trim();
                    System.out.println("[*] File uploaded :"+ dir +"/" + fileName);
                    path = dir+"/"+fileName;
                    md.update(fileName.getBytes());
                    byte[] digest = md.digest();
                    md5hex= DatatypeConverter.printHexBinary(digest).toUpperCase();
                    timestamp= new Timestamp(System.currentTimeMillis()).toString();
                    Matcher m = p.matcher(fileName);
                    if (m.find()) {email = m.group(1).toString();}
                    new writeDb(timestamp,md5hex,email,fileName);
                  //  bash.setCuckoCmd(path,username);
                }
            }
            valid = watchKey.reset();
        } while (valid);

        return false;
    }

}