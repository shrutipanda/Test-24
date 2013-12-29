/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Files {
    public static String[] files() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
              Connection conn = null;
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcs", "root", "root");
              java.sql.Statement statement = conn.createStatement();
              String query="select video_name from videos;";
              ResultSet rs = null;
              rs = (ResultSet) statement.executeQuery(query);
             // statement.executeQuery(query);
              ArrayList al=new ArrayList();
              while(rs.next())
              {
                   al.add(rs.getString(1));
                   
              }
              String[] files;    
            if(al.size()==0)
            {
                files= new String[]{""};
            }
            else
            {
                files= new String[al.size()];
              
                for(int i=0;i<al.size();i++)
                {
                    files[i]=al.get(i).toString();
                  
                }
            }
            return files;
          
          
    
    }
    
}
