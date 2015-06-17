<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                <s:iterator value="#session.activityList" id="activity">
                    <form action="activityInformation" method="post" name="activityInformation" validate="true">
                        <input type="hidden" name="activity.activityId"
                               value="<s:property value="#activity.activityId"/>">
                        <input class="item" type="submit" value="<s:property value="#activity.activityName"/>">
                    </form>
                </s:iterator>
            </s:if>
            </div>
        </div>
        <div class="right">

        </div>
    </div>
</div>
</div>
</body>
</html>