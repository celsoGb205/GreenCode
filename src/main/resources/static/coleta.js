$("#enviar").click(criarColeta);


  function criarColeta(){
  	let cidade = $("#cidade").val();
  	let rua = $("#rua").val();
  	let bairro = $("#bairro").val();
  	let numero = $("#numero").val();
  	let tipo_lixo = $("#tipo_lixo").val();
  	let data_inicial = $("#data_inicial").val();
  	let data_final = $("#data_final").val();

  	$.ajax({
  		type: "POST",
  		url: "/coleta",
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
  			alert("Ponto criado com Sucesso");
  		},
  		error:function(){
  			alert("Deu ruim");
  		}
  	});
 }