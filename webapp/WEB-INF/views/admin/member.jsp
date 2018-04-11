<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js">
</script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/admin/member/member.js">
</script>
<style type="text/css">

#member-table .member-delete:hover{
	cursor: pointer;
}
</style>

</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<input type="hidden" name="no" value="${authUser.no}">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<form name="form1" method="get" action="${pageContext.servletContext.contextPath}/admin/member">
	<input type="hidden" name="nowPage" value="${pb.nowPage }">
	<tr height="40">
		<td width="200" valign="bottom">&nbsp 회원수 : <font id="member-totalCount" color="#FF0000">${pb.totalCount }</font></td>
		<td width="200">&nbsp</td>
		<td width="350" align="right" valign="bottom">
			<select name="option" class="combo1">
				<option value="name" >이름</option>
				<option value="id" >아이디</option>
			</select>
			<input type="text" name="keyword" size="15" value="">&nbsp
		</td>
		<td width="50" valign="bottom">
			<input type="submit" value="검색">&nbsp
		</td>
	</tr>
	<tr><td height="5" colspan="4"></td></tr>
	</form>
</table>
<table id="member-table" width="800" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
		
		<tr bgcolor="#CCCCCC" height="23"> 
			<td width="100" align="center">ID</td>
			<td width="100" align="center">이름</td>
			<td width="100" align="center">전화</td>
			<td width="100" align="center">핸드폰</td>
			<td width="200" align="center">E-Mail</td>
			<td width="100" align="center">회원구분</td>
			<td width="100" align="center">수정/삭제</td>
		</tr>		
	<c:forEach items="${memberList}" var="l">
		<tr bgcolor="#F2F2F2" height="23">	
			<td width="100">&nbsp ${l.id }</td>	
			<td width="100">&nbsp ${l.name }</td>	
			<td width="100">&nbsp ${l.tel }</td>	
			<td width="100">&nbsp ${l.phone }</td>	
			<td width="200">&nbsp ${l.email }</td>	
			<td width="100" align="center">${l.auth }</td>	
			<td width="100" align="center">
				<a href="#">수정</a>/
				<label class="member-delete" data-no='${l.no }' >삭제</label>
			</td>
		</tr>		
	</c:forEach>
	
</table>
<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
		
			<c:if test="${pb.previousPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/member?nowPage=${pb.startPage-1}&option=${pb.option}&keyword=${pb.keyword}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
			 
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
				<c:choose>
					<c:when test="${pb.nowPage eq i }">
						<font color="#FC0504"><b>${i }</b></font>&nbsp;
					</c:when>
					<c:when test="${pb.nowPage ne i }">
						<a href="${pageContext.servletContext.contextPath }/admin/member?nowPage=${i}&option=${pb.option}&keyword=${pb.keyword}">
						<font color="#7C7A77">[${i }]</font></a>&nbsp;
					</c:when>
				</c:choose>
			</c:forEach>
			
			<c:if test="${pb.nextPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/member?nowPage=${pb.endPage+1}&option=${pb.option}&keyword=${pb.keyword}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
			
		</td>
	</tr>
</table>
</center>
</body>
</html>