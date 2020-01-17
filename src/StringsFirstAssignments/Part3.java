package StringsFirstAssignments;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int firstIndex = stringb.indexOf(stringa);
        int secondIndex = stringb.indexOf(stringa, firstIndex+stringa.length());
        if(firstIndex == -1 || secondIndex == -1)
            return false;
        return true;
    }

    public void testTwoOccurrences(){
        String[] test = new String[]{"a", "banana"};
        System.out.println(twoOccurrences(test[0],test[1]));
    }

    public static void main(String[] test){
        Part3 p = new Part3();
        p.testTwoOccurrences();
    }
}
