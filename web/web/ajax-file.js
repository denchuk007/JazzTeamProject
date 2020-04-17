$(document).ready(function() {
    $('#equalsButton').on('click', function() {
        $.ajax({
            url : 'GetUserServlet',
            data : {
                inputValue : $('#inputValue').val(),
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
                $('#inputValue').val('');
            },
            error : function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
                $('#inputValue').val('');
            }
        });
    });

    $('#deleteButton').on('click', function() {
        $('#ajaxGetUserServletResponse').text("");
    });
});