<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>
<h3 align="center">이 벤 트 관 리</h3>
<div align="center">
<table width="800">
 <tr>
  <td align="right">
   <a href="eventWrite.chi">이벤트등록</a>
  </td>
 </tr>
</table>

<table border="1" width="800">
 <tr>
  <td width="35%">제목</td>
  <td width="15%">이미지</td>
  <td>시작일</td>
  <td>종료일</td>
  <td>조회수</td>
  <td>수정|삭제</td>
 </tr>
 <c:if test="${eventList==null}">
 <tr>
  <td colspan="6">등록된 이벤트가 없습니다</td> 
 </tr>
 </c:if>
 <c:forEach var="dto" items="${eventList}">
 <tr>
 <td>${dto.etype}</td>
 <td><a href="eventView.chi">${dto.ename}</a></td>
 <td>${dto.eiamge}</td>
 <td>${dto.estart}~${dto.eend}</td>
 <td>${dto.readcount}</td>
 <td>
 <a href="eventEdit.chi">수정</a>|
 <a href="eventDelete.chi">삭제</a> 
 </td>
 </tr>
 </c:forEach>
 
 
</table>
</div>
<%@ include file="bottom.jsp"%>	