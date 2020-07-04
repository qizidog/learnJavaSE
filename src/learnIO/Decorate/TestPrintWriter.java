package learnIO.Decorate;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args) throws FileNotFoundException {
        print();
    }
    
    public static void print() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("src/learnIO/print.txt", true)), true);
        pw.println();
        pw.println("这是PrintWriter");
    }
}
