<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/6/16
  Time: 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Joined activities</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/activityList.css"/>
</head>
<body>
<s:if test="#session.student!=null">
        <div class="heading">
            <div class="back_img">
                <a href="welcomeStudent.jsp"><span class="glyphicon glyphicon-menu-left"></span></a>
            </div>
            <div class="username" id="username">
                <p><s:property value="#session.student.studentName"/> <s:property value="#session.student.studentId" /></p>
            </div>
        </div>
</s:if>
<div class="main_body">
    <s:if test="#session.activityList2!=null">
        <s:iterator value="#session.activityList2" id="activity2">
            <form name="activity_detail_stu" method="post" action="activity_detail_stu" validate="true">
                <div class="list">
                    <div class="head_img">
                        <span class="glyphicon glyphicon-user"></span>
                    </div>
                        <input type="hidden" value=${activity2.activityId} name="activity.activityId"/>
                        <input type="hidden" value=${student.studentId} name="student.studentId"/>
                        <input type="hidden" value=${student.studentName} name="student.studentName"/>
                        <input type="hidden" value=${student.studentPassword} name="student.studentPassword"/>
                    <div class="activity_title">
                        <button class="btn" type="Submit" font="100px">
                            <a>${activity2.activityName}</a>
                        </button>
                    </div>
                    <div class="release_time">
                        <p>${activity2.organizerName} ${activity2.time}</p>
                    </div>
                </div>
            </form>
        </s:iterator>
    </s:if>

</div>
</body>

</html>
