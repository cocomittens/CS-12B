import java.util.concurrent.LinkedBlockingQueue;

class room{
        String tag;
        String[] description;
        String[] options;
        public room(String roomTag){
                tag = roomTag;
        }
        public void addDescription(LinkedBlockingQueue<String> q){
                int size = q.size();
                description = new String[size];
                for(int i=0; i<size; i++){
                        description[i] = q.peek();
			q.remove();
        	}
	}
}


