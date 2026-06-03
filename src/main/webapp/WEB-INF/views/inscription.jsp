<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="assets/images/iconedenkolochi.png" type="image/x-icon">

    <title>Inscription - DenKolosi</title>
    <style>
        /* Réutilisation de la charte graphique de la page de connexion */
        body { 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            min-height: 100vh; 
            margin: 0; 
            background-color: #f9f9f9; 
        }

        .login-container { 
            display: flex; 
            background: white; 
            border-radius: 20px; 
            box-shadow: 0 4px 20px rgba(0,0,0,0.1); 
            width: 800px; 
            overflow: hidden; 
        }

        .illustration { 
            flex: 1; 
            background: #f0f7f4; 
            padding: 40px; 
            display: flex; 
            flex-direction: column; 
            justify-content: center; 
            align-items: center; 
            text-align: center;
        }

        .login-box { 
            flex: 1; 
            padding: 40px; 
            h2{text-align: center;}
        }

        h2 { color: #333; margin-top: 0; }
        
        label { display: block; margin-top: 15px; font-weight: 600; color: #555; }
        
        input { 
            width: 100%; 
            padding: 12px; 
            margin: 8px 0; 
            border: 1px solid #ccc; 
            border-radius: 8px; 
            box-sizing: border-box; 
        }

        .btn-register { 
            width: 100%; 
            padding: 12px; 
            background: #ff9800; 
            color: white; 
            border: none; 
            border-radius: 8px; 
            cursor: pointer; 
            font-weight: bold;
            margin-top: 20px;
            transition: all .5s ease-in;
        }

        .btn-register:hover { background: #e68900; }

        .back-link { 
            text-align: center; 
            margin-top: 15px; 
            font-size: 0.9em; 
        }

        .back-link a { color: #28a745; text-decoration: none; font-weight: bold; }

        .terms { font-size: 0.75em; color: #666; margin-top: 20px; text-align: center; }
        .logo{
            display: block;
            width: 30%;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <!-- Partie gauche : Rappel de l'illustration -->
        <div class="illustration">
            <img src="assets/images/iconedenkolochi.png" alt="logo de Denkolochi" class="logo">
            <p>Rejoignez notre communauté pour un suivi intelligent.</p>
        </div>

        <!-- Partie droite : Formulaire d'inscription -->
        <div class="login-box">
            <h2>Créer un compte</h2>
            
            <form action="registerAction.jsp" method="POST">
                <label>Nom complet</label>
                <input type="text" placeholder="Entrer votre nom" required>
                
                <label>Email</label>
                <input type="email" placeholder="Entrer votre email" required>
                
                <label>Mot de passe</label>
                <input type="password" placeholder="Choisir un mot de passe" required>
                
                <label>Confirmer le mot de passe</label>
                <input type="password" placeholder="Confirmer le mot de passe" required>
                
                <button type="submit" class="btn-register">S'inscrire</button>
            </form>

            <div class="back-link">
                Déjà inscrit ? <a href="index.jsp">Connectez-vous</a>
            </div>
            
            <p class="terms">En vous inscrivant, vous acceptez nos <a>conditions d'utilisation</a> et notre <a>politique de confidentialité</a>.</p>
        </div>
    </div>
</body>
</html>