<!-- hero-list.ftl -->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hero List</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

<nav>
    <a href="/">Home</a>
    <a href="/heroes">Hero List</a>
</nav>

<div class="container">
    <h1>Hero List</h1>
    <ul>
        <#list heroes as hero>
            <li>${hero.name} (Power: ${hero.power}, Weakness: ${hero.weakness})</li>
        </#list>
    </ul>
    <a href="/heroes/new">Add New Hero</a>
</div>

</body>
</html>
