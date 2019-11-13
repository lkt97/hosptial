<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找医生--在线预约挂号系统</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>

<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">

        <div class="search">
            <h1>按医生挂号</h1>
            <form id="doctor" action="/searchDoctor.do" method="post">
                <input  value="${doctor}" name="doctor"  autocomplete="off" class="" placeholder="查找医生">
                <input id="start" hidden value="1" name="start">
                <input id="order" hidden value="doctor" name="order">
                <button type="submit">查找医生</button>
            </form>
            <style>
                .search{
                    height:150px;
                    border-bottom: 2px #2e2e2e solid;
                }
                .search input{
                    height: 40px;
                    width: 200px;
                    color: #2e2e2e;
                    padding: 0 20px;
                    border-radius: 4px;
                }
                .search button{
                    height: 40px;
                    color: #2e2e2e;
                    padding: 0 20px;
                    border-radius: 2px;
                    cursor: pointer;
                }
                .search button:hover{
                    color: #0065AF;
                }
            </style>
        </div>


        <div class="doctors">
            <c:forEach items="${page.datas}" var="doctor">
                <div class="ysjs">
                    <div class="title">
                        <div class="t">
                            <span><a href="/doctorInfo.do?did=${doctor.doctorid}">${doctor.doctorname}</a></span>
                            <span class="gender">${doctor.doctorsex}</span><br>
                            <span class="career">${doctor.doctorjobtitle}</span>
                            <span class="career">${doctor.doctorage}岁</span>
                        </div>
                        <%--<img src="${item.picpath}">--%>
                    </div>
                    <div class="content">
                        <div >
                            <div>介绍：</div>
                            <div>${doctor.doctorspecialty}</div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <style>
                .doctors:after{
                    content: "";
                    clear: both;
                    display: block;
                }
                .ysjs{
                    float: left;
                    margin: 20px;
                    height: 300px;
                    border-radius: 8px;
                    width: 300px;
                    border: 1px #000 solid;
                }
                .ysjs .title{
                    margin: 20px;
                    position: relative;
                }
                .ysjs .title:after{
                    visibility: hidden;
                    display: block;
                    font-size: 0;
                    content: "";
                    clear: both;
                    height: 0;
                }
                .ysjs .title .t span{
                    margin: 20px;
                    color: rgb(43,43,43);
                    font-size: 30px;
                    line-height: 30px;
                }
                .ysjs .title img{
                    position: absolute;
                    top: -20px;
                    left: 480px;
                    width: 100px;
                    height: 125px;
                }
                .ysjs .title .t .gender{
                    color:rgb(95, 156, 236);
                }
                .ysjs .title .t .career{
                    font-size: 17px;
                    margin-left: 30px;
                    color:rgb(61,175,167);
                }
                .ysjs .content {
                    border-top: 1px solid rgb(219, 219, 219);
                    margin: 30px;
                    text-align: left;
                    width: 640px;
                }
                .ysjs .content div{
                    padding-top: 10px;
                }
            </style>
        </div>
<%--分页--%>
        <div>
        <span style="float:right">
            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
            <a href="${rootPath}/searchDoctor.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
            <a href="${rootPath}/searchDoctor.do?currentPage=${page.prePage}&pageSize=${page.pageSize}">上一页</a>
            <a href="${rootPath}/searchDoctor.do?currentPage=${page.nextPage}&pageSize=${page.pageSize}">下一页</a>
            <a href="${rootPath}/searchDoctor.do?currentPage=${page.lastPage}&pageSize=${page.pageSize}">尾页</a>
             <input type="text" name="jumpPage" size="4"><button id="jumpPageBtn">跳转</button>
            <%--每页条数:<input id="pageSizeSelect" type="text" value="${page.pageSize}" size="4"><button--%>
                <%--id="pageSizeSelect">修改</button>--%>
         </span>
        </div>

        <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#jumpPageBtn").click(function () {
                    var pageNo = $("input[name=jumpPage]").val();
                    window.location.href = "${rootPath}/searchDoctor.do?currentPage=" + pageNo + "&pageSize=${page.pageSize}";
                })

                $("#pageSizeSelect").change(function () {
                    var pageSize = $("#pageSizeSelect").val();
                    window.location.href = "${rootPath}/searchDoctor.do?pageSize=" + pageSize;
                })
            })
        </script>
    </div>
</div>

</body>
</html>
