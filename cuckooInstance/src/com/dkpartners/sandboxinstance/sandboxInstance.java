package com.dkpartners.sandboxinstance;

public class sandboxInstance {

    private String host = null;
    private int port;
    private String user = null;
    private String pass = null;
    private String localDir = null;
    private String remoteDir = null;
    private String request = null;
    private String privateKey = null;


    public sandboxInstance(String privateKey,String host, int port, String user, String pass,String localDir, String remoteDir,String request){
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.localDir = localDir;
        this.remoteDir = remoteDir;
        this.request = request;
        this.privateKey = privateKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLocalDir() {
        return localDir;
    }

    public void setLocalDir(String localDir) {
        this.localDir = localDir;
    }

    public String getRemoteDir() {
        return remoteDir;
    }

    public void setRemoteDir(String remoteDir) {
        this.remoteDir = remoteDir;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getPrivateKey() {return privateKey; }

    public void setPrivateKey(String privateKey) {this.privateKey = privateKey; }
}
