window.addEventListener("load", function() {
    function showScreen2(){
        document.getElementById("screen1").style.display="none";
        document.getElementById("screen3").style.display="none";
        document.getElementById("screen2").style.display="block";
    }   

    document.getElementById("lifestage1").addEventListener("click",showScreen2);

    function showScreen3(){
        document.getElementById("screen1").style.display="none";
        document.getElementById("screen2").style.display="none";
        document.getElementById("screen3").style.display="block";
    }   

    document.getElementById("lifestage2").addEventListener("click",showScreen3);




 });