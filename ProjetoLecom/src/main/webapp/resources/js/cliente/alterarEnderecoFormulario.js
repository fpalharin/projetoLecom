function validarFormularioEnderecoAlt(){
	
	var msgErroRetornoEnderecoAlt = cliente.validarFormularioEnderecoAlt();
	
	var msgErroEnderecoAlt = '';
	
	if(msgErroRetornoEnderecoAlt != null){
		
		if(geral.isCampoValidoFormulario(msgErroRetornoEnderecoAlt.msgLogradouroCliente)){
			

			msgErroEnderecoAlt += "<div>";
			
			msgErroEnderecoAlt += msgErroRetornoEnderecoAlt.msgLogradouroCliente;
			
			msgErroEnderecoAlt += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoEnderecoAlt.msgBairroCliente)){
			
			msgErroEnderecoAlt += "<div>";
			
			msgErroEnderecoAlt += msgErroRetornoEnderecoAlt.msgBairroCliente;
			
			msgErroEnderecoAlt += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoEnderecoAlt.msgCepCliente)){
			
			msgErroEnderecoAlt += "<div>";
			
			msgErroEnderecoAlt += msgErroRetornoEnderecoAlt.msgCepCliente;
			
			msgErroEnderecoAlt += "</div>";
		}
		
		
		if(geral.isCampoValidoFormulario(msgErroRetornoEnderecoAlt.msgComboEstado)){
			
			msgErroEnderecoAlt += "<div>";
			
			msgErroEnderecoAlt += msgErroRetornoEnderecoAlt.msgComboEstado;
			
			msgErroEnderecoAlt += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoEnderecoAlt.msgComboCidade)){
			
			msgErroEnderecoAlt += "<div>";
			
			msgErroEnderecoAlt += msgErroRetornoEnderecoAlt.msgComboCidade;
			
			msgErroEnderecoAlt += "</div>";
		}
		
		$("#formularioAlterarEndereco #containerErro").removeClass('campo_invisivel');
		
		$("#formularioAlterarEndereco #containerErro").empty();
		
		$("#formularioAlterarEndereco #containerErro").append(msgErroEnderecoAlt);
		
		return false;
	}
	else{
		
		$("#formularioAlterarEndereco #containerErro").addClass('campo_invisivel');
	}
};

function limparFormularioEmailAlt(){
	
	$("#formularioAlterarEndereco\\:logradouroCliente").val("");
	$("#formularioAlterarEndereco\\:bairroCliente").val("");
	$("#formularioAlterarEndereco\\:cepCliente").val("");
	$("#formularioAlterarEndereco\\:complementoCliente").val("");
	$("#formularioAlterarEndereco\\:comboEstado").val(0);
	$("#formularioAlterarEndereco\\:comboCidade").val(0);
};

$(document).ready(function(){
	
	$("#formularioAlterarEndereco\\:cepCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterarEndereco\\:cepCliente", evento);
		
	});
	
	
	$("#formularioAlterarEndereco\\:logradouroCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarEndereco\\:bairroCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarEndereco\\:cepCliente").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarEndereco\\:comboEstado").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
	$("#formularioAlterarEndereco\\:comboCidade").on('blur', function(){
		  
		 
		  $(this).removeClass('input_erro');

		  	if($.trim($(this).val()) == ''){
		   
		   
		  		$(this).addClass('input_erro');
		  	}
		  
	});
	
});

