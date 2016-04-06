package com.amcs31.jsonfragmenttest.util;


import android.content.Context;

import com.amcs31.jsonfragmenttest.model.PlaceItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {

    public static List<PlaceItem> parsePlaces(String jsonFile, Context context) {
        List<PlaceItem> content = new ArrayList<>();
        String jsonText = FileUtils.readFromAssets(jsonFile, context);
        try {
            JSONArray jsonArray = new JSONArray(jsonText);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String address = jsonObject.getString("address");
                PlaceItem placeItem = new PlaceItem();
                placeItem.setName(name);
                placeItem.setAddress(address);
                content.add(placeItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return content;
    }
}
