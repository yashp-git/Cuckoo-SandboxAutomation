package com.dkpartners.sandboxinstance;
import java.io.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class sftpUpload {

    public sftpUpload(){ }

    public boolean uploadInstance(sandboxInstance instance){
        boolean flag = false;
        Session session = null;
        Channel channel = null;
        ChannelSftp channelSftp = null;
        try {
            privateKey prvkey = new privateKey();
            prvkey.create();
            JSch jsch = new JSch();
            jsch.addIdentity(instance.getPrivateKey());
            session = jsch.getSession(instance.getUser(), instance.getHost(), instance.getPort());
            session.setPassword(instance.getPass());
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(instance.getRemoteDir());
            File source = new File(instance.getLocalDir());

            if(source.exists() == true) {
                if (source.isDirectory() == true) {
                    //System.out.println("DIR");
                    File[] listOfFiles = source.listFiles();
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            //System.out.println("File " + listOfFiles[i].getName());
                            channelSftp.put(new FileInputStream(listOfFiles[i]), instance.getRequest()+"_"+listOfFiles[i].getName());
                            System.out.println("[*] Done");
                            flag=true;
                        } else{
                            //System.out.println("Directory " + listOfFiles[i].getName());
                            flag=false;
                        }
                    }
                } else if (source.isFile() == true ) {
                    //System.out.println("FILE");
                    channelSftp.put(new FileInputStream(source), instance.getRequest()+"_"+source.getName());
                    System.out.println("[*] Done");
                    flag=true;
                }
            }else
            {
                System.out.println("[*] Source doesn't exists");
                flag=false;
            }

            //channelSftp.put(new FileInputStream(source), source.getName());
            prvkey.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

}