function disableLink(){
  $('a').click(function(event){
    event.preventDefault();
    if(!$(this).hasClass('btn')){
      $('a').removeClass('active disabled');
      $(this).addClass('active disabled');
    }
    controleRotasGet($(this).attr("href"));
  });
}

disableLink();

$('.navbar-brand').off('click');

function controleRotasGet(url){

  if(url == "/logout"){
    gerarSwal(url);

  }else if(url == "/coleta"){
    $.get(url,function(data){
      $(".container").html(data);
      $("#enviar").click(criarColeta);

    });
  }else if(url == "/alterarsenha"){
           $.get(url,function(data){
             $(".container").html(data);
             $("#alterar").click(salvarSenha);
           });


  }else if(url == "/Home"){
    $.get(url,function(data){
      $(".container").html(data);
      disableLink();
    });
  }else if(url == "/busca"){
    $.get(url,function(data){
      $(".container").html(data);
    });
  }else if(url == "/editarponto"){
    $.get(url,function(data){
        $(".container").html(data);
    });
  }else if(url == "/ponto_coleta"){
    $.get(url,function(data){
      $(".container").html(data);
      disableLink();
      $("#searchWasteType").keyup(function(){
        const wasteTypeQuery = $(this).val().toLowerCase().trim();
        const cityQuery = $("#searchCity").val().toLowerCase().trim();

        $(".col-4.mb-5").each(function() {
          const cidade = $(this).find(".cursive[data-label='cidade']").text().toLowerCase();
          const tipoLixo = $(this).find(".cursive[data-label='tipo_lixo']").text().toLowerCase();

          if (cidade.includes(cityQuery) && tipoLixo.includes(wasteTypeQuery)) {
            $(this).show();
          } else {
            $(this).hide();
          }
        });
      });


      $("#searchCity").keyup(function(){
       const cityQuery = $(this).val().toLowerCase().trim();
       const wasteTypeQuery = $("#searchWasteType").val().toLowerCase().trim();

       $(".col-4.mb-5").each(function() {
         const cidade = $(this).find(".cursive[data-label='cidade']").text().toLowerCase();
         const tipoLixo = $(this).find(".cursive[data-label='tipo_lixo']").text().toLowerCase();

         if (cidade.includes(cityQuery) && tipoLixo.includes(wasteTypeQuery)) {
           $(this).show();
         } else {
           $(this).hide();
         }
       });
     });
      $("#btncheck1").change(function(){
        if($("#btncheck1").prop("checked")){
          $(".oto").hide();
        }else{
          $(".oto").show();
        }
      });
    });

  }
  else if(url.startsWith("/excluir")){
    let id = url.replace("/excluir/","");
    excluirDado(url,id);
  }
   else if(url.startsWith("/solicitar")){
      let id = url.replace("/solicitar/","");
      solicitarDados(url,id);
    }
}


function excluirDado(url,id){
  Swal.fire({
    title: "Você tem certeza?",
    text: "Você deseja excluir esse ponto?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Sim"
  }).then((result) => {
    if (result.isConfirmed) {
        Swal.fire({
              title: "Deletado!",
              text: "Você deletou esse ponto.",
              icon: "success"
            });
            excluirPonto(id);
    }

  });
}
function gerarSwal(urlSucesso){
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success me-2',
      cancelButton: 'btn btn-danger ms-2'
    },
    buttonsStyling: false
  })

  swalWithBootstrapButtons.fire({
    title: 'Sair?',
    text: "Você realmente deseja sair da aplicação?",
    icon: 'question',
    showCancelButton: true,
    confirmButtonText: '<i class="fa-solid fa-thumbs-up"></i> Sim!',
    cancelButtonText: '<i class="fa-solid fa-thumbs-down"></i> Não!',
    reverseButtons: false
  }).then((result) => {
    if (result.isConfirmed) {
      window.location.href=urlSucesso;
    }
  });
}
function excluirPonto(id){
  $.ajax({
    type: "POST",
    url: "/deletar",
    data:{
        id:id
    },
    success:function(data){

    },
    error:function(){
      alert("Deu ruim");
    }
  });
}