const images=document.querySelectorAll("figure>img");
const contenu=document.querySelector("main");
const liens = document.querySelectorAll("a");
let info=false;
const headertelephone=document.querySelector("header#tel");
const bouttonDeNavigation=document.querySelector(".iconenavigation");
const popupDeNavigation=document.querySelector(".menunavigationliste");
const pied = document.querySelector("footer");
liens.forEach((element)=> {
    element.onclick = ()=>{
        contenu.style.display="";
        popupDeNavigation.id="";
        bouttonDeNavigation.src="https://cdn-icons-png.flaticon.com/128/5358/5358649.png";
    }
}) 

bouttonDeNavigation.addEventListener("click",()=>{
    if (!info) {
        bouttonDeNavigation.setAttribute("src","https://cdn-icons-png.flaticon.com/128/7782/7782784.png");
        bouttonDeNavigation.style.width="20px";
        contenu.style.display="none";
    pied.style.display="none";
    popupDeNavigation.setAttribute("id","menuouvert");
    info=true;
    }
    else{
        bouttonDeNavigation.setAttribute('src',"https://cdn-icons-png.flaticon.com/128/5358/5358649.png");
        contenu.style.display="";
        bouttonDeNavigation.style.width="";
        pied.style.display="";
        popupDeNavigation.id="";
        info=false;
    }
  
})
images.forEach((element)=>{
    element.onclick=(e)=>{
        const cible=e.target;
        const nom=cible.nextElementSibling.textContent.toLowerCase();
        switch (nom) {
            case "hamath diallo":
                window.location="cv-Hamath Diallo.html";
                break;
            case "seyba yacouba sissoko":
                window.location="cv-seyba Y Sissoko.html";
                break;
                case "aïssata moulekafou":
                window.location="cv-Moulekafou.html";
                break;
            case "al banou sylla":
                window.location="cv-al banou sylla.html";
                break;
            case "hawa ballo":
                window.location="cv-hawa ballo.html";
                break;
            case "awa koniba":
                window.location="cv-koniba awa.html";
                break;
            case "mohamed coulibaly":
                window.location="cv-Mohamed Coulibaly.html";
                break;
                case "zakaria nouhou":
                window.location="cv-zakaria nouhou.html";
                break;
                case "amidou diagana":
                window.location="cv-Amidou DIAGANA.html";
                break;
                case "cheick ayoub sanogo":
                window.location="cv-cheick ayoub sanogo.html";
                break;
                case "amadou n'diaye":
                window.location="cv-Amadou N'diaye.html";
                break;
            default:
                alert("ce cv n'existe pas");
                break;
        }
    }
});
