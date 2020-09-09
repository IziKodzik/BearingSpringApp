const $ = document;
const tos=$.getElementById("type-of-service");
const got=$.getElementById("grade-of-thordon");
const tol=$.getElementById("type-of-lubrication");
const toi=$.getElementById("type-of-installation");
const gbs=$.getElementById("grooved-bearing-style");
const ba=$.getElementById("bonding-agent");
const baft=$.getElementById("bonding-agent-film-thickness");
const tost=$.getElementById("type-of-staxl");
const nok=$.getElementById("number-of-keepers");
const twok=$.getElementById("total-width-of-keepers");
const ts=$.getElementById("temperature-scale");
const maxot=$.getElementById("maximum-operating-temperature");
const minot=$.getElementById("minimum-operating-temperature");
const msat=$.getElementById("machine-shop-ambient-temperature");
const pdt=$.getElementById("pdt");
const ds=$.getElementById("dimension-scale");
const smrhd=$.getElementById("smrhd");
const maxsd=$.getElementById("maximum-shaft-diameter");
const minhd=$.getElementById("minimum-housing-diameter");
const maxhd=$.getElementById("maximum-housing-diameter");
const hl=$.getElementById("housing-length");
const lob=$.getElementById("load-on-bearing");
const ssr=$.getElementById("shaft-speed-(RPM)");
const rdst=$.getElementById("required-dry-start-time");
const s=$.getElementById("standard");
const c=$.getElementById("customized");
const tfg=$.getElementById("thickness-for-gm2401");
const rsb=$.getElementById("rudder-stock-bearing");
const rpb=$.getElementById("rudder-pintle-bearing");


function disOpts(selectElement,indexes){
    for(op = 0 ; op < indexes.length; ++op){
        selectElement.options[indexes[op]].disabled = true;
    }
}
function enOpts(selectElement,indexes){
    for(op = 0 ; op < indexes.length; ++op){
        selectElement.options[indexes[op]].disabled = false;
    }
}
