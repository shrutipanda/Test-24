 
package test;
 
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.concurrent.Worker.State.FAILED;
 

public class SimpleSwingBrowser1 extends JFrame {

    String selectedVideo;
    private JFXPanel jPanel1;
    private WebEngine engine;
    private JPanel panel;
    private  JTextField txtURL = new JTextField();
//   -----------------------------------------------------------------------
     private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    //private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField2;
  //   -----------------------------------------------------------------------
    public SimpleSwingBrowser1() {
        super();
        initComponents();
    }

    private void initComponents() {
    //    jfxPanel = new JFXPanel();
         jPanel1 = new JFXPanel();
        createScene();
    //   -----------------------------------------------------------------------
        
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        //jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 30, 67, 0);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(390, 140, 140, 36);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SimpleSwingBrowser1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SimpleSwingBrowser1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(540, 140, 90, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter key word to search");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 140, 160, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(680, 140, 140, 30);

        jButton2.setText("Play Video");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(SimpleSwingBrowser1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(840, 140, 100, 30);

        jButton5.setText("HOME");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(700, 40, 61, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Capture.JPG"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 20, 200, 50);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(230, 190, 400, 320);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(650, 190, 290, 320);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.jpg"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(20, 180, 190, 70);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.jpg"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 110, 190, 70);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.jpg"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(20, 250, 190, 70);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(20, 320, 190, 70);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.jpg"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(20, 390, 190, 70);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.jpg"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(20, 460, 190, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/black-background.jpeg"))); // NOI18N
        jLabel1.setIconTextGap(0);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 980, 600);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-994)/2, (screenSize.height-635)/2, 994, 635);
//   -----------------------------------------------------------------------
        pack();
    }
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
       
    }                                           

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, SQLException {  
        String key=jTextField2.getText();
        ArrayList<String> a = new ArrayList<String>(); 
        try {
            // TODO add your handling code here:
            Connection conn=null;
            conn = DataBaseConnection.dbConnection();
            Statement stmt = null;
            stmt = (Statement) conn.createStatement();       
           
           String query="SELECT video_name,path,description from videos";
           ResultSet rs  = stmt.executeQuery(query);
           while(rs.next())
           {
               String vname=rs.getString(1);
               String desc = rs.getString(3);
               if(vname.contains(key)||desc.contains(key))
               {
                   a.add(vname);
               }     
           }
           if(a.size()==0)
           {
              JOptionPane.showMessageDialog(null,"Key word not found !!!");
           }
           String[] arr = new String[a.size()];
           arr = a.toArray(arr);
           jComboBox1.setModel(new DefaultComboBoxModel(arr));
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }                                        

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                         
         try {
            // TODO add your handling code here:
            String choice = (String) jComboBox1.getSelectedItem();
            String text ="";
             Base b = new Base();
            b.changeVideoname(choice);
            Connection conn=null;
            conn = DataBaseConnection.dbConnection();
            Statement stmt = null;
            stmt = (Statement) conn.createStatement();       
           
           String query="SELECT video_name,path,description from videos";
           ResultSet rs  = stmt.executeQuery(query);
           while(rs.next())
           {
               String a=rs.getString(1);
                if(a.contains(choice))
                {
                    text=rs.getString(3);
                    BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Target/Description.txt"));
                    bw.write(text);
                    
                }
           }
           BufferedReader br = new BufferedReader(new FileReader("D:/Target/Description.txt"));
             jTextArea2.setText(br.readLine());
             
            this.setVisible(false);
            SimpleSwingBrowser1.main(null);
         }
         catch(Exception e)
         {
             
         }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            // TODO add your handling code here:
            DiscussionForum.main(null);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Search_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        index.main(null);
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        login.main(null);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Search_UI.main(null);
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Upload.main(null);
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }



    private void createScene() {

        Platform.runLater(new Runnable() {
            
            public void run() {

                WebView view = new WebView();
                engine = view.getEngine();
                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {

                            public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                                if (engine.getLoadWorker().getState() == FAILED) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            JOptionPane.showMessageDialog(
                                            panel,
                                            (value != null)
                                            ? engine.getLocation() + "\n" + value.getMessage()
                                            : engine.getLocation() + "\nUnexpected error.",
                                            "Loading error...",
                                            JOptionPane.ERROR_MESSAGE);
                                        }
                                    });
                                }
                            }
                        });

             //  jfxPanel.setScene(new Scene(view));
               jPanel1.setScene(new Scene(view));
            }
        });
    }

    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            
            public void run() {
                String tmp = toURL(url);

                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
                System.out.println("Tmp--"+tmp);
                engine.load(tmp);
            }
        });
    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }
    
    public static void main(String[] username) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                SimpleSwingBrowser1 browser = new SimpleSwingBrowser1();
                browser.setVisible(true);
                browser.loadURL("file:///D:/Target/ab.html");
            }
        });
    }
}
