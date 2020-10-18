const body = document.getElementsByTagName("body")[0];
const application = document.getElementById("application");
const appWidth = application.offsetWidth;
const appHeight = application.offsetHeight;
const cnv = application.querySelector('canvas');
const ctx = cnv.getContext('2d');
const filler = document.getElementById("filler");
const bitmap = document.getElementById("bitmap");
application.addEventListener('click',createHitMap);
createView();




function createHitMap(event) {

    const x=event.pageX-application.offsetLeft;
    const y=event.pageY-application.offsetTop;
    var path=document.location.href;
    if(filler.value === ""){
        path+="/click?";
    }else{
        path+="/fill?command="+filler.value+"&";
    }
    path+= "x="+x+"&y="+y;
    post(path,3,'post');

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
        if(x===683){
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