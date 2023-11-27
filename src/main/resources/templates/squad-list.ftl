<!DOCTYPE html>
<html lang="en">
<head>
    <title>Squad List</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

<nav>
    <a href="/">Home</a>
    <a href="/heroes">Hero List</a>
    <a href="/squads">Squad List</a>
</nav>

<div class="container">
    <h1>Squad List</h1>
    <ul>
        <#list squads as squad>
            <li>${squad.name} (Cause: ${squad.cause}, Max Size: ${squad.maxSize})</li>
        </#list>
    </ul>
    <a href="/squads/new">Create New Squad</a>
</div>

</body>
</html>
