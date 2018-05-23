var Vectorlink = Vectorlink || {};

Vectorlink.ComboDistrito = (function() {
	
	function ComboDistrito() {
		this.combo = $('#district');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboDistrito.prototype.iniciar = function() {
		this.combo.on('change', onDistritoAlterado.bind(this));
	}
	
	function onDistritoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
		
	}
	
	return ComboDistrito;
	
}());

Vectorlink.CodigoEstudo = (function(){
	
	function CodigoEstudo(comboDistrito){
		this.comboDistrito = comboDistrito;
		this.inputCodigoEstudo = $('#studyCode');
		
	}
	
	CodigoEstudo.prototype.iniciar = function(){
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		abilitarCodigoEstudo.call(this, codigoDistrito);
		
	}
	
	function onDistritoAlterado(evento, codigoDistrito){
		abilitarCodigoEstudo.call(this, codigoDistrito);
		console.log('Valor');
	}
	
	function abilitarCodigoEstudo(codigoDistrito){
		if(codigoDistrito == 1){
			this.inputCodigoEstudo.removeAttr('disabled');
		} else {
			this.inputCodigoEstudo.attr('disabled', 'disabled');
		}
		
	}
	
	return CodigoEstudo;
	
}());

$(function(){
	
	var comboDistrito = new Vectorlink.ComboDistrito();
	comboDistrito.iniciar();
	
	var codigoEstudo = new Vectorlink.CodigoEstudo(comboDistrito);
	codigoEstudo.iniciar();
	
});