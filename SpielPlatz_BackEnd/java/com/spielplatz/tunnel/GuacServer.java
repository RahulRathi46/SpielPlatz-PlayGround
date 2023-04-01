/*
 * Copyright 2017 Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ].
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
package com.spielplatz.tunnel;

import com.spielplatz.modelclasses.ServerConfig;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;

/**
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
public class GuacServer 
{
    private GuacamoleSocket socket;
    private InetGuacamoleSocket insocket;

    public GuacServer(ServerConfig sconfig, TunnelConfig config) throws GuacamoleException {
        this.insocket = new InetGuacamoleSocket(sconfig.getServer(),sconfig.getServerport());
        this.socket  = new ConfiguredGuacamoleSocket(this.insocket , config.getConfig());
    }

    public GuacamoleSocket getSocket() {
        return socket;
    }

    public void setSocket(GuacamoleSocket socket) {
        this.socket = socket;
    }

    public InetGuacamoleSocket getInsocket() {
        return insocket;
    }

    public void setInsocket(InetGuacamoleSocket insocket) {
        this.insocket = insocket;
    }

    
    
    
    
}
