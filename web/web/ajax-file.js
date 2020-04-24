$(document).ready(function() {
    $('#equalsButton').on('click', function() {
        $.ajax({
            url : 'GetUserServlet',
            data : {
                inputValue : $('#inputValue').val(),
            },
            success : function(responseText) {
                $('#inputValue').val(responseText);
            },
            error : function (responseText) {
                $('#inputValue').val(responseText);
            }
        });
    });


    $('#deleteButton').on('click', function() {
        $('#ajaxGetUserServletResponse').text("");
    });
});