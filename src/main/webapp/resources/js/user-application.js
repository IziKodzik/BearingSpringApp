const body = document.getElementsByTagName("body")[0];
const application = document.getElementById("application");
const appWidth = application.offsetWidth;
const appHeight = application.offsetHeight;

application.addEventListener('click',createHitMap);



function createHitMap(event) {
    const x=event.clientX-application.offsetLeft;
    const y=event.clientY-application.offsetTop;
    console.log((x + " " + y));
    var params = new URLSearchParams(window.location.search);

    post(document.location.href + "/click?x="+x+"&y="+y,2,'post');

}
function post(path,params,method='post') {
    const form = document.createElement("form");
    form.method = method;
    form.action = path;
    body.appendChild(form);
    form.submit();
    body.removeChild(form);

}
function createButtonHitMap() {

     console.log(appHeight);
     console.log(appWidth);
     const buttonWidth = 20;
     const buttonHeight = 10;
     const buttonsAmount = appHeight/buttonHeight * appWidth/buttonWidth;
     for(let op=0;op<buttonsAmount;++op){
         const button = document.createElement("button");
         button.style.height=buttonHeight +"px";
         button.style.width=buttonWidth +"px";
         button.className = "invisible";
         button.addEventListener('click',function () {
             const xPos = buttonWidth/2  + button.offsetLeft - application.offsetLeft ;
             const yPos = buttonHeight/2  + button.offsetTop - application.offsetTop ;
             button.
             console.log("X=" + xPos + ", Y=" + yPos);
         });
         application.appendChild(button);
     }
 }