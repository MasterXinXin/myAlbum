<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
</head>
<body>
FreeMarker模板引擎
<h1>${HELLO[2]}!</h1>
<h1>${HELLO[0..3]}</h1>
<h1>
    <#list LIST_A + LIST_B as x>
        ${x}
    </#list>
</h1>
<h1>${"hello"+USER.name}</h1>
</body>
</html>
