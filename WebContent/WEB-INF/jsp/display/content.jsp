<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*"%>
<!-- content.jsp -->
<%@ include file="top.jsp"%>
<html>
<head>
	<title>�۳���</title>
</head>
<body>
<div align="center">
	<b>�۳��� ����</b>
	<table border="1" width="600">
		<tr>
			<th bgcolor="yellow" width="20%">�۹�ȣ</th>
			<td width="30%" align="center">${getBoard.num}</td>
			<th bgcolor="yellow" width="20%">��ȸ��</th>
			<td width="30%" align="center">${getBoard.readcount}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�ۼ���</th>
			<td width="30%" align="center">${getBoard.writer}</td>
			<th bgcolor="yellow" width="20%">�ۼ���</th>
			<td width="30%" align="center">${getBoard.reg_date}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">������</th>
			<td width="80%" align="center" colspan="3">${getBoard.subject}</td>
		</tr>
		<tr>
			<th bgcolor="yellow" width="20%">�۳���</th>
			<td width="80%" align="center" colspan="3">${getBoard.content}</td>
		</tr>
		<tr>
			<td width="80%" align="right" colspan="4">
				<input type="button" value="��۾���" 
				onclick="window.location='boardWrite.dis?num=${getBoard.num}&re_step=${getBoard.re_step}&re_level=${getBoard.re_level}'">
				<input type="button" value="�ۼ���" onclick="window.location='boardEdit.dis?num=${getBoard.num}'">
				<input type="button" value="�ۻ���" onclick="window.location='boardDelete.dis?num=${getBoard.num}'">
				<input type="button" value="�۸��" onclick="window.location='boardList.dis'">
			</td>
		</tr>
	</table>
</div>
</body>
</html>
<%@ include file="bottom.jsp"%>










