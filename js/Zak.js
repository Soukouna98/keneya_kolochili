document.addEventListener("DOMContentLoaded", function() {
  const bouton = document.querySelector('#telecharger');

    bouton.addEventListener("click", function() {
      const lien = document.createElement('a');

        lien.href="../CV/CV_Zakaria.pdf";
        lien.download="cv_Zakaria_Nouhou";
        lien.click();
        alert("Le CV a été téléchargé avec succès !!");

    });
  });