import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    private Map<String, Integer> map;

    public DuplicateCounter(){
        map = new HashMap<String,Integer>();
    }

    public void count(String dataFile){

        Scanner readFile;


        try {

            readFile = new Scanner(new File(dataFile));

        } catch (FileNotFoundException error) {

            System.out.println(error.getMessage());
            return;

        }
        
        while(readFile.hasNext()) {

            String word = readFile.next().toLowerCase();
            Integer count = map.get(word);

            if(count == null) {

                count = 1;

            }

            else {

                count = count + 1;

            }

            map.put(word, count);

        }

        readFile.close();
    }

    public void write(String outputFile){

        try {

            PrintWriter outfile = new PrintWriter(new File(outputFile));

            for(String k : map.keySet()) {

                outfile.println(k + " " + map.get(k));

            }

            outfile.close();

        } catch (FileNotFoundException error) {

            System.out.println(error.getMessage());

        }
    }
}
