<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>
<script type="text/javascript">
	function encode(cname){
			location.href="prodList.dis?cname="+encodeURI(cname)			
	}
</script>
<h3 align="center"> ${param.cname} 목 록</h3>
<table align="left" width="100%">
<tr>
<td width="15%">
 <li><a href="prodList.dis">전체</a></li>
<c:forEach var="cdto" items="${cateList}">
 <li><a href="javascript:encode('${cdto.cname}')">${cdto.cname}</a></li>
</c:forEach>
</td>
<td>
<%int count=0; %>
 	<c:if test="${prodList==null}">
	<h3>등록된 메뉴가 없습니다</h3>
	</c:if>
	<table width="100%" align="center">
	<tr>
	<c:forEach var="pdto" items="${prodList}">
	<%count++;%>
			
				
				<td align="center">
				
				<a href="prodView.dis?pnum=${pdto.pnum}">
					<img src="${upPath}/${pdto.pimage}" width="150" height="150">
				</a><br>
				<c:out value="${pdto.pname}"/>
				</td>
				<%if(count%3==0){ %>
				</tr><tr>
                <%}%>
                	
            
     </c:forEach>
     </tr>
     </table>
    
	
</td>
</tr>
</table>

<%@ include file="bottom.jsp"%>	