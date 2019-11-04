<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>

<div style="margin-top: 100px;margin-left: 300px">
    <div id="page-inner">
        <div class="container">
            <div class="h3 alert-info ">修改密码</div>
            <div class="col-lg-8">
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
                    <div class="row">
                        <button type="submit" class="btn btn-primary  center-block" style="width: 150px" data-toggle="modal" data-target="#myModal">确定</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>

</body>
</html>
