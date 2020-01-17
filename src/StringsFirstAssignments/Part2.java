package StringsFirstAssignments;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCondon){
        int startIndex = dna.indexOf(startCodon);
        int endIndex = dna.indexOf(stopCondon, startIndex+3);
        if(startIndex == -1)
            return "";
        if(endIndex == -1)
            return "";
        String gene = dna.substring(startIndex,endIndex+3);
        if(gene.length() % 3 == 0)
            return gene;
        return "";
    }

    public void testSimpleGene(){
        String[] testDNA = new String[] {"ATTTTT", "ATGGGGT","AATGGTA","ATGTATTAA","ATGATTAA"};
        for (String dna : testDNA){
            System.out.println("DNA sequence is " + dna);
            System.out.println("The result is " + findSimpleGene(dna,"ATG","TAA"));
        }
    }

    public static void main(String[] test){
        Part1 p = new Part1();
        p.testSimpleGene();
    }
}
