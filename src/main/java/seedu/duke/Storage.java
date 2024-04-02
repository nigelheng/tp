//package seedu.duke;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.FileReader;
//
//public class Storage {
//    private static String filepath = "data.txt";
//    private static File outfile = new File(filepath);
//    private static BufferedReader reader;
//    private static FileWriter writer;
//
//    private static String getName() {
//        try {
//            reader = new BufferedReader(new FileReader(outfile));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        String name = "Unnamed Player";
//        if (outfile.length() > 0) {
//            try {
//                name = reader.readLine().trim();
//                reader.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return name;
//    }
//
//    private static int[] getStats() {
//        try {
//            reader = new BufferedReader(new FileReader(outfile));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        int [] stats = {0, 0};
//        if (outfile.length() > 0) {
//            try {
//                reader.readLine(); // catch the name
//                String [] scores = reader.readLine().split("\\s+");
//                stats[0] = Integer.parseInt(scores[0].trim());
//                stats[1] = Integer.parseInt(scores[1].trim());
//                reader.close();
//            } catch (IOException | NumberFormatException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return stats;
//    }
//
//    public static void updateFile(String name, int[] stats) {
//        try {
//            writer = new FileWriter(outfile, false);
//            writer.write(name + "\n");
//            writer.write(stats[0] + " " + stats[1]);
//            writer.flush();
//            writer.close();
//        } catch (FileNotFoundException e) {
//            try { // new user
//                outfile.createNewFile();
//                writer = new FileWriter(outfile, false);
//                writer.write(name + "\n");
//                writer.write(stats[0] + " " + stats[1]);
//                writer.flush();
//                writer.close();
//            } catch (IOException ex) {
//                System.out.println("something's wrong :0");
//            }
//        } catch (IOException e) {
//            System.out.println("\tio exception\t");
//        }
//    }
//}

