<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Calculator</title>

    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="ajax-file.js" type="text/javascript"></script>
</head>
<style>
    .wrapper {
        margin: 0 auto;
        width: 250px;
    }

    .buttons input {
        margin: 0 auto;
        overflow: hidden;
        width: 50px;
        height: 50px;
        border-radius: 5px;
        font-size: 24px;
    }
</style>
<body>
<form name="calc" class="wrapper">
    <table class="main">
        <tr>
            <td colspan="3"><input type="text" name="display" id="inputValue"></td>
        </tr>

        <tr class="buttons">
            <td><input type="button" value="1" OnClick="display.value += 1"></td>
            <td><input type="button" value="2" OnClick="display.value += 2"></td>
            <td><input type="button" value="3" OnClick="display.value += 3"></td>
            <td><input type="button" value="+" OnClick="display.value += '+'"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="4" OnClick="display.value += 4"></td>
            <td><input type="button" value="5" OnClick="display.value += 5"></td>
            <td><input type="button" value="6" OnClick="display.value += 6"></td>
            <td><input type="button" value="-" OnClick="display.value += '-'"></td>
        </tr>
        <tr class="buttons">
            <td><input type="button" value="7" OnClick="display.value += 7"></td>
            <td><input type="button" value="8" OnClick="display.value += 8"></td>
            <td><input type="button" value="9" OnClick="display.value += 9"></td>
            <td><input type="button" value="x" OnClick="display.value += 'x'"></td>
        </tr>
        <tr class="buttons">
            <td><input type="reset" value="c" OnClick="display.value += ''" id="deleteButton"></td>
            <td><input type="button" value="0" OnClick="display.value += 0"></td>
            <td><input type="button" value="=" OnClick="" id="equalsButton"></td>
            <td><input type="button" value="/" OnClick="display.value += '/'"></td>
        </tr>
    </table>
</form>
</body>
</html>
