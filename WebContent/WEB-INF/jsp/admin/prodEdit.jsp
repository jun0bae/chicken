<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<form name="f" action="prodEditOk.chi" method="post"
												enctype="multipart/form-data">
<input type="hidden" name="pnum" value="${getProd.pnum}" />
<input type="hidden" name="pimage2" value="${getProd.pimage}" />													
<table width="100%" border="1">
 <tr>
  <td width="10%">카테고리</td>
  <td>
	<select name="pcate">
	    <option value="${getProd.pcate}" selected>${getProd.pcate}</option>
	    <c:forEach var="dto" items="${cateList}">
		<option value="${dto.cname}">
		${dto.cname}	
	    </option>
</c:forEach>						
	</select>
  </td>
 </tr>
 <tr>
  <td width="10%">제품명</td>
  <td><input type="text" name="pname" value="${getProd.pname}"></td>
 </tr>
 <tr>
  <td width="10%">제품이미지</td>
  <td><input type="file" name="pimage"></td>
 </tr>
 <tr>
  <td width="10%">가격</td>
  <td><input type="text" name="price" value="${getProd.price}"></td>
 </tr>
 <tr>
  <td width="10%">출시일</td>
  <td><input type="text" name="launch_date" value="${getProd.launch_date}"></td>
 </tr>
 <tr>
  <td width="10%">코멘트</td>
  <td><input type="text" name="coment" value="${getProd.coment}"></td>
 </tr>
 <tr>
  <td colspan="2" align="right">
   <input type="submit" name="product" value="수정">
   <button type="button"onclick="document.location.href='admin.chi'">취소</button>
  </td>
 </tr>
</table>
</form>
<%@ include file="bottom.jsp"%>	