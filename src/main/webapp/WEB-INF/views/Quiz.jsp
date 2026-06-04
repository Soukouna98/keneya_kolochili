<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="quiz.css">
    <title>Page quiz</title>
</head>
<body>
    <div class="container">
        <header>
            <div class="retour">
                <a href="#">Quitter le quiz</a>
            </div>
            <div class="btn-gauche">
                <a href="#">Meilleur Score</a>
                <a href="#">Recommencer</a>
            </div>

        </header>

        <main>
            <div class="main-gauche">
                <div class="progression">
                    <h2>Progression Quiz</h2>
                    <div class="progress">
                        <div class="progress-bar"></div>
                    </div>
                </div>
                <div class="question-reponse">
                    <p id="affiche-question">Question : 6/20 : <strong>Qui est réellement Noob Saibot sous son masque d'ombre ? </strong></p>
                    <p><strong>Veillez choisir une  reponse : </strong></p>
                    <div class="propositions">
                        <div class="reponse">
                            <p>A. Scorpion revenu d'entre les morts</p>
                        </div>
                        <div class="reponse">
                            <p>B. Bi-Han, le tout premier Sub-Zero</p>
                        </div>
                        <div class="reponse">
                            <p>C. Kuai Liang, le second Sub-Zero</p>
                        </div>
                        <div class="reponse">
                            <p>D. Un clone raté créé par Shang Tsung</p>
                        </div>
                    </div>

                </div>
                <div class="bouton-bas">
                    <button class="precedent">Précédent</button>
                    <button class="suivant">Suivant</button>
                </div>

            </div>

            <div class="main-droite">
                <div class="score">
                    <h2>34%</h2>
                    <p>Votre score</p>
                </div>

                <div class="list-question">
                    <div class="question">
                        Question 1
                    </div>
                    <div class="question">
                        Question 2
                    </div>
                    <div class="question" id="faux">
                        Question 3
                    </div>
                    <div class="question">
                        Question 4
                    </div>
                    <div class="question" id="actuel">
                        Question 5
                    </div>
                    <div class="question" id="no-answer">
                        Question 6
                    </div>
                  
                </div>
            </div>
        </main>

    </div>
</body>
</html>