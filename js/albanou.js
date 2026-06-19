const bouttonTelecharger=document.querySelector("#telecharger");
bouttonTelecharger.onclick=()=>{
    const lien=document.createElement('a');
    lien.href="./CV/Al Banou Sylla.pdf";
    lien.download="Al Banou'cv";
    lien.click();
}