<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="assets/images/iconedenkolochi.png">
    <link rel="stylesheet" href="accueil.css">
    <title>Connexion - DenKolosi</title>
    <style>
        body { font-family: sans-serif; display: flex; justify-content: center; align-items: center;  background-color: #f9f9f9; }

.login-container { display: flex; background: white; border-radius: 20px; box-shadow: 0 4px 20px rgba(0,0,0,0.1); width: 90vw;height: 95vh;overflow: hidden; }

.illustration { background: #f0f7f4; padding: 20px 0 20px 20px; display: flex; flex-flow: column nowrap;}

.login-box {  padding: 40px; }

input { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ccc; border-radius: 8px; box-sizing: border-box; }

.btn-connect { width: 100%; padding: 12px; background: #28a745; color: white; border: none; border-radius: 8px; cursor: pointer; }

.btn-register { width: 100%; padding: 12px; background: transparent; border: 1px solid #ff9800; color: #ff9800; border-radius: 8px; cursor: pointer; }

.form-options { display: flex; justify-content: space-between; font-size: 0.9em; margin: 10px 0; }

.divider { display: flex; justify-content: center;align-items: center; margin: 5vh 0;}

.terms { font-size: 0.75em; color: #666; margin-top: 20px; text-align: center; }
.logo{
    width: 10vw;
    /* margin: auto; */
}
.main-img{
    width: 60%;
    align-self: flex-end;
}
h2,h2+p{
    text-align: center;
}
.tiret{
    background-color: #666;
    width: 45%;
    height: .2vw;
}
[type=checkbox]{
    width: auto;
}
h2{
    font-size:large ;
}
    </style>
</head>
<body>
    <div class="login-container">
        <div class="illustration">
            <img src="assets/images/iconedenkolochi.png" alt="Logo DenKolosi" class="logo">
            <img src="assets/images/Photo de fond.png" alt="Parent et enfant" class="main-img">
        </div>

        <div class="login-box">
            <h2>Bienvenue !</h2>
            <p>Connectez-vous pour accéder au suivi intelligent de votre enfant.</p>
            
            <form action="loginAction.jsp" method="POST">
                <label>Email</label>
                <input type="email" placeholder="Entrer votre email" required>
                
                <label>Mot de passe</label>
                <input type="password" placeholder="Entrer votre mot de passe" required>
                
                <div class="form-options">
                    <label><input type="checkbox"> Se souvenir de moi</label>
                    <a href="#">Mot de passe oublié ?</a>
                </div>
                
                <button type="submit" class="btn-connect">Se connecter</button>
            </form>

            <div class="divider">
              <div class="tiret"></div>
              OU
              <div class="tiret"></div>
              
            </div>
            
            <button class="btn-register">Créer un compte</button>
            
            <p class="terms">En vous connectant, vous acceptez nos <a>conditions d'utilisation</a> et notre <a>politique de confidentialité</a>.</p>
        </div>
    </div>
</body>
</html>