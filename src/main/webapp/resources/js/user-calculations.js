const application = document.getElementById("application");

const appWidth = application.offsetWidth;
const appHeight = application.offsetHeight;

console.log(appHeight);
console.log(appWidth);
const buttonWidth = 10;
const buttonHeight = 5;
const buttonsAmount = appHeight/buttonHeight * appWidth/buttonWidth;
createHitMap();



 function createHitMap() {

     for(let op=0;op<buttonsAmount;++op){
         const button = document.createElement("button");
         button.style.height=buttonHeight +"px";
         button.style.width=buttonWidth +"px";
         button.className = "invisible";
         button.addEventListener('click',function () {
             const xPos = buttonWidth/2  + button.offsetLeft - application.offsetLeft ;
             const yPos = buttonHeight/2  + button.offsetTop - application.offsetTop ;
             console.log("X=" + xPos + ", Y=" + yPos);
         });
         application.appendChild(button);
     }
 }
 console.log(buttonsAmount);