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

import com.spielplatz.modelclasses.VmConfig;
import com.spielplatz.services.JsonService;
import java.io.IOException;
import org.apache.guacamole.protocol.GuacamoleConfiguration;

/**
 * connection information
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
public class TunnelConfig {

    private GuacamoleConfiguration config;
    private VmConfig vmconfig;

    public TunnelConfig(String uid , String name) throws IOException {

        config = new GuacamoleConfiguration();
        vmconfig = new JsonService(uid , name).getConfig();
        
        config.setProtocol(vmconfig.getProtocol());
        config.setParameter("hostname", vmconfig.getIp());
        config.setParameter("port", vmconfig.getPort());
        config.setParameter("color-depth", "16");
        
        if(vmconfig.getProtocol().equals("rdp"))
        {
            config.setParameter("ignore-cert", "true");
        }
        
        if(vmconfig.getProtocol().equals("vnc"))
        {
            
            config.setParameter("autoretry", "5");
            
        }
        
    }

    public GuacamoleConfiguration getConfig() {
        return config;
    }

    public void setConfig(GuacamoleConfiguration config) {
        this.config = config;
    }

    public VmConfig getVmconfig() {
        return vmconfig;
    }

    public void setVmconfig(VmConfig vmconfig) {
        this.vmconfig = vmconfig;
    }

    @Override
    public String toString() {
        return "TunnelConfig{" + "config=" + config.toString() + ", vmconfig=" + vmconfig.toString() + '}';
    }

}
