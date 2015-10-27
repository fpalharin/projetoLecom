function Cliente(){
	
}

Cliente.prototype.validarFormularioAlt = function(){
	
	var msgErroRetornoAlt = null;
	
	var flag = true;
	
	var erroNomeClienteAlt = '';
	var erroRgClienteAlt = '';
	var erroEmailClienteAlt = '';
	var erroCpfClienteAlt = '';
	var erroCodClienteAlt = '';
	
	try{
		
		var nomeCliente = $("#formularioAlterar\\:nomeCliente");
		
		var rgCliente = $("#formularioAlterar\\:rgCliente");
		
		var emailCliente = $("#formularioAlterar\\:emailCliente");
		
		var cpfCliente = $("#formularioAlterar\\:cpfCliente");
		
		var codCliente = $("#formularioAlterar\\:codCliente");
		
		if(!geral.isCampoValido(nomeCliente)){
			
			erroNomeClienteAlt += "O campo Nome do Cliente é obrigatório" + '\n';
		
			flag = false;
			
		}
		
		if(!geral.isCampoValido(rgCliente)){
			
			erroRgClienteAlt += "O campo Rg do Cliente é obrigatório" + '\n';
			
			flag = false;
		}
		
		if(!geral.isCampoValido(emailCliente)){
			
			erroEmailClienteAlt += "O campo e-Mail é obrigatório" + '\n';
		}
		
		if(!geral.isCampoValido(cpfCliente)){
			
			erroCpfClienteAlt += "O campo Cpf do Cliente é obrigatório" + '\n';
		}
		
		if(!geral.isCampoValido(codCliente)){
			
			erroCodClienteAlt += "O campo Codigo do Cliente é obrigatório" + '\n';
		}
		
		if(!flag){
			
			msgErroRetornoAlt = {"msgNomeCliente":erroNomeClienteAlt, "msgRgCliente":erroRgClienteAlt, 
					"msgEmailCliente":erroEmailClienteAlt, "msgCpfCliente":erroCpfClienteAlt, "msgCodCliente":erroCodClienteAlt};
			
		}
		
	}
	catch(e){
		msgErroRetornoAlt = null;
		
		alert(e);
		
	}
	
	return msgErroRetornoAlt;
	
};

Cliente.prototype.validarFormularioTelefoneAlt = function(){
	
	var msgErroRetornoTelefoneAlt = null;
	var flag = true;
	
	var erroDddCliente = '';
	var erroTelefoneCliente = '';
	var erroTipoTelefone = '';
	
	try{
		
		var dddCliente = $("#formularioAlterarTelefone\\:dddCliente");
		var telefoneCliente = $("#formularioAlterarTelefone\\:telefoneCliente");
		var tipoTelefone = $("#formularioAlterarTelefone\\:tipoTelefone");
		
		if(!geral.isCampoValido(dddCliente)){
			
			erroDddCliente += 'O campo ddd é obrigatório \n';
			
			flag = false;
		}
		
		if(!geral.isCampoValido(telefoneCliente)){
			
			erroTelefoneCliente += 'O campo telefone é obrigatório \n';
			
			flag = false;
		}
		
		if(!geral.isCampoValido(tipoTelefone)){
			
			erroTipoTelefone += 'O campo tipo telefone é obrigatório\n';
			
			flag = false;
		}
		
		if(!flag){
			
			msgErroRetornoTelefoneAlt = {"msgDddCliente":erroDddCliente, "msgtelefoneCliente":erroTelefoneCliente, 
										"msgTipoTelefone":erroTipoTelefone};
		}
		
	}catch(e){
		
		msgErroRetornoTelefoneAlt = null;
		alert(e);
	}
	
	return msgErroRetornoTelefoneAlt;
	
};

