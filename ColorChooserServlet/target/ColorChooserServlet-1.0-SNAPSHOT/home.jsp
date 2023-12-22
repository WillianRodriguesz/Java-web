<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Escolha de Time</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            margin: 50px;
        }

        h1 {
            color: #333;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            color: #fff;
        }

        #gremista {
            background-color: #005cbf;
        }

        #colorado {
            background-color: #ff0000;
        }
    </style>
</head>
<body>
    <h1>Escolha seu time:</h1>
    
    <form action="ChooserColorServlet" method="post">
        <button type="submit" id="gremista" name="time" value="gremista">Gremista</button>
        <button type="submit" id="colorado" name="time" value="colorado">Colorado</button>
    </form>
    
</body>
</html>