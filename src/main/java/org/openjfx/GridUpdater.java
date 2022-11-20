package org.openjfx;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GridUpdater extends Thread {
    private MyGrid myGrid;

    public GridUpdater(MyGrid myGrid) {
        this.myGrid = myGrid;
    }
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);
            ss.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}