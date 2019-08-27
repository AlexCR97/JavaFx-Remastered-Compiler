package ale.neo;

import ale.neo.compiler.Parser;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        //var tokens = Arrays.asList("int x = 0".split(" "));
        //var tokens = Arrays.asList("a ( )".split(" "));
        var tokens = Arrays.asList("a ( int a , int b , double c ) ;".split(" "));

        var parser = new Parser();
        parser.parse(tokens);
    }

}
