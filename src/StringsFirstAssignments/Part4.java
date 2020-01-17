package StringsFirstAssignments;

import edu.duke.URLResource;

public class Part4 {
    private String url1 = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";

    public void findLinks(){
        URLResource ur = new URLResource(url1);
        for(String word : ur.words()){
            String temp = word.toLowerCase();
            if(temp.contains("youtube.com")){
                int index = temp.indexOf("youtube.com");
                int end = temp.indexOf("\"",index+11);
                int start = temp.substring(0,index).lastIndexOf("\"");
                System.out.println(word.substring(start,end+1));
            }
        }
    }

    public static void main(String[] test){
        Part4 p = new Part4();
        p.findLinks();
    }
}
