<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者队列--在线预约挂号系统</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<div style="margin-top: 100px">
    <div id="page-inner">
        <div class="container">
            <div class="h3 alert-info info">患者队列</div>

            <%--显示患者队列--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>预约时间</td>
                    <td>就诊序号</td>
                    <td>预约状态</td>
                    <td>患者id</td>
                    <td>医嘱</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach var="item" items="${palist}">
                    <tr>
                        <td>${item.appointtime}</td>
                        <td>${item.appointnumber}</td>
                        <td>${item.appointstatus}</td>
                        <td>${item.patientid}</td>
                        <td><input type="text" name="Recipe" id="Recipe"></td>
                        <c:choose>
                            <c:when test="${item.appointstatus=='未就诊'}">
                                <td >
                                    <a href="/paSave.do?appointnumber=${item.appointnumber}">
                                    <button type="button" data-rid=" " data-pid=" " data-action="finish"  class="btn btn-success btn-xs"  data-toggle="modal" data-target="#myModal">
                                        就诊
                                    </button>
                                    </a>
                                    <a href="">
                                    <button type="button" data-rid=" " data-pid=" " data-action="sy"   class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#myModal">
                                        爽约
                                    </button>
                                    </a>
                                </td>
                            </c:when>
                            <c:otherwise><td></td></c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                <script>

                </script>
            </table>

        </div>
    </div>
</div>

</body>
</html>
