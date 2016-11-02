/*
 * jQuery JavaScript Library - http://jquery.com/download/
 */

$(document).ready(function () {
    $('#menuProdutos').click(function () {
        $.ajax({
            url: 'ProdutoController',
            type: 'GET',
            async: false,
//            statusCode: {
//                404: function () {
//                    alert('Página não encontrada.');
//                },
//                500: function () {
//                    alert('Erro no servidor.');
//                }
//            },
            success: function (data) {
                if (data.isValid) {
                    $('#principal').removeClass('in');
                    $('#principal').removeClass('active');
                    $('#menuPrincipal').removeClass('active');

                    $('#movimentacoes').removeClass('in');
                    $('#movimentacoes').removeClass('active');
                    $('#menuMovimentacoes').removeClass('active');

                    $('#produtos').addClass('in');
                    $('#produtos').addClass('active');
                    $('#menuProdutos').addClass('active');
                } else {
                    alert('Não há produtos cadastrados.');
                }
            }
        });
    });

    $('#cadastrarProduto').click(function () {
        $.ajax({
            url: 'CategoriaController',
            type: 'GET',
            async: false,
            statusCode: {
                404: function () {
                    alert('Página não encontrada.');
                },
                500: function () {
                    alert('Erro no servidor.');
                }
            },
            success: function (data) {
                $.each(data, function (id, categoria) {
                    $('#categorias').append($('<option>', {value: categoria.id, text: categoria.nome}));
                });
            }
        });
        $.ajax({
            url: 'UnidadeController',
            type: 'GET',
            async: false,
            statusCode: {
                404: function () {
                    alert('Página não encontrada.');
                },
                500: function () {
                    alert('Erro no servidor.');
                }
            },
            success: function (data) {
                $.each(data, function (id, unidade) {
                    $('#unidades').append($('<option>', {value: unidade.id, text: unidade.sigla}));
                });
            }
        });
    });
});