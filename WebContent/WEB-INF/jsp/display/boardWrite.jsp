<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="top.jsp" %>
<html>
<head>
<title>�Խñ۾���</title>
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
	<form name="f" action="boardWriteOk.dis" method="post"
													onsubmit="return check()">
		<input type="hidden" name="num" value="${param.num}" />		
		<input type="hidden" name="re_step" value="${param.re_step}" />	
		<input type="hidden" name="re_level" value="${param.re_level}" />												
		<table border="1" width="500">
			<tr>
				<td align="center" colspan="2">�� �� ��</td>
			</tr>
			<tr>
				<th width="20%">�̸�</th>
				<td><input type="text" name="writer" class="box"></td>
			</tr>
			<tr>
				<th width="20%">����</th>
				<td><input type="text" name="subject" class="box" size="45"></td>
			</tr>
			<tr>
				<th width="20%">Email</th>
				<td><input type="text" name="email" class="box" size="45"></td>
			</tr>
			<tr>
				<th width="20%">����</th>
				<td><textarea name="content" rows="11" cols="45" class="box"></textarea></td>
			</tr>
			<tr>
				<th width="20%">��й�ȣ</th>
				<td><input type="text" name="passwd" class="box"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="�۾���">
					<input type="reset" value="�ٽþ���">
					<input type="button" value="��Ϻ���" onclick="window.location='boardList.dis'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<%@ include file="bottom.jsp" %>