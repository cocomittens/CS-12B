import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
public class cyoa{	
	public static LinkedBlockingQueue<String> readCommands(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String line;
		LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
		while((line = in.readLine()) != null){
			if(line.trim().isEmpty() == false){
				char command = line.charAt(0);
				String content = line.substring(2, line.length());
					q.add(line);
				}
		}
		in.close();
	        return q;	
	}

	public static void main(String[] args) throws IOException{
		LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
		LinkedList<room> rl = new LinkedList<room>();
		if(args[0] != null)
			q = readCommands(args[0]);
		while(!q.isEmpty()){
			char command = q.peek().charAt(0);
			String content = q.peek().substring(2, q.peek().length());
			
		}
		
	}
}

