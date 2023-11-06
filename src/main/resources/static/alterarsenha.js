$("#enviar").click(salvarSenha);

function salvarSenha(){
    let senhaAtual = $("#senhaAtual").val();
    let novaSenha = $("#novaSenha").val();
    let confSenha = $("#confSenha").val();

    $.ajax({
        type: "POST",
        url: "/ alterarsenha",
        data:{
            senhaAtual:senhaAtual,
            novaSenha:novaSenha,
            confSenha:confSenha
        },
        success: function(data){
            if(data.sucesso){
                alertaSucesso("Alterado com sucesso!");
            }else{
                alert(data.mensagem);
            }
        },
        error: function(){
            alert("Deu ruim");
        }
    })
}