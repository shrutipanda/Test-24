/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 *
 * @author Anku
 */
public class Base {
    public static void main(String[] args) throws IOException, URISyntaxException
    {
     //Desktop d=Desktop.getDesktop();
     //d.browse(new URI("http://localhost:8084/pcs_video/Sync_Online_Upload"));
        
        BufferedReader br = null;  
        BufferedWriter bw = null;  
          
        try{  
            br = new BufferedReader(new FileReader("D:/abcd/notes.txt"));  
            bw = new BufferedWriter(new FileWriter("D:/abcd/ab1.html"));  
              
            String line = br.readLine();  
              
            for( int i = 1; i <= 10 && line != null; i++)  
            {  
               // System.out.println(line);
                if(line.contains("<source "))
                {
                    bw.write("<source src=\"movie.mp4\" type=\"video/mp4\"> </video>");
                }
                else
                {
                    bw.write(line);  
                    bw.write("\n");  
                }
                line = br.readLine();  
            }  
              
            System.out.println("Lines are Successfully copied!");  
              
            br.close();  
            bw.close();  
        }  
        catch(Exception e){  
            System.out.println("Exception caught : " + e);  
        }  
    }
    
    public void changeVideoname(String selectedVideo) throws IOException
    {
        BufferedReader br = null;  
        BufferedWriter bw = null;  
          
        try{  
            br = new BufferedReader(new FileReader("D:/Target/notes.txt"));  
            bw = new BufferedWriter(new FileWriter("D:/Target/ab.html"));  
              
            String line = br.readLine();  
              
            for( int i = 1; i <= 10 && line != null; i++)  
            {  
               // System.out.println(line);
                if(line.contains("<source "))
                {
                    bw.write("<source src=\""+selectedVideo+"\" type=\"video/mp4\"> </video>");
                }
                else
                {
                    bw.write(line);  
                    bw.write("\n");  
                }
                line = br.readLine();  
            }  
              
            System.out.println("Lines are Successfully copied!");  
              
            br.close();  
            bw.close();  
        }  
        catch(Exception e){  
            System.out.println("Exception caught : " + e);  
        }  
       
    }
}
