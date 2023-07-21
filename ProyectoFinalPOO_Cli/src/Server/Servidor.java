package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread
{
    
  public static void main (String args[])
  {
    ServerSocket sfd = null;
    try
    {
      sfd = new ServerSocket(7000);
    }
    catch (IOException ioe)
    {
      System.out.println("Comunicación rechazada."+ioe);
      System.exit(1);
    }

    while (true)
    {
      try
      {
        Socket nsfd = sfd.accept();
        System.out.println("Conexion aceptada de: "+nsfd.getInetAddress());
        DataInputStream FlujoLectura = new DataInputStream(new BufferedInputStream(nsfd.getInputStream()));
        String linea = FlujoLectura.readUTF();
        String text = "";
        if (!linea.equals(""))
 	     {
          text = text+" "+ linea;
          System.out.println(text);
  	   }
      } 
      catch(IOException ioe)
      {
        System.out.println("Error: "+ioe);
      }
    }
  }
}
