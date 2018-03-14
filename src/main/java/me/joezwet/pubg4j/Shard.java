/*
 *     Copyright 2018 Joe van der Zwet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package me.joezwet.pubg4j;

/**
 * Used to define the platform and region that data is retrieved from.
 */
public enum Shard {
    /** Asian server for Xbox */
    XBOX_AS,
    /** European server for Xbox */
    XBOX_EU,
    /** North American server for Xbox */
    XBOX_NA,
    /** Oceanic server for Xbox */
    XBOX_OC,
    /** Koran and Japaneses server for PC */
    PC_KRJP,
    /** North American server for PC */
    PC_NA,
    /** European server for PC */
    PC_EU,
    /** Oceanic server for PC */
    PC_OC,
    /** South East Asian server for PC */
    PC_SEA,
    /** South and Central American server for PC */
    PC_SA,
    /** Asian server for PC */
    PC_AS,
    /** Spoopy PC server with no name */
    PC_KAKAO
}
