/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymaingaids;

/**
 *
 * @author Inbo
 */
//import Connection.DatabaseConnection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WatchFolder implements KeyListener {

    public static boolean stop = false;

    static <T> WatchEvent<T> castEvent(WatchEvent<?> event) {
        return (WatchEvent<T>) event;
    }

    public WatchFolder(String path) throws Exception {
        watcher(path);

    }

    public static void watcher(String path) {
        try {
            Path _directotyToWatch = Paths.get(path);
            WatchService watcherSvc = FileSystems.getDefault().newWatchService();
            WatchKey watchKey = _directotyToWatch.register(watcherSvc, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            System.out.println("in watch folder");
            
            while (true) {
                watchKey = watcherSvc.take();
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent<Path> watchEvent = castEvent(event);
                    System.out.println(event.kind().name().toString() + " " + _directotyToWatch.resolve(watchEvent.context()));
                    watchKey.reset();
                    if (event.kind().name().equals("ENTRY_DELETE") || event.kind().name().equals("ENTRY_MODIFY")) {
                        //System.out.println("break called stop true");
                        //Client c = new Client();
                        //c.setMessage(event.kind().name());
//                        System.err.println("path== " + _directotyToWatch.resolve(watchEvent.context()));
//                        DataOutputStream dout = new DataOutputStream(IntrusionClient.Client.sck.getOutputStream());
//                        dout.writeUTF(_directotyToWatch.resolve(watchEvent.context()).toString());
//                        dout.flush();                        
                        stop = true;
                        break;
                    }
//                    if (Client.disconnect) {
//                        break;
//                    }
                }
                if (stop) //|| Client.disconnect) {
                {
                    System.out.println("stopped");
                    break;
                }
            }
            System.out.println("got there");
        } catch (Exception ex) {
            Logger.getLogger(WatchFolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) throws Exception {
        //Path _directotyToWatch = Paths.get(args[0]);
        //new WatchFolder("\\\\192.168.2.109\\f\\hemant");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.getKeyCode();
        System.err.println("code== " + e.getKeyCode());
        System.err.println("code== " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        e.getKeyCode();
        System.err.println("code== " + e.getKeyCode());
        System.err.println("code== " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        e.getKeyCode();
        System.err.println("code== " + e.getKeyCode());
        System.err.println("code== " + e.getKeyChar());
    }
}
