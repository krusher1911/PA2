var app = angular.module("myModule", []).controller("myController", function($scope, $http){
    
    $scope.toggled=1;
    $scope.togglePri=function(){
        $scope.toggled=1;
    }
    
    $scope.toggleMov=function(){
        $scope.toggled=2;
    }

    $scope.togglePro=function(){
        $http({
            method : 'GET',    
            url: 'ProdutoController',
            params: {id: ''}
        }).then(function sucess(rs) {
            $scope.produtos = rs.data.produtos;
        });
        $scope.toggled=3;
    }

    $scope.carregarSelect = function () {
        $http({
            method: 'GET',
            url: 'UnidadeController'
        }).then(function sucess(rs) {
            $scope.unidades = rs.data;
        });
        $http({
            method: 'GET',
            url: 'CategoriaController'
        }).then(function sucess(rs) {
            $scope.categorias = rs.data;
        });
}

    $scope.abrirCadastrarProduto = function () {
        $scope.produto = null;
        $scope.carregarSelect();
        $('#modalCadastrar').modal('show');
    }

    $scope.abrirEditarProduto = function (id) {

        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function sucess(rs) {
            $scope.carregarSelect();
            $scope.produto = rs.data.produto;
            $('#modalEditar').modal('show');
        });
    }

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
        }).then(function (rs) {
            if (method == 'PUT') {
                alert("Put Data Method Executed Successfully!");
                $('#modalEditar').modal('hide');
            } else {
                $('#modalCadastrar').modal('hide');
            }
            $scope.togglePro();
        });
    }










});