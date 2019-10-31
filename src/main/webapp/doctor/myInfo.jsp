<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.gm.hosptial.pojo.*" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<table>
        <tr>
            <td>医生姓名：</td>
            <td>${doctor.doctorname}</td>
        </tr>
        <tr>
            <td>医生id：</td>
            <td>${doctor.doctorid}</td>
        </tr>
        <tr>
            <td>医生科室：</td>
            <td>${doctor.doctordeptid}</td>
        </tr>
        <tr>
            <td>医生电话：</td>
            <td>${doctor.doctorphone}</td>
        </tr>
        <tr>
            <td>医生职称：</td>
            <td>${doctor.doctorjobtitle}</td>
        </tr>
        <tr>
            <td>医生领域：</td>
            <td>${doctor.doctorspecialty}</td>
        </tr>
</table>
</body>
</html>
