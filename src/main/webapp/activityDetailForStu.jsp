<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/14
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Activity Description</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/activityAandD.css"/>
</head>
<body>
<div class="heading">
    <div class="back_img">
        <a href="welcomeStudent.jsp"><span class="glyphicon glyphicon-menu-left"></span></a>
    </div>
    <div class="username" id="username">
        <p><s:property value="#session.student.studentName"/> <s:property value="#session.student.studentId" /></p>
    </div>
</div>
<div class="main_body">
    <div class="activity_title">
        <s:property value="#session.activity.activityName"/>
    </div>
    <div class="release_time">
        <p><s:property value="#session.activity.organizerName" />
            <s:property value="#session.activity.time"/> <s:property value="#session.activity.place"/>
        </p>
    </div>
    <div class="relative_img">
        <span class="glyphicon glyphicon-picture"></span>
    </div>
    <div class="description">
        <s:property value="#session.activity.description"/>
    </div>
</div>
<s:if test="#session.link.activityId!=''">
    <div class="footing">
        <button type="Submit" aria-label="Left Align" class="btn-block">
            <div class="submit_img" >
                    <%--<button class="btn" type="Submit" aria-label="Left Align">--%>
                    <%--<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>--%>
                    <%--</button>--%>
                <span class="glyphicon glyphicon-ok-sign"></span>
                <p>Joined!</p>
            </div>
        </button>
    </div>
</s:if>
<s:if test="#session.link.activityId==''">
<form name="join_activity" method="post" action="join_activity" validate="true">
    <input type="hidden" value=${session.student.studentId} name="student.studentId">
    <input type="hidden" value=${session.student.studentPassword} name="student.studentPassword">
    <input type="hidden" value=${session.activity.activityId} name="activity.activityId">
    <input type="hidden" value=${session.student.studentId} name="link.studentId">
    <input type="hidden" value=${session.activity.activityId} name="link.activityId">
    <div class="footing">
        <button type="Submit" aria-label="Left Align" class="btn-block">
            <div class="submit_img">
                        <%--<button class="btn" type="Submit" aria-label="Left Align">--%>
                        <%--<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>--%>
                        <%--</button>--%>
                <span class="glyphicon glyphicon-plus-sign"></span>
                <p>Join</p>
            </div>
        </button>
    </div>
</form>
</s:if>
</body>
</html>
