<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src='<c:url value="/js/springxt.js"/>'></script>
        <title>Spring Modules XT Ajax Framework : Example 1</title>
        <link href='<c:url value="/springxt.css"/>' rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="titleBar"></div>
        <h1>Spring Modules XT Framework</h1>
        <h3 align="center">Test page updating actions ...</h3>
        <p>
            This example gives you a taste of ajax updating actions.
        </p>
        <form name="" action="">
            <table>
                <tr>
                    <td>Press to append a random number :</td>
                    <td><input type="button" value="Press" onclick="javascript:doAjaxAction('appendNumber', this);"></td>
                </tr>
                <tr>
                    <td id="num" colspan="2"></td>
                </tr>
                <tr>
                    <td>Press to replace all numbers above with a single number :</td>
                    <td><input type="button" value="Press" onclick="javascript:doAjaxAction('replaceNumbers', this);"></td>
                </tr>
                <tr>
                    <td>Press to remove all numbers above :</td>
                    <td><input type="button" value="Press" onclick="javascript:doAjaxAction('removeNumbers', this);"></td>
                </tr>
                <tr>
                    <td>Press to replace the text below, sorrounded by a <i>span</i> element, with an input field :</td>
                    <td><input type="button" value="Press" onclick="javascript:doAjaxAction('replaceElement', this);"></td>
                </tr>
                <tr>
                    <td colspan="2"><span id="toReplace" style="color: red;">Text to be replaced</span></td>
                </tr>
                <tr>
                    <td>Press to remove the text below, sorrouned by a <i>span</i> element :</td>
                    <td><input type="button" value="Press" onclick="javascript:doAjaxAction('removeElement', this);"></td>
                </tr>
                <tr>
                    <td colspan="2"><span id="toRemove" style="color: red;">Text to be removed</span></td>
                </tr>
            </table>
        </form>
    </body>
</html>