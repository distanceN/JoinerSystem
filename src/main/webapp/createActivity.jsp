<%@ page import="joiner.entity.Organizer" %>
<%@ page import="joiner.entity.Activity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="index.css" rel="stylesheet">
    <title></title>

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
                            <input type="hidden" name="activity.activityId"
                                   value="<s:property value="#activity1.activityId"/>">
                            <input class="item" type="submit" value="<s:property value="#activity1.activityName"/>">
                        </form>
                    </s:iterator>
                </s:if>
            </div>
        </div>
        <div class="right">
            <div class="text-create">Create Event</div>
            <div class="line-right"></div>
            <div>


                <form name="create_activity" method="post" action="create_activity">
                    <input type="hidden" name="activity.organizerName"
                           value="<s:property value="#session.organizer.organizerName"/>"/>

                    <div class="event-name">
                        <p>Event Name:</p>
                        <input type="text" castyle="width: 800px;" name="activity.activityName">
                    </div>
                    <div class="event-name">
                        <p>Event Time:</p>
                        <input type="text" style="width: 800px;" name="activity.time">
                    </div>
                    <div class="event-name">
                        <p>Event Place:</p>
                        <input type="text" style="width: 800px;" name="activity.place">
                    </div>
                    <div class="event-name">
                        <p>Event detial:</p>
                        <textarea type="text" style="width: 800px; height: 100px;"
                                  name="activity.description"> </textarea>
                    </div>
                    <input type="submit" class="btn-send" value="Save"/>
                </form>
                <form name="Redict" action="create_event.jsp" method="get">
                    <input type="submit" class="btn-cancel" value="Cancel">
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>