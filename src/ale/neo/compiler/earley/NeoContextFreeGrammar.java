package ale.neo.compiler.earley;

import java.util.List;

public class NeoContextFreeGrammar extends ContextFreeGrammar {

    @Override
    protected void initStartRules() {
        var rules = List.of(
                "<type> <id> ;",
                "<type> <id> = <number> ;",
                "<id> ( ) ;",
                "<id> ( <params> ) ;"
        );
        addStartRules(rules);
    }

    @Override
    protected void initProductionRules() {
        addProductionRule("<type>", "int float double");

        addProductionRule("<id>", "a b c d e f g h i j k l m n o p q r s t u v w x y z");

        addProductionRule("<number>", "0 1 2 3 4 5 6 7 8 9");

        addProductionRules("<params>", List.of(
                "<param> , <params>",
                "<param>"
        ));

        addProductionRules("<param>", List.of(
                "<type> <id>"
        ));
    }

}
