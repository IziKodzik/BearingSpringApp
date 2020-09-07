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
                    <option value="hydro-wicket-gate-&-linkage=bearings">Hydro Wicket Gate & Linkage Bearings</option>
                </select>
                <br>
                <label for="grade-of-thordon">Grade of Thordon</label>
                <select name="grade-of-thordon" id="grade-of-thordon">
                    <option value="sxl">SXL</option>
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

                <input type="submit" value="Submit">
            </form>


        </section>

</body>
</html>
