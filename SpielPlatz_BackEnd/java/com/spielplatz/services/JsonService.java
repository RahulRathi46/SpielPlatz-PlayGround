/*
 * Copyright 2018 VanGiex.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spielplatz.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spielplatz.modelclasses.VmConfig;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author VanGiex
 */
public class JsonService {

    private VmConfig config;
    private URL url;
    private ObjectMapper objectMapper;
    private String uid ;
    private String name;

    public JsonService(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }
    

    public VmConfig getConfig() throws MalformedURLException, IOException {

        objectMapper = new ObjectMapper();
        url = new URL("http://35.204.254.134/vmconfig/"+uid+"/"+name);
        config = objectMapper.readValue(url, VmConfig.class);
        return config;
    }

    public void setConfig(VmConfig config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "JsonService{" + "config=" + config.toString() + ", url=" + url + ", objectMapper=" + objectMapper + '}';
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
