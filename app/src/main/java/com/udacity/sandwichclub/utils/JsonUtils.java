package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {
    /**
    *Take sandwich data in string format, and create a Sandwich instance as return
    */
    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwich = new JSONObject(json);
        JSONObject name = sandwich.getJSONObject("name");

        String mainName = name.getString("mainName");

        JSONArray aliasArray = name.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < aliasArray.length(); i++) {
            alsoKnownAs.add((String) aliasArray.get(i));
        }

        String placeOfOrigin = sandwich.getString("placeOfOrigin");
        String description = sandwich.getString("description");
        String image = sandwich.getString("image");

        JSONArray ingredientsArray = sandwich.getJSONArray("ingredients");
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredients.add((String) ingredientsArray.get(i));
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
