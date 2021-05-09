import React from 'react';

const Registration = () => {
    return (
        <div >
			<h2 style={{textAlign: "center"}}>Registration form</h2>
			<form>
				<label for="Firstname">First Name : </label><br/>
				<input type="text"  name="Firstname"/><br/><br/>
				<label for="Lastname  :">Last Name :</label><br/>
				<input type="text" name="Lastname"/><br/><br/>
				<label for="Date of Birth : ">Date of Birth :</label><br/>
				<input type="text" name="Date of Birth"/><br/><br/>
				<label for="Address">Address : </label><br/>
				<input type="text" name="Address"/><br/><br/>
				<label for="Institute">Institute :</label><br/>
				<input type="text" name="Institute "/><br/><br/>
				<label for="Email">Email ID :</label><br/>
				<input type="text" name="Email"/><br/><br/>
				<label for="Paper title">Paper Title :</label><br/>
				<input type="text" name="Paper title"/><br/><br/>
				<label for="contactno">Contact No :</label><br/>
				<input type="text" name="contactno"/><br/><br/>
				<p style={{textAlign: "center"}}><input type="submit" id="a" value="submit"/></p>
			</form>
		</div>
    );
}

export default Registration;