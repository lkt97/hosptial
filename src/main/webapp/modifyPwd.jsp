<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="bean.WorkDay" %>--%>
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
            <div class="h3 alert-info ">修改密码</div>
            <div class="col-lg-8">
                <form class=" form-horizontal" action="/modifyPwd.do" method="post">
                    <div class="h3 alert-danger ">${message}</div>
                    <input hidden name="action" value="patient">
                    <div class="form-group">
                        <label for="jmm" class="col-sm-2 control-label">旧密码</label>
                        <div class="col-sm-10">
                            <input name="jmm"  type="text" class="form-control" id="jmm" placeholder="${patient.password}">
                            <span id="pwdTip1"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xmm" class="col-sm-2 control-label">新密码</label>
                        <div class="col-sm-10">
                            <input name="xmm"  type="password" class="form-control" id="xmm" placeholder="新密码" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="qdmm" class="col-sm-2 control-label">确定密码</label>
                        <div class="col-sm-10">
                            <input name="qdmm"  type="password" class="form-control" id="qdmm"
                                   placeholder="确定密码" required onkeyup="isCheckPwd()" />
                            <span id="pwdTip"></span>
                        </div>
                    </div>
                    <div class="row">
                        <button type="submit" class="btn btn-primary  center-block" style="width: 150px" id="btn" name="btn" data-toggle="modal" data-target="#myModal">确定</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>

    function isCheck() {
        var psw2=document.getElementById("jmm")
        $.ajax({
            url:"msg.do",
            dataType:"json",
            data:{pwd:psw2},
            success:function (data) {
                alert(data.result)

                if (data.result)
                {
                    document.getElementById("pwdTip1").innerHTML = "密码正确";
                }
                else{
                    document.getElementById("pwdTip1").innerHTML = "密码不正确"
                }

            },
            error:function () {
                alert("error")
            }
        })

    }
    function isCheckPwd() {
        var pwd1 = document.getElementById("xmm").value;
        var pwd2 = document.getElementById("qdmm").value;

        if (pwd1 == pwd2) {

            document.getElementById("pwdTip").innerHTML = "两次密码相同";
            document.getElementById("btn").disabled = false;
        } else {

            document.getElementById("pwdTip").innerHTML = "两次密码不相同";
            document.getElementById("btn").disabled = true;
        }
    }
</script>
</body>
</html>
