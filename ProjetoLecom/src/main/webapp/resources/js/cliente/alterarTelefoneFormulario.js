function validarFormularioTelefoneAlt(){
	
	var msgErroRetornoTelefoneAlt = cliente.validarFormularioTelefoneAlt();
	
	var msgErroTelefoneAlt = '';
	
	if(msgErroTelefoneAlt != null){
		
		if(geral.isCampoValidoFormulario(msgErroRetornoTelefoneAlt.msgDddCliente)){
			
			msgErroTelefoneAlt += "<div>";
			
			msgErroTelefoneAlt += msgErroRetornoTelefoneAlt.msgDddCliente;
			
			msgErroTelefoneAlt += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoTelefoneAlt.msgtelefoneCliente)){
			
			msgErroTelefoneAlt += "<div>";
			
			msgErroTelefoneAlt += msgErroRetornoTelefoneAlt.msgtelefoneCliente;
			
			msgErroTelefoneAlt += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoTelefoneAlt.msgTipoTelefone)){
			
			msgErroTelefoneAlt += "<div>";
			
			msgErroTelefoneAlt += msgErroRetornoTelefoneAlt.msgTipoTelefone;
			
			msgErroTelefoneAlt += "</div>";
		}
		
		$("#formularioAlterarTelefone #containerErro").removeClass('campo_invisivel');
		
		$("#formularioAlterarTelefone #containerErro").empty();
		
		$("#formularioAlterarTelefone #containerErro").append(msgErroTelefoneAlt);
		
		return false;
	}
	else{
		
		$("#formularioAlterarTelefone #containerErro").addClass('campo_invisivel');
	}
};

function limparFormularioTelefoneAlt(){
	
	$("#formularioAlterarTelefone\\:dddCliente").val("");
	$("#formularioAlterarTelefone\\:telefoneCliente").val("");
	$("#formularioAlterarTelefone\\:tipoTelefone").val("");
	
};

$(document).ready(function(){
	
	$("#formularioAlterarTelefone\\:dddCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterarTelefone\\:dddCliente", evento);
		
	});
	
	$("#formularioAlterarTelefone\\:telefoneCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterarTelefone\\:telefoneCliente", evento);
		
	});
	
	$("#formularioAlterarTelefone\\:dddCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarTelefone\\:telefoneCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarTelefone\\:tipoTelefone").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
});
