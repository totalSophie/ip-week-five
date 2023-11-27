<!-- resources/templates/squad-view.ftl -->

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Squad Details</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

<nav>
    <a href="/">Home</a>
    <a href="/heroes">Hero List</a>
    <a href="/squads">Squad List</a>
</nav>

<div class="container">
    <h1>Squad Details</h1>
    <h2>${squad.name} (Cause: ${squad.cause}, Max Size: ${squad.maxSize})</h2>

    <h3>Heroes in Squad:</h3>
    <ul>
        <#list squad.heroes as hero>
            <li>${hero.name} (Power: ${hero.power}, Weakness: ${hero.weakness})</li>
        </#list>
    </ul>

    <h3>Add Hero to Squad:</h3>
    <form action="/squads/${squad.id}/add-hero" method="post">
        <label for="heroId">Hero ID:</label>
        <input type="number" name="heroId" required><br>
        <button type="submit">Add Hero</button>
    </form>

    <h3>Remove Hero from Squad:</h3>
    <form action="/squads/${squad.id}/remove-hero" method="post">
        <label for="heroId">Hero ID:</label>
        <input type="number" name="heroId" required><br>
        <button type="submit">Remove Hero</button>
    </form>

    <h3>Battle Opponent Squad:</h3>
    <form action="/squads/${squad.id}/battle" method="post">
        <label for="opponentId">Opponent Squad ID:</label>
        <input type="number" name="opponentId" required><br>
        <button type="submit">Battle</button>
    </form>

    <a href="/squads">Back to Squad List</a>
</div>

</body>
</html>
