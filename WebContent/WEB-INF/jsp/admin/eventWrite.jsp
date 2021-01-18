<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>

<html>
<div align="center">
<head>
<title>이 벤 트 작 성</title>
</head>
<body>
 <form name="f" action="eventWriteOk.chi" method="post"
												enctype="multipart/form-data">
 <table border="1">
  <tr>
   <td>타입</td>
   <td>
   <select name="etype">
     <option value="ing">진행중이벤트</option>
     <option value="end">지난이벤트</option>
     <option value="win">당첨자발표</option>
   </select>
   </td>
  </tr>
  <tr>
   <td>이벤트제목</td>
   <td><input type="text" name="ename"></td>
  </tr>
  <tr>
   <td>이벤트이미지</td>
   <td>
    <input type="file" name="eimage">
   </td>
  </tr>
  <tr>
   <td>시작일</td>
   <td><input type="text" name="estart"></td>
  </tr>
  <tr>
   <td>종료일</td>
   <td><input type="text" name="eend"></td>
  </tr>
  <tr>
   <td colspan="2" align="center"><input type="submit" name="event" value="등록">
   <input type="reset" value="다시작성">
   <input type="button" value="목록" onclick="document.location.href='eventList.chi'"></td>
  </tr>
  
  
 </table>
</form>
</body>
</div>
</html>
<%@ include file="bottom.jsp" %>