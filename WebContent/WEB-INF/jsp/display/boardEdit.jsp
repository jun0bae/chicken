<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="top.jsp" %>
<html>
<head>
<title>�ۼ���</title>
<link rel="stylesheet" type="text/css" href="../style.css">
<script type="text/javascript">
	function check(){
		if (f.writer.value==""){
			alert("�̸��� �Է��� �ּ���!!")
			f.writer.focus()
			return false
		}
		if (f.subject.value==""){
			alert("������ �Է��� �ּ���!!")
			f.subject.focus()
			return false
		}
		if (f.content.value==""){
			alert("������ �Է��� �ּ���!!")
			f.content.focus()
			return false
		}
		if (f.passwd.value==""){
			alert("��й�ȣ�� �Է��� �ּ���!!")
			f.passwd.focus()
			return false
		}
		return true
	}
</script>
</head>
<body>
<div align="center">
	<form name="f" action="boardEditOk.dis" method="post"
													onsubmit="return check()">
		<b>�� �� ��</b>
		<input type="hidden" name="num" value="${getBoard.num}" />													
		<table border="1" width="500">
			<tr>
				<th width="20%" bgcolor="yellow">�̸�</th>
				<td><input type="text" name="writer" class="box" value="${getBoard.writer}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">����</th>
				<td><input type="text" name="subject" class="box" size="45" value="${getBoard.subject}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">Email</th>
				<td><input type="text" name="email" class="box" size="45" value="${getBoard.email}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">����</th>
				<td><textarea name="content" rows="11" cols="45" class="box">${getBoard.content}</textarea></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">��й�ȣ</th>
				<td><input type="text" name="passwd" class="box"></td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan="2" align="center">
					<input type="submit" value="�ۼ���">
					<input type="reset" value="�ٽþ���">
					<input type="button" value="��Ϻ���" onclick="window.location='boardList.dis'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<%@ include file="bottom.jsp"%>	