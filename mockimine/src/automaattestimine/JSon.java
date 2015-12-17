package automaattestimine;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URL;


public class JSon {
    private static JSONArray commentsArray; //et ei peaks getData() meetodi sees declarima ja et saaks eraldi funktsiooni
    private static JSONArray todosArray; // välja kutsuda mis tagastab selle array size


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
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/comments");
            JSONParser parser = new JSONParser();

            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object comments = parser.parse(readAll(bufferedReader));
            commentsArray = (JSONArray) comments;

            url = new URL("http://jsonplaceholder.typicode.com/todos");
            is = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            Object todos = parser.parse(readAll(bufferedReader));
            todosArray = (JSONArray) todos;

            return (getCommentsArraySize() - getTodosArraySize());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getCommentsArraySize(){ //eraldi meetod size tagastamiseks
        return (commentsArray.size());
    }

    public int getTodosArraySize(){   //eraldi meetod size tagastamiseks
        return todosArray.size();
    }
}