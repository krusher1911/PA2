var app = angular.module("myModule", []).controller("myController", function($scope, $http ){
    
    $scope.status = '  ';
    $scope.customFullscreen = false;
    
    $scope.toggled=1;
    $scope.togglePri=function(){
        $scope.toggled=1;
    }
    
    //===INICIO TAB MOVIMENTAÇÕES===//
    $scope.toggleMov=function(){
        $scope.toggled=2;
    }
    //===========FIM==========//
    
    //===INICIO TAB PRODUTOS===//
    $scope.togglePro=function(){
        $http({
            method : 'GET',    
            url: 'ProdutoController',
            params: {id:""}
        }).then(function sucess(data) {
            $scope.produtos = data;
        });
        $scope.toggled=3;
    }
    //===========FIM==========//
    
    //===INICIO DELETE ITEM===//
    $scope.idDel = 0;
    $scope.confirmDel = function(id){
        $scope.idDel = id;
    }
    $scope.del = function(confirm){
        if(confirm === 'true'){
            $http({
                method : 'POST',    
                url: 'ProdutoController',
                params: {id:$scope.idDel, del:'true'}
            });
            $scope.togglePro();
        }
    }
    //===========FIM==========//
});