<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating Details</title>
</head>
<body style="background-color:#7FFFD4; color:#000000">
<h1>Updating the Data</h1>
<form action="up" method="post">
<table>
<tr>
<td><label>Enter Your Email :</label></td>
<td><input type = "email" required name = "tbemail" placeholder="Enter your Email" style="background-color:#ADD8E6; color:#000000"/></td>
</tr>

<tr>
<td><label>Enter Your Name :</label></td>
<td><input type = "text" name = "tbname" placeholder="Enter your Name" style="background-color:#ADD8E6; color:#000000"/></td>
</tr>

<tr>
<td><label>Enter Your Password :</label></td>
<td><input type = "password" name = "tbpassword" placeholder="Enter your Password" style="background-color:#ADD8E6; color:#000000"/></td>
</tr>

<tr>
<td><label>Enter Your State :</label></td>
<td><select name="ddlstates"  style="background-color:#ADD8E6; color:#000000">
<option value=" ">--Select--</option>
<option value="Jammu and Kashmir">JK</option>
<option value="Telagana">TL</option>
<option value="Uttar Pradesh">UP</option>
<option value="Andrapradesh">AP</option>
<option value="Karanataka">KA</option>
</select></td>

<tr>
<td align="center"><input type = "submit" value="UPDATE" style="background-color:#0000FF; color:#FFFFFF"/></td>
</tr>
</table>
</form>
</body>
</html>