Cliente.prototype.validarFormularioEnderecoAlt = function(){
	
	var msgErroRetornoEnderecoAlt = null;
	var flag = true;
	
	var erroLogradouroCliente = '';
	var erroBairroCliente = '';
	var erroCepCliente = '';
	var erroComboEstado = '';
	var erroComboCidade = '';
	
	try{
		
		var logradouroCliente = $("#formularioAlterarEndereco\\:logradouroCliente");
		var bairroCliente = $("#formularioAlterarEndereco\\:bairroCliente");
		var cepCliente = $("#formularioAlterarEndereco\\:cepCliente");
		var comboEstado = $("#formularioAlterarEndereco\\:comboEstado");
		var comboCidade = $("#formularioAlterarEndereco\\:comboCidade");
		
		if(!geral.isCampoValido(logradouroCliente)){
			
			erroLogradouroCliente += 'O campo Logradouro é obrigatório\n';
			
			flag = false;
		}
		
		if(!geral.isCampoValido(bairroCliente)){
			
			erroBairroCliente += 'O campo Bairro é obrigatório\n';
						
			flag = false;
		}
		
		if(!geral.isCampoValido(cepCliente)){
			
			erroCepCliente += 'O campo Cep é obrigatório\n';
			
			flag = false;
		}
		
		if(!geral.isComboValido(comboEstado)){
			
			
			erroComboEstado += 'O campo Estado é obrigatório\n';
			
			flag = false;
		}
		
		if(!geral.isComboValido(comboCidade)){
			
			erroComboCidade += 'O campo Cidade é obrigatório\n';
			
			flag = false;
		}
		
		if(!flag){
			
			msgErroRetornoEnderecoAlt = {"msgLogradouroCliente":erroLogradouroCliente,"msgBairroCliente":erroBairroCliente, 
					"msgCepCliente":erroCepCliente, "msgComboEstado":erroComboEstado,
					"msgComboCidade":erroComboCidade};
		}
	}
	catch(e){
		
		msgErroRetornoEnderecoAlt = null;
		
		alert(e);
	}
	
	return msgErroRetornoEnderecoAlt;
	
};

Cliente.prototype.validarFormulario = function(){
	
	var msgErroRetorno = null;
	
	var flag = true;
	
	var erroNomeCliente = '';
	var erroRg = '';
	var erroEmail = '';
	var erroCpf = '';
	var erroCod = '';
	var erroEstado = '';
	var erroCidade = '';
	var erroCEP = '';
	var erroLogradouro = '';
	var erroBairro = '';
	var erroDdd = '';
	var erroTelefone = '';
	var erroTipoTelefone = '';

	
	try{
	
	var nomeCliente = $("#formulario\\:nomeCliente");
	
	var rg = $("#formulario\\:rgCliente");
	
	var email = $("#formulario\\:emailCliente");
	
	var cpf = $("#formulario\\:cpfCliente");
	
	var codCliente = $("#formulario\\:codCliente");
	
	var estado = $("#formulario\\:comboEstado");
	
	var cidade = $("#formulario\\:comboCidade");
	
	var cep = $("#formulario\\:cepCliente");
	
	var logradouro = $("#formulario\\:logradouroCliente");
	
	var bairro = $("#formulario\\:bairroCliente");
	
	var ddd = $("#formulario\\:dddCliente");
	
	var telefone = $("#formulario\\:telefoneCliente");
	
	var tipoTelefone = $("#formulario\\:tipoTelefone");
	
	if(!geral.isCampoValido(nomeCliente)){
		
		erroNomeCliente += 'O campo nome é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(rg)){
		
		erroRg += 'O campo Rg é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(email)){
		
		erroEmail += 'O campo email é obrigatório\n';
	}
	
	if(!geral.isCampoValido(cpf)){
		
		erroCpf += 'O campo Cpf é obrigatório\n';
	}
	
	if(!geral.isCampoValido(codCliente)){
		
		erroCod += 'O campo Codigo do Cliente é obrigatório\n';
	}
	
	if(!geral.isComboValido(estado)){
		
		erroEstado += 'O campo Estado é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isComboValido(cidade)){
		
		erroCidade += 'O campo Cidade é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(cep)){
		
		erroCEP += 'O campo Cep é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(logradouro)){
		
		erroLogradouro += 'O campo Logradouro é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(bairro)){
		
		erroBairro += 'O campo Bairro é obrigatório\n';
	
		flag = false;
		
	}
	
	if(!geral.isCampoValido(ddd)){
		
		erroDdd += 'O campo DDD é obrigatório\n';
	}
	
	if(!geral.isCampoValido(telefone)){
		
		erroTelefone += 'O campo Telefone é obrigatório\n';
	}
	
	
	if(!geral.isCampoValido(tipoTelefone)){
		
		erroTipoTelefone += 'O campo Tipo Telefone é obrigatório\n';
	}
	
	
		
	
	if(!flag){
		
		msgErroRetorno = {"msgNomeCliente":erroNomeCliente,"msgRG":erroRg,"msgEmail":erroEmail,"msgCPF":erroCpf,
				"msgCod":erroCod,"msgEstado":erroEstado,"msgCidade":erroCidade,"msgCEP":erroCEP,"msgLogradouro":erroLogradouro,
				"msgBairro":erroBairro,"msgDdd":erroDdd,"msgTelefone":erroTelefone,"msgTipoTelefone":erroTipoTelefone};
		
	}
	
	}catch(e){
		
		msgErroRetorno = null;
		
		alert(e);
		
	}
	

	return msgErroRetorno;
	
};

var cliente = new Cliente();
