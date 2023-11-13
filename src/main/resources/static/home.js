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
    switch(url){
        case "/logout":
            gerarSwal(url);
            break;
        case "/coleta":
            $.get(url,function(data){
                $(".container").html(data);
                $("#enviar").click(criarColeta);

            });
            break;
        case "/alterarsenha":
            $.get(url,function(data){
                $(".container").html(data);
                $("#alterar").click(salvarSenha);
            });
            break;
        case "/Home":
            $.get(url,function(data){
                $(".container").html(data);
                disableLink();
            });
            break;
        case "/Home":
            $.get(url,function(data){
                $(".container").html(data);
            });
            break;
        case "/busca":
            $.get(url,function(data){
            $(".container").html(data);
            });
            break;
        case "/ponto_coleta":
            $.get(url,function(data){
            $(".container").html(data);
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


            });
            break;
        default:
             $.get(url,function(data){
                $(".container").html(data);
             });
             break;
    }
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