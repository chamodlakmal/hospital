<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <meta charset="UTF-8">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        * {
            box-sizing: border-box
        }

        /* style the container */
        .container {
            position: relative;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px 0 30px 0;
        }


        /* Two-column layout */
        .col {
            float: left;
            width: 50%;
            margin: auto;
            padding: 0 50px;
            margin-top: 6px;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* vertical line */
        .vl {
            position: absolute;
            left: 50%;
            transform: translate(-50%);
            border: 2px solid #ddd;
            height: 175px;
        }

        /* text inside the vertical line */
        .inner {
            position: absolute;
            top: 50%;
            transform: translate(-50%, -50%);
            background-color: #f1f1f1;
            border: 1px solid #ccc;
            border-radius: 50%;
            padding: 8px 10px;
        }

        /* hide some text on medium and large screens */
        .hide-md-lg {
            display: none;
        }

        /* bottom container */
        .bottom-container {
            text-align: center;
            background-color: #666;
            border-radius: 0px 0px 4px 4px;
        }

        /* Responsive layout - when the screen is less than 650px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 650px) {
            .col {
                width: 100%;
                margin-top: 0;
            }

            /* hide the vertical line */
            .vl {
                display: none;
            }

            /* show the hidden text on small screens */
            .hide-md-lg {
                display: block;
                text-align: center;
            }
        }

        #box {
            margin-top: 200px;
            width: 600px;
            padding: 20px;
        }
    </style>

</head>

<body>


<div class="container" id="box">
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->

            <%
                String msg = request.getParameter("msg");
                if (msg != null) {
            %>
            <div class="alert alert-danger">
                <p>Invalid Credentials</p>
            </div>
            <%
                }
            %>

            <h4>User Login</h4>

            <!-- Login Form -->
            <form:form action="${context}/hospital" method="POST" modelAttribute="hospital">
                <div class="form-group">
                    <form:label path="address">NIC</form:label>
                    <form:input required="required" type="text" class="form-control" placeholder="NIC" path="address"/>
                </div>
                <div class="form-group">
                    <form:label path="name">Password</form:label>
                    <form:input required="required" type="password" class="form-control" placeholder="Password"
                                path="name"/>

                </div>

                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-4">
                        <form:button type="submit" class="btn btn-primary"
                                     style="display:inline;text-align: center;">Login</form:button>

                    </div>
                    <div class="col-4"></div>
                </div>
            </form:form>


        </div>
    </div>
</div>

</body>

</html>