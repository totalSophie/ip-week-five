<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create New Squad</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

<nav>
    <a href="/">Home</a>
    <a href="/heroes">Hero List</a>
    <a href="/squads">Squad List</a>
</nav>

<div class="container">
    <h1>Create New Squad</h1>
    <form action="/squads/new" method="post">
        <label for="squadName">Squad Name:</label>
        <input type="text" name="squadName" required><br>
        <label for="cause">Cause:</label>
        <input type="text" name="cause" required><br>
        <label for="maxSize">Max Size:</label>
        <input type="number" name="maxSize" required><br>
        <button type="submit">Create Squad</button>
    </form>
    <a href="/squads">Back to Squad List</a>
</div>

</body>
</html>
