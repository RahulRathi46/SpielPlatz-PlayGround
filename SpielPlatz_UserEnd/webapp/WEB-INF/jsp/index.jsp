<%-- 
    Document   : home
    Created on : Jul 18, 2017, 1:26:18 AM
    Author     : Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Author Meta -->
        <meta name="author" content="VanGiex">
        <!-- Meta Description -->
        <meta name="description" content="Login Window For Remote Machine">
        <!-- Meta Keyword -->
        <meta name="keywords" content="SpielPlatZ Remote Viwer">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>SpielPlatz | Remote Systems</title>

        <!-- ================================================ Fnt ============================================= -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
        <!-- ================================================ CSS ============================================= -->
        <link rel="stylesheet" href="css/vendor/bootstrap.css">
        <link rel="stylesheet" href="css/vendor/font-awesome.min.css">

    </head>
    <body class="full-width-div" style="height: 100%;">

        <div class="container mt-3">

            <div class="row" id="canvas" style="display: none;">
                <div class="col-md-2 col-lg-2 col-xl-2"></div>
                <div class="col-md-10 col-lg-10 col-xl-10 full-width-div " style="height: 100%;" id="display">
                </div>
            </div>
        </div>

        <!-- Guacamole JavaScript API -->
        <script type="text/javascript" src="guacamole-common-js/all.min.js"></script>

        <script type="text/javascript" src="js/vendor/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/vendor/popper.min.js"></script>
        <script type="text/javascript" src="js/vendor/bootstrap.min.js"></script>
        <script type="text/javascript">

            // Get display div from document
            var display = document.getElementById("display");
            // Instantiate client, using an HTTP tunnel for communications.
            var guac = new Guacamole.Client
                    (
                            new Guacamole.HTTPTunnel("tunnel")
                            );
            // Add client to display div
            display.appendChild(guac.getDisplay().getElement());
            // Error handler
            guac.onerror = function (error) {
<<<<<<< HEAD
                guac.disconnect();
                window.close();
=======
            guac.disconnect();
            window.close();
>>>>>>> 562015d7c0328439b40da79112d8955d40958cf7
            };
            // Connect
            guac.connect('data={"uid": "<%= request.getParameter("uid")%>","name":"<%= request.getParameter("name")%>"}');
            //state 
<<<<<<< HEAD
            guac.onstatechange = function (error) {
               
=======
            guac.onstatechange = function (state) {

            if (state == 3)
            {
            document.getElementById("canvas").style.display = "block";
            }
            else if (state == 4)
            {
            guac.disconnect();
            }
            else if (state == 5)
            {
            guac.disconnect();
            }
>>>>>>> 562015d7c0328439b40da79112d8955d40958cf7
            };
            // Disconnect on close
            window.onunload = function () {
                
                guac.disconnect();
                }
                
                // Mouse
                var mouse = new Guacamole.Mouse(guac.getDisplay().getElement());
        mouse.onmousedown =
        mouse.onmouseup =
        mouse.onmousemove = function (mouseState) {
                    guac.sendMouseState(mouseState);
        };
        // Keyboard
        var keyboard = new Guacamole.Keyboard(document);
        keyboard.onkeydown = function (keysym) {
                    guac.sendKeyEvent(1, keysym);
        };
        keyboard.onkeyup = function (keysym) {
                    guac.sendKeyEvent(0, keysym);
            };
            
            var mouseTouch = new Guacamole.Mouse.Touchscreen(guac.getDisplay().getElement());
            mouseTouch.onmousedown =
                    mouseTouch.onmouseup =
                            mouseTouch.onmousemove = function (mouseState) {
                    guac.sendMouseState(mouseState);
            };
            
            </script>
    </body>
</html>
