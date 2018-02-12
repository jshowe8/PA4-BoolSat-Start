import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bool_exp.ASTNode;
import bool_exp.BoolSatParser;

public class PA4BoolSat {

    public static void main(String[] args) {
        ASTNode expression = readFile(args[0]);
        Boolean debug = args[1].equals("DEBUG");
    }

    // read file and output the input file
    public static ASTNode readFile(String file) {
        String expression = "";
        // two extra dashes on the left, 6 extra on the right
        int excessDashCount = 8;

        try {
            Scanner scan = new Scanner(new File(file));
            if (!scan.hasNext()) {
                System.out.println("No expression exists");
                System.exit(-1);
            }
            expression = scan.nextLine();
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Does Not Exist");
        }

        // output
        String expressionDashes = "";
        System.out.println("Input File:");
        for (int i = 0; i < expression.length() + excessDashCount; i++) {
            expressionDashes += "-";
        }
        System.out.println(expressionDashes);
        System.out.println("| " + expression + "     |");
        System.out.println(expressionDashes);

        ASTNode root = BoolSatParser.parse(expression);
        return root;
    }
}
