<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js">
</script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/admin/product/product.js">
</script>	
	
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<form id="product-search" method="post" action="${pageContext.servletContext.contextPath }/admin/product">
<input id="nowPage" type="hidden" name="nowPage" value="${pb.nowPage }">
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr height="40">
		<td align="left"  width="150" valign="bottom">&nbsp; 제품수 : <font color="#FF0000">${totalCount }</font></td>
		<td align="right" width="550" valign="bottom">
			<select name="status">
				<option value="" >상품상태</option>
				<c:forEach items="${readLists.salesStatusList }" var="l" varStatus="status">
					<option value="${l.no }" >${l.status }</option>	
				</c:forEach>
			</select> &nbsp;
			<select name="event">
				<option value="" >아이콘선택</option>
				<c:forEach items="${readLists.eventList }" var="l" varStatus="status">
					<option value="${l.no }" >${l.title }</option>
				</c:forEach>
			</select> &nbsp; 
			<select name="category">
				<option value="" >분류선택</option>
				<c:forEach items="${readLists.categoryList }" var="l" varStatus="status">
					<option value="${l.no }" >${l.name }</option>
				</c:forEach>
			</select> &nbsp 
			<select name="option">
				<option value="name" selected>제품이름</option>
				<option value="code" >제품번호</option>
			</select>
			<input type="text" name="keyword" size="10" value="">&nbsp;
		</td>
		<td align="left" width="120" valign="bottom">
			<input type="submit" value="검색">
			&nbsp;
			<a href="product_new"><input type="button" value="새상품"></a>
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>
</form>

<table width="800" border="1" cellspacing="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="23"> 
		<td width="100" align="center">제품분류</td>
		<td width="100" align="center">제품코드</td>
		<td width="280" align="center">제품명</td>
		<td width="70"  align="center">판매가</td>
		<td width="50"  align="center">상태</td>
		<td width="120" align="center">이벤트</td>
		<td width="80"  align="center">수정/삭제</td>
	</tr>
	
	<c:forEach items="${productList }" var="l" varStatus="status">
		<tr bgcolor="#F2F2F2" height="23">	
			<td width="100">&nbsp ${l.categoryName }</td>
			<td width="100">&nbsp ${l.code }</td>
			<td width="280">&nbsp ${l.name }</td>	
			<td width="70"  align="right">${l.price } &nbsp</td>	
			<td width="50"  align="center">${l.status }</td>	
			<td width="120" align="center">
			&nbsp; ${fn:replace(l.eventTitle,"/",", ") }
			</td>	
			<td width="80"  align="center">
				<a href="${pageContext.servletContext.contextPath }/admin/product_edit?no=${l.no}">수정</a>/
				<a href="${pageContext.servletContext.contextPath }/admin/product_delete?no=${l.no}">삭제</a>
			</td>
		</tr>	
	</c:forEach>
</table>

<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
		
			<c:if test="${pb.previousPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/product?nowPage=${pb.startPage-1}&option=${pb.opt.option}&keyword=${pb.opt.keyword}&status=${pb.opt.status}&event=${pb.opt.event}&category=${pb.opt.category}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
			
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
				<c:choose>
					<c:when test="${pb.nowPage eq i }">
						<font color="#FC0504"><b>${i }</b></font>&nbsp;
					</c:when>
					<c:when test="${pb.nowPage ne i }">
						<a href="${pageContext.servletContext.contextPath }/admin/product?nowPage=${i}&option=${pb.opt.option}&keyword=${pb.opt.keyword}&status=${pb.opt.status}&event=${pb.opt.event}&category=${pb.opt.category}">
						<font color="#7C7A77">[${i }]</font></a>&nbsp;
					</c:when>
				</c:choose>
			</c:forEach>	
					
			<c:if test="${pb.nextPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/product?nowPage=${pb.endPage+1}&option=${pb.opt.option}&keyword=${pb.opt.keyword}&status=${pb.opt.status}&event=${pb.opt.event}&category=${pb.opt.category}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
		
		</td>
	</tr>
</table>
</body>
</html>