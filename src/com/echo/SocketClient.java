package com.echo;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello world!\r".getBytes());
        outputStream.flush();

        InputStream inputStream = socket.getInputStream();
        //System.out.println(inputStream.available());
        while (true){
            if(inputStream.available() != 0){
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println(reader.readLine());
                outputStream.close();
                inputStream.close();
                socket.close();
            }
            else {
                inputStream = socket.getInputStream();
            }
        }
    }
}
