$("#editar").click(salvarPonto);


  function salvarPonto(){
  	let cidade = $("#cidadeList option[value='"+$("#cidade").val()+"']").data('value');
  	let rua = $("#rua").val();
  	let bairro = $("#bairro").val();
  	let numero = $("#numero").val();
  	let tipo_lixo = $("#tipo_lixo").val();
  	let data_inicial = $("#data_inicial").val();
  	let data_final = $("#data_final").val();

  	$.ajax({
  		type: "POST",
  		url: "/editarponto",
  		data:{
  		    cidade:cidade,
  		    rua:rua,
  			bairro:bairro,
  			numero:numero,
  			tipo_lixo:tipo_lixo,
  			data_inicial:data_inicial,
  			data_final:data_final,

  		},
  		success:function(data){
  			alert("Sucesso ao Atualizar  ponto de coleta");
  		},
  		error:function(){
  			alert("Deu ruim");
  		}
  	});
 }