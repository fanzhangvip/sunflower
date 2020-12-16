/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower_java.utilities;

public class GrowZoneUtil {

    public static int getZoneForLatitude(double latitude){
        int result = 1;
        latitude = Math.abs(latitude);
        if(latitude>=0.0 && latitude <7.0){
            result = 13;
        }else if(latitude>=7.0 && latitude <14.0){
            result = 12;
        }else if(latitude>=14.0 && latitude <21.0){
            result = 11;
        }else if(latitude>=21.0 && latitude <28.0){
            result = 10;
        }else if(latitude>=28.0 && latitude <35.0){
            result = 9;
        }else if(latitude>=35.0 && latitude <42.0){
            result = 8;
        }else if(latitude>=42.0 && latitude <49.0){
            result = 7;
        }else if(latitude>=49.0 && latitude <56.0){
            result = 6;
        }else if(latitude>=56.0 && latitude <63.0){
            result = 5;
        }else if(latitude>=63.0 && latitude <70.0){
            result = 4;
        }else if(latitude>=70.0 && latitude <77.0){
            result = 3;
        }else if(latitude>=77.0 && latitude <84.0){
            result = 2;
        }else{
            result = 1;
        }
        return result;
    }
}
