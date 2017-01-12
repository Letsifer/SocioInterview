package edu.altstu.sociointerview.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author gea
 */
public class InputUtil {

    private BufferedReader in;
    private StringTokenizer st = new StringTokenizer("");
    private String temp;

    public InputUtil(String fileName) throws IOException {
        in = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(new FileInputStream(fileName)),
                        "utf-8")
        );
    }
    
    public void close() throws IOException{
        in.close();
    }

    public String nextToken() throws Exception {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(readLine());
        }
        return st.nextToken();
    }

    public Integer nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public Double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

    public String readLine() throws IOException {
        if (temp != null) {
            String temp2 = temp;
            temp = null;
            return temp2;
        }
        return in.readLine();
    }

    public boolean isEOF() throws IOException {
        temp = in.readLine();
        return temp == null;
    }

}
