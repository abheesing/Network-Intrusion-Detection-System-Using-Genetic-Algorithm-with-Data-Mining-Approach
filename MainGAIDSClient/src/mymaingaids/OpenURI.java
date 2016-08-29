/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mymaingaids;

/**
 *
 * @author Inbo
 */
import java.net.URI;
import java.awt.Desktop;

public class OpenURI {

    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

    public OpenURI(String str) {

        try {
            System.err.println("in open uri");
            java.net.URI uri = new java.net.URI(str);
            desktop.browse(uri);
            System.err.println("opened");
        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        new OpenURI("http://localhost:8080/GIDSHTTP/index.jsp");
    }
}