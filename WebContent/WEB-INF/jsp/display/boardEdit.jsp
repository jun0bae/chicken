<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="top.jsp" %>
<html>
<head>
<title>글수정</title>
<link rel="stylesheet" type="text/css" href="../style.css">
<script type="text/javascript">
	function check(){
		if (f.writer.value==""){
			alert("이름을 입력해 주세요!!")
			f.writer.focus()
			return false
		}
		if (f.subject.value==""){
			alert("제목을 입력해 주세요!!")
			f.subject.focus()
			return false
		}
		if (f.content.value==""){
			alert("내용을 입력해 주세요!!")
			f.content.focus()
			return false
		}
		if (f.passwd.value==""){
			alert("비밀번호를 입력해 주세요!!")
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
		<b>글 수 정</b>
		<input type="hidden" name="num" value="${getBoard.num}" />													
		<table border="1" width="500">
			<tr>
				<th width="20%" bgcolor="yellow">이름</th>
				<td><input type="text" name="writer" class="box" value="${getBoard.writer}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">제목</th>
				<td><input type="text" name="subject" class="box" size="45" value="${getBoard.subject}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">Email</th>
				<td><input type="text" name="email" class="box" size="45" value="${getBoard.email}"></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">내용</th>
				<td><textarea name="content" rows="11" cols="45" class="box">${getBoard.content}</textarea></td>
			</tr>
			<tr>
				<th width="20%" bgcolor="yellow">비밀번호</th>
				<td><input type="text" name="passwd" class="box"></td>
			</tr>
			<tr bgcolor="yellow">
				<td colspan="2" align="center">
					<input type="submit" value="글수정">
					<input type="reset" value="다시쓰기">
					<input type="button" value="목록보기" onclick="window.location='boardList.dis'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
<%@ include file="bottom.jsp"%>	