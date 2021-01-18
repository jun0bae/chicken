<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<%@ include file="top.jsp" %>
<script type="text/javascript">
	function checkDel(pnum,pimage){
		var isDel = window.confirm("������ �����Ͻðڽ��ϱ�?")
		if (isDel){
			location.href="prodDelete.chi?pnum="+encodeURI(pnum)+"&pimage="+encodeURI(pimage)	
					
		}
	}
</script>
<div align="center">
<table class="outline" width="100%">
<caption>�� �� �� ��</caption>
 <tr bgcolor="yellow">
  <th>��ǰ�̹���</th>
  <th>ī�װ�</th>
  <th>��ǰ��</th>
  <th>����</th>
  <th>�����</th>
  <th>����|����</th>
</tr>
<c:if test="${prodlist==null}">
 <tr>
  <td colspan="8">��ϵ� ��ǰ�� �����ϴ�.</td>
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
				<a href="prodEdit.chi?num=${dto.pnum}">����</a> | 
				<a href="javascript:checkDel('${dto.pnum}','${dto.pimage}')">����</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="bottom.jsp"%>	