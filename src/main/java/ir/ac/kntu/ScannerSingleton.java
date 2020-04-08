package ir.ac.kntu;

import java.util.Scanner;

/**
 * @author Ali Afshar
 * @since 3/14/2020
 * @version version 1.0
 * @see Scanner
 */
public class ScannerSingleton {
    /**
     * declaring scanner and scannerSingleton
     */
    private static final ScannerSingleton INSTANCE = new ScannerSingleton();
    private static Scanner scanner;

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return scannerSingleton of class
     */
    public ScannerSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * @return the next line of cmd in string
     */
    public String nextLine() {
        return scanner.nextLine();
    }

    /**
     * @return the next Integer of cmd
     */
    public Integer nextInt() {
        String input = scanner.nextLine();
        input = input.trim();
        return Integer.parseInt(input);
    }

    /**
     * @return the next Double of cmd
     */
    public Double nextDouble(){
        return scanner.nextDouble();
    }

    /**
     * if we don,t need this class , we close the Scanner
     */
    public void close() {
        scanner.close();
    }
}
