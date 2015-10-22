function Geral(){

}

Geral.prototype.tamanhoCampo = function(campo, tamanho, evento){
	
	var tecla = evento.keyCode || evento.which;
	
	if(tecla != 8){
		
		if($(campo).val().length() == tamanho){
			
			evento.preventDefault();
		}
	}
	
};

Geral.prototype.campoNumerico = function(campo, evento){
	
	var tecla = evento.keyCode || evento.which;
	
	if(tecla !=8){
		
		if(tecla < 48 || tecla > 57){
		
			evento.preventDefault();
		}
	
	}
	
};

Geral.prototype.isCampoValido = function(campo){

	return campo.length != 0 && $.trim(campo.val()) != '';


};

Geral.prototype.isCampoValidoFormulario = function(campo){
	
	return campo != null && $.trim(campo) != '';
};

Geral.prototype.isComboValido = function(campo){
	
	return $.trim(campo.val()) != '0';
};

Geral.prototype.converterByteMega = function(campo){

	if(campo){
	
		return campo.size / 1024 / 1024;
	}
	
	
	return 0;

};

var geral = new Geral();