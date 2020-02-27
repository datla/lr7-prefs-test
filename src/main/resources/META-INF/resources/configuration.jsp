<%@ include file="/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:input name="redirect" type="hidden"
		value="<%=configurationRenderURL%>" />

	<aui:fieldset>
		<aui:select name="city" label="City" value="<%=city%>">
			<aui:option value="Delhi">Delhi</aui:option>
			<aui:option value="Bangalore">Bangalore</aui:option>
			<aui:option value="Chennai">Chennai</aui:option>
			<aui:option value="Hyderabad">Hyderabad</aui:option>
		</aui:select>

		<aui:select label="Unit" name="unit" value="<%=unit%>">
			<aui:option value="Celsius">Celsius</aui:option>
			<aui:option value="Fahrenheit">Fahrenheit </aui:option>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>