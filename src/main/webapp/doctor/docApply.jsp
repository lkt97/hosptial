<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假--在线预约挂号系统</title>
    <style>
        body{
            background-image: url("images/1.jpg");
            background-size: 100%;
            text-align: center;
        }
        .form-box{
            margin: 0 auto;
            width: 550px;
            color: #fff;
        }
        .form-box a{
            color: #de615e;
            text-decoration: none;
        }
        .form-top {
            overflow: hidden;
            padding: 0 25px 15px 25px;
            background: #444;
            background: rgba(0, 0, 0, 0.35);
            -moz-border-radius: 4px 4px 0 0;
            -webkit-border-radius: 4px 4px 0 0;
            border-radius: 4px 4px 0 0;
            text-align: left;
        }
        .form-bottom {
            padding: 25px 25px 30px 25px;
            background: #444;
            background: rgba(0, 0, 0, 0.3);
            -moz-border-radius: 0 0 4px 4px;
            -webkit-border-radius: 0 0 4px 4px;
            border-radius: 0 0 4px 4px;
            text-align: left;
        }
        .form-top-left {
            float: left;
            width: 75%;
            padding-top: 25px;
        }
        .form-top-left h3 {
            margin-top: 0;
            color: #969696;
        }
        .form-top-left p {
            opacity: 0.8;
            color: #fff;
        }

        .text-danger {
            color: #b94a48;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .col-xs-12 {
            width: 100%;
            float: left;
            position: relative;
            min-height: 1px;
            padding-left: 15px;
            padding-right: 15px;
        }
        .sr-only {
            position: absolute;
            width: 1px;
            height: 1px;
            margin: -1px;
            padding: 0;
            overflow: hidden;
            clip: rect(0, 0, 0, 0);
            border: 0;
        }
        input[type="text"], input[type="password"], textarea, textarea.form-control {
            display: block;
            width: 90%;
            height: 50px;
            margin: 0;
            padding: 0 20px;
            vertical-align: middle;
            background: #fff;
            border: 1px solid #cccccc;
            font-family: 'Roboto', sans-serif;
            font-size: 16px;
            font-weight: 300;
            line-height: 50px;
            color: #888;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            -moz-box-shadow: none;
            -webkit-box-shadow: none;
            box-shadow: none;
            -o-transition: all .3s;
            -moz-transition: all .3s;
            -webkit-transition: all .3s;
            transition: all .3s;
        }
        .btn {
            width: 90%;
            display: inline-block;
            height: 50px;
            margin: 0;
            padding: 0 20px;
            vertical-align: middle;
            background: #de615e;
            border: 0;
            font-family: 'Roboto', sans-serif;
            font-size: 16px;
            font-weight: 300;
            line-height: 50px;
            color: #fff;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            border-radius: 4px;
            text-shadow: none;
            -moz-box-shadow: none;
            -webkit-box-shadow: none;
            box-shadow: none;
            -o-transition: all .3s;
            -moz-transition: all .3s;
            -webkit-transition: all .3s;
            transition: all .3s;
        }
        .pull-right{
            float: right;
        }
    </style>
</head>
<body>
<div class="form-box">
    <div class="form-top">
        <div class="form-top-left">
            <h3 style="color: #969696;">请假信息</h3>
            <p>请输入医生请假</p>
        </div>
        <div class="pull-right-bottom">
            <p class="text-danger"
               id="errorTip"></p>
        </div>
        <div class="form-bottom">
            <form role="form" action="/Docapply.do" method="post" class="login-form">

                <div class="form-group col-xs-12">
                    <label class="sr-only" for="userName">name</label>请假时间（格式mmdd）:<input
                        style="font-weight: bold" type="text" name="name"
                        id="userName" class="form-username form-control" required />
                </div>
                <div class="form-group col-xs-12">
                    <label class="sr-only" for="userEmail"></label>请假天数:<input
                        style="font-weight: bold" type="text" name="account"
                        class="form-control input-control clearfix"
                        required onkeyup="isCheckEmail()" /><span id="accountTip"></span>
                </div>
                <div class="form-group col-xs-12">
                    <label class="sr-only" for="userEmail"></label>请假理由:<input
                        style="font-weight: bold" type="text" name="phone"
                        id="userEmail" class="form-control input-control clearfix"
                        required onkeyup="isCheckEmail()" /><span id="emailTip"></span>
                </div>
                <div class="form-group col-xs-12">
                    <label class="sr-only" for="userEmail"></label>调班医生id:<input
                        style="font-weight: bold" type="text" name="tbdoc"
                        id="userEdoc" class="form-control input-control clearfix"
                        required onkeyup="isCheckEmail()" /><span id="docTip"></span>
                </div>

                <div class="form-group col-xs-12">
                    <button type="submit" class="btn" id="btn">提交</button>
                </div>
            </form>
        </div>
    </div>
    <script>

    </script>
</div>
</body>
</html>
