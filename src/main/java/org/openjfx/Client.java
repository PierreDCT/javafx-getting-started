package org.openjfx;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8888);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("0.8");
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}