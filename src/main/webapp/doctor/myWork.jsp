<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>

<div style="margin-top: 100px">
    <div wid="page-inner">
        <div class="container">
            <div class="h3 alert-info info">我的信息</div>
            <div class="row">
            <div class="ysjs ">
                <div class="title">
                    <div class="t">
                        <span>${doctor.doctorname}</span>
                        <span class="gender">${doctor.doctordeptid}</span>
                        <span class="career">${doctor.doctorjobtitle}</span>
                        <span class="career">${doctor.doctorstatus==1?"正常":"请假"}</span>
                    </div>
                    <%--<img src="${doctor.picpath}">--%>
                </div>
                <div class="content">
                    <div >
                        <div>介绍：</div>
                        <div>${doctor.doctorspecialty}</div>
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
            <div class="h3 alert-info info">我的排班</div>
            <%--显示医生排班--%>
            <div class="schedule">
                <div class="week">
                    <div class="ysjj1">
                    </div>
                    <div class="title2">
                        <table width="800" align="center" border="1"><tr><td></td>
                            <td align="center">星期日</td>
                            <td align="center">星期一</td>
                            <td align="center">星期二</td>
                            <td align="center">星期三</td>
                            <td align="center">星期四</td>
                            <td align="center">星期五</td>
                            <td align="center">星期六</td>
                        </tr>
                            <tr align="center">
                                <td height="90">上午</td>
                                <td  align="center"><a>${doctorsch.sunam==0?"无":doctorsch.sunam}</a></td>
                                <td  align="center"><a>${doctorsch.monam==0?"无":doctorsch.monam}</a></td>
                                <td  align="center"><a>${doctorsch.tueam==0?"无":doctorsch.tueam}</a></td>
                                <td  align="center"><a>${doctorsch.wedam==0?"无":doctorsch.wedam}</a></td>
                                <td  align="center"><a>${doctorsch.thuram==0?"无":doctorsch.thuram}</a></td>
                                <td  align="center"><a>${doctorsch.friam==0?"无":doctorsch.friam}</a></td>
                                <td  align="center"><a>${doctorsch.satam==0?"无":doctorsch.satam}</a></td>
                            </tr>
                            <tr align="center">
                                <td height="90">下午</td>
                                <td  align="center"><a>${doctorsch.sunpm==0?"无":doctorsch.sunpm}</a></td>
                                <td  align="center"><a>${doctorsch.monpm==0?"无":doctorsch.monpm}</a></td>
                                <td  align="center"><a>${doctorsch.tuepm==0?"无":doctorsch.tuepm}</a></td>
                                <td  align="center"><a>${doctorsch.wedpm==0?"无":doctorsch.wedpm}</a></td>
                                <td  align="center"><a>${doctorsch.thurpm==0?"无":doctorsch.thurpm}</a></td>
                                <td  align="center"><a>${doctorsch.fripm==0?"无":doctorsch.fripm}</a></td>
                                <td  align="center"><a>${doctorsch.satpm==0?"无":doctorsch.satpm}</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <style>
                    .schedule{
                        text-align: center;
                        width: 800px;
                        border: 1px #0065AF solid;
                    }
                    .schedule:after{
                        content:"";
                        clear: both;
                        display: block;
                    }
                    .schedule .week {
                        float: left;
                        height: 250px;
                        width: 100%;
                    }
                    .schedule .week .title1{
                        font-size: 20px;
                    }
                    .schedule .week .title2{
                        width: 70%;
                    }
                    .schedule .week:after{
                        content: '';
                        clear: both;
                        display: block;
                    }
                    .ysjj{
                        width: 100%;
                        float: left;
                    }
                    .ysjj img{
                        width: 30%;
                        float: left;
                    }
                    .ysjj .title{
                        float: left;
                        width: 50%;
                        overflow: hidden;
                    }
                    .ysjj .title span{
                        float: left;
                        margin: 10px;
                    }
                    .ysjj .title .name{
                        font-size: 20px;
                    }
                    .ysjj .title .career{
                        font-size: 17px;
                    }
                    .ysjj .title .gender{
                        font-size: 15px;
                    }
                    .ysjj .title div:after{
                        content: '';
                        clear: both;
                        display: block;
                    }
                    .ysjj .title p{
                        height: 90px;
                        width: 113%;
                        overflow-y: scroll;
                    }
                    .ysjj .work{
                        float: left;
                        width: 20%;
                    }
                    .ysjj .work div{
                        width: 100%;
                        height: 100px;
                        line-height: 100px;
                        text-align: center;
                    }
                    .schedule .week .title2{
                        float: left;
                        height: 100%;
                    }
                    .schedule .week .title2 ul{
                        float: left;
                        height: 100%;
                        width: 14.27%;
                    }
                    .schedule .week .title2 ul li{
                        list-style: none;
                        background-color: #eeeeee;
                        height: 40%;
                        border-left: #0065AF 1px solid;
                    }
                    .schedule .week .title2 ul li:nth-of-type(even){
                        background: rgb(250, 250, 250);
                    }
                    .schedule .week .title2 .date{
                        height: 20%;
                        line-height: 3;
                    }
                    .schedule .week .title2 .预约{
                        background: rgb(219, 255, 211)!important;
                        color: rgb(61, 175, 167);
                        cursor: pointer;
                    }
                    .schedule .week .title2 .预约:hover{
                        color: rgb(255, 255, 255);
                        background: rgb(61, 175, 167)!important;
                    }
                    .schedule .week .title2 .停诊{
                        background: rgb(208, 222, 251)!important;
                        color: rgb(20, 82, 205)!important;
                    }

                    .schedule .week ul:after{
                        content: '';
                        clear: both;
                        display: block;
                    }

                    .work1{
                        width: 70%;
                        float: left;
                    }
                    .work1 ul li{
                        float: left;
                        list-style: none;
                        width: 12.303%;
                        height: 100px;
                        line-height: 100px;
                        text-align: center;
                        border: 1px dashed rgb(219, 219, 219);
                    }
                    .work1 ul li:nth-of-type(odd){
                        background: rgb(250, 250, 250);
                    }
                    .work1 ul .预约{
                        background: rgb(219, 255, 211)!important;
                        color: rgb(61, 175, 167);
                        cursor: pointer;
                    }
                    .work1 ul .预约:hover{
                        color: rgb(255, 255, 255);
                        background: rgb(61, 175, 167)!important;
                    }
                    .work1 ul .停诊{
                        background: rgb(208, 222, 251)!important;
                        color: rgb(20, 82, 205)!important;
                    }
                </style>

                <%--<script>--%>
                    <%--$(function () {--%>
                        <%--$('#myModal').on('show.bs.modal', function (event) {--%>
                            <%--var  a=$(event.relatedTarget);--%>
                            <%--var wid =a .data('wid');--%>
                            <%--console.log(wid);--%>
                            <%--$("#wid").val(wid);--%>
                        <%--});--%>
                    <%--})--%>
                <%--</script>--%>
            </div>

            <%--显示预约的号源信息--%>
            <div class="haoyuan">
                <ul>
                </ul>
                <style>
                    .haoyuan{
                        margin: 20px auto;
                        background-color: #eeeeee;
                    }
                    .haoyuan:after{
                        display: block;
                        content: '';
                        clear: both;
                    }
                    .haoyuan ul{
                        list-style: none;
                    }
                    .haoyuan ul li{
                        float: left;
                        margin:10px 20px;
                    }
                    .haoyuan ul .已被预约{
                        color: #999;
                    }
                    .haoyuan ul .可预约{
                        color: #0065AF;
                        cursor: pointer;
                    }
                    .haoyuan ul .可预约:hover{
                        background-color: #00E8D7;
                    }
                </style>
            </div>
        </div>
    </div>
</div>

</body>
</html>
