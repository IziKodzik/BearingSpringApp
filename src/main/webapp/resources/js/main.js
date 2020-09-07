console.log("qq");
const button = document.querySelector("button");
const test = document.getElementById("grooved-bearing-style");
const agent = document.getElementById("bonding-agent");
button.disabled=false;


agent.addEventListener('change',function () {

})

button.addEventListener('click',function () {
    var index = 0;
    if(test.selectedIndex === 0)
        test.selectedIndex = 1;
    test.options[index].disabled = !test.options[index].disabled;
})