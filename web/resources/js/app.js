var app = angular.module("myModule", []).controller("myController", function ($scope, $http) {

    $scope.status = '  ';
    $scope.customFullscreen = false;

    $scope.toggled = 1;
    $scope.togglePri = function () {
        $scope.toggled = 1;
    };

    //===INICIO TAB MOVIMENTAÇÕES===//
    $scope.toggleMov = function () {
        $http({
            method: 'GET',
            url: 'MovimentacaoController',
            params: {id: ''}
        }).then(function success(rs) {
            $scope.movimentacoes = rs.data.movimentacoes;
            $scope.toggled = 2;
        });
    };
    //===========FIM==========//

    //===INICIO TAB PRODUTOS===//
    $scope.togglePro = function () {
        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: ''}
        }).then(function success(rs) {
            $scope.produtos = rs.data.produtos;
            $scope.toggled = 3;
        });
    };
    //===========FIM==========//


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
            $scope.togglePro();
        });
    };
    //===========FIM==========//
    $scope.carregarUnidades = function (redirect) {
        $http({
            method: 'GET',
            url: 'UnidadeController'
        }).then(function success(rs) {
            $scope.unidades = rs.data;
            if(redirect){
                $scope.toggled = 5;
            }
        });
    };

    $scope.carregarCategorias = function (redirect) {
        $http({
            method: 'GET',
            url: 'CategoriaController'
        }).then(function success(rs) {
            $scope.categorias = rs.data;
            if(redirect){
                $scope.toggled = 4;
            }
        });
    };

    $scope.abrirCadastrarProduto = function () {
        $scope.produto = null;
        $scope.carregarUnidades();
        $scope.carregarCategorias();
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
                $scope.togglePro();
            });
        }
        else{
            
        }
    };

    $scope.cadastrarProduto = function (produto, method) {
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
        }).then(function success(rs) {
            $scope.togglePro();
        });
    };

    $scope.abrirEditarProduto = function (id) {

        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.carregarUnidades();
            $scope.carregarCategorias();
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
                $scope.togglePro();
            });
        }
        else{
            
        }
    };
    
    $scope.editarProduto = function (produto, method) {
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
        }).then(function success(rs) {
            $scope.togglePro();
        });
    };

    //=== MOVIMENTACAO ===//

    $scope.carregarProdutos = function (id) {
        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.produtos = rs.data.produtos;
        });
    };

    $scope.carregarNotasFiscais = function () {
        $http({
            method: 'GET',
            url: 'NotaFiscalController'
        }).then(function success(rs) {
            $scope.notasFiscais = rs.data;
        });
    };

    $scope.abrirCadastrarMovimentacao = function () {
        $scope.movimentacao = null;
//        $scope.carregarNotasFiscais();
        $scope.carregarProdutos('');
        $scope.carregarUnidades();
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
            $scope.toggleMov();
        });
    };

    $scope.abrirEditarrMovimentacao = function () {
        $scope.movimentacao = null;
        $scope.carregarUnidades();
        $scope.carregarProdutos('');
//        $scope.carregarNotasFiscais();
        $('#modalEditarMovimentacao').modal('show');
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
            $scope.toggleMov();
        });
    };
})

