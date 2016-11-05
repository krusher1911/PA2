/*
 * jQuery JavaScript Library - http://jquery.com/download/
 */

function abrirModalEditar(id) {
    $('#modalEditar').modal('show');
    carregarSelect('#modalEditar #unidades', '#modalEditar #categorias');
    $.ajax({
        url: 'ProdutoController?codigo=' + id,
        type: 'GET',
        dataType: 'json',
        async: false,
        data: {id: id},
//        statusCode: {
//            404: function () {
//                console.log('Página ProdutoController não encontrada.');
//            },
//            500: function () {
//                console.log('Erro no servidor - ProdutoController');
//            }
//    },
        success: function (rs) {
            $('#modalEditar #inputId').val(rs.produto.id);
            $('#modalEditar #inputDescricao').val(rs.produto.descricao);
            $('#modalEditar #selectUnidades option[value="' + rs.produto.unidade.id + '"]').prop("selected", true);
            $('#' + rs.produto.permiteFracionar).prop('checked', true);
            $('#modalEditar #inputTipo').val(rs.produto.tipo);
            $('#modalEditar #inputCodigoNcm').val(rs.produto.codigoNcm);
            $('#modalEditar #selectCategorias option[value="' + rs.produto.categoria.id + '"]').prop("selected", true);
        }
    });
}

function carregarSelect(unidades, categorias) {
    $('select option').remove();
    $.ajax({
        url: 'UnidadeController',
        type: 'GET',
        async: false,
        statusCode: {
            404: function () {
                console.log('Página UnidadeController não encontrada.');
            },
            500: function () {
                console.log('Erro no servidor - UnidadeController');
            }
        },
        success: function (rs) {
            $(unidades).append($('<option>', {value: "", text: ""}));
            $.each(rs, function (id, unidade) {
                $(unidades).append($('<option>', {value: unidade.id, text: unidade.sigla}));
            });
        }
    });

    $.ajax({
        url: 'CategoriaController',
        type: 'GET',
        async: false,
        statusCode: {
            404: function () {
                console.log('Página CategoriaController não encontrada .');
            },
            500: function () {
                console.log('Erro no servidor - CategoriaController');
            }
        },
        success: function (rs) {
            $(categorias).append($('<option>', {value: "", text: ""}));
            $.each(rs, function (id, categoria) {
                $(categorias).append($('<option>', {value: categoria.id, text: categoria.nome}));
            });
        }
    });
}

$(document).ready(function () {

    $('#contentProduto').ready(function () {
        $.ajax({
            url: 'ProdutoController',
            type: 'GET',
            async: false,
            data: {id: ""},
            statusCode: {
                404: function () {
                    console.log('Página ProdutoController não encontrada.');
                },
                500: function () {
                    console.log('Erro no servidor - ProdutoController');
                }
            },
            success: function (data) {
//                //if (data.isValid) {
//                    $('#principal').removeClass('in');
//                    $('#principal').removeClass('active');
//                    $('#menuPrincipal').removeClass('active');
//
//                    $('#movimentacoes').removeClass('in');
//                    $('#movimentacoes').removeClass('active');
//                    $('#menuMovimentacoes').removeClass('active');
//
//                    $('#produtos').addClass('in');
//                    $('#produtos').addClass('active');
//                    $('#menuProdutos').addClass('active');
//                    
//                    $("#produtos").load("contentProduto.jsp");
//                //} else {
//                    //alert('Não há produtos cadastrados.');
//                //}
            } 
        });
    });


});
