package graph.data;

import java.io.File;

public class Data {
    public static File tinyG() throws Exception {
        return new File(Data.class.getResource("tinyG.txt").toURI());
    }
    public static File tinyDG() throws Exception {
        return new File(Data.class.getResource("tinyDG.txt").toURI());
    }
    public static File eWG() throws Exception {
        return new File(Data.class.getResource("eWG.txt").toURI());
    }
    public static File EWG() throws Exception {
        return new File(Data.class.getResource("eWG.txt").toURI());
    }
    public static File tinyEWD() throws Exception {
        return new File(Data.class.getResource("tinyEWD.txt").toURI());
    }
}
