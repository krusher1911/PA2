<div ng-controller="myController" id="principal" class="panel panel-primary">
    <div class="panel panel-heading">
        <p class="panel-title" align="center"><strong>Principal</strong></p>
    </div>
    <div class="panel-body">
        <div class="row" ng-init="buscarNota()" >
            <!--<form class="form-horizontal col-lg-3 col-lg-offset-1" name="form_coletor" action="Receita" method="POST">
                <p class="centro"><a class="btn btn-primary" type="submit" name="botao" ng-click="buscarNota()">Pesquisar</a></p>
            </form>-->
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3" id="dicCaptcha">
                ${messageError}
            </div>
        </div>
    </div>
</div>