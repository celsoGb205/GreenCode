function salvarSenha(){
    let senhaAtual = $("#senhaAtual").val();
    let novaSenha = $("#novaSenha").val();
    let confSenha = $("#confSenha").val();

    $.ajax({
        type: "POST",
        url: "/alterarsenha",
        data:{
            senhaAtual:senhaAtual,
            novaSenha:novaSenha,
            confSenha:confSenha
        },
        success: function(data){
            if(data.sucesso){
                alert("Alterado com sucesso!");
            }else{
                alert("Deu ruim");
            }
        },
        error: function(){
            alert("Deu ruim");
        }
    });
}