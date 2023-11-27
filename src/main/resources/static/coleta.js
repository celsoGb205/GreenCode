$("#enviar").click(criarColeta);

   $(document).ready(function () {
       // Quando o valor do select for alterado
       $('#tipoLixo').change(function () {
           // Obtém todos os valores selecionados
           var selectedValues = $('#tipoLixo').val();

           // Exibe os valores no console (você pode fazer o que quiser com esses valores)
           console.log(selectedValues);
      });
   });

  function criarColeta(){
  	let cidade = $("#cidadeList option[value='"+$("#cidade").val()+"']").data('value');
  	let rua = $("#rua").val();
  	let bairro = $("#bairro").val();
  	let numero = $("#numero").val();
  	let tipo_lixo = $("#tipoLixo").val();
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
            tipoLixo:selectedValues,
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