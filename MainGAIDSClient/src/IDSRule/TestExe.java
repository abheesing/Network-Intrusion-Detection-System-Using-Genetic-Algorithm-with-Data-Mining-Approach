/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IDSRule;

/**
 *
 * @author madhura
 */

    import java.io.*;  
public class TestExe {

    
        public static void main(String[] args) {  
            try {  
                Process p = Runtime.getRuntime().exec("javac");  
                BufferedReader in = new BufferedReader(  
                                    new InputStreamReader(p.getInputStream()));  
                String line = null;  
                while ((line = in.readLine()) != null) {  
                    System.out.println(line);  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    
}
