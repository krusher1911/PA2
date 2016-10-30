window.setTimeout(function(){
    $(".alert").fadeTo(7000, 0).slideUp(1000, function(){
       $(this).remove(); 
    });
});
