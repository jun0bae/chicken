<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="top.jsp" %>
<h3 align="center">�� �� Ʈ �� ��</h3>
<div align="center">
<table width="800">
 <tr>
  <td align="right">
   <a href="eventWrite.chi">�̺�Ʈ���</a>
  </td>
 </tr>
</table>

<table border="1" width="800">
 <tr>
  <td width="35%">����</td>
  <td width="15%">�̹���</td>
  <td>������</td>
  <td>������</td>
  <td>��ȸ��</td>
  <td>����|����</td>
 </tr>
 <c:if test="${eventList==null}">
 <tr>
  <td colspan="6">��ϵ� �̺�Ʈ�� �����ϴ�</td> 
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
 <a href="eventEdit.chi">����</a>|
 <a href="eventDelete.chi">����</a> 
 </td>
 </tr>
 </c:forEach>
 
 
</table>
</div>
<%@ include file="bottom.jsp"%>	