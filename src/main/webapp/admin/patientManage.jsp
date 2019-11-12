<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>患者队列--在线预约挂号系统</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>

<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">
        <div class="container">
            <div class="h3 alert-info info">患者信息</div>

            <%--显示患者信息--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>患者账号</td>
                    <td>患者姓名</td>
                    <td>患者电话</td>
                    <td>患者性别</td>
                </tr>
                </thead>
                <c:forEach var="item" items="${page.datas}">
                    <tr>
                        <td>${item.patientid}</td>
                        <td>${item.patientname}</td>
                        <td>${item.patientphone}</td>
                        <td>${item.patientsex}</td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <span style="float:right">
			            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
			            <a href="/paAllList.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
			            <a href="/paAllList.do?currentPage=${page.prePage }&pageSize=${page.pageSize}">上一页</a>
			            <a href="/paAllList.do?currentPage=${page.nextPage }&pageSize=${page.pageSize}">下一页</a>
			            <a href="/paAllList.do?currentPage=${page.lastPage }&pageSize=${page.pageSize}">尾页</a>
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
