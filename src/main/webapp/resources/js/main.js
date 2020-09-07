console.log("qq");
const button = document.querySelector("button");
const test = document.getElementById("grooved-bearing-style");
const agent = document.getElementById("bonding-agent");

agent.addEventListener('change',function () {
    if(agent.options[agent.selectedIndex].value === ("other")) {
        test.disabled = true;
    }else
        test.disabled=false;
})

test.addEventListener('click',function () {
    
})