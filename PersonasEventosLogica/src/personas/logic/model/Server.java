/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.logic.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import personas.IModel;
import personas.Protocol;

/**
 *
 * @author jsanchez
 */
public class Server {

    ServerSocket srv;
    
    public Server() {
        try {
            srv = new ServerSocket(Protocol.PORT);
            System.out.println("Servidor iniciado...");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        IModel Model = new Model();

        boolean continuar = true;
        while (continuar) {
            try {
                Socket skt = srv.accept();
                System.out.println("Conexion Establecida...");
                ModelWorker worker = new ModelWorker(skt,Model);    
                worker.start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
    
}