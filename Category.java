package com.eurabota.android;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Category {
    // category class

    public String categ_name    = "categ_name";
    public String categ_varname = "categ_varname";
    public String categ_count   = "categ_count";

    private int mPosition;

    public Category(JSONObject object) {
        try {
            this.categ_name     = object.getString( Const.CATEGORY_NAME );
            this.categ_varname  = object.getString( Const.CATEGORY_TITLE );
            this.categ_count    = object.getString( Const.CATEGORY_COUNT );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Category> fromJson(JSONArray catgoryObjects) {
        ArrayList<Category> categories = new ArrayList<>();

        for(int i=0; i<catgoryObjects.length(); i++) {
            try {
                categories.add( new Category( catgoryObjects.getJSONObject(i) ) );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return categories;
    }
}
