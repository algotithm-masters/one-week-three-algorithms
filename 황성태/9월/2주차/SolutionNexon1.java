import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SolutionNexon1 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        String filename;
        filename = scan.nextLine();
        File file = new File(filename);
        HashSet<String> uniqueFiles = new HashSet<>();

        try {
            Scanner fileScanner = new Scanner(file);
            String[] parts;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // "] "로 분리해서 두 번째 부분만 취한다
                parts = line.split("\\] \"");
                if (parts.length > 1) {
                    String secondPart = parts[1];
                    parts = secondPart.split(" ");
                    if (parts[0].equals("GET") && parts[3].equals("200") && (parts[1].contains(".gif") || parts[1].contains(".GIF"))) {
                        String[] getFileNameParts = parts[1].split("/");
                        String fileName = getFileNameParts[getFileNameParts.length-1];
                        uniqueFiles.add(fileName);
                    }
                }
            }

            fileScanner.close();

            // 파일에 gifs_를 붙여서 중복 없이 저장
            String outputFilename = "gifs_" + filename;
            FileWriter writer = new FileWriter(outputFilename);
            for (String uniqueFile : uniqueFiles) {
                System.out.println(uniqueFile);
                writer.write(uniqueFile + "\n");
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found: " + filename);
        } catch (IOException e) {
            System.out.println("error");
        }


    }
}


