package ale.neo.compiler.earley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ContextFreeGrammar {

    private Map<RHS[], String> rules = new HashMap<>();
    private List<String> pos = new ArrayList<>();

    public ContextFreeGrammar() {
        init();
    }

    private void init() {
        initStartRules();
        initProductionRules();
    }

    public void resetGrammar() {
        rules = new HashMap<>();
        pos = new ArrayList<>();
        init();
    }

    protected abstract void initStartRules();
    protected abstract void initProductionRules();

    public RHS[] getRHS(String lhs) {
        if (rules.containsValue(lhs))
            for (Map.Entry<RHS[], String> i : rules.entrySet())
                if (i.getValue().equals(lhs))
                    return i.getKey();

        return null;
    }

    public boolean isPartOfSpeech(String word) {
        return pos.contains(word);
    }

    public void addStartRule(String rule) {
        String[] words = rule.split(" ");
        RHS[] rhs = { new RHS(words) };
        rules.put(rhs, "S");

        for (String word : words) {
            if (!isTag(word)) {
                addProductionRule(word, word);
                addPos(word);
            }
        }
    }

    public void addStartRules(List<String> rules) {
        RHS[] rhs = new RHS[rules.size()];

        for (int i = 0; i < rules.size(); i++) {
            String[] words = rules.get(i).split(" ");
            rhs[i] = new RHS(words);

            for (String word : words) {
                if (!isTag(word)) {
                    addProductionRule(word, word);
                    addPos(word);
                }
            }
        }

        this.rules.put(rhs, "S");
    }

    public void addProductionRule(String tag, String rule) {
        if (rules.containsValue(tag))
            return;

        String[] words = rule.split(" ");
        RHS[] rhs = { new RHS(words) };
        rules.put(rhs, tag);

        addPos(tag);
    }

    public void addProductionRules(String tag, List<String> rules) {
        RHS[] rhs = new RHS[rules.size()];

        for (int i = 0; i < rules.size(); i++) {
            String[] words = rules.get(i).split(" ");
            rhs[i] = new RHS(words);

            for (String word : words) {
                if (!isTag(word)) {
                    addProductionRule(word, word);
                    addPos(word);
                }
            }
        }

        this.rules.put(rhs, tag);
    }

    private void addPos(String pos) {
        if (this.pos.contains(pos))
            return;

        this.pos.add(pos);
    }

    private boolean isTag(String input) {
        return input.charAt(0) == '<' && input.charAt(input.length() - 1) == '>';
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        rules.forEach((key, value) -> {
            for (RHS rhs : key)
                str.append(rhs.toString()).append(", ");
            str.append(value).append("\n");
        });

        return str.toString();
    }

}
