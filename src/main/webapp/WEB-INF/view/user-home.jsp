<%--
  Created by IntelliJ IDEA.
  User: JebanyDis
  Date: 25.08.2020
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../resources/css/global.css">
    <title>User - home</title>

</head>
<body>

<header class="notice">Welcome ${id}</header>
<nav>

    <ul class="horizontal-list">
        <li><input class="button" type="submit" value="Calculations"/></li>
        <li><input class="button" type="submit" value="Account"/></li>
    </ul>



</nav>
<section class="form-container" id="calculator">


    <form action="${pageContext.request.contextPath}/user/calculate" method="post">


        <label for="type-of-service">Type of Service</label></th>
        <select name="type-of-service" id="type-of-service">
            <option value="marine-propeller-shaft">Marine propeller shaft</option>
            <option value="rudder-thordon-standard">Rudder - Thordon Standard</option>
            <option value="rudder-with-1.5-mm-mic">Rudder - With 1.5 mm MIC</option>
            <option value="hydro-wicket-gate-&-linkage-bearings">Hydro Wicket Gate & Linkage Bearings</option>
            <option value="vertical-turbine-guide-bearing">Vertical Turbine Guide Bearing</option>
            <option value="horizontal-turbine-guide-bearing">Horizontal Turbine Guide Bearing</option>
            <option value="ind.-vertical-pump">Ind. Vertical Pump</option>
            <option value="ind.-vertical-pump-dry-shaft">Ind. Vertical Pump - Dry Shaft</option>
            <option value="ind.-other-full-rotation">Ind. Other Full Rotation</option>
            <option value="ind.-oscillating-rotation">Ind. Oscillating Rotation</option>

        </select>
        <br>

        <label for="grade-of-thordon">Grade of Thordon</label>
        <select name="grade-of-thordon" id="grade-of-thordon">
            <option value="sxl">SXL</option>
            <option value="compac">Compac</option>
            <option value="river-tough">River Tough</option>
            <option value="gm2401-in-metal-carrier">GM2401 in Metal Carrier</option>
            <option value="xl">XL</option>
            <option value="composite">Composite</option>
            <option value="gm2401">GM2401</option>
        </select>
        <br>

        <label for="type-of-lubrication">Type of Lubrication</label>
        <select name="type-of-lubrication" id="type-of-lubrication">
            <option value="water">Water</option>
            <option value="dry">Dry</option>
            <option value="grease">Grease</option>
        </select>
        <br>

        <label for="type-of-installation">Type of Installation</label>
        <select name="type-of-installation" id="type-of-installation">
            <option value="interference-freeze-fit">Interference Freeze Fit</option>
            <option value="interference-press-fit">Interference Press Fir</option>
            <option value="bonded">Bonded</option>
            <option value="staxl-staves">STAXL Staves</option>
            <option value="dovetail-staves-standard">Dovetail Staves - Standard</option>
            <option value="dovetail-staves-custom">Dovetail Staves - Custom</option>
        </select>
        <br>


        <label for="grooved-bearing-style">Grooved Berading Style</label>
        <select name="grooved-bearing-style" id="grooved-bearing-style">
            <option value="grooved">Grooved</option>
            <option value="none">None</option>
        </select>
        <br>

        <label for="bonding-agent">Bonding Agent</label>
        <select name="bonding-agent" id="bonding-agent">
            <option value="tg-75">TG-75</option>
            <option value="chocking-compound">Chocking Compound</option>
            <option value="other">Other</option>
        </select>
        <br>

        <label for="bonding-agent-film-thickness">Bonding Agent Film Thickness</label>
        <input type="text" name="bonding-agent-film-thickness" id="bonding-agent-film-thickness">
        <br>

        <label for="type-of-staxl">Type of staxl</label>
        <select name="type-of-staxl" id="type-of-staxl">
            <option name="a42">A42</option>
        </select>
        <br>

        <label for="number-of-keepers">Number of Keepers</label>
        <input type="text" name="number-of-keepers" id="number-of-keepers">
        <br>

        <label for="total-width-of-keepers">Total Width of Keepers</label>
        <input type="text" name="total-width-of-keepers" id="total-width-of-keepers">
        <br>

        <label for="temperature-scale">Temperature Scale</label>
        <select name="temperature-scale" id="temperature-scale">
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
        </select>
        <br>

        <label for="maximum-operating-temperature">Maximum Operating Temperature</label>
        <input type="text" name="maximum-operating-temperature" id="maximum-operating-temperature">
        <br>

        <label for="minimum-operating-temperature">Minimum Operating Temperature</label>
        <input type="text" name="minimum-operating-temperature" id="minimum-operating-temperature">
        <br>

        <label for="machine-shop-ambient-temperature">Machine Shop Ambient Temperature</label>
        <input type="text" name="machine-shop-ambient-temperature" id="machine-shop-ambient-temperature">
        <br>

        <label for="pdt">Provide Default Temperature</label>
        <input type="checkbox" id="pdt" name="pdt" value="pdt">
        <br>

        <label for="dimension-scale">Dimension Scale</label>
        <select name="dimension-scale" id="dimension-scale">
            <option value="metric-(mm)">Metric (mm)</option>
            <option value="imperial-(in)">Imperial (in)</option>
        </select>
        <br>


        <label for="smrhd">Suggested Minimum Required Housing Diameter</label>
        <input type="checkbox" id="smrhd" name="smrhd" value="smrhd">
        <br>

        <label for="maximum-shaft-diameter">Maximum Shaft Diameter</label>
        <input type="text" name="maximum-shaft-diameter" id="maximum-shaft-diameter">
        <br>

        <label for="maximum-housing-diameter">Maximum Housing Diameter</label>
        <input type="text" name="maximum-housing-diameter" id="maximum-housing-diameter">
        <br>

        <label for="minimum-housing-diameter">Minimum Housing Diameter</label>
        <input type="text" name="minimum-housing-diameter" id="minimum-housing-diameter">
        <br>

        <label for="housing-length">Housing Length</label>
        <input type="text" name="housing-length" id="housing-length">
        <br>

        <label for="load-on-bearing">Load on Bearing</label>
        <input type="text" name="load-on-bearing" id="load-on-bearing">
        <br>

        <label for="shaft-speed-(RPM)">Shaft Speed (RPM)</label>
        <input type="text" name="shaft-speed-(RPM)" id="shaft-speed-(RPM)">
        <br>

        <label for="required-dry-start-time">Required Dry Start Time</label>
        <input type="text" name="required-dry-start-time" id="required-dry-start-time">
        <br>

        <div>GM2401 Thiccness of Compositer</div>
        <label for="standard">Standard</label>
        <input type="checkbox" id="standard" name="standard" value="standard">
        <br>

        <label for="customized">Customized</label>
        <input type="checkbox" id="customized" name="customized" value="customized">
        <br>

        <label for="thickness-for-gm2401">Thickness for GM2401</label>
        <input type="text" id="thickness-for-gm2401" name="thickness-for-gm2401">
        <br>

        <div>Rudder Bearing Default Temperature</div>
        <label for="rudder-stock-bearing">Rudder Stock Bearing</label>
        <input type="checkbox" id="rudder-stock-bearing" name="rudder-stock-bearing" value="rudder-stock-bearing">
        <br>

        <label for="rudder-pintle-bearing">Rudder Pintle Bearing</label>
        <input type="checkbox" id="rudder-pintle-bearing" name="rudder-pintle-bearing" value="rudder-pintle-bearing">
        <br>

    </form>

</section>

</body>
</html>
