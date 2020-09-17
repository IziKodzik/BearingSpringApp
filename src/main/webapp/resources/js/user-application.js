const body = document.getElementsByTagName("body")[0];
const application = document.getElementById("application");
const appWidth = application.offsetWidth;
const appHeight = application.offsetHeight;
const cnv = application.querySelector('canvas');
const ctx = cnv.getContext('2d');
const bitmap = document.getElementById("bitmap");
application.addEventListener('click',createHitMap);
createView();



function createHitMap(event) {
    const x=event.clientX-application.offsetLeft;
    const y=event.clientY-application.offsetTop;
    console.log((x + " " + y));
    var params = new URLSearchParams(window.location.search);

    post(document.location.href + "/click?x="+x+"&y="+y,2,'post');

}
function createView(){

    var x = 0;
    var y = 0;
    const colors = bitmap.value;
    const tab = colors.split(",");
    tab.length = tab.length-1;
    for(let op = 0; op < tab.length ; ++op){
        const r = (tab[op] >> 16) & 255;
        const g = (tab[op] >> 8) & 255;
        const b = (tab[op] >> 0) & 255;
        const style = 'rgb(' + r + "," + g + "," + b + ")";

        ctx.fillStyle = style;
        ctx.fillRect(x,y,x+1,y+1);
        x++;
        if(x===680){
            x=0;
            y++;
        }
    }
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