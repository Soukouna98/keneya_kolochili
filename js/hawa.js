document.addEventListener("DOMContentLoaded", function() {
  const bouton = document.querySelector('button');

    bouton.addEventListener("click", function() {
      const lien=document.createElement('a');

        lien.href="CV/cv-hawa.pdf";
        lien.download="CV De Hawa";
        lien.click();
        alert("Le cv est telechargé !");

    });
  });