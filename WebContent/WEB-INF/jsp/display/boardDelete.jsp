<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>�ۻ���</title>
</head>

<body>	
<div align="center">
	<b>�ۻ���</b>
	<form name="f" action="boardDeleteOk.dis" method="post">
		<input type="hidden" name="num" value="${param.num}"/>
		<table border="1" width="300">
			<tr bgcolor="yellow">
				<th>��й�ȣ�� �Է��� �ּ���</th>			
			</tr>
			<tr>
				<td align="center">��й�ȣ : 
					<input type="password" name="passwd" class="box">
				</td>
			</tr>
			<tr bgcolor="yellow">
				<td align="center">
					<input type="submit" value="�ۻ���">
					<input type="button" value="�۸��" onclick="window.location='boardList.dis'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>