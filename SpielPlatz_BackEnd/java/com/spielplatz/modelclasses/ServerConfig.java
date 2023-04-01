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

/**
 *
 * @author VanGiex
 */
public class ServerConfig {

    private String Server;
    private int Serverport;
    private String test_client_protocol;
    private String test_client_hostname;
    private int test_client_port;

    public ServerConfig() {
    }

    public ServerConfig(String Server, int Serverport, String test_client_protocol, String test_client_hostname, int test_client_port) {
        this.Server = Server;
        this.Serverport = Serverport;
        this.test_client_protocol = test_client_protocol;
        this.test_client_hostname = test_client_hostname;
        this.test_client_port = test_client_port;
    }

    public int getTest_client_port() {
        return test_client_port;
    }

    public void setTest_client_port(int test_client_port) {
        this.test_client_port = test_client_port;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String Server) {
        this.Server = Server;
    }

    public int getServerport() {
        return Serverport;
    }

    public void setServerport(int Serverport) {
        this.Serverport = Serverport;
    }

    public String getTest_client_protocol() {
        return test_client_protocol;
    }

    public void setTest_client_protocol(String test_client_protocol) {
        this.test_client_protocol = test_client_protocol;
    }

    public String getTest_client_hostname() {
        return test_client_hostname;
    }

    public void setTest_client_hostname(String test_client_hostname) {
        this.test_client_hostname = test_client_hostname;
    }

    @Override
    public String toString() {
        return "ServerConfig{" + "Server=" + Server + ", Serverport=" + Serverport + ", test_client_protocol=" + test_client_protocol + ", test_client_hostname=" + test_client_hostname + ", test_client_port=" + test_client_port + '}';
    }
    
    

}
