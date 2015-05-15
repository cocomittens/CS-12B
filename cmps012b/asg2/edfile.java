/* Name: Corrie Gripenstraw
 * ID: cgripens
 * Class: CMPS 12B
 * Date: November 5, 2014
 * Filename: edfile.java
 * Description: 
 */
import java.util.Scanner;
import static java.lang.System.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

class edfile extends dllist{

    public static dllist readFile(String filename) throws IOException{
        BufferedReader textReader = new BufferedReader(new FileReader(filename));
        dllist list = new dllist();
        String line = textReader.readLine();
        while(line != null){
            list.insert(line, dllist.position.FOLLOWING);
            line = textReader.readLine();
        }
        textReader.close();
        return list;
    }

    public static dllist appendList(String filename, dllist list) throws IOException{
        dllist addLines = readFile(filename);
        int count = 0;
        list.setPosition(dllist.position.LAST);
        addLines.setPosition(dllist.position.FIRST);
        while(addLines.getPosition() < addLines.listSize){
            list.insert(addLines.getItem(), dllist.position.FOLLOWING);
            addLines.setPosition(dllist.position.FOLLOWING);
            count++;
        }
        System.out.println(count + " lines printed to file");
        return list;
    }
   
    public static void writeFile(String filename, dllist list) throws IOException{
        File file = new File(filename);
        PrintWriter printWriter = new PrintWriter(file);
        int count = 0;
        list.setPosition(dllist.position.FIRST);
        while(list.getPosition() < list.listSize){
            printWriter.println(list.getItem());
            list.setPosition(dllist.position.FOLLOWING);
            count++;
        }
        printWriter.close();
        System.out.println(count + " lines written to file");
    }   

    public static void main (String[] args) throws IOException {
        boolean want_echo = false;
        dllist lines = new dllist();
        String filename = "", options = "";
        int i = 0;
        if(args.length > 0){
            while(args.length > i){
                if(args[i].equals("-e")){
                    want_echo = true;
                    options+=args[i];
                }
            else
                filename=args[i];
                i++;
            }
        }
        if(filename!="")
            lines = readFile(filename);
        Scanner stdin = new Scanner (in);
        System.out.println("Welcome to the program");
        for (;;) { 
            if (! stdin.hasNextLine()) break;
            String inputline = stdin.nextLine();
            String txt = "";
            if(inputline.length() > 1)
            txt = inputline.substring(2, inputline.length());
            if (want_echo) out.printf ("%s%n", inputline);
            if (inputline.matches ("^\\s*$")) continue;
            char command = inputline.charAt(0);
            switch (command) {
                case '#': break;
                case '$':
                    lines.setPosition(dllist.position.LAST);
                    System.out.println(lines.getItem());
                    break;
                case '*':
                    int length = lines.listSize;
                    lines.setPosition(dllist.position.FIRST);
                    while(lines.getPosition() < length){
                        System.out.println(lines.getItem());
                        lines.setPosition(dllist.position.FOLLOWING);
                    }
                    break;
                case '.': 
                    System.out.println(lines.getItem()); 
                    break;
                case '0':
                    lines.setPosition(dllist.position.FIRST);
                    System.out.println(lines.getItem());
                    break;
                case '<': 
                    lines.setPosition(dllist.position.PREVIOUS);
                    System.out.println(lines.getItem());
                    break;
                case '>': 
                    lines.setPosition(dllist.position.FOLLOWING);
                    System.out.println(lines.getItem()); 
                    break;
                case 'a': 
                    lines.insert(txt, dllist.position.FOLLOWING);
                    System.out.println(lines.getItem());
                    break;
                case 'd': 
                    lines.delete();
                    break;
                case 'i': 
                    lines.insert(txt, dllist.position.PREVIOUS);
                    System.out.println(lines.getItem());
                    break;
                case 'r':
                    lines = appendList(txt, lines);
                    break;
                case 'w': 
                    writeFile(txt, lines);
                    break;
                default : System.out.println("Invalid command."); break;
            }
        }
        System.exit(0);
    }
}
