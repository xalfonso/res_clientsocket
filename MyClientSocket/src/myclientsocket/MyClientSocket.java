/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclientsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Eduardo
 */
public class MyClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        String hostName = "127.0.0.1";
        int portNumber = 9095;
        
        try {
            Socket echoSocket =  new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput); //send message to server
                System.out.println("Response from server: " + in.readLine()); //mensaje from server
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }

}
