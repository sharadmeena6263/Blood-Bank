<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-image: url("Image/home image2.jpg");
  background-size: cover;
  background-position: center;
  margin: 0;
  padding: 0;
}

.container {
  max-width: 1000px;
  margin: 20px auto;
  background-color: rgba(255, 255, 255, 0.7); 
  padding: 20px;
  border-radius: 10px;
}

header {
  background-color: #f44336;
  color: white;
  padding: 15px 0;
  text-align: center;
  margin-bottom: 30px;
  border-radius: 5px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

table th, table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

table th {
  background-color: #f2f2f2;
}

.logout-btn, .change-status-btn {
  background-color: #f44336;
  color: white;
  border: none;
  padding: 10px 20px;
  text-decoration: none;
  border-radius: 5px;
  cursor: pointer;
  display: inline-block;
  margin-right: 10px;
}
.change-status-btn {
  background-color: #32cd32;
  color: white;
  border: none;
  padding: 10px 20px;
  text-decoration: none;
  border-radius: 5px;
  cursor: pointer;
  display: inline-block;
  margin-right: 10px;
}

.logout-btn:hover{
  background-color:#d32f2f;
}
.change-status-btn:hover {
  background-color:#228b22;
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
</style>
</head>
<body>
<nav>
    <a href="home.html">Home</a>
    <a href="aboutUs.html">About Us</a>
    <a href="login.html">Donor Login</a>
    <a href="#">Contact Us</a>
</nav>
<div class="container">
  <header>
     <h2>Welcome: ${name}</h2>
  </header>
  
  <a href="logout.do" id="logoutBtn" class="logout-btn">Logout</a>
  
  <table>
    <tr>
      <th>Name</th>
      <th>Email Id</th>
      <th>Blood Group</th>
      <th>Gender</th>
      <th>State</th>
      <th>Contact No</th>
      <th>City</th>
      <th>Status</th>
      <th>Change Status</th>
    </tr>
    <tr>
      <td>${name}</td>
      <td>${email}</td>
      <td>${blood}</td>
      <td>${gender}</td>
      <td>${state}</td>
      <td>${phone}</td>
      <td>${city}</td>
      <td>${status}</td>
       <td>
    <form action="change.do" method="post">
    <select name="status" required>
    <option value="" disabled selected>Modify</option>
    <option value="Available">Available</option>
    <option value="Unavailable">Unavailable</option>
    </select>
    <button type="submit" class="change-status-btn">Change</button>
    </form>
      </td>
    </tr>
  </table>
</div>
 <script>
document.getElementById('logoutBtn').addEventListener('click', function() {
    location.reload();
});
</script>
 
</body>
</html>
