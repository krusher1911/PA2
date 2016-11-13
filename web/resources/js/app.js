var app = angular.module("myModule", []).controller("myController", function ($scope, $http) {

    $scope.onlyNumbers = /^[0-9]+$/;
    
    $scope.status = '  ';
    $scope.customFullscreen = false;
    $scope.toggled = 1;

    $scope.carregarPrincipal = function (limpar) {
        if(limpar){
            $('#dicCaptcha').html('');
        }
        $scope.toggled = 1;
    };
    
    $scope.buscarNota = function(){
        $http({
            method: 'GET',
            url: 'Receita'
        }).then(function success(rs) {
            $('#dicCaptcha').html(rs.data.capt);
            $scope.carregarPrincipal();
            
        }).catch(function(){
            $('#dicCaptcha').html('<div class="alert alert-danger">\n\
                                                                   <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>\n\
                                                                   <center><p><strong>Erro na pesquisa da nota!</strong></p>\n\
                                                                   <p>Verifique sua coneção.</p></center></div>');
        });
    };
    
    $scope.salvarNota= function(){
        $http({
            method: 'POST',
            url: 'posteceita'
        }).then(function success(rs) {
            $scope.carregarPrincipal();
        }).catch(function(){
            $('#dicCaptcha').html('<div class="alert alert-danger">\n\
                                                                   <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>\n\
                                                                   <center><p><strong>Erro na pesquisa da nota!</strong></p>\n\
                                                                   <p>Verifique sua coneção.</p></center></div>');
        });
    }
    
    $scope.carregarNotasFiscais = function (redirect, id) {
        //debugger;
        $http({
            method: 'GET',
            url: 'NotaFiscalController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.notasFiscais = rs.data.notasFiscais;
            if(redirect){
                $scope.toggled = 2;
            }
        });
    };

    $scope.carregarMovimentacoes = function (redirect, id) {
        $http({
            method: 'GET',
            url: 'MovimentacaoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.movimentacoes = rs.data.movimentacoes;
            if (redirect) {
                $scope.toggled = 3;
            }
        });
    };

    $scope.carregarProdutos = function (redirect, id) {
        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.produtos = rs.data.produtos;
            if (redirect) {
                $scope.toggled = 4;
            }
        });
    };

    $scope.carregarCategorias = function (redirect, id) {
        $http({
            method: 'GET',
            url: 'CategoriaController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.categorias = rs.data.categorias;
            if (redirect) {
                $scope.toggled = 5;
            }
        });
    };

    $scope.carregarUnidades = function (redirect, id) {
        $http({
            method: 'GET',
            url: 'UnidadeController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.unidades = rs.data.unidades;
            if (redirect) {
                $scope.toggled = 6;
            }
        });
    };
    
    $scope.carregarEntidades = function (redirect, id) {
        $http({
            method: 'GET',
            url: 'EntidadeController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.entidades = rs.data.entidades;
            if (redirect) {
                $scope.toggled = 7;
            }
        });
    };

    //===INICIO DELETE ITEM===//
    $scope.id = 0;
    $scope.confirmacao = function (id) {
        $scope.id = id;
    };

    $scope.deletarProduto = function () {
        $http({
            method: 'DELETE',
            url: 'ProdutoController',
            params: {id: $scope.id}
        }).then(function sucess(rs) {
            $scope.carregarProdutos(true, '');
        });
    };

    $scope.abrirCadastrarProduto = function () {
        $scope.produto = null;
        $scope.carregarUnidades(false, '');
        $scope.carregarCategorias(false, '');
    };
    
    $scope.cadastrarProduto = function (produto, method, valid) {
        if(valid){
            var data = {
                id: produto.id,
                descricao: produto.descricao,
                unidade: produto.unidade.id,
                permiteFracionar: produto.permiteFracionar,
                tipo: produto.tipo,
                codigoNcm: produto.codigoNcm,
                categoria: produto.categoria.id
            };
            $http({
                method: method,
                url: 'ProdutoController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs){
                $scope.carregarProdutos(true, '');
            });
        }
        else{
            
        }
    };

    $scope.abrirEditarProduto = function (id) {
        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.carregarUnidades(false, '');
            $scope.carregarCategorias(false, '');
            $scope.produto = rs.data.produto;
        });
    };
    
    $scope.editarProduto = function (produto, method,  valid) {
        if(valid){
            var data = {
                id: produto.id,
                descricao: produto.descricao,
                unidade: produto.unidade.id,
                permiteFracionar: produto.permiteFracionar,
                tipo: produto.tipo,
                codigoNcm: produto.codigoNcm,
                categoria: produto.categoria.id
            };
            $http({
                method: method,
                url: 'ProdutoController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs){
                $scope.carregarProdutos(true, '');
            });
        }
        else{
            
        }
    };
    
    //=== MOVIMENTACAO ===//

    $scope.abrirCadastrarMovimentacao = function () {
        $scope.movimentacao = null;
        $scope.carregarProdutos(false, '');
        $scope.carregarUnidades(false, '');
    };

    $scope.cadastrarMovimentacao = function (movimentacao) {
        var data = {
            id: movimentacao.id,
            notaFiscal: movimentacao.notaFiscal,
            produto: movimentacao.produto.id,
            unidade: movimentacao.unidade.id,
            quantidade: movimentacao.quantidade,
            unitario: movimentacao.unitario,
            desconto: movimentacao.desconto,
            total: movimentacao.total
        };
        $http({
            method: 'POST',
            url: 'MovimentacaoController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarMovimentacoes(true, '');
        });
    };

    
    $scope.abrirEditarMovimentacao = function (id) {
        $http({
            method: 'GET',
            url: 'MovimentacaoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.carregarProdutos(false, '');
            $scope.carregarUnidades(false, '');
            $scope.movimentacao = rs.data.movimentacao;
        });
    };

    $scope.editarMovimentacao = function (movimentacao) {
        var data = {
            id: movimentacao.id,
            notaFiscal: movimentacao.notaFiscal,
            produto: movimentacao.produto.id,
            unidade: movimentacao.unidade.id,
            quantidade: movimentacao.quantidade,
            unitario: movimentacao.unitario,
            desconto: movimentacao.desconto,
            total: movimentacao.total
        };
        $http({
            method: 'PUT',
            url: 'MovimentacaoController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarMovimentacoes(true, '');
        });
    };
    
    $scope.deletarMovimentacao = function () {
        $http({
            method: 'DELETE',
            url: 'MovimentacaoController',
            params: {id: $scope.id}
        }).then(function sucess(rs) {
            $scope.carregarMovimentacoes(true, '');
        });
    };
    
    $scope.cacTotal = function(){
        $scope.movimentacao.total = $scope.movimentacao.quantidade * $scope.movimentacao.unitario - $scope.movimentacao.desconto;
        //$('#').val($scope.total);
    };
    
    
    $scope.abrirCadastrarNotaFiscal = function () {
        $scope.notaFiscal = null;
    };

    $scope.cadastrarNotaFiscal = function (notaFiscal) {
        var data = {
            emissao: notaFiscal.emissao,
            valorTotal: notaFiscal.valorTotal,
            entidade: notaFiscal.entidade,
            numero: notaFiscal.numero,
            serie: notaFiscal.serie,
            tipo: notaFiscal.tipo,
            natureza: notaFiscal.natureza
        };
        $http({
            method: 'POST',
            url: 'NotaFiscalController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarNotasFiscais(true, '');
        });
    };
    
    $scope.abrirEditarNotaFiscal = function (id) {
        $http({
            method: 'GET',
            url: 'NotaFiscalController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.notaFiscal = rs.data.notaFiscal;
        });
    };

    $scope.editarNotaFiscal = function (notaFiscal) {
        debugger;
        var data = {
            id: notaFiscal.id,
            emissao: notaFiscal.emissao,
            valorTotal: notaFiscal.valorTotal,
            numero: notaFiscal.numero,
            serie: notaFiscal.serie,
            tipo: notaFiscal.tipo,
            natureza: notaFiscal.natureza,
            entidade: ''
        };
        $http({
            method: 'PUT',
            url: 'NotaFiscalController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarNotasFiscais(true, '');
        });
    }; 
    
    $scope.abrirCadastrarUnidade = function () {
        $scope.unidade = null;
    };

    $scope.cadastrarUnidade = function (unidade) {
        var data = {
            descricao: unidade.descricao,
            sigla: unidade.sigla
        };
        $http({
            method: 'POST',
            url: 'UnidadeController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarUnidades(true, '');
        });
    };
    
    $scope.abrirEditarUnidade = function (id) {
        $http({
            method: 'GET',
            url: 'UnidadeController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.unidade = rs.data.unidade;
        });
    };

    $scope.editarUnidade = function (unidade, method) {
        var data = {
            id: unidade.id,
            descricao: unidade.descricao,
            sigla: unidade.sigla
        };
        $http({
            method: method,
            url: 'UnidadeController',
            data: data,
            headers: {"Content-Type": "application/json;charset=UTF-8"}
        }).then(function success(rs) {
            $scope.carregarUnidades(true, '');
        });
    };
    
    $scope.excluirUnidade = function () {
        $http({
            method: 'DELETE',
            url: 'UnidadeController',
            params: {id: $scope.id}
        }).then(function success(rs) {
            $scope.carregarUnidades(true, '');
        });
    };
    
    //=== CATEGORIA ===//

    $scope.abrirCadastrarCategoria = function () {
        $scope.categoria = null;
    };

    $scope.cadastrarCategoria = function (categoria, valid) {
        if (valid) {
            var data = {
                id: categoria.id,
                nome: categoria.nome
            };
            $http({
                method: 'POST',
                url: 'CategoriaController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs) {
                $scope.carregarCategorias(true, '');
            });
        } else {

        }
    };

    $scope.abrirEditarCategoria = function (id) {
        $http({
            method: 'GET',
            url: 'CategoriaController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.categoria = rs.data.categoria;
        });
    };

    $scope.editarCategoria = function (categoria, valid) {
        if (valid) {
            var data = {
                id: categoria.id,
                nome: categoria.nome
            };
            $http({
                method: 'PUT',
                url: 'CategoriaController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs) {
                $scope.carregarCategorias(true, '');
            });
        } else {

        }
    };

    $scope.deletarCategoria = function () {
        $http({
            method: 'DELETE',
            url: 'CategoriaController',
            params: {id: $scope.id}
        }).then(function sucess(rs) {
            $scope.carregarCategorias(true, '');
        });
    };
    
    //=== ENTIDADE ===//

    $scope.abrirCadastrarEntidade = function () {
        $scope.entidade = null;
    };

    $scope.cadastrarEntidade = function (categoria, valid) {
        if (valid) {
            var data = {
                id: categoria.id,
                nome: categoria.nome
            };
            $http({
                method: 'POST',
                url: 'CategoriaController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs) {
                $scope.carregarCategorias(true, '');
            });
        } else {

        }
    };

    $scope.abrirEditarEntidade = function (id) {
        $http({
            method: 'GET',
            url: 'CategoriaController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.categoria = rs.data.categoria;
        });
    };

    $scope.editarEntidade = function (categoria, valid) {
        if (valid) {
            var data = {
                id: categoria.id,
                nome: categoria.nome
            };
            $http({
                method: 'PUT',
                url: 'CategoriaController',
                data: data,
                headers: {"Content-Type": "application/json;charset=UTF-8"}
            }).then(function success(rs) {
                $scope.carregarCategorias(true, '');
            });
        } else {

        }
    };

    $scope.deletarEntidade = function () {
        $http({
            method: 'DELETE',
            url: 'CategoriaController',
            params: {id: $scope.id}
        }).then(function sucess(rs) {
            $scope.carregarCategorias(true, '');
        });
    };
});
