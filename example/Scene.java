package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;

import example.classloader.SteganographyClassLoader;

public class Scene {

    public static void main(String[] args) throws Exception {

        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        Geezer theGeezer = Geezer.getTheGeezer();

        // SteganographyClassLoader loader = new SteganographyClassLoader(
        //         new URL("file:/Users/vectormoon/Documents/Code/Java/NJU/jw03-vectormoon/example.BubbleSorter.png"));
        // Class c = loader.loadClass("example.BubbleSorter");

        // SteganographyClassLoader loader = new SteganographyClassLoader(
        //         new URL("file:/Users/vectormoon/Documents/Code/Java/NJU/jw03-vectormoon/example.SelectionSorter.png"));
        // Class c = loader.loadClass("example.SelectionSorter");

        // SteganographyClassLoader loader = new SteganographyClassLoader(
        //         new URL("file:/Users/vectormoon/Documents/Code/Java/NJU/jw03-vectormoon/example.InsertionSorter.png"));
        // Class c = loader.loadClass("example.InsertionSorter");

        SteganographyClassLoader loader = new SteganographyClassLoader(
                new URL("file:/Users/vectormoon/Documents/Code/Java/NJU/jw03-vectormoon/example.ShellSorter.png"));
        Class c = loader.loadClass("example.ShellSorter");

        Sorter sorter = (Sorter) c.newInstance();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}