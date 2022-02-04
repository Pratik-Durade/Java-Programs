<html>
<body bgcolor="LightCoral">
	
	<form action="./patient_appointment.jsp" method="get" align="center">
		Username : <input type="text" name="pname" placeholder="Enter Patient Name"><br><br>  
		Date of Appointment :<input type="date" name="doa" placeholder="Select Date"><br><br>
		Time of Appointment :<input type="text" name="toa" placeholder="Enter Time"><br><br>
		Specialist : <select name="specialist">
			<option value="ENT">ENT</option>
			<option value="DENTIST">DENTIST</option>
			<option value="Orthopedic">Orthopedic</option>
		</select><br><br>
		<input type="submit" value="Register">
	</form>

</body>
</html>