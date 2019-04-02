package com.example.edulib;

public class Chat {
    String name, pesan;
    boolean isMe;

    public Chat(String name, String pesan, boolean isMe) {
        this.name = name;
        this.pesan = pesan;
        this.isMe = isMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }
}
