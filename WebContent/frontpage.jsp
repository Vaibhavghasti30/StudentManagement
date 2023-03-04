<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registering</title>
</head>
<body style="background-color:#7FFFD4; color:#000000">
<div align="center">
<h1>Registrtation</h1>

<form action = "reg" method="post">
<table>
<tr>
<td><label>Enter your Name :</label></td>
<td><input type = "text" name="tbname" placeholder="Enter your Name" style="background-color:#ADD8E6; color:#000000"/></td>
<tr>

<tr>
<td><label>Enter your Email :</label></td>
<td><input type = "email" required name="tbemail" placeholder="Enter your Email" style="background-color:#ADD8E6; color:#000000" /></td>
</tr>


<tr>
<td><label>Enter your Password :</label></td>
<td><input type = "password" name="tbpassword" placeholder="Enter your Password" style="background-color:#ADD8E6; color:#000000"/></td>
</tr>

<tr>
<td><label>Enter your State :</label></td>
<td><select name="ddlstates" style="background-color:#ADD8E6; color:#000000">
<option value=" ">--select--</option>
<option value="Karanataka">KA</option>
<option value="Maharastra">MH</option>
<option value="Tamil Nadu">TN</option>
<option value="Kerala">KL</option>
<option value="Goa">GA</option>
</select></td>

<tr>
<td align="right"><input type = "submit" value="Register" style="background-color:#0000FF; color:#FFFFFF"></td>
</tr>
</table>
</form>
</div>
</body>
</html>