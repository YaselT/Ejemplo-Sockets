/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsanchez
 */
public class Protocol {

    public static final String SERVER = "localhost";
    public static final int PORT = 1234;

    public static final int ADD_PERSONA=0;
    public static final int DELETE_PERSONA=1;
    public static final int GET_ESTADOCIVIL=2;
    public static final int GET_ESTADOSCIVILES=3;
    public static final int GET_PERSONA=4;
    public static final int SEARCH_PERSONAS=5;
    public static final int UPDATE_PERSONA=6;
    public static final int CLOSE=7;
    public static final int ESTADISTICA=8;
    
    public static final int ERROR_NO_ERROR=0;
    public static final int ERROR_ADD_PERSONA=1;
    public static final int ERROR_DELETE_PERSONA=2;
    public static final int ERROR_GET_ESTADOCIVIL=3;
    public static final int ERROR_GET_PERSONA=4;
    public static final int ERROR_UPDATE_PERSONA=5;
        
}