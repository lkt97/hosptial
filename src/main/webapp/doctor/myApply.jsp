<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>

<div style="margin-top: 100px">
    <div id="page-inner"><div class="container">
            <div class="row"> <a href="doctor/docApply.jsp" target="iframedoctor"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" >新增申请</button></a></div>
            <div class="h3 alert-info info">我的申请</div>
            <%--显示我的申请--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>id</td>
                    <td>开始时间</td>
                    <td>申请天数</td>
                    <td>请假状态</td>
                    <td>申请医生</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach var="item" items="${page.datas}">
                    <tr>
                        <td>${item.dleid}</td>
                        <td>${item.leastatime}</td>
                        <td>${item.leadaynum}</td>
                        <c:if test="${item.flag==1}">
                            <td>已审批</td>
                        </c:if>
                        <c:if test="${item.flag==0}">
                            <td>未通过</td>
                        </c:if>
                        <c:if test="${item.flag==2}">
                            <td>已拒绝</td>
                        </c:if>
                        <td>${item.doctorid}</td>
                        <td class="btn btn-info btn-link" data-aid=""data-toggle="modal" data-target="#myModal">
                            <c:if test="${item.flag==0}">
                            <a href="/Docapplydel.do?dleid=${item.dleid}">取消</a>
                            </c:if>
                            <c:if test="${item.flag==1}">
                                不可取消
                            </c:if>
                            <c:if test="${item.flag==2}">
                                不可取消
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                    <span style="float:right">
                            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
                            <a href="/DocL.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
                            <a href="/DocL.do?currentPage=${page.prePage }&pageSize=${page.pageSize}">上一页</a>
                            <a href="/DocL.do?currentPage=${page.nextPage }&pageSize=${page.pageSize}">下一页</a>
                            <a href="/DocL.do?currentPage=${page.lastPage }&pageSize=${page.pageSize}">尾页</a>
                             <input type="text" name="jumpPage" size="4"><button id="jumpPageBtn">跳转</button>
                            每页条数:<input id="pageSizeSelect" type="text" value="${page.pageSize}" size="4"><button
                            id="pageSizeSelect">修改</button>
                         </span>
            </div>
            <%--取消--%>
            <%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">--%>
                <%--<div class="modal-dialog" style="margin-top: 200px;" role="document">--%>
                    <%--<div class="modal-content" style="width: 650px;">--%>
                        <%--<div class="modal-header">--%>
                            <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                            <%--<h4 class="modal-title" id="myModalLabel">请选择要锁定的号源</h4>--%>
                        <%--</div>--%>
                        <%--<form action='myApply' method='post'>--%>
                            <%--<input id="aid" hidden  name="aid">--%>
                            <%--<input  hidden  name="action" value="cancel">--%>
                            <%--<div class="modal-body">--%>
                                <%--<div class="haoyuan">--%>
                                    <%--<label><input  type='radio'>确定取消吗？</label></li>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="modal-footer">--%>
                                <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                                <%--<button id="doalert" type="button" class="btn btn-primary order">确定</button>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <script>
                // $(function () {
                //     $('#myModal').on('show.bs.modal', function (event) {
                //         var button = $(event.relatedTarget);
                //         var aid = button.data('aid');
                //         $("#aid").val(aid);
                //     });
                //     $('#doalert').click(function () {
                //         if($("input[type=radio]:checked").length==1){
                //             $("form").submit();
                //         }else {$('#myModal').modal('hide')}
                //     })
                // })

            </script>
            <%--显示预约的号源信息--%>
            <style>
                .haoyuan{
                    margin: 20px auto;
                    background-color: #eeeeee;
                }
                .haoyuan:after{
                    display: block;
                    content: '';
                    clear: both;
                }
                .haoyuan ul{
                    list-style: none;
                }
                .haoyuan ul li{
                    float: left;
                    margin:10px 20px;
                }
                .haoyuan ul .已被预约{
                    color: #999;
                }
                .haoyuan ul .可预约{
                    color: #0065AF;
                    cursor: pointer;
                }
                .haoyuan ul .可预约:hover{
                    background-color: #00E8D7;
                }
            </style>
        </div>
    </div>
</div>

</body>
</html>
