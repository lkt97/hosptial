<%--
  Created by IntelliJ IDEA.
  User: tyy
  Date: 2019/10/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/styles.css">
    <link rel="shortcut icon" href="#">
    <style>
        form :focus:required:invalid {
            border-color: #a94442;
        }
        .text-center button{
            height: 54px;
            color: #fff;
            background: #e22;
            border: 0;
            font-size: 16px;
            font-family: "Microsoft YaHei","Hiragino Sans GB";
        }
        /*设定html和body的宽度为100%*/
        html,body{
            width:100%;
            font: 14px/150% tahoma,arial,Microsoft YaHei,Hiragino Sans GB,"\u5b8b\u4f53",sans-serif;
            -webkit-font-smoothing: antialiased;
            color: #666;
        }

        .form-control{
            height: 19px;
            padding-bottom: 11px;
            padding-left: 20px;
            padding-top: 16px;
            font-size: 14px;
            color: #666;
            font-family: "Microsoft YaHei","Hiragino Sans GB";
        }
    </style>
</head>
<body  class="container">
    <header class="main-header">
        <h1 class="logo-text">医院预约系统</h1>
    </header>
    <head >
        <h1>用户登录</h1>
    </head>
    <section>
        <div class="panel panel-default">
            <div class="panel-body">
                <form login="form">
                    <div class="form-group">
                        <label for="usename">账号</label>
                        <input class="form-control" name="usename" id="usename" autofocus required pattern="[a-zA-Z\s]+" placeholder="请输入用户名或ID">
                    </div>

                    <div class="form-group">
                        <label for="password">密码</label>
                        <input class="form-control" type="password" name="password" id="password" value="" placeholder="请输入密码" required>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="p">
                            患者
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="d" checked>
                            医师
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="type" value="g">
                            管理员
                        </label>
                    </div>

                    <div class="text-center">
                        <button type="submit" id="submit" class="btn btn-default">立即登录</button>
                    </div>

                    <div>
                        <div class="text-left">
                            <a type="findpassword" class="text text-default">找回密码</a>
                        </div>
                        <div class="text-right">
                            <a type="registered" class="text text-default">用户注册</a>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </section>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
    <script src="scripts/login.js" charset="utf-8"></script>

    <script type="text/javascript" charset="utf-8">
        $(function() {
            $("#submit").click(function(e) {
                alert("登录成功");
                window.location.href="http://localhost:8080/jsp/registered.jsp";
            })

        })
    </script>

</body>
</html>
