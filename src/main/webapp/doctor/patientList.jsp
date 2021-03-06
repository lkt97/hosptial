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
                <c:forEach var="item" items="${page.datas}">
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
                                    <a href="/pdDel.do?appointnumber=${item.appointnumber}">
                                        <button type="button" data-rid=" " data-pid=" " data-action="sy"   class="btn btn-danger btn-xs"  data-toggle="modal" data-target="#myModal">
                                            爽约
                                        </button>
                                    </a>
                                </td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>

            <div>
                <span style="float:right">
			            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
			            <a href="/palist.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
			            <a href="/palist.do?currentPage=${page.prePage }&pageSize=${page.pageSize}">上一页</a>
			            <a href="/palist.do?currentPage=${page.nextPage }&pageSize=${page.pageSize}">下一页</a>
			            <a href="/palist.do?currentPage=${page.lastPage }&pageSize=${page.pageSize}">尾页</a>
			             <input type="text" name="jumpPage" size="4"><button id="jumpPageBtn">跳转</button>
			            每页条数:<input id="pageSizeSelect" type="text" value="${page.pageSize}" size="4"><button
                        id="pageSizeSelect">修改</button>
			         </span>
            </div>
        </div>
    </div>
</div>

</body>
</html>
