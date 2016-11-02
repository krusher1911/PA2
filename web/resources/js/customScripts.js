$('#loginEntrar').click(function() {
    $('form').submit(); 
});
$(function(){
    $(".grid").loadGrid();
});

$(function () {

    $.ajax({
        type: "GET",
        url: "/JsGridEx/ManageCars"
    }).done(function () {

        $("#jsGrid").jsGrid({
            height: "60%",
            width: "50%",
            inserting: true,
            editing: true,
            sorting: true,
            paging: true,
            autoload: true,
            pageSize: 10,
            controller: {
                loadData: function (filter) {
                    return $.ajax({
                        type: "GET",
                        url: "/JsGridEx/ManageCars",
                        data: filter
                    });
                },
                insertItem: function (item) {
                    return $.ajax({
                        type: "POST",
                        url: "/JsGridEx/ManageCars",
                        data: item
                    });
                },
                updateItem: function (item) {
                    return $.ajax({
                        type: "PUT",
                        url: "/JsGridEx/ManageCars",
                        data: item
                    });
                },
                deleteItem: function (item) {
                    return $.ajax({
                        type: "DELETE",
                        url: "/JsGridEx/ManageCars",
                        data: item
                    });
                }
            },
            fields: [
                {name: "NAME", title: "Name", type: "text", width: 60},
                {name: "PRICE", title: "Price", type: "text",  width: 50},
                {type: "control"}
            ]
        });

    });
});
