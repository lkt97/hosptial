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
            <form class=" form-horizontal" action="/myPwd.do"  method="post">
                <div class="h3 alert-danger "></div>
                <input hidden name="action" value="doctor">
                <div class="form-group">
                    <label for="jmm" class="col-sm-2 control-label">旧密码</label>
                    <div class="col-sm-10">
                        <input name="jmm"  type="password" class="form-control" id="jmm" placeholder="旧密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="xmm" class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-10">
                        <input name="xmm"  type="password" class="form-control" id="xmm" placeholder="新密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="qdmm" class="col-sm-2 control-label">确定密码</label>
                    <div class="col-sm-10">
                        <input name="qdmm"  type="password" class="form-control" id="qdmm" placeholder="确定密码">
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

</body>
</html>
