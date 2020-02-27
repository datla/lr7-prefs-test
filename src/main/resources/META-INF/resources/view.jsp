<%@ include file="/init.jsp" %>

<%
if(Validator.isNull(city)){ 
	city ="Not Configured";
}

if(Validator.isNull(unit)){ 
	unit ="Not Configured";
}

%>

<b>City:</b><%=city%>
<br/>
<b>Unit:</b><%=unit%>