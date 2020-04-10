<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
   td,th{
   }
   table{
    width:600px;
    text-align: center;
    
   }
</style>
</head>
<body>
   <table cellpadding="0" cellspacing="1">
     <tr>
       <th>编号</th>
       <th>姓名</th>
       <th>生日</th>
       <th>性别</th>
       <th>地址</th>
     </tr>
      <c:forEach items="${list}" var="user">
         <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/></td>
          <td>${user.sex}</td>
          <td>${user.address}</td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>