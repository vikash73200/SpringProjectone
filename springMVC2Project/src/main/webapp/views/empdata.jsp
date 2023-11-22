<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix='sf'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="POST" modelAttribute="employee">

		<center>
			<h2>Employee Data Application</h2>
			<table>

				<tr>
					<td>EmId</td>
					<td><sf:input type="text" path="EmpId" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><sf:input type="text" path="name" /></td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><sf:input type="text" path="birthDate" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
					<sf:radiobutton path="gender" label="Male" value="Male" />
					<sf:radiobutton path="gender" label="Female" value="Female" />
					</td>
				</tr>
 
				<tr>
					<td>Role</td>
					<td><sf:select path="role">
							<sf:options items="${ roles}" />
						</sf:select></td>
				</tr>
				<tr>
					<td colspan='2' align='center'><input type='submit'
						name='action' value='save'> <input type='submit'
						name='action' value='Find'> <input type='submit'
						name='action' value='Update'> <input type='submit'
						name='action' value='Delete'></td>
				</tr>

			</table>
			<h3>${message}</h3>
		</center>
	</sf:form>
	<center>
		<table align='center' border='1' width='70%'>
			<tr style="background-color: yellow;">
				<th>Emp Id</th>
				<th>Name</th>
				<th>Gender</th>
				<th>D O B</th>
				<th>Role</th>
			</tr>
			<c:forEach items="${empList}" var="e">
				<tr>
					<td>${ e.empId}</td>
					<td>${e.name}</td>
					<td>${e.gender}</td>
					<td>${e.birthDate}</td>
					<td>${e.role}</td>
				</tr>

			</c:forEach>




		</table>
	</center>

</body>
</html>