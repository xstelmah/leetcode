
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Task2115 {


    @Test
    void example1() {
        var recipes = new String[]{"a", "b", "c", "d"};
        var ingredients = List.of(List.of("b"), List.of("a"), List.of("d"), List.of( "e", "f"));
        var supplies = new String[] {"e", "f"};

        var result = findAllRecipes(recipes, ingredients, supplies);
        Assertions.assertArrayEquals(new String[] {"c", "d"}, result.toArray());
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        var recMap = new HashMap<String, Integer>();
        var handledMap = new HashMap<String, Boolean>();
        for (int i = 0; i < recipes.length; i++) {
            recMap.put(recipes[i], i);
        }
        var answers = new ArrayList<String>();
        var sup = Set.of(supplies);
        for (int i = 0; i < recipes.length; i++) {
            if (rec(recipes[i], recMap, handledMap, sup, ingredients)) {
                answers.add(recipes[i]);
            }
        }
        return answers;
    }

    public boolean rec(String recipe,
                       Map<String, Integer> recipeMap,
                       Map<String, Boolean> processedRecipes,
                       Set<String> supplies,
                       List<List<String>> ingredientsLists) {
        if (processedRecipes.containsKey(recipe)) {
            return processedRecipes.get(recipe);
        }
        var ingredients = ingredientsLists.get(recipeMap.get(recipe));
        for (var ingredient : ingredients) {
            if (supplies.contains(ingredient)) {
                continue;
            }
            if (!recipeMap.containsKey(ingredient)) {
                processedRecipes.put(recipe, false);
                return false;
            }
            if (processedRecipes.containsKey(ingredient)) {
                if (!processedRecipes.get(ingredient)) {
                    processedRecipes.put(recipe, false);
                    return false;
                }
            } else {
                processedRecipes.put(recipe, false);
                var result = rec(ingredient, recipeMap, processedRecipes, supplies, ingredientsLists);
                if (!result) {
                    return false;
                } else {
                    processedRecipes.remove(recipe);
                }
            }
        }
        processedRecipes.put(recipe, true);
        return true;
    }
}
