var app = angular.module("myModule", []).controller("myController", function($scope, $http ){
    
    $scope.status = '  ';
    $scope.customFullscreen = false;
    
    $scope.toggled=1;
    $scope.togglePri=function(){
        $scope.toggled=1;
    };
    
    //===INICIO TAB MOVIMENTAÇÕES===//
    $scope.toggleMov=function(){
        $scope.toggled=2;
    };
    //===========FIM==========//
    
    //===INICIO TAB PRODUTOS===//
    $scope.togglePro=function(){
        $http({
            method : 'GET',    
            url: 'ProdutoController',
            params: {id: ''}
        }).then(function success(rs) {
            $scope.produtos = rs.data.produtos;
            $scope.toggled=3;
        });
    };
    //===========FIM==========//
    
    //===INICIO DELETE ITEM===//
    $scope.idDel = 0;
    $scope.confirmDel = function(id){
        $scope.idDel = id;
    };
    
    $scope.del = function(confirm){
        if(confirm === 'true'){
            $http({
                method : 'POST',    
                url: 'ProdutoController',
                params: {id:$scope.idDel, del:'true'}
            }).then(function sucess(rs){
                $scope.togglePro();
            });
        }
    };
    //===========FIM==========//
    
    $scope.carregarSelect = function () {
        $http({
            method: 'GET',
            url: 'UnidadeController'
        }).then(function success(rs) {
            $scope.unidades = rs.data;
        });
        $http({
            method: 'GET',
            url: 'CategoriaController'
        }).then(function success(rs) {
            $scope.categorias = rs.data;
        });
    };

    $scope.abrirCadastrarProduto = function () {
        $scope.produto = null;
        $scope.carregarSelect();
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

    $scope.abrirEditarProduto = function (id) {

        $http({
            method: 'GET',
            url: 'ProdutoController',
            params: {id: id}
        }).then(function success(rs) {
            $scope.carregarSelect();
            $scope.produto = rs.data.produto;
            $('#modalEditar').modal('show');
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
});
