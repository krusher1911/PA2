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
            url: 'ProdutoController'
        }).then(function sucess(data) {
            $scope.produtos = data;
        });
        $scope.toggled=3;
    }
});