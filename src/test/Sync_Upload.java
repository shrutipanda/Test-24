package test;
import java.net.*;
import java.io.*;

public class Sync_Upload
{
    public static void stream(InputStream in, OutputStream out)
        throws IOException {
    byte[] buf = new byte[1024];
    int bytesRead = 0;

    try {

        while (-1 != (bytesRead = in.read(buf, 0, buf.length))) {
            //System.out.println(buf);
            out.write(buf, 0, bytesRead);
        }

    } catch (IOException e) {
//        log.error("Error with streaming op: " + e.getMessage());
        throw (e);
    } finally {
                    try{
           in.close();
           out.flush();
           out.close();
                    } catch (Exception e){}//Ignore
    }
}
   public static void main(String[] args)
   {
       
      String serverName = "127.0.0.1";
      //String serverName = "localhost";
      int port = Integer.parseInt("4445");
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         
         OutputStream os = client.getOutputStream();
         InputStream is = new FileInputStream(new File("E:/movie.mp4"));
          stream(is, os);
          
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}