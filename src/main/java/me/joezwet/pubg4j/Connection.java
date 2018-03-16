/*
 *     Copyright 2018 Joe van der Zwet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.joezwet.pubg4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class Connection {

    /** The platform and region {@link me.joezwet.pubg4j.Shard Shard} used to define which server to get the player data from. */
    private final String key;

    private OkHttpClient client;


    Connection(String key) {
        this.client = new OkHttpClient();
        this.key = key;
        //check connection to api
        try {
            checkStatus();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /** Used to check connection to the API on initial startup */
    private void checkStatus() throws IOException{
        System.out.println("Checking connection to the API...");
        String response = run("https://api.playbattlegrounds.com/status");
        JSONObject statusObject = new JSONObject(response);
        if(!statusObject.has("errors")) {
            String version = statusObject.getJSONObject("data").getJSONObject("attributes").getString("version");
            String released = statusObject.getJSONObject("data").getJSONObject("attributes").getString("releasedAt");
            System.out.println(String.format("Connected to API on version \"%s\", released at \"%s\".", version, released));
        } else {
            System.err.println("Failed to connect to the API, check your internet connection and try again.");
        }

    }

    String run(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", key)
                .addHeader("Accept", "application/vnd.api+json")
                .addHeader("Access-Control-Allow-Origin", "*")
                .addHeader("Access-Control-Expose-Headers", "Content-Length")
                .build();
        Response response;
        response = client.newCall(request).execute();
        return response.body().string();
    }
            }
