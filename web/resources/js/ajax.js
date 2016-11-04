/*
 * jQuery JavaScript Library - http://jquery.com/download/
 */

$(document).ready(function () {
    $('#menuProdutos').click(function () {
        $.ajax({
            url: 'ProdutoController',
            type: 'GET',
            async: false,
            statusCode: {
                404: function () {
                    console.log('Página ProdutoController não encontrada.');
                },
                500: function () {
                    console.log('Erro no servidor - ProdutoController');
                }
            },
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
            success: function (data) {

                $('#unidades').append($('<option>', {value: "", text: ""}));
                $.each(data, function (id, unidade) {
                    $('#unidades').append($('<option>', {value: unidade.id, text: unidade.sigla}));
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
            success: function (data) {

                $('#categorias').append($('<option>', {value: "", text: ""}));
                $.each(data, function (id, categoria) {
                    $('#categorias').append($('<option>', {value: categoria.id, text: categoria.nome}));
                });
            }
        });
    });
});