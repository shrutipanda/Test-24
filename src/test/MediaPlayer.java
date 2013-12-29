package test;




import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javax.swing.JFrame;


public class MediaPlayer extends Application {
    private static final String MEDIA_URL = "file:///E:/movie.mp4";
    //private static final String MEDIA_URL = "file:///c:/documents/movie.mp4";
    private static String arg1;

    @Override public void start(Stage stage) {
        stage.setTitle("Media Player");
        Group root = new Group();
        Scene scene = new Scene(root,600,265);
        // create media player
        Media media = new Media((arg1 != null) ? arg1 : MEDIA_URL);
        javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
                
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        scene.setRoot(mediaControl);
        scene.getStylesheets().add(MediaPlayer.class.getResource("mediaplayer.css").toExternalForm());
        // show stage
        stage.setScene(scene);
        stage.show();
    }
    JFrame frame=new JFrame("");
    private javax.swing.JButton jButton1;
    private void initComponents()
    {
         jButton1 = new javax.swing.JButton();
         jButton1.setText("Discussion Forum");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MediaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(MediaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MediaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(MediaPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.getContentPane().add(jButton1);
        jButton1.setBounds(710, 420, 47, 23);

        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds((screenSize.width-819)/2, (screenSize.height-553)/2, 819, 553);
    }
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
         DiscussionForum.main(null);
     }
     
    public static void main(String[] args) {
        if (args.length > 0) {
            arg1 = args[0];
        }
        Application.launch(args);
    }
}