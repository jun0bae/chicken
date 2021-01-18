<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*, java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>

<c:if test="${count==null}">
<c:set var="count" value="0"/>
<c:set var="startNum" value="1"/>
</c:if>
<html>
<head>
	<title>�Խñ�</title>
</head>
<body>
<div align="center">
	<b>�� �� ��</b>
	<table border="0" width="100%">
		<tr>
			<td align="right"><a href="boardWrite.dis">�۾���</a></td>
		</tr>
	</table>
	<table border="1" width="100%">
		<tr>
			<th>��ȣ</th>
			<th width="30%">�� ��</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ</th>
		</tr>
		<c:if test="${listBoard == null}">
		<tr>
			<td colspan="6">��ϵ� �Խñ��� �����ϴ�.</td>
		</tr>
		</c:if>
<c:forEach var="dto" items="${listBoard}">
		<tr>
			<td align="center">${startNum}</td>
			<c:set var="startNum" value="${startNum-1}"/>
			<td>
			<c:if test="${dto.re_level>0}">
				<img src="img/level.gif" width="${dto.re_level*10}" height="15"/>
				<img src="img/re.gif">
</c:if>	
				<a href="boardContent.dis?num=${dto.num}">
					${dto.subject}
				</a>	
<c:if test="${dto.readcount>10}">
				<img src="img/hot.gif">
</c:if>
			</td>
			<td align="center">${dto.writer}</td>
			<td align="center">${dto.reg_date}</td>
			<td align="center">${dto.readcount}</td>
		</tr>
</c:forEach>	
	
	</table>
	<br>
<c:if test="${count>0}">
            <c:if test="${startPage > pageBlock}">
			[<a href="boardList.dis?pageNum=${startPage-pageBlock}">����</a>]
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}">
			[<a href="boardList.dis?pageNum=${i}">${i}</a>]
</c:forEach>

<c:if test="${endPage<PageCount}">
			[<a href="boardList.dis?pageNum=${startPage+pageBlock}">����</a>]
</c:if>
</c:if>
</div>
</body>
</html>
<%@ include file="bottom.jsp"%>			
