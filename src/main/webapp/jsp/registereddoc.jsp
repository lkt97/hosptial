<%--
  Created by IntelliJ IDEA.
  User: tyy
  Date: 2019/10/28
  Time: 9:59
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
    <title>regidter</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/styles.css">
    <link rel="shortcut icon" href="#">
    <style>
        form :focus:required:invalid{
            border-color: #a94442;
        }

        i{
            font-style: normal;
        }
        a{
            text-decoration: none;
        }
        input{
            outline: none;
            border:none;
        }
        /*设定html和body的宽度为100%*/
        html,body{
            width:100%;
            font: 14px/150% tahoma,arial,Microsoft YaHei,Hiragino Sans GB,"\u5b8b\u4f53",sans-serif;
            -webkit-font-smoothing: antialiased;
            color: #666;
        }
        .logo img{
            width: 200px;
            height:100px;

            position: absolute;
        }
        .desc{
            font-size: 18px;
            line-height: 34px;
            border-left: 1px solid #ccc;
            position: absolute;
            left: 200px;
            top:28px;
            padding-left: 20px;
            font-weight:bold;
        }
        /*注册信息*/
        /*总体布局*/
        form{
            width: 400px;
            margin: auto;
            margin-top: 100px;
        }
        .register-box{
            border: 1px solid #ddd;
            margin-bottom: 32px;
        }
        .register-box label{
            height: 52px;
            line-height: 52px;
            padding-left: 20px;
            display: inline-block;
        }
        .register-box input{
            width: 190px;
            height: 19px;
            padding-bottom: 11px;
            padding-left: 20px;
            padding-top: 16px;
            font-size: 14px;
            color: #666;
            font-family: "Microsoft YaHei","Hiragino Sans GB";
        }
        .register-box .tips{
            position: absolute;
            margin-top: 5px;
            font-size: 14px;
            color: #ccc;
        }
        /*用户名*/
        .register-box .username_label{
            word-spacing: 10px;
        }
        /*密码，确认密码，*/
        .register-box .other_label{
            word-spacing: 2px;
        }
        /*手机号*/
        .register-box span{
            display: inline-block;
            width: 77px;
            height: 52px;
            border-right: 1px solid #ddd;
        }
        .register-box .phone{
            padding-left: 18px;
        }
        /*验证码*/
        #code{
            display: inline-block;
            width: 100px;
            height: 46px;
            vertical-align: middle;
            background-color: black;
            font-size: 25px;
            color: #fff;
            text-align: center;
            line-height: 46px;
        }
        /*协议*/
        .arguement{
            margin-bottom: 58px;
        }
        .arguement input{
            vertical-align: middle;
        }
        .arguement a{
            color: #38f;
            text-decoration: none;
            font-size: 12px;
        }
        /*提交按钮*/
        .submit_btn button{
            width: 100%;
            height: 54px;
            color: #fff;
            background: #e22;
            border: 0;
            font-size: 16px;
            font-family: "Microsoft YaHei","Hiragino Sans GB";
        }
    </style>
</head>
<body  class="container">
<header class="main-header">
    <h1 class="logo-text">医院预约系统</h1>
</header>
<head >
    <h1>医生注册</h1>
</head>
<section>
    <div class="panel panel-default">


        <form class="form-login" action="/registerdoc.do" method="post">
            <div class="register-box">
                <label for="DoctorID" class="username_label">医 生 I D
                    <input id="DoctorID"  name="DoctorID" maxlength="20" type="text" autofocus required placeholder="医生登录ID" onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                </label>
                <div id="userNameTip" class="tips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DocPassword" class="other_label">设 置 密 码
                    <input id="DocPassword"  name="DocPassword" maxlength="20" type="password" placeholder="建议至少使用两种字符组合" onkeyup="value=value.replace(/\s/g,'')"/>
                </label>
                <div class="passtips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DoctorName" class="username_label">医 生 姓 名
                    <input id="DoctorName"  name="DoctorName" maxlength="20" type="text" autofocus required placeholder="医生姓名" onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                </label>
                <div id="nametips" class="tips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DoctorDeptID" class="username_label">医 生 科 室
                    <input id="DoctorDeptID"  name="DoctorDeptID" maxlength="20" type="text" autofocus required placeholder="医生科室" onkeyup="value=value.replace(/[\W]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                </label>
                <div id="deotidtips" class="tips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DoctorJobTitle" class="other_label">医 生 级 别
                    <input id="DoctorJobTitle"  name="DoctorJobTitle" maxlength="20" type="text" placeholder="医生/主任" onkeyup="value=value.replace(/\s/g,'')"/>
                </label>
                <div class="jobtips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DoctorSpecialty" class="other_label">医 生 领 域
                    <input id="DoctorSpecialty"  name="DoctorSpecialty" maxlength="20" type="text" placeholder="" onkeyup="value=value.replace(/\s/g,'')"/>
                </label>
                <div class="jobtips" >

                </div>
            </div>
            <div class="register-box">
                <label for="DoctorPhone" class="other_label">手 机 号 码
                    <input type="text" name="DoctorPhone" id="DoctorPhone" placeholder="建议输入常用的手机号码" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" >
                </label>
                <div class="phonetips" id="mobileTip">

                </div>
            </div>

            <div class="arguement">
                <input type="checkbox" id="xieyi"/>
                阅读并同意
                <a href="#">《商城用户注册协议》</a>
                <a href="#">《隐私政策》</a>
                <div class="tips">

                </div>
            </div>
            <div class="submit_btn">
                <button type="submit" id="submit">立 即 注 册</button>
            </div>
        </form>
    </div>





