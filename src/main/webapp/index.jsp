
<!DOCTYPE html>
<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*"%>


<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="index.css" rel="stylesheet">
</head>

<body>
<div>


    <div class="container">
        <div class="left">
            <div class="img">
                <img src="">
            </div>
            <div type="button" class="btn btn-1" type="button">
                Create
            </div>
            <div class="cut-line"></div>

            <div class="items">
                <% for (int i = 1; i < 9; i ++) { %>
                <div class="item" onclick="location.href='#'">Item<%out.print(i);%></div>
                <% } %>
            </div>


        </div>
        <div class="right">
            <div class="text-create">Create Event</div>
            <div class="line-right-1"></div>
            <div class="event-name">
                <p>Event Name:</p><input type="text" style="width: 800px;">
            </div>
            <div class="event-name">
                <p>Event Time:</p>
                <input type="text" style="width: 800px;">
            </div>
            <div class="event-name">
                <p>Event detial:</p>
                <textarea type="text" style="width: 800px; height: 100px; "> </textarea>
            </div>

            <div class="line-right-2"></div>

            <div class="btn-cancel" onclick="location.href='#' ">Cancel</div>
            <div class="btn-send" onclick="location.href='#' ">Save</div>
        </div>
    </div>
</div>
</body>
</html>