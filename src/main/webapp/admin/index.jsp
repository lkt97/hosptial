<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线预约挂号系统（管理员)</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>
<jsp:include page="include/menu.jsp"/>
<script src="scripts/echarts.min.js"></script>
<div style="margin-top: 100px;margin-left: 300px">

    <div style="margin-top: 100px">
        <div id="page-inner">
            <div class="container">
                <div class="h3 alert-info info">我的信息</div>
                <div class="row">
                    <div class="ysjs ">
                        <div class="title">
                            <div class="t">
                                <span><a >${admin.doctorname}</a></span>
                                <span class="gender">医生ID：${admin.doctorid}</span>
                                <span class="career">科室：${depment.departmentname}</span>
                                <span class="career">职称：${admin.doctorjobtitle}</span>
                            </div>
                            <%--<img src="${doctor.picpath}">--%>
                        </div>
                        <div class="content">
                            <div >
                                <div>介绍：</div>
                                <div>${admin.doctorspecialty}</div>
                            </div>
                        </div>
                        <style>
                            .ysjs:after{
                                content: "";
                                clear: both;
                                display: block;
                            }
                            .ysjs{
                                float: left;
                                margin: 20px auto;
                                border-radius: 8px;
                                width: 800px;
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
                </div>
                <button type="button" style="color: #eeeeee"  class="btn btn-primary btn-xs"  data-toggle="modal" data-target="#myModal">
                   更新资料
                </button></div>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="margin-top: 100px;" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">更新信息</h4>
            </div>
            <form class="form-horizontal" action="/adminup.do" method="post">
                <input id="action" hidden value="add" name="action">
                <div class="modal-body">
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
                            <select class="form-control"  id="doctorsex" name="doctorsex">
                                <option>男</option>
                                <option>女</option>
                            </select>
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
                </div>
            </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
