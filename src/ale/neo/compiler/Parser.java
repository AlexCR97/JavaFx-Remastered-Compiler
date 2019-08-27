package ale.neo.compiler;

import ale.neo.compiler.earley.ContextFreeGrammar;
import ale.neo.compiler.earley.EarleyParser;
import ale.neo.compiler.earley.NeoContextFreeGrammar;

import java.util.List;

public class Parser {

    private final ContextFreeGrammar grammar = new NeoContextFreeGrammar();
    private final EarleyParser parser = new EarleyParser(grammar);

    public boolean parse(List<String> tokens) {
        System.out.println("Parsing: " + tokens);

        boolean success = parser.parse(tokens);

        System.out.println("=============================================================");
        System.out.println("=============================================================");
        if (success)
            System.out.println("Parse SUCCESSFUL! :D");
        else
            System.out.println("Parse FAILED :(");
        System.out.println("=============================================================");
        System.out.println("=============================================================");

        return success;
    }

}
