<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Entry</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .form-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        input[type="text"], input[type="number"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Student Registration</h2>
        <form action="putData" method="post">
            <input type="text" placeholder="Enter Student id" name="t1" required>
           <input type="text" placeholder="Enter Name" name="t2" required>
            <input type="text" placeholder="Enter Address" name="t3" required>
            <input type="number" placeholder="Enter Fees" name="t4" required>
            <br>
            
            <input type="submit" value="Register">
          
          <br><br>
         <center ><a href="showData">Show Table Data</a></center>
            
        </form>
    </div>
</body>
</html>
