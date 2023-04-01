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
package com.spielplatz.modelclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author VanGiex
 */
public class VmConfig {

    private String uid;
    private String vid;
    private String protocol;
    private String ip;
    private String name;
    private String port;

    public VmConfig() {
    }
    
    

    public VmConfig(String uid, String vid, String protocol, String ip, String name, String port) {
        this.uid = uid;
        this.vid = vid;
        this.protocol = protocol;
        this.ip = ip;
        this.name = name;
        this.port = port;
    }

    public String getUid() {
        return uid;
    }

    @JsonProperty("UID")
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVid() {
        return vid;
    }

    /**
     *
     * @param vid
     */
    @JsonProperty("VID")
    public void setVid(String vid) {
        this.vid = vid;
    }

    
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("PROTOCAL")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    @JsonProperty("IP")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("VM_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    @JsonProperty("PORT")
    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "VmConfig{" + "uid=" + uid + ", vid=" + vid + ", protocol=" + protocol + ", ip=" + ip + ", name=" + name + ", port=" + port + '}';
    }

}
