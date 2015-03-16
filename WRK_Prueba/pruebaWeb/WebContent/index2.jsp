<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet"
	type="text/css">
<TITLE>index2.jsp</TITLE>
</HEAD>
<BODY>
<P><%
	String rut = "";
	String password = "";
	if(request.getAttribute("rut") != null &&
	   request.getAttribute("password") != null
	){
		rut = (String) request.getAttribute("rut");
		password = (String) request.getAttribute("password");
	}
%>
<%="Su rut es "+rut+" y su password : "+password%>
</P>
</BODY>
</HTML>
