<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科室预约--在线预约挂号系统</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>

<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">

        <div class="search">
            <h1>科室列表</h1>
            <form id="office" action="/searchOffice.do" method="post">
                <input  value="${office}" name="office"  autocomplete="off" class="" placeholder="科室名称">
                <input id="start" hidden value="1" name="start">
                <button type="submit">查找科室</button>
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
        <div id="offices">
            <c:forEach items="${page.datas}" var="department" varStatus="wid">
                <a href="/searchDoctor.do?office=${department.departmentid} ">
                    <div class="office-item">
                        <div class="office-name">
                            <h3>${department.departmentname}</h3>
                        </div>
                        <div>
                            <p>&nbsp;</p>
                            <p  class="office-click">详细信息</p>
                        </div>
                    </div>
                </a>
            </c:forEach>

            <style>
                #offices:after{
                    content: "";
                    clear: both;
                    display: block;
                }
            .office-item{
                width: 230px;
                height: 180px;
                float: left;
                text-align: center;
                border: 1px solid #dddddd;
                margin: 30px ;
            }
            .office-item .office-name{
                margin: 30px auto;
                color: #000;
            }
            .office-item p{
                margin: 30px auto;
                color: #2b66a5;
            }
            .office-item .office-click{
                color: #de615e;
                font-size: 15px;
                cursor: pointer;
            }
        </style>
        </div>
    </div>
</div>
        <%--<c:if test="${pages.totalPages> 0}">--%>
    <%--<form id="pagination">--%>

    <%--<ul class="pagination">--%>
        <%--<li <c:if test="${pages.currentPage < 1}">class="disabled"</c:if>><a--%>
                <%--onclick="jump('${pages.prePage}')">&laquo;</a></li>--%>
        <%--<c:forEach begin="${pages.firstPage}" end="${pages.lastPage}"--%>
                   <%--varStatus="status">--%>
            <%--<li>--%>
                <%--<a <c:if test="${status.index == pages.currentPage}">class="disabled"</c:if>--%>
                    <%--onclick="jump('${status.index}')">--%>
                        <%--${status.index } </a>--%>
            <%--</li>--%>
        <%--</c:forEach>--%>
        <%--<li--%>
                <%--<c:if test="${pages.currentPage> pages.totalPages}">class="disabled"</c:if>>--%>
            <%--<a onclick="jump('${pages.nextPage}')">&raquo;</a>--%>
        <%--</li>--%>
        <%--<li><input id="index"></li>--%>
        <%--<li><a onclick="jumpInput()">Go</a></li>--%>
        <%--<li><a class="disabled">共${pages.totalPages}页${pages.totalRecords}条记录</a>--%>

        <%--<script>--%>
            <%--function jump(index) {--%>
                <%--$("#start").val(index);--%>
                <%--$("#office").submit();--%>
            <%--}--%>
            <%--function jumpInput() {--%>
                <%--var index=$("#index").val();--%>
                <%--var match = /^[1-9][0-9]*[0-9]*$/;--%>
                <%--if(match.test(index)){--%>
                    <%--jump(index);--%>
                <%--}else {--%>
                    <%--alert("请输入数字！")--%>
                <%--}--%>
            <%--}--%>
        <%--</script>--%>
        <%--<style>--%>
            <%--#pagination{--%>
                <%--width: 90%;--%>
                <%--text-align: center;--%>
            <%--}--%>
            <%--.pagination {--%>
                <%--display: inline-block;--%>
                <%--padding-left: 0;--%>
                <%--margin: 21px 0;--%>
                <%--border-radius: 4px;--%>
            <%--}.pagination li{--%>
                 <%--display: inline;--%>
             <%--}--%>

            <%--.pagination a{--%>
                <%--border-radius: 6px;--%>
                <%--color: #eb6864;--%>
                <%--cursor: pointer;--%>
                <%--padding: 14px 16px;--%>
                <%--font-size: 19px;--%>
                <%--line-height: 1.3333333;--%>
                <%--border: 1px solid #dddddd;--%>
                <%--margin-left: -1px;--%>
            <%--}--%>
            <%--.pagination a:hover{--%>
                <%--background-color: #eeeeee;--%>
            <%--}--%>
            <%--.pagination input{--%>
                <%--border: 1px solid #dddddd;--%>
                <%--width: 60px;--%>
                <%--padding: 8px 12px;--%>
                <%--font-size: 15px;--%>
                <%--line-height: 1.5;--%>
                <%--color: #777777;--%>
            <%--}--%>
            <%--.pagination .disabled{--%>
                <%--cursor: not-allowed;--%>
            <%--}--%>
        <%--</style>--%>
    <%--</ul>--%>
<%--</form>--%>

        <div>
        <span style="float:right">
            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
            <a href="${rootPath}/searchOffice.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
            <a href="${rootPath}/searchOffice.do?currentPage=${page.prePage}&pageSize=${page.pageSize}">上一页</a>
            <a href="${rootPath}/searchOffice.do?currentPage=${page.nextPage}&pageSize=${page.pageSize}">下一页</a>
            <a href="${rootPath}/searchOffice.do?currentPage=${page.lastPage}&pageSize=${page.pageSize}">尾页</a>
             <input type="text" name="jumpPage" size="4"><button id="jumpPageBtn">跳转</button>
            <%--每页条数:<input id="pageSizeSelect" type="text" value="${page.pageSize}" size="4"><button--%>
                <%--id="pageSizeSelect">修改</button>--%>
         </span>
        </div>
        </fieldset>
</body>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function () {
        $("#jumpPageBtn").click(function () {
            var pageNo = $("input[name=jumpPage]").val();
            window.location.href = "${rootPath}/searchOffice.do?currentPage=" + pageNo + "&pageSize=${page.pageSize}";
        })

        $("#pageSizeSelect").change(function () {
            var pageSize = $("#pageSizeSelect").val();
            window.location.href = "${rootPath}/searchOffice.do?pageSize=" + pageSize;
        })
    })
</script>
<%--</c:if>--%>
    </div>
</div>

</body>
</html>
