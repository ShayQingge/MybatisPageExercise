<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${PageInfo.list }" var="pi">
			<tr>
				<td>${pi.id }</td>
				<td>${pi.name }</td>
				<td>${pi.age }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="page?curNum=${PageInfo.curNum-1 }&pageSize=${PageInfo.pageSize }" <c:if test="${PageInfo.curNum<=1 }"> onclick="javascript:return false;" </c:if> >上一页</a>
	<a href="page?curNum=${PageInfo.curNum+1 }&pageSize=${PageInfo.pageSize }" <c:if test="${PageInfo.curNum>=PageInfo.totalPage }"> onclick="javascript:return false;" </c:if> >下一页</a>
</body>
</html>