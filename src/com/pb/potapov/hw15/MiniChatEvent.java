package com.pb.potapov.hw15;

public interface MiniChatEvent {

    void onConnectionReady(MiniChatConnection mcConnection);
    void onReceiveString(MiniChatConnection mcConnection, String msg);
    void onDisconnect(MiniChatConnection mcConnection);
    void onException(MiniChatConnection mcConnection, Exception ex);

}
