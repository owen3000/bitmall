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
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/admin/jumun/jumun.js">
</script>


</head>
<body bgcolor="white" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<br>
<jsp:include page="/WEB-INF/views/include/admin-menu.jsp"/>
<hr width='900' size='3'>
<form id="jumun-search" name="form1" method="post" action="${pageContext.servletContext.contextPath }/admin/jumun">
<input id="nowPage" type="hidden" name="nowPage" value="${pb.nowPage }">
<input id="day1" type="hidden" name="day1" value="">
<input id="day2" type="hidden" name="day2" value="">
<table width="800" border="0" cellspacing="0" cellpadding="0">
	<tr height="40">
		<td align="left"  width="100" valign="bottom">&nbsp 주문수 : <font color="#FF0000">${totalCount }</font></td>
		<td align="right" width="650" valign="bottom">
			기간 : 
			<input data-day1="${pb.opt.day1 }" id="day1_y" type="text" name="day1_y" size="4" value="2008" maxlength="4" placeholder="년도" >
			<select id="day1_m" name="day1_m">
				<option value="01" selected>1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<select id="day1_d" name="day1_d">
				<option value="01" selected>1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select> 
			
			<input data-day2="${pb.opt.day2 }" id="day2_y" type="text" name="day2_y" size="4" value="2018" maxlength="4" placeholder="년도">
			<select id="day2_m"  name="day2_m">
				<option value="01" selected>1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<select id="day2_d" name="day2_d">
				<option value="01" selected>1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select> &nbsp;
			<select name="sel1">
				<option value="0" selected>전체</option>
				<option value="jumun">주문신청</option>
				<option value="jumunOk">주문확인</option>
				<option value="depositOk">입금확인</option>
				<option value="delivery">배달중</option>
				<option value="complete">배달완료</option>
				<option value="jumunCancel">주문취소</option>
			</select> &nbsp; 
			<select name="sel2">
				<option value="jumunNo">주문번호</option>
				<option value="customerName">고객명</option>
				<option value="productName">상품명</option>
			</select>
			<input type="text" name="keyword" size="10" value="">&nbsp;
		</td>
		<td align="left" width="50" height="50" valign="bottom">
			<input type="submit" value="검색"> &nbsp;
		</td>
	</tr>
	<tr><td height="5"></td></tr>
</table>
</form>

<table width="800" border="1" cellspacing="0" cellpadding="0" bordercolordark="white" bordercolorlight="black">
	<tr bgcolor="#CCCCCC" height="23"> 
		<td width="70"  align="center">주문번호</td>
    <td width="70"  align="center">주문일</td>
	  <td width="250" align="center">상품명</td>
		<td width="40"  align="center">제품수</td>	
		<td width="70"  align="center">총금액</td>
    <td width="65"  align="center">주문자</td>
		<td width="50"  align="center">결재</td>
    <td width="135" align="center">주문상태</td>
    <td width="50"  align="center">삭제</td>
	</tr>
	
	<c:forEach items="${jumunList }" var="l" varStatus="status">
		<tr bgcolor="#F2F2F2" height="23">
			<form class="form-modify" method="post" action="${pageContext.servletContext.contextPath }/admin/jumun/modify_state">
				<input name="jumun-no" type="hidden" value="${l.no }">
				<input class="modify-nowPage" type="hidden" name="nowPage" value="${pb.nowPage }">
				<input class="modify-day1" type="hidden" name="day1" value="${pb.opt.day1 }">
				<input class="modify-day2" type="hidden" name="day2" value="${pb.opt.day2 }">
				<input class="modify-sel1" type="hidden" name="sel1" value="${pb.opt.sel1 }">
				<input class="modify-sel2" type="hidden" name="sel2" value="${pb.opt.sel2 }">
				<input class="modify-keyword" type="hidden" name="keyword" value="${pb.opt.keyword }">
				
			<td width="70"  align="center"><a href="jumun_info.jsp?no=0803050004">${l.no }</a></td>
			<td width="70"  align="center">${l.date }</td>
			<td width="250" align="left">&nbsp;${l.productName }&nbsp; (외${l.count-1 }) </td>	
			<td width="40" align="center">${l.count }</td>	
			<td width="70"  align="right"><fmt:formatNumber value="${l.totalPrice }" type="number"/>&nbsp;</td>	
			<td width="65"  align="center">${l.userName }</td>	
			<td width="50"  align="center">${l.paymentOption }</td>	
			<td width="135" align="center" valign="bottom">
				<select class="select-state" data-state="${l.state }" name="jumun-state" style="font-size:9pt; color:black">
					<option value="주문신청">주문신청</option>
					<option value="주문확인">주문확인</option>
					<option value="입금확인">입금확인</option>
					<option value="배송중">배송중</option>
					<option value="주문완료">주문완료</option>
					<option value="주문취소">주문취소</option>
				</select>&nbsp;

				<input class="modify-state" type="image" src="${pageContext.servletContext.contextPath }/assets/images/admin/b_edit1.gif" border="0">
			</td>	
			
			<td width="50" align="center" valign="bottom">
				<a href="${pageContext.servletContext.contextPath }/admin/jumun/delete?jumun-no=${l.no }&nowPage=${pb.startPage-1}&keyword=${pb.opt.keyword}&day1=${pb.opt.day1}&day2=${pb.opt.day2}&sel1=${pb.opt.sel1}&sel2=${pb.opt.sel2}">
				<img src="${pageContext.servletContext.contextPath }/assets/images/admin/b_delete1.gif" border="0"></a>
			</td>
			</form>
		</tr>
	</c:forEach>

</table>
<br>
<table width="800" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="30" class="cmfont" align="center">
			<c:if test="${pb.previousPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/jumun?nowPage=${pb.startPage-1}&keyword=${pb.opt.keyword}&day1=${pb.opt.day1}&day2=${pb.opt.day2}&sel1=${pb.opt.sel1}&sel2=${pb.opt.sel2}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_prev.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
			
			<c:forEach var="i" begin="${pb.startPage }" end="${pb.endPage }">
				<c:choose>
					<c:when test="${pb.nowPage eq i }">
						<font color="#FC0504"><b>${i }</b></font>&nbsp;
					</c:when>
					<c:when test="${pb.nowPage ne i }">
						<a href="${pageContext.servletContext.contextPath }/admin/jumun?nowPage=${i}&keyword=${pb.opt.keyword}&day1=${pb.opt.day1}&day2=${pb.opt.day2}&sel1=${pb.opt.sel1}&sel2=${pb.opt.sel2}">
						<font color="#7C7A77">[${i }]</font></a>&nbsp;
					</c:when>
				</c:choose>
			</c:forEach>	
					
			<c:if test="${pb.nextPageGroup }">
				<a href="${pageContext.servletContext.contextPath }/admin/jumun?nowPage=${pb.endPage+1}&keyword=${pb.opt.keyword}&day1=${pb.opt.day1}&day2=${pb.opt.day2}&sel1=${pb.opt.sel1}&sel2=${pb.opt.sel2}">
					<img src="${pageContext.servletContext.contextPath }/assets/images/admin/i_next.gif" align="absmiddle" border="0">
				</a>&nbsp;
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>