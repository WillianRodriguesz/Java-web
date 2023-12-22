<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb</title>
        <style>
            body {
                background: orange;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
            }
            
            .quadrado1 {     
                width: 600px;
                height: 400px;
                background: blue;
                display: flex; 
                justify-content: space-around; 
                align-items: center; 
                margin-right: 0; /* Removendo a margem direita */
                padding: 0;
            }
            
            .olhos {
                width: 100px;
                height: 100px;
                background: green;
                margin: -150px 30px 0 0;
            }
            
            .nariz {
                width: 50px;
                height: 50px;
                background: gray;
            }
            
            .boca {
                width: 300px;
                height: 30px;
                background: yellow;
                margin: 150px 200px -50px -400px;
            }
            
        </style>
    </head>
    <body>
         <div class="quadrado1">
        <div class="olhos" id="olhosEsquerdo"></div>
        <div class="nariz"></div>
        <div class="olhos" id="olhosDireito"></div>
        <div class="boca" onmouseover="mudarAlturaOlho(10)" onmouseout="mudarAlturaOlho(100)"></div>
    </div>
        
        <script>
                function mudarAlturaOlho(altura) {
            document.getElementById("olhosEsquerdo").style.height = altura + "px";
        }
            
        </script>
            
    </body>
</html>
