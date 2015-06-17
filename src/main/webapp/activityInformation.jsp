<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
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
            <s:if test="#session.organizer!=null">
                <div class="item"><s:property value="#session.organizer.organizerName"/></div>
            </s:if>
            <div class="img">
                <img src="">
            </div>
            <form name="Redict" action="createActivity.jsp" method="get">
                <input type="submit" class="brn btn-1" value="Create">
            </form>
            <div class="cut-line"></div>
            <div class="items">
            <s:if test="#session.activityList!=null">
                <s:iterator value="#session.activityList" id="activity1">
                    <form action="activityInformation" method="post" name="activityInformation" validate="true">
                        <input type="hidden" name="activity.activityId" value="<s:property value="#activity1.activityId"/>">
                        <input class="item" type="submit" value="<s:property value="#activity1.activityName"/>">
                    </form>
                </s:iterator>
            </s:if>
            </div>
        </div>
        <div class="right">
            <div class="text-create"><s:property value="#session.activity.activityName"/></div>
            <div class="line-right"></div>
            <div class="event-name">
                    <p>Event Name:</p>
                    <input type="text" readonly="true" style="width: 800px;" value="<s:property value="#session.activity.activityName"/>">

                    <p>Event Time:</p>
                    <input type="text" readonly="true" style="width: 800px;" value="<s:property value="#session.activity.time"/>">

                <p>Event Place:</p>
                <input type="text" readonly="true" style="width: 800px;" value="<s:property value="#session.activity.place"/>">

                    <p>Event detial:</p>
                    <input type="text" readonly="true" style="width: 800px; height: 100px;" value="<s:property value="#session.activity.description"/>"> </textarea>
            </div>
            <s:if test="#session.studentList!=null">
                <s:iterator value="#session.studentList" id="student">
                    <div class="event-name"><s:property value="#student.studentId"/></div>
                </s:iterator>
            </s:if>
        </div>
    </div>
</div>
</body>
</html>