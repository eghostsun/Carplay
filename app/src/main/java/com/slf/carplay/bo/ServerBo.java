package com.slf.carplay.bo;

public class ServerBo {

    private int serverId;
    private String serverIp;
    private int serverPort;

    public final static String SERVER_ID = "serverId";
    public final static String SERVER_IP = "serverIp";
    public final static String SERVER_PORT = "serverPort";

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
