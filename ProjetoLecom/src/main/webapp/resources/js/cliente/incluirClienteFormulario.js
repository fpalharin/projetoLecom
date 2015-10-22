function validarFormulario(){
	
	var msgErroRetorno = cliente.validarFormulario();
	
	var msgErro = '';
	
	if(msgErroRetorno != null){
		
	
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgNomeCliente)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgNomeCliente;
			
			msgErro += "</div>";
			
		}
		
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgRG)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgRG;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgEmail)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgEmail;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgCPF)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgCPF;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgCod)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgCod;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgEstado)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgEstado;
			
			msgErro += "</div>";
			
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgCidade)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgCidade;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgCEP)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgCEP;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgLogradouro)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgLogradouro;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgBairro)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgBairro;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgDdd)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgDdd;
			
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgTelefone)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgTelefone;
				
			msgErro += "</div>";
			
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetorno.msgTipoTelefone)){
			
			msgErro += "<div>";
			
			msgErro += msgErroRetorno.msgTipoTelefone;
				
			msgErro += "</div>";
			
		}
		
		
		$("#formulario #containerErro").removeClass('campo_invisivel');
		
		$("#formulario #containerErro").empty();
		
		$("#formulario #containerErro").append(msgErro);
		
		return false;
		
	}else{
		
		$("#formulario #containerErro").addClass('campo_invisivel');
	}
	
};

function limparFormulario(){
	
	 $("#formulario\\:nomeCliente").val("");
	 $("#formulario\\:rgCliente").val("");
	 $("#formulario\\:emailCliente").val("");
	 $("#formulario\\:cpfCliente").val("");
	 $("#formulario\\:codCliente").val("");
	 $("#formulario\\:comboEstado").val("0");
	 $("#formulario\\:comboCidade").val("0");
	 $("#formulario\\:comboCidade").attr("disabled","true");
	 $("#formulario\\:cepCliente").val("");
	 $("#formulario\\:logradouroCliente").val("");
	 $("#formulario\\:bairroCliente").val("");
	 $("#formulario\\:dddCliente").val("");
	 $("#formulario\\:telefoneCliente").val("");
	 $("#formulario\\:tipoTelefone").val("");
		
};

$(document).ready(function(){
	
	$("#formulario\\:rgCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:rgCliente", evento);
		geral.tamanhoCampo("#formulario\\:rgCliente", 9, evento);
		
	});
	
	$("#formulario\\:cpfCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:cpfCliente", evento);
		geral.tamanhoCampo("#formulario\\:cpfCliente", 11, evento);
		
	});
	
	$("#formulario\\:codCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:codCliente", evento);
		geral.tamanhoCampo("#formulario\\:codCliente", 8, evento);
		
	});
	
	
	$("#formulario\\:cepCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:cepCliente", evento);
		geral.tamanhoCampo("#formulario\\:cepCliente", 8, evento);
		
	});
	
	$("#formulario\\:dddCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:dddCliente", evento);
		geral.tamanhoCampo("#formulario\\:dddCliente", 2, evento);
	});
	
	$("#formulario\\:telefoneCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formulario\\:telefoneCliente", evento);
		geral.tamanhoCampo("#formulario\\:telefoneCliente", 9, evento);
	});
	
	$("#formulario\\:nomeCliente").on("keypress",function(evento){
		
		geral.tamanhoCampo("#formulario\\:nomeCliente", 50, evento);
		
	});
	
	$("#formulario\\:emailCliente").on("keypress",function(evento){
		
		geral.tamanhoCampo("#formulario\\:emailCliente", 30, evento);
		
	});
	
	$("#formulario\\:logradouroCliente").on("keypress",function(evento){
		
		geral.tamanhoCampo("#formulario\\:logradouroCliente", 100, evento);
		
	});
	
	$("#formulario\\:bairroCliente").on("keypress",function(evento){
		
		geral.tamanhoCampo("#formulario\\:bairroCliente", 100, evento);
		
	});

	$("#formulario\\:nomeCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	
	$("#formulario\\:rgCliente").on('blur', function(){
		  
		  
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:emailCliente").on('blur', function(){
		  
		  
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:cpfCliente").on('blur', function(){
		  
		  
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:codCliente").on('blur', function(){
		  
		  
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:cepCliente").on('blur', function(){
		  
		
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:logradouroCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	$("#formulario\\:bairroCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  if($.trim($(this).val()) == ''){
		   
		   
		   $(this).addClass('input_erro');
		  }
		  
	});
	
	
});
