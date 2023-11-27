<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add New Hero</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>

<nav>
    <a href="/">Home</a>
    <a href="/heroes">Hero List</a>
</nav>

<div class="container">
    <h1>Add New Hero</h1>
    <form action="/heroes/new" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>
        <label for="age">Age:</label>
        <input type="number" name="age" required><br>
        <label for="power">Power:</label>
        <input type="text" name="power" required><br>
        <label for="weakness">Weakness:</label>
        <input type="text" name="weakness" required><br>
        <button type="submit">Add Hero</button>
    </form>
    <a href="/heroes">Back to Hero List</a>
</div>

</body>
</html>
