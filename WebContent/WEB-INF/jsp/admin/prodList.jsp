<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<script type="text/javascript">
	function checkDel(pnum,pimage){
		var isDel = window.confirm("정말로 삭제하시겠습니까?")
		if (isDel){
			location.href="prodDelete.chi?pnum="+encodeURI(pnum)+"&pimage="+encodeURI(pimage)	
					
		}
	}
</script>
<div align="center">
<table class="outline" width="100%">
<caption>메 뉴 목 록</caption>
 <tr bgcolor="yellow">
  <th>제품이미지</th>
  <th>카테고리</th>
  <th>상품명</th>
  <th>가격</th>
  <th>출시일</th>
  <th>수정|삭제</th>
</tr>
<c:if test="${prodlist==null}">
 <tr>
  <td colspan="8">등록된 상품이 없습니다.</td>
 </tr>
 </c:if>
        <c:forEach var="dto" items="${prodlist}">
		<tr>
		    <td>
					<img src="${upPath}/${dto.pimage}" width="100" height="70">
			</td>
			<td>${dto.pcate}</td>
			<td>${dto.pname}</td>
			<td><fmt:formatNumber value="${dto.price}" type="currency"/></td>
			<td>${dto.launch_date}</td>
			<td>
				<a href="prodEdit.chi?num=${dto.pnum}">수정</a> | 
				<a href="javascript:checkDel('${dto.pnum}','${dto.pimage}')">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="bottom.jsp"%>	