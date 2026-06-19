document.addEventListener("DOMContentLoaded", function() {
  const bouton = document.querySelector('button');

    bouton.addEventListener("click", function() {
      const lien=document.createElement('a');

        lien.href="CV/CV De Hamath.pdf";
        lien.download="CV De Hamath";
        lien.click();
        alert("Le cv est telechargé !");

    });
  });