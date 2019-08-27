import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
Takes an input textfile in the format of blah:blahblah - blahblahblahblah and converts it to HTML.
First table column includes everything before the colon. Second table column includes everything between the : and the -
Third table column gets everything else.


*/

public class TextToHtml {
    public static void main(String[] args) {
        // Hardcode the working directory for testing purposes.
        String baseDir = "D:\\Files\\Programming\\java\\java\\";

        // Ensure we get a text file input from the command line or exit with a message.
        if (args.length < 1) {
            System.out.println("Usage: java TextToHtml <file>");
            System.exit(0);
        }
        String fileName = baseDir + args[0];
        try {
            // Open the file or die trying...
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Create the opening of the HTML document.
            String line;
            StringBuilder output = new StringBuilder("<html><body>\n");
            output.append("<style>table {  border-collapse: collapse; \n font-size: 10px; \n font-family: \"Verdana\", \"Helvetica\", \"Arial\", \"sans-serif\"; }</style>");
            output.append("<table border=\"1\">\n");
            output.append("<tr>\n");
            output.append("<th>Return Type</th><th>Method</th><th>Description</th>\n");
            output.append("</tr>\n");

            // Loop through the input file line by line and parse the data.
            while ((line = bufferedReader.readLine()) != null) {
              // System.out.println(line);
              output.append("<tr>"); // New row
              output.append("<td>"); // START COLUMN 1
              int colPos = line.indexOf(":");
              if (colPos != -1) {
                // System.out.println(colPos);
                output.append(line.substring(0, colPos)); // Grab everything in the line from start to :
                output.append("</td><td>"); // END COLUMN 1; START COLUMN 2
                int breakPos = line.indexOf(" - ");

                if (breakPos != -1) {
                  output.append(line.substring(colPos + 1, breakPos)); // Grab everything in the line from the : to the -
                  output.append("</td><td>"); // END COLUMN 2; START COLUMN 3
                  output.append(line.substring(breakPos + 3)); // Grab the remainder of the line from the text.
                  output.append("</td></tr>\n"); // END COLUMN 3; CLOSE ROW.
                } else {
                  output.append("<td colspan=\"2\"" + line + "</td></tr>");
                }
              } else {
                // Colon not found. Line is in incorrect format so just dump it out.
                output.append("<td colspan=\"3\"" + line + "</td></tr>");
              }
            }

            // Wrap up the HTML. Create a new filename based in the input name and give it a .html extension.
            output.append("</table></body></html>");
            fileName = baseDir + args[0].substring(0, args[0].indexOf(".")) + ".html";
            file = new File(fileName);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(output.toString());
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
