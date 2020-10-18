const anal = document.getElementsByClassName("rect")[0];
anal.addEventListener('click',printMouse);
const filler = document.getElementById("filler");
// setInterval(fixFillerPosition,4000);
fixFillerPosition();

function fixFillerPosition(){


    alert(window.innerWidth + " " + window.innerHeight + "\n"
    + document.body.clientWidth + " " + document.body.clientHeight);

    
}
function printMouse(event) {

        fixFillerPosition();


}
