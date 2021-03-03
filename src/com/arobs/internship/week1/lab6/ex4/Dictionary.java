package com.arobs.internship.week1.lab6.ex4;

import java.util.HashMap;

public class Dictionary {
    HashMap<Word, Definition> definitionHashMap;

    public Dictionary() {
        definitionHashMap = new HashMap<>();
    }

    public void addWord(Word w, Definition d) {
        definitionHashMap.put(w, d);
    }

    public Definition getDefinition(Word w) {
        return definitionHashMap.get(w);
    }

    public void getAllWord() {
        System.out.println("Words: " + definitionHashMap.keySet());
    }

    public void getAllDefinitions() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Word word : definitionHashMap.keySet()) {
            stringBuilder.append(word.getName());
            stringBuilder.append(": ");
            stringBuilder.append(definitionHashMap.get(word).getDescription());
            stringBuilder.append("; ");
        }
        System.out.println("Definitions: " + stringBuilder);
    }


}
