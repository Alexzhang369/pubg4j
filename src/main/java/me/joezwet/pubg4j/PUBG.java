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

import com.sun.istack.internal.NotNull;

/** The main class for the Library, can be used to access any class in the Library. */
public class PUBG {
    /** The API Key that is used to access the API */
    private final String API_KEY;
    /** The platform and region {@link me.joezwet.pubg4j.Shard Shard} used to define which server to get the player data from. */
    private Shard platformRegion;
    /** Handles all requests to the API */
    private Connection connection;


    public PUBG(/** The API Key that is used to access the API */ @NotNull String key) {
        System.out.println("Starting...");
        this.API_KEY = key;
        this.connection = new Connection(API_KEY);
    }

    public PUBG(/** The API Key that is used to access the API */ @NotNull String key, /** The platform and region {@link me.joezwet.pubg4j.Shard Shard} used to define which server to get the player data from. */ Shard platformRegion) {
        this.API_KEY = key;
        this.platformRegion = platformRegion;
    }

    public Shard getPlatformRegion() {
        return platformRegion;
    }

    public void setPlatformRegion(Shard platformRegion) {
        this.platformRegion = platformRegion;
    }
}
