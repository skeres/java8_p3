package com.sks.execution;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin");
        Main main = new Main();

        main.prompt();

        main.createfile();

        main.readFile();

        System.out.println("end");
    }

    private void prompt() throws InterruptedException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter username : ");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input

        System.out.println("Enter double");
        double d1=myObj.nextDouble();
        System.out.println("java get value "+d1);

        String toConsumeSkipLine=myObj.nextLine(); //why this ? The problem is that nextDouble() does not consume the '\n',
                                                    // so the next call to nextLine() consumes it
                                                    // big diffrence : the nextLine() method does not put the '\n' character back at the head of the stream; instead, it discards it.
        String s1=myObj.nextLine();
        System.out.println("Entrez un double");
        Double d2=null;
        boolean ok=false;
        try {
            d2=parseDouble(s1);
            ok=true;}
        catch (NullPointerException e) {
            System.out.println("aucune entrée, saisissez un double svp ");
        }
        catch (NumberFormatException e) {
            System.out.println("format incorrect "+s1+ ", saisissez un nombre double avec le caractère '.' pour les décimales");
        } finally {
            if (ok==true){
                System.out.println("format correct, java get the value "+d2);
            }
        }

    }

    /**
     * FOS + OSW
     */
    public void createfile(){
        System.out.println("create and write file newfile.txt");
        boolean ok=false;
        String skp="\n";
        try (FileOutputStream fos=new FileOutputStream("/home/stephane/newFile.txt"); OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8"); )
        {
            osw.append("firstLine"+skp);
            osw.append("secondLine"+skp);
            ok=true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (ok) System.out.println("file successfully created"); else {
                System.out.println("bad news, sorry ...");
            }
        }

    }

    /**
     *  BR ( ISR(FIS,charset)) =>
     */
    public void readFile() {
        System.out.println("read file newfile.txt");
        boolean ok=true;
        Charset inputCharset = Charset.forName("UTF-8");
        try(InputStreamReader isr=new InputStreamReader(new FileInputStream("/home/stephane/newFile.txt"),inputCharset); BufferedReader br = new BufferedReader(isr)) {
            int k=0;
            String line = br.readLine();
            while(line != null) {
                k++;
                System.out.println("line "+k+" = "+line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            ok=false;
            e.printStackTrace();
        } catch (IOException e) {
            ok=false;
            e.printStackTrace();
        } finally {
            if (ok) System.out.println("read all file status ok"); else System.out.println("read file status KO");
        };
    }
}
