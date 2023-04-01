/*
 * Copyright 2017 Er. Rahul Rathi.
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spielplatz.modelclasses.ConnectData;
import com.spielplatz.modelclasses.ServerConfig;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Simple tunnel example with hard-coded configuration parameters.
 *
 * @author Er. Rahul Rathi
 */
public class Tunnel extends GuacamoleHTTPTunnelServlet {

    @Override
    protected GuacamoleTunnel doConnect(HttpServletRequest request) throws GuacamoleException {

        ApplicationContext ctx;
        ObjectMapper objectMapper;
        ServerConfig sconfig;
        ConnectData data;
        TunnelConfig config = null;
        JSONObject obj;

        ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        sconfig = (ServerConfig) ctx.getBean("ServerConfig");

        // VNC connection information
        try {

            obj = new JSONObject(request.getParameter("data"));
            data = new ConnectData(obj.getString("uid"), obj.getString("name"));
            config = new TunnelConfig(data.getUid(), data.getName());
            
            System.out.println(obj.toString());
            System.out.println(config.toString());
            System.out.println(sconfig.toString());

        } catch (IOException ex) {
            Logger.getLogger(Tunnel.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Connect to guacd, proxying a connection to the VNC server above
        GuacServer server = new GuacServer(sconfig, config);

        // Create tunnel from now-configured socket
        GuacamoleTunnel tunnel = new SimpleGuacamoleTunnel(server.getSocket());
        return tunnel;

    }

}
