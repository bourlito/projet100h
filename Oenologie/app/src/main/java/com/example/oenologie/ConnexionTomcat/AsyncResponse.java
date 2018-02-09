package com.example.oenologie.ConnexionTomcat;

import org.json.JSONException;

/**
 * Created by etienne on 08/02/2018.
 */

public interface AsyncResponse {
    void processFinish(String output) throws JSONException;
}
