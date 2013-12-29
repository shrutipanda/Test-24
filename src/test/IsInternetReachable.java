
package test;

import java.awt.Desktop;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Task extends TimerTask {
    int count = 1;

    // run is a abstract method that defines task performed at scheduled time.
    public void run(){
        boolean check = IsInternetReachable.isInternetReachable();
        System.out.println(check);
        if(check && count!=0)
        {
            FileInputStream fstream = null;
            try {
                System.out.println("Internet Connection Present");
                count=0;
                //SwingBrowser.main(null);
                fstream = new FileInputStream("D:/Target/Temp/temporary.txt");
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                strLine=br.readLine();
                System.out.println(strLine);
                Desktop d=Desktop.getDesktop(); // Create Desktop 
                if(strLine==null)
                {
                    System.out.println("Printing in if: "+strLine);
                    
                    try {
                            // Browse a URL
                           d.browse(new URI("http://localhost:8084/pcs_video/index.html"));

                    } 
                    catch (Exception ex) {
                        Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                else
                {
                    try {
                    //Read File Line By Line
                    System.out.println("Printing in else: "+strLine);
                    Connection conn=null;
                    conn = DataBaseConnection.dbConnection();
                    Statement stmt = null;
                    stmt = (Statement) conn.createStatement();  
                    //stmt.executeUpdate(strLine);
                    
                    while ((strLine = br.readLine()) != null)   {
                    // Print the content on the console
                    System.out.println (strLine);
                    //stmt.executeUpdate(strLine);
                    }
                    
                    //Opening the web Mode 
                    // Create Desktop object
                    d = Desktop.getDesktop();
                    // Browse a URL
                    d.browse(new URI("http://localhost:8084/pcs_video/index.html"));

                    } 
                    catch (Exception ex) {
                        Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    //Sync_Upload.main("F:/abcd/mv.mp4");
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                try {
                    fstream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        else if(count==0 && !check)
        {
            System.out.println("Internet Connection Missing");
            count=1;
            index.main(null);
        }
    }
}
public class IsInternetReachable {
    
    public static boolean isInternetReachable()
        {
            try {
                //make a URL to a known source
                URL url = new URL("http://www.google.com");

                //open a connection to that source
                HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

                //trying to retrieve data from the source. If there
                //is no connection, this line will fail
                Object objData = urlConnect.getContent();

            } catch (UnknownHostException e) {
                //e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
               // e.printStackTrace();
                return false;
            }
            return true;
        }
    
    public static void main(String args[]) throws MalformedURLException, IOException
    {
        Timer timer = new Timer();
        // Schedule to run after every 3 second(3000 millisecond)
        timer.schedule( new Task(),0,3000);
        index.main(null);
    }
}
