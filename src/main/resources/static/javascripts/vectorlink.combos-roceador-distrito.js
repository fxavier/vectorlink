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

Vectorlink.ComboRoceador = (function() {
	
	function ComboRoceador(comboDistrito) {
		this.comboDistrito = comboDistrito;
		this.combo = $('#sop');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenRoceadorSelecionado = $('#inputHiddenRoceadorSelecionado');
	}
	
	ComboRoceador.prototype.iniciar = function() {
		reset.call(this);
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarRoceadores.call(this, codigoDistrito);
	}
	
	
	
	function onDistritoAlterado(evento, codigoDistrito) {
		this.inputHiddenRoceadorSelecionado.val('');
		inicializarRoceadores.call(this, codigoDistrito);
	}
	
	function inicializarRoceadores(codigoDistrito) {
		if (codigoDistrito) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'distrito': codigoDistrito }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarRoceadoresFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	function onBuscarRoceadoresFinalizado(roceadores) {
		var options = [];
		roceadores.forEach(function(sprayOperator) {
			options.push('<option value="' + sprayOperator.id + '">' + sprayOperator.name + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoRoceadorSelecionado = this.inputHiddenRoceadorSelecionado.val();
		if (codigoRoceadorSelecionado) {
			this.combo.val(codigoRoceadorSelecionado);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione o Roceador</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	return ComboRoceador;
	
}());


$(function() {
	
	var comboDistrito = new Vectorlink.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboRoceador = new Vectorlink.ComboRoceador(comboDistrito);
	comboRoceador.iniciar();
	
	
});

