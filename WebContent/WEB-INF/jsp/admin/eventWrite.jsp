<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>

<html>
<div align="center">
<head>
<title>�� �� Ʈ �� ��</title>
</head>
<body>
 <form name="f" action="eventWriteOk.chi" method="post"
												enctype="multipart/form-data">
 <table border="1">
  <tr>
   <td>Ÿ��</td>
   <td>
   <select name="etype">
     <option value="ing">�������̺�Ʈ</option>
     <option value="end">�����̺�Ʈ</option>
     <option value="win">��÷�ڹ�ǥ</option>
   </select>
   </td>
  </tr>
  <tr>
   <td>�̺�Ʈ����</td>
   <td><input type="text" name="ename"></td>
  </tr>
  <tr>
   <td>�̺�Ʈ�̹���</td>
   <td>
    <input type="file" name="eimage">
   </td>
  </tr>
  <tr>
   <td>������</td>
   <td><input type="text" name="estart"></td>
  </tr>
  <tr>
   <td>������</td>
   <td><input type="text" name="eend"></td>
  </tr>
  <tr>
   <td colspan="2" align="center"><input type="submit" name="event" value="���">
   <input type="reset" value="�ٽ��ۼ�">
   <input type="button" value="���" onclick="document.location.href='eventList.chi'"></td>
  </tr>
  
  
 </table>
</form>
</body>
</div>
</html>
<%@ include file="bottom.jsp" %>