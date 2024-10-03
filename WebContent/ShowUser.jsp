<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Available Donor</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f7f7f7;
}

nav {
  background-color: #343a40;
  color: #fff;
  padding: 10px;
  text-align: center;
}

nav a {
  color: #fff;
  text-decoration: none;
  margin: 0 10px;
}

nav a:hover {
  text-decoration: underline;
}

header {
  background-color: #f44336;
  color: white;
  text-align: center;
  padding: 20px 0;
}

main {
  background-image:url("Image/login img.jpg");
  background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
  padding: 70px;
}

form {
  max-width: 400px;
  margin: 0 auto;
  background-color: #ffffff;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
select {
  width: 100%;
  padding: 10px;
  border: 1px solid #cccccc;
  border-radius: 5px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #f44336;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #d32f2f;
}
</style>
</head>
<body>
<header>
  <h1>Blood Donor Availability</h1>
</header>
<nav>
  <a href="home.html">Home</a>
  <a href="aboutUs.html">About Us</a>
  <a href="login.html">Donor Login</a>
  <a href="#">Contact Us</a>
</nav>
<main>
  <form action="show.do" method="post">
    <div class="form-group">
      <label for="blood">Blood Group</label>
      <select id="blood" name="blood" required>
        <option value="" disabled selected>Select</option>
        <option value="All">All</option>
        <option value="A+">A+</option>
        <option value="B+">B+</option>
        <option value="O+">O+</option>
        <option value="AB+">AB+</option>
        <option value="A-">A-</option>
        <option value="B-">B-</option>
        <option value="O-">O-</option>
        <option value="AB-">AB-</option>
      </select>
    </div>
    <div class="form-group">
      <label for="state">State</label>
      <select id="state" name="state" required>
        <option value="" disabled selected>Select</option>
        <option value="All">All</option>
        <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
        <option value="Andhra Pradesh">Andhra Pradesh</option>
        <option value="Arunachal Pradesh">Arunachal Pradesh</option>
        <option value="Assam">Assam</option>
        <option value="Bihar">Bihar</option>
        <option value="Chandigarh">Chandigarh</option>
        <option value="Chhattisgarh">Chhattisgarh</option>
        <option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
        <option value="Daman and Diu">Daman and Diu</option>
        <option value="Delhi">Delhi</option>
        <option value="Goa">Goa</option>
        <option value="Gujarat">Gujarat</option>
        <option value="Haryana">Haryana</option>
        <option value="Himachal Pradesh">Himachal Pradesh</option>
        <option value="Jammu and Kashmir">Jammu and Kashmir</option>
        <option value="Jharkhand">Jharkhand</option>
        <option value="Karnataka">Karnataka</option>
        <option value="Kerala">Kerala</option>
        <option value="Ladakh">Ladakh</option>
        <option value="Lakshadweep">Lakshadweep</option>
        <option value="Madhya Pradesh">Madhya Pradesh</option>
        <option value="Maharashtra">Maharashtra</option>
        <option value="Manipur">Manipur</option>
        <option value="Meghalaya">Meghalaya</option>
        <option value="Mizoram">Mizoram</option>
        <option value="Nagaland">Nagaland</option>
        <option value="Odisha">Odisha</option>
        <option value="Puducherry">Puducherry</option>
        <option value="Punjab">Punjab</option>
        <option value="Rajasthan">Rajasthan</option>
        <option value="Sikkim">Sikkim</option>
        <option value="Tamil Nadu">Tamil Nadu</option>
        <option value="Telangana">Telangana</option>
        <option value="Tripura">Tripura</option>
        <option value="Uttar Pradesh">Uttar Pradesh</option>
        <option value="Uttarakhand">Uttarakhand</option>
        <option value="West Bengal">West Bengal</option>
      </select>
    </div>
    <div class="form-group">
      <label for="city">City</label>
      <input type="text" id="city" name="city" placeholder="Enter All or city name" required>
    </div>
    <button type="submit">Show Donors</button>
  </form>
</main>

</body>
</html>
