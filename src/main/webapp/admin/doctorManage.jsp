<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线预约挂号系统（管理员)</title>
    <jsp:include page="include/headtag.jsp"/>

</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">

        <div class="search">
            <h1>医生列表</h1>
            <div class="alert-danger">${message}</div>
            <button type="button" style="color: #eeeeee"  class="btn btn-primary btn-xs"  data-toggle="modal" data-target="#myModal">
                添加医生
            </button>
            <form style="margin-top: 10px" id="office" action="/findoc.do" method="post">
                <input  type="text" name="doctor" id="doctor" placeholder="医生名字">
                <button type="submit">查找医生</button>
            </form>
            <style>
            .search{
                height:180px;
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
            <c:forEach items="${doclist}" var="item">
                <div class="ysjs">
                    <div class="title">
                        <div class="t">
                            <span><a href="/schedule.do?doctorid=${item.doctorid}">${item.doctorname}</a></span>
                            <span class="gender">${item.doctorphone}</span>
                            <span class="career">${item.doctorsex}</span>
                            <span class="career">${item.doctorage}岁</span>
                        </div>
                        <div class="b">
                            <span>${depment.departmentname} （${item.doctorjobtitle}）</span>
                        </div>
                    </div>
                    <div class="content">
                        <div >
                            <div>介绍：</div>
                            <div>${item.doctorspecialty}</div>
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
                    margin: 20px ;
                    height: 300px;
                    border-radius: 8px;
                    width: 680px;
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

        <%--添加科室--%>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" style="margin-top: 100px;" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">添加医生</h4>
                    </div>
                    <form class="form-horizontal" action="/registerdoc.do" method="post">
                        <input id="action" hidden value="add" name="action">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="DoctorID" class="col-sm-2 control-label">医生账号</label>
                                <div class="col-sm-10">
                                    <input   name="DoctorID" class="form-control" id="DoctorID" placeholder="医生账号">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="DocPassword" class="col-sm-2 control-label">医生密码</label>
                                <div class="col-sm-10">
                                    <input   name="DocPassword" class="form-control" id="DocPassword" placeholder="医生密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="DoctorName" class="col-sm-2 control-label">医生姓名</label>
                                <div class="col-sm-10">
                                    <input   name="DoctorName" class="form-control" id="DoctorName" placeholder="医生姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="doctorage" class="col-sm-2 control-label">年龄</label>
                                <div class="col-sm-10">
                                    <input type="number" name="doctorage" class="form-control" id="doctorage" placeholder="年龄">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="DoctorPhone" class="col-sm-2 control-label">医生电话</label>
                                <div class="col-sm-10">
                                    <input   name="DoctorPhone" class="form-control" id="DoctorPhone" placeholder="医生电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="doctorsex" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-10" >
                                    <select class="form-control" id="doctorsex" name="doctorsex">
                                        <option>男</option>
                                        <option>女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="DoctorJobTitle" class="col-sm-2 control-label">医生职称</label>
                                <div class="col-sm-10" >
                                    <select class="form-control" id="DoctorJobTitle" name="DoctorJobTitle">
                                        <option>医生</option>
                                        <option>主任</option>
                                    </select>
                                </div>
                            </div>

                            </div>
                            <div class="form-group">
                                <label for="DoctorSpecialty" class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10" >
                                    <textarea id="DoctorSpecialty" name="DoctorSpecialty" class="form-control" rows="3" placeholder="请输入医生描述信息"></textarea>
                                </div>
                            </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button  type="submit" class="btn btn-primary order">确定</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
