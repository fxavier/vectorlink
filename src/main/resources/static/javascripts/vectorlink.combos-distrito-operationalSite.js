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

Vectorlink.ComboOpSite = (function() {
	
	function ComboOpSite(comboDistrito) {
		this.comboDistrito = comboDistrito;
		this.combo = $('#operationalSite');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenOpSiteSelecionado = $('#inputHiddenOpSiteSelecionada');
	}
	
	ComboOpSite.prototype.iniciar = function() {
		reset.call(this);
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarOpSites.call(this, codigoDistrito);
	}
	
	
	
	function onDistritoAlterado(evento, codigoDistrito) {
		this.inputHiddenOpSiteSelecionado.val('');
		inicializarOpSites.call(this, codigoDistrito);
	}
	
	function inicializarOpSites(codigoDistrito) {
		if (codigoDistrito) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'distrito': codigoDistrito }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarOpSitesFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	function onBuscarOpSitesFinalizado(opSites) {
		var options = [];
		opSites.forEach(function(operationalSite) {
			options.push('<option value="' + operationalSite.id + '">' + operationalSite.name + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoOpSiteSelecionado = this.inputHiddenOpSiteSelecionado.val();
		if (codigoOpSiteSelecionado) {
			this.combo.val(codigoOpSiteSelecionado);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione a Base operacional</option>');
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
	
	return ComboOpSite;
	
}());


$(function() {
	
	var comboDistrito = new Vectorlink.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboOpSite = new Vectorlink.ComboOpSite(comboDistrito);
	comboOpSite.iniciar();
	
	
});

