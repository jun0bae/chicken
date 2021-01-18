<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<form name="f" action="prodAddOk.chi" method="post"
												enctype="multipart/form-data">
<table width="100%" border="1">
 <tr>
  <td width="10%">ī�װ�</td>
  <td>
	<select name="pcate">
	    <option value="none" selected>ī�װ�����</option>
	    <c:forEach var="dto" items="${cateList}">
		<option value="${dto.cname}">
		${dto.cname}	
	    </option>
</c:forEach>						
	</select>
  </td>
 </tr>
 <tr>
  <td width="10%">��ǰ��</td>
  <td><input type="text" name="pname"></td>
 </tr>
 <tr>
  <td width="10%">��ǰ�̹���</td>
  <td><input type="file" name="pimage"></td>
 </tr>
 <tr>
  <td width="10%">����</td>
  <td><input type="text" name="price"></td>
 </tr>
 <tr>
  <td width="10%">�����</td>
  <td><input type="text" name="launch_date"></td>
 </tr>
 <tr>
  <td width="10%">�ڸ�Ʈ</td>
  <td><input type="text" name="coment"></td>
 </tr>
 <tr>
  <td colspan="2" align="right">
   <input type="submit" name="product" value="���">
   <button type="button"onclick="document.location.href='admin.chi'">���</button>
  </td>
 </tr>
</table>
</form>
<%@ include file="bottom.jsp"%>	