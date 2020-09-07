console.log("qq");
const button = document.querySelector("button");
const test = document.getElementById("test");
const agent = document.getElementById("bonding-agent");

agent.addEventListener('change',function () {
    console.log("PLS");
})

test.addEventListener('click',function () {
    console.log(button.disabled)
    button.disabled = !button.disabled
})