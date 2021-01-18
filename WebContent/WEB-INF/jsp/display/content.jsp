<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*"%>
<!-- content.jsp -->
<%@ include file="top.jsp"%>
<html>
<head>
	<title>글내용</title>
</head>
<body>
<div align="center">
	<b>글내용 보기</b>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow" width="20%">글번호</th>
			<td width="30%" align="center">${getBoard.num}</td>
			<th bgcolor="yellow" width="20%">조회수</th>
			<td width="30%" align="center">${getBoard.readcount}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">작성자</th>
			<td width="30%" align="center">${getBoard.writer}</td>
			<th bgcolor="yellow" width="20%">작성일</th>
			<td width="30%" align="center">${getBoard.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">글제목</th>
			<td width="80%" align="center" colspan="3">${getBoard.subject}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">글내용</th>
			<td width="80%" align="center" colspan="3">${getBoard.content}</td>
		</tr>
		<tr>
			<td width="80%" align="right" colspan="4">
				<input type="button" value="답글쓰기" 
				onclick="window.location='boardWrite.dis?num=${getBoard.num}&re_step=${getBoard.re_step}&re_level=${getBoard.re_level}'">
				<input type="button" value="글수정" onclick="window.location='boardEdit.dis?num=${getBoard.num}'">
				<input type="button" value="글삭제" onclick="window.location='boardDelete.dis?num=${getBoard.num}'">
				<input type="button" value="글목록" onclick="window.location='boardList.dis'">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
<%@ include file="bottom.jsp"%>










