function validarFormularioAlt(){
	
	var msgErroRetornoAlt = cliente.validarFormularioAlt();
	
	var msgErro = '';
	
	if(msgErroRetornoAlt != null){
		
		if(geral.isCampoValidoFormulario(msgErroRetornoAlt.msgNomeCliente)){
			
			msgErro += "<div>" ;
			
			msgErro += msgErroRetornoAlt.msgNomeCliente;
			
			msgErro += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoAlt.msgRgCliente)){
			
			msgErro += "<div>" ;
			
			msgErro += msgErroRetornoAlt.msgRgCliente;
			
			msgErro += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoAlt.msgEmail)){
			
			msgErro += "<div>" ;
			
			msgErro += msgErroRetornoAlt.msgEmail;
			
			msgErro += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoAlt.msgCPF)){
			
			msgErro += "<div>" ;
			
			msgErro += msgErroRetornoAlt.msgCPF;
			
			msgErro += "</div>";
		}
		
		if(geral.isCampoValidoFormulario(msgErroRetornoAlt.msgCod)){
			
			msgErro += "<div>" ;
			
			msgErro += msgErroRetornoAlt.msgCod;
			
			msgErro += "</div>";
		}
		
		$("#formularioAlterar #containerErro").removeClass('campo_invisivel');
		
		$("#formularioAlterar #containerErro").empty();
		
		$("#formularioAlterar #containerErro").append(msgErro);
		
		return false;
	}
	else{
		
		$("#formularioAlterar #containerErro").addClass('campo_invisivel');
	}
};

function limparFormularioAlt(){
	$("#formularioAlterar:\\nomeCliente").val("");
	$("#formularioAlterar:\\rgCliente").val("");
	$("#formularioAlterar:\\emailCliente").val("");
	$("#formularioAlterar:\\cpfCliente").val("");
	$("#formularioAlterar:\\codCliente").val("");
};

$(document).ready(function(){
	
	$("#formularioAlterar\\:rgCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterar\\:rgCliente", evento);
		
	});
	
	$("#formularioAlterar\\:cpfCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterar\\:cpfCliente", evento);
		
	});
	
	$("#formularioAlterar\\:codCliente").on("keypress",function(evento){
		
		geral.campoNumerico("#formularioAlterar\\:codCliente", evento);
		
	});
	
	$("#formularioAlterar\\:nomeCliente").on("blur", function(){
		
		$(this).removeClass('input_erro');
		
		if($.trim($(this).val()) == ''){
			
			$(this).addClass('input_erro');
		}
		
	});
	
	$("#formularioAlterar\\:rgCliente").on('blur', function(){
		
		$(this).removeClass('input_erro');
		
		if($.trim($(this).val()) == ''){
			
			$(this).addClass('input_erro');
		}
		
	});
	
	$("#formularioAlterar\\:emailCliente").on('blur', function(){
		
		$(this).removeClass('input_erro');
		
		if($.trim($(this).val()) == ''){
			
			$(this).addClass('input_erro');
		}
		
	});
	
	$("#formularioAlterar\\:cpfCliente").on('blur', function(){
		
		$(this).removeClass('input_erro');
		
		if($.trim($(this).val()) == ''){
			
			$(this).addClass('input_erro');
		}
		
	});
	
	$("#formularioAlterar\\:codCliente").on('blur', function(){
		
		$(this).removeClass('input_erro');
		
		if($.trim($(this).val()) == ''){
			
			$(this).addClass('input_erro');
		}
		
	});
	
	
	
});