</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js" charset="utf-8"></script>
<script src="scripts/registered.js" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
    // $(function(){
    //     //聚焦失焦input
    //     $('input').eq(0).focus(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("仅允许字母，数字的多种组合");
    //         }
    //     })
    //
    //     $('input').eq(1).focus(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("建议使用字母、数字和符号两种以上的组合，6-20个字符");
    //         }
    //     })
    //     $('input').eq(2).focus(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("请再次输入密码");
    //         }
    //     })
    //     $('input').eq(3).focus(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("验证完后，你可以使用该手机登陆和找回密码");
    //         }
    //     })
    //     $('input').eq(4).focus(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next().next("div").text("看不清？点击图片更换验证码");
    //         }
    //     })
    //     //input各种判断
    //     //用户名：
    //     $('input').eq(0).blur(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("");
    //             $(this).parent().next("div").css("color",'#ccc');
    //         }else if($(this).val().length>0 && $(this).val().length<4){
    //             $(this).parent().next("div").text("长度只能在4-20个字符之间");
    //             $(this).parent().next("div").css("color",'red');
    //         }else if($(this).val().length>=4&& !isNaN($(this).val())){
    //             $(this).parent().next("div").text("用户名不能为纯数字");
    //             $(this).parent().next("div").css("color",'red');
    //         }else{
    //             $.get("LoginAndRegisterServlet?op=findName&username="+$(this).val(),function(data){
    //                 $("#userNameTip").html(data);
    //             });
    //             $(this).parent().next("div").css("color",'red');
    //         }
    //     })
    //     //昵称
    //     $('input').eq(1).blur(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("");
    //             $(this).parent().next("div").css("color",'#ccc');
    //         }else if($(this).val().length>0 && $(this).val().length<3){
    //             $(this).parent().next("div").text("长度只能在3-16个字符之间");
    //             $(this).parent().next("div").css("color",'red');
    //         }else{
    //             $(this).parent().next("div").text("");
    //         }
    //     })
    //     //密码
    //     $('input').eq(2).blur(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("");
    //             $(this).parent().next("div").css("color",'#ccc');
    //         }else if($(this).val().length>0 && $(this).val().length<6){
    //             $(this).parent().next("div").text("长度只能在6-20个字符之间");
    //             $(this).parent().next("div").css("color",'red');
    //         }else{
    //             $(this).parent().next("div").text("");
    //         }
    //     })
    //     //	确认密码
    //     $('input').eq(3).blur(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("");
    //             $(this).parent().next("div").css("color",'#ccc');
    //         }else if($(this).val()!=$('input').eq(2).val()){
    //             $(this).parent().next("div").text("两次密码不匹配");
    //             $(this).parent().next("div").css("color",'red');
    //         }else{
    //             $(this).parent().next("div").text("");
    //         }
    //     })
    //     //	手机号
    //     $('input').eq(4).blur(function(){
    //         //var regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))$";
    //         if($(this).val().length==0){
    //             $(this).parent().next("div").text("");
    //             $(this).parent().next("div").css("color",'#ccc');
    //             //}else if($(this).val().substr(0,3)!=138&&$(this).val().substr(0,3)!=189&&$(this).val().substr(0,3)!=139&&$(this).val().substr(0,3)!=158&&$(this).val().substr(0,3)!=188&&$(this).val().substr(0,3)!=157||$(this).val().length!=11){
    //         }else if($(this).val().length!=11){
    //             $(this).parent().next("div").text("手机号格式不正确");
    //             $(this).parent().next("div").css("color",'red');
    //         }else{
    //             $.get("LoginAndRegisterServlet?op=findMobile&mobile="+$(this).val(),function(data){
    //                 $("#mobileTip").html(data);
    //             });
    //         }
    //         $(this).parent().next("div").css("color",'red');
    //     })
    //
    //     // 	验证码
    //     //	 验证码刷新
    //     function code(){
    //         var str="qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPLKJHGFDSAZXCVBNM";
    //         var str1=0;
    //         for(var i=0; i<4;i++){
    //             str1+=str.charAt(Math.floor(Math.random()*62))
    //         }
    //         str1=str1.substring(1)
    //         $("#code").text(str1);
    //     }
    //     code();
    //     $("#code").click(code);
    //     //	验证码验证
    //     $('input').eq(5).blur(function(){
    //         if($(this).val().length==0){
    //             $(this).parent().next().next("div").text("");
    //             $(this).parent().next().next("div").css("color",'#ccc');
    //         }else if($(this).val().toUpperCase()!=$("#code").text().toUpperCase()){
    //             $(this).parent().next().next("div").text("验证码不正确");
    //             $(this).parent().next().next("div").css("color",'red');
    //         }else{
    //             $(this).parent().next().next("div").text("");
    //         }
    //     })
    //     // //	提交按钮
    //     // $("#submit").click(function(e){
    //     //     alert("注册成功");
    //     //     window.location.href="http://localhost:8080/jsp/login.jsp";
    //     // })
    // })

</script>

</body>
</html>
