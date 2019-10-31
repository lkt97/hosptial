<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页--在线预约挂号系统</title>
    <jsp:include page="include/headtag.jsp"/>
</head>
<body>
<jsp:include page="include/head.jsp"/>

<!--右边菜单栏-->
<div id="wrapper" class="toggled1 ">

    <div id="sidebar-wrapper1">
        <ul class="sidebar-nav1">
            <li class="sidebar-brand1"><a href="#"> </a></li>
            <br />
            <br />
            <br />
            <li><a class="list-group-item1" href="/myWork.do" target="iframedoctor"><font color="#fff">排班信息</font></a></li>
            <li><a class="list-group-item1" href="<%=request.getContextPath()%>/doctor/myApply" target="iframedoctor"><font color="#fff">我的申请</font></a></li>
            <li><a class="list-group-item1" href="<%=request.getContextPath()%>/doctor/patientList" target="iframedoctor"><font color="#fff">患者队列</font></a></li>
            <li><a class="list-group-item1" href="/myinfo.do" target="iframedoctor"><font color="#fff">我的信息</font></a></li>
            <!-- <li><a class="list-group-item1" href="/ssm_pro/orderIndex"><font color="#fff">快速预约</font></a></li> -->
            <li><a class="list-group-item1" href="modifyPwd.jsp" target="iframedoctor"><font color="#fff">修改密码</font></a></li>
        </ul>
    </div>
</div>


<div style="margin-top: 65px;margin-left: 300px">

    <iframe src="" frameborder="0" name="iframedoctor" width="1000px" height="600px">

    </iframe>
</div>

</body>
</html>
