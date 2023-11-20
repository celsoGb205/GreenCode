$("#enviar").click(RecuperarSenha);


  function RecuperarSenha(){
  	let email = $("#email").val();

  	$.ajax({
  		type: "POST",
  		url: "/senha",
  		data:{
  		    email:email,
  		},
  		success:function(data){
  			alert(data);
  		},
  		error:function(){
  			alert("Deu ruim");
  		}
  	});
 }