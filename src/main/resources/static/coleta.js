$("#enviar").click(criarColeta);

  function criarColeta(){
  	let cidade = $("#cidadeList option[value='"+$("#cidade").val()+"']").data('value');
  	let rua = $("#rua").val();
  	let bairro = $("#bairro").val();
  	let numero = $("#numero").val();
  	let tipo_lixo = Array.from($("#tipo_lixo option:selected")).map(x=>x.value??x.text);
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
            tipo_lixo: JSON.stringify(tipo_lixo),
  			data_inicial:data_inicial,
  			data_final:data_final,

  		},
  		success:function(data){
  			alert("Sucesso ao criar ponto de coleta");
  		},
  		error:function(){
  			alert("Deu ruim");
  		}
  	});
 }
