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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author VanGiex
 */
@CrossOrigin(origins = "*" )
public class VmService extends HttpServlet {
    // initialize socket and input output streams

    private Socket socket = null;
    private final DataInputStream input = null;
    private DataOutputStream out = null;
<<<<<<< HEAD
    private final String address = "172.19.111.146";
    private int port = 11221;
=======
    private final String address = "10.142.0.2";
    private final int port = 11221;
>>>>>>> 562015d7c0328439b40da79112d8955d40958cf7
    private JsonObject act = null;
    private String Redirect = "http://35.204.254.134/labs";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // establish a connection
        try {

            String action = request.getParameter("action");

            act = Json.createObjectBuilder()
                    .add("Status", "Error")
                    .build();

            switch (action) {
                case "0": {
                    // check for name & user existince

                    act = Json.createObjectBuilder()
                            .add("userid", request.getParameter("userid"))
                            .add("name", request.getParameter("name"))
                            .add("os", request.getParameter("os"))
                            .add("ram", request.getParameter("ram"))
                            .add("action", action)
                            .build();
                    Redirect = "http://35.204.254.134/labs?warn=true";
                    break;

                }
                case "1": {
                    // cheack state before start

                    act = Json.createObjectBuilder()
                            .add("userid", request.getParameter("userid"))
                            .add("name", request.getParameter("name"))
                            .add("action", action)
                            .build();
                    
                    break;

                }
                case "2": {

                    act = Json.createObjectBuilder()
                            .add("userid", request.getParameter("userid"))
                            .add("name", request.getParameter("name"))
                            .add("action", action)
                            .build();
                    break;

                }
                 case "2": {
                    act = Json.createObjectBuilder()
                            .add("userid", request.getParameter("userid"))
                            .add("name", request.getParameter("name"))
                            .add("action", action)
                            .build();
                    break;

                }
                case "3": {

                    act = Json.createObjectBuilder()
                            .add("userid", request.getParameter("userid"))
                            .add("name", request.getParameter("name"))
                            .add("action", action)
                            .build();
                    break;

                }
                default: {
                    
                    // redirect to page error
                    response.sendRedirect(Redirect);
                }
            }

            socket = new Socket(address, port);
            System.out.println("Connected");

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(act.toString());
            socket.close();

            // redirect to page notefication page
            response.sendRedirect(Redirect);

        } catch (UnknownHostException u) {
            System.out.println(u);
            // redirect to page error
            response.sendRedirect(Redirect);
        } catch (IOException i) {
            System.out.println(i);
            // redirect to page error
            response.sendRedirect(Redirect);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
