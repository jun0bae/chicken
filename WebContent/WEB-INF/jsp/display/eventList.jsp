<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="my.chicken.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>
<script type="text/javascript">
	function encode(cname){
			location.href="eventList.dis?cname="+encodeURI(cname)			
	}
</script>
<h3 align="center"> 이 벤 트 목 록</h3>
<table align="center" width="100%">
 <tr>
  <th width="33%"><a href="eventList.dis?event=ing">진행중인 이벤트</a></th>
  <th width="33%"><a href="eventList.dis?event=end">지난 이벤트</a></th>
  <th width="33%"><a href="eventList.dis?event=win">당첨자 발표</a></th>
 </tr>
</table><br>

<%int count=0; %>
 	<c:if test="${eventList==null}">
	<h3>등록된 이벤트가 없습니다</h3>
	</c:if>
	<table width="100%" align="center">
	<tr>
	<c:forEach var="dto" items="${eventList}">
	<%count++;%>
			
				
				<td align="center">
				
				<a href="eventView.dis?num='${dto.num}'">
					<img src="${upPath}/${dto.eimage}" width="150" height="150">
				</a><br>
				<c:out value="${dto.ename}"/><br>
				<c:out value="${dto.estart}~${dto.eend}"/>
				</td>
				<%if(count%4==0){ %>
				</tr><tr>
                <%}%>
                	
            
     </c:forEach>
     </tr>
     </table>
    
	




<%@ include file="bottom.jsp"%>	