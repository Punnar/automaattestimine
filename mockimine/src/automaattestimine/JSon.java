package automaattestimine;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URL;


public class JSon {
  
    public static void main(String[] args){
        JSon a = new JSon();
        System.out.println(a.getData());
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }



    protected int getData() {
    	return (getCommentsArraySize() - getTodosArraySize());
    }
    
    
    private static JSONArray getCommentsArray() {
    	try {
    		URL url = new URL("http://jsonplaceholder.typicode.com/comments");
            JSONParser parser = new JSONParser();
            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object comments = parser.parse(readAll(bufferedReader));
            JSONArray commentsArray = (JSONArray) comments;
            return commentsArray;
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	JSONArray commentsArray = new JSONArray();
    	return commentsArray;
        
    }
    
    private static JSONArray getTodosArray() {
    	try {
    		URL url = new URL("http://jsonplaceholder.typicode.com/todos");
            JSONParser parser = new JSONParser();
            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object todos = parser.parse(readAll(bufferedReader));
            JSONArray todosArray = (JSONArray) todos;
            return todosArray;
    	} catch (Exception e) {
            e.printStackTrace();
        }
    	JSONArray todosArray = new JSONArray();
    	return todosArray;
    }
    
    public int getCommentsArraySize(){ //eraldi meetod size tagastamiseks
        return (getCommentsArray().size());
    }
    

    public int getTodosArraySize(){   //eraldi meetod size tagastamiseks
        return (getTodosArray().size());
    }
}

