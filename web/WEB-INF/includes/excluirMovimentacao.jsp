<div class="modal fade" id="modalRemoverMovimentacao" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <center><h4 class="modal-title">Excluir Movimentação</h4></center>
            </div>
            <div class="modal-body">
                <center><h5><strong>Deseja realmente excluir esta movimentação?</strong></h5></center>
            </div>
            <div class="modal-footer">
                <center>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
                    <button type="submit" class="btn btn-primary" ng-click="deletarMovimentacao()" data-dismiss="modal">Sim</button>
                </center>
            </div>
        </div>
    </div>
</div>