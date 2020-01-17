package perimeter_quiz;

import edu.duke.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for (Point currPt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double aveLength = getPerimeter(s)/getNumPoints(s);
        return aveLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currSide = prevPt.distance(currPt);
            if(currSide > largestSide)
                largestSide = currSide;
            prevPt = currPt;
        }
        return largestSide;
    }

    /**
     *
     * @param s
     * @return the point with the largest X value
     */
    public double getLargestX(Shape s) {
        // Put code here
        int res = Integer.MIN_VALUE;
        for (Point currPt : s.getPoints()){
            if(currPt.getX() > res)
                res = currPt.getX();
        }
        return res;
    }

    public double getLargestPerimeterMultipleFiles() {
        double res = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            Shape s = new Shape(fr);
            double preimeter = getPerimeter(s);
            if(preimeter > res)
                res = preimeter;
        }
        return res;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            Shape s = new Shape(fr);
            double preimeter = getPerimeter(s);
            if(preimeter > largestPerimeter) {
                largestPerimeter = preimeter;
                temp = file;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPts = getNumPoints(s);
        System.out.println("Number of the points = " + numPts);
        double aveLength = getAverageLength(s);
        System.out.println("AverageLength = " + aveLength);
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("LargestX = " + largestX);

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double res = getLargestPerimeterMultipleFiles();
        System.out.println("LargestPerimeterMultipleFiles = " + res);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println(getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
