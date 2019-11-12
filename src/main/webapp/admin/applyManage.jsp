<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页--在线预约挂号系统</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>

<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">
        <div class="container">
            <div class="h3 alert-info info">医生申请列表</div>
            <%--显示医生申请列表--%>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>id</td>
                    <td>开始时间</td>
                    <td>申请天数</td>
                    <td>请假状态</td>
                    <td>调班医生</td>
                    <td>操作</td>
                </tr>
                </thead>
                <c:forEach var="item" items="${page.datas}">
                    <tr>
                        <td>${item.dleid}</td>
                        <td>${item.leastatime}</td>
                        <td>${item.leadaynum}</td>
                        <td>${item.flag==1?"已审批":"未通过"}</td>
                        <td>${item.tbdoctorid}</td>
                        <td>
                            <c:if test="${item.flag==0}">
                                <a href="/doclSave.do?dleid=${item.dleid}">
                                <button type="button" data-aid="" data-action="agree"  class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">
                                    同意
                                </button></a>
                                <a href="/doclNo.do?dleid=${item.dleid}"><button type="button" data-aid="" data-action="reject" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myModal">
                                    拒绝
                                </button></a>
                            </c:if></td>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div>
                <span style="float:right">
                            总共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.currentPage }页
                            <a href="/docLlist.do?currentPage=${page.firstPage}&pageSize=${page.pageSize}">首页</a>
                            <a href="/docLlist.do?currentPage=${page.prePage }&pageSize=${page.pageSize}">上一页</a>
                            <a href="/docLlist.do?currentPage=${page.nextPage }&pageSize=${page.pageSize}">下一页</a>
                            <a href="/docLlist.do?currentPage=${page.lastPage }&pageSize=${page.pageSize}">尾页</a>
                             <input type="text" name="jumpPage" size="4"><button id="jumpPageBtn">跳转</button>
                            每页条数:<input id="pageSizeSelect" type="text" value="${page.pageSize}" size="4"><button
                        id="pageSizeSelect">修改</button>
                         </span>
            </div>
            <%--取消--%>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" style="margin-top: 200px;" role="document">
                    <div class="modal-content" style="width: 650px;">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">医生申请管理</h4>
                        </div>
                        <form action='applyManage' method='post' autocomplete="off">
                            <input id="aid" hidden  name="aid">
                            <input  hidden id="action" name="action" value="cancel">
                            <div class="modal-body">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button id="doalert" type="button" class="btn btn-primary order">确定</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <script>
                $(function () {
                    $('#myModal').on('show.bs.modal', function (event) {
                        var button = $(event.relatedTarget);
                        var aid = button.data('aid');
                        var action = button.data('action');
                        $("#aid").val(aid);
                        $("#action").val(action);
                        var options="";
                        if(action=="agree"){
                            $('.modal-body').empty();
                            options="<label ><input class='form-control' name='nsnum'  placeholder='输入号源数'></label><br><label ><input   type='radio'>同意</label>";
                            ($(options)).appendTo($(".modal-body"));
                        }else {
                            $('.modal-body').empty();
                            options="<label><input  type='radio'>拒绝？</label>";
                            ($(options)).appendTo($(".modal-body"));
                        }
                    });
                    $('#doalert').click(function () {
                        if($("input[type=radio]:checked").length==1){
                            $("form").submit();
                        }else {$('#myModal').modal('hide')}
                    })
                })

            </script>
        </div>
    </div>
</div>

</body>
</html>
