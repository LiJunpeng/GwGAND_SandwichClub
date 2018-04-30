package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JsonUtils {
    /**
    *Take sandwich data in string format, and create a Sandwich instance as return
    */
    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwich = new JSONObject(json);
//        private String mainName;
//        private List<String> alsoKnownAs = null;
//        private String placeOfOrigin;
//        private String description;
//        private String image;
//        private List<String> ingredients = null;

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


/*
*         {
*           \"name\":{
*               \"mainName\":\"Ham and cheesesandwich\",
*               \"alsoKnownAs\":[]
*            },
*           \"placeOfOrigin\":\"\",
*           \"description\":\"A ham and cheesesandwich is a common type of sandwich. It is made by putting cheese and sliced ham
            between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables
            like lettuce, tomato, onion or pickle slices can also be included. Various kinds of
            mustard and mayonnaise are also
            common.\",
            \"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",
            \"ingredients\":[\"Slicedbread\",\"Cheese\",\"Ham\"]
         }
        </item>
* */