<%--
  Created by IntelliJ IDEA.
  User: zl
  Date: 1/23/2015
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Activity List For Student</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/activityList.css"/>
</head>
<body>
<s:if test="#session.student!=null">
    <form name="search_activity" method="post" action="search_activity" validate="true">
        <div class="heading">
            <div class="back_img">
                <a href="loginForStudent.html"><span class="glyphicon glyphicon-menu-left"></span></a>
            </div>
            <div class="username" id="username">
                <p><s:property value="#session.student.studentName"/> <s:property value="#session.student.studentId" /></p>
            </div>
            <div class="search_img" type="Submit">
                <button class="btn" type="Submit" aria-label="Left Align">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </div>
            <div class="input_text">
                <input type="hidden" value=${student.studentId} name="student.studentId"/>
                <input type="hidden" value=${student.studentName} name="student.studentName"/>
                <input type="hidden" value=${student.studentPassword} name="student.studentPassword"/>
                <input type="text" name="activity.activityName">
            </div>
        </div>
    </form>
</s:if>
<div class="main_body">
    <form name="see_joined" method="post" action="see_joined" validate="true">
    <div class="list">
        <div class="head_img">
            <span class="glyphicon glyphicon-paperclip"></span>
        </div>
        <input type="hidden" value=${student.studentId} name="student1.studentId"/>
        <input type="hidden" value=${student.studentName} name="student1.studentName"/>
        <input type="hidden" value=${student.studentPassword} name="student1.studentPassword"/>
        <div class="activity_title">
            <button class="btn" type="Submit" font="100px">
                <a>See My Joins</a>
            </button>
        </div>
        <div class="release_time">
            <p></p>
        </div>
    </div>
    </form>
    <s:if test="#session.activityList!=null">
        <s:iterator value="#session.activityList" id="activity">
        <form name="activity_detail_stu" method="post" action="activity_detail_stu" validate="true">
            <div class="list">
                <div class="head_img">
                    <span class="glyphicon glyphicon-user"></span>
                </div>
                    <input type="hidden" value=${activity.activityId} name="activity.activityId"/>
                    <input type="hidden" value=${student.studentId} name="student.studentId"/>
                    <input type="hidden" value=${student.studentName} name="student.studentName"/>
                    <input type="hidden" value=${student.studentPassword} name="student.studentPassword"/>
                <div class="activity_title">
                    <button class="btn" type="Submit" font="100px">
                        <a>${activity.activityName}</a>
                    </button>
                </div>
                <div class="release_time">
                    <p>${activity.organizerName} ${activity.time}</p>
                </div>
            </div>
        </form>
        </s:iterator>
    </s:if>

</div>
</body>
</html>