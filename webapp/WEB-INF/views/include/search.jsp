<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table width="959" height="25" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr><td height="1" colspan="5" bgcolor="#F7F7F7"></td></tr>
	<tr bgcolor="#262626">
		<td width="181" align="center"><font color="#FFFFFF">&nbsp <b>Welcome ! &nbsp;&nbsp ${authUser.name}</b></font></td>
		<td style="font-size:9pt;color:#FFFFFF;font-family:돋움;padding-left:5px;"></td>
		<td align="right" style="font-size:9pt;color:#FFFFFF;font-family:돋움;"><b>상품검색 ▶&nbsp;</b></td>
		<!-- form1 시작 -->
		<form name="form1" method="get" action="${pageContext.servletContext.contextPath }/product_search">
		<td width="380" height="50">
		<span class='green_window'>
			<input class='input_text' type="text" name="findtext" maxlength="40" size="20" class="cmfont1">&nbsp;
		</span>
		</td>
		<td width="60">
		<input  class="sch_smit" id="search-btn" type="submit" value="검색"></td>
		</form>
		<!-- form1 끝 -->
	</tr>
	<tr><td height="1" colspan="5" bgcolor="#E5E5E5"></td></tr>
</table>