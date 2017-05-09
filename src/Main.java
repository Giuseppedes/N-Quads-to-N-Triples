import java.io.*;


public class Main {

    private final static String INPUT_FILE = "dbpedia_2016-04.nt";
    private final static String OUTPUT_FILE = "dbpedia_2016-04-range-domain.nt";


    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader (INPUT_FILE);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {

                //delete spaces between angular brackets
                //String resultString = s.replaceAll("\\s+(?=[^<>]*\\>)", "");

                //delete the fourth field (namespace for n-quad files)
                //String resultString = s.substring(0, s.lastIndexOf("<") - 1) + " .";

                //write output file
                /*
                try(FileWriter fw = new FileWriter(OUTPUT_FILE, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw))
                {
                    out.println(resultString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //*/

                String resultString = s;

                System.out.println(resultString);

                //write only lines with range or domain property
                if (s.contains("<http://www.w3.org/2000/01/rdf-schema#range>") || s.contains("<http://www.w3.org/2000/01/rdf-schema#domain>")) {
                    try(FileWriter fw = new FileWriter(OUTPUT_FILE, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw))
                    {
                        out.println(resultString);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
