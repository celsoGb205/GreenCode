$('a').click(function(event){
    event.preventDefault();
    if(!$(this).hasClass('btn')){
    $('a').removeClass('active disabled');
    $(this).addClass('active disabled');
    }

    controleRotasGet($(this).attr("href"));
});

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
        case "/Home":
            $.get(url,function(data){
            $(".container").html(data);
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
        case "/pontoColeta":
            $.get(url,function(data){
            $(".container").html(data);
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