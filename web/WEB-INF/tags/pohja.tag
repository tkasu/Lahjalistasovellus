

<%@tag description="put the tag description here" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@attribute name="pageTitle"%>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="./css/bootstrap.css" rel="stylesheet">
	<link href="./css/bootstrap-theme.css" rel="stylesheet">
	<link href="./css/main.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="./js/bootstrap.js"></script>
        
        <title>${pageTitle}</title>
    </head>
    
    <body>
        <div>
            <jsp:doBody/>
        </div>
        
    </body>
            
