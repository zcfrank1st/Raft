package com.chaos.raft.rpc;

import com.chaos.raft.role.Role;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by zcfrank1st on 2/3/15.
 */
public class Client implements Runnable {
    private SocketChannel socketChannel = null;
    private Role role = null;

    public Client(Role role, String addr, int port) {
        this.role = role;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(addr, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socketChannel.socket().getOutputStream()));
            while (true) {
                // out.writeObject(new Message());
                out.flush();
            }
        } catch (IOException e) {
        }
    }
}
