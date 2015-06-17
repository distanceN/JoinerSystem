<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 1/23/2015
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>Login For Group</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
<div class="main_body">
    <form class="form_info" name="student_back" method="post" action="student_login" validate="true">
        <div class="input-group">
            <span class="input-group-addon">Succeed Join!!!</span>
        </div>
        <input type="hidden" value=${session.student.studentId} name="student.studentId">
        <input type="hidden" value=${session.student.studentPassword}
                name="student.studentPassword">
        <p>


        </p>
        <p style="text-align:center;">
            <button class="btn" type="submit">OK</button>
        </p>
        <p>

    </form>
</div>
<%--<h2>Success to join the activity!!</h2>--%>
<%--<form name="student_back" method="post" action="student_login" validate="true">--%>
    <%--<p>--%>
        <%--<input type="hidden" value=${session.student.studentId} name="student.studentId">--%>
        <%--<input type="hidden" value=${session.student.studentPassword}--%>
                <%--name="student.studentPassword">--%>
    <%--</p>--%>
    <%--<p>--%>
        <%--<input type="Submit" value="ok">--%>
    <%--</p>--%>
<%--</form>--%>
</body>
</html>