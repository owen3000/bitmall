<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>쇼핑몰 관리자 홈페이지</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.servletContext.contextPath }/assets/css/font.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js">
</script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/admin/product/product_new.js">
</script>
<style type="text/css">
#product-new-discount{text-align: right; padding-right: 4px;}
p.p-errors, .errors span{margin: 0px; padding: 0px; color: red;}
</style>
</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>

<form:form modelAttribute="productVO" id="form-product-new" action="${pageContext.servletContext.contextPath}/admin/product_new" 
	enctype="multipart/form-data" method="post">
<table width="800" border="1" cellspacing="0" cellpadding="3" bordercolordark="white" bordercolorlight="black">
	<tr height="23"> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품분류</td>
	    <td width="700" bgcolor="#F2F2F2">
		    <form:select path="categoryNo" id="product-new-category">
		    		<form:option value="0">상품분류를 선택하세요</form:option>
		    	<c:forEach items="${readLists.categoryList }" var="l" varStatus="status">
		    		<form:option value="${l.no }">${l.name }</form:option>
				</c:forEach>
		    </form:select>
		    <p class="p-errors"><form:errors path="categoryNo"/></p>
		</td>
	</tr>
	<tr height="23"> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품코드</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="code" id="product-new-code" size="20" maxlength="20"/>
			<p class="p-errors"><form:errors path="code"/></p>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품명</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="name" id="product-new-name" size="60" maxlength="60"/>
			<p class="p-errors"><form:errors path="name"/> </p>
			
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">제조사</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="manufacturer" id="product-new-manufacturer" size="30" maxlength="30"/>
			<p class="p-errors"><form:errors path="manufacturer"/></p>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">판매가</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:input path="price" id="product-new-price" size="12" maxlength="12"/> 원
			<p class="p-errors"><form:errors path="price"/></p>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">옵션</td>
    <td width="700" bgcolor="#F2F2F2">
    				
				<c:forEach items="${readLists.optList }" var="l" varStatus="status">
					<input type="checkbox" name="opt" value="${l.no }">
					${l.name }&nbsp;
				</c:forEach>
			&nbsp; &nbsp; 
			&nbsp; &nbsp; 
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">제품설명</td>
		<td width="700" bgcolor="#F2F2F2">
			<form:textarea path="description" id="product-new-description" rows="10" cols="80"/>
			<p class="p-errors"><form:errors path="description"/></p>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">상품상태</td>
    <td width="700" bgcolor="#F2F2F2">
    	<form:radiobuttons path="salesStatusNo" items="${readLists.salesStatusList }" itemValue="no" itemLabel="status" />
    	<p class="p-errors"><form:errors path="salesStatusNo"/></p>
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">아이콘</td>
		<td width="700" bgcolor="#F2F2F2">
			<c:forEach items="${readLists.eventList }" var="l" varStatus="status">
				<input class="checkbox-event" type="checkbox" name="event" value="${l.no }" data-rate="${l.rate }"> ${l.title } &nbsp;&nbsp;	
			</c:forEach>
			할인율 : <input id="product-new-discount" type="text" name="discount" value="0" size="3" maxlength="3" readonly="readonly"> %
		</td>
	</tr>
	<tr> 
		<td width="100" bgcolor="#CCCCCC" align="center">이미지</td>
		<td width="700" bgcolor="#F2F2F2">
			<b>이미지1</b>: <input class="product-new-file" type="file" name="file" size="30" value="찾아보기"><br>
			<b>이미지2</b>: <input class="product-new-file" type="file" name="file" size="30" value="찾아보기"><br>
			<b>이미지3</b>: <input class="product-new-file" type="file" name="file" size="30" value="찾아보기"><br>
		</td>
	</tr>
</table>
<br>
<table width="800" border="0" cellspacing="0" cellpadding="7">
	<tr> 
		<td align="center">
			<input type="submit" value="등록하기"> &nbsp;&nbsp
			<a href="product.jsp"><input type="button" value="이전화면"></a>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>
