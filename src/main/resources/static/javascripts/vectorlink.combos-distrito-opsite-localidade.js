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
		this.emitterOpSite = $({});
		this.on = this.emitterOpSite.on.bind(this.emitterOpSite);
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenOpSiteSelecionado = $('#inputHiddenOpSiteSelecionada');
	}
	
	 ComboOpSite.prototype.iniciar = function() {
		reset.call(this);
		this.combo.on('change', onOpSiteAlterado.bind(this));
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarOpSites.call(this, codigoDistrito);
	}
	
	function onOpSiteAlterado(){
		this.emitterOpSite.trigger('alterado', this.combo.val());
		console.log('OpSite Selecionado:', this.combo.val());
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
	
	function onBuscarOpSitesFinalizado(operationalSite) {
		var options = [];
		operationalSite.forEach(function(operationalSite) {
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
		this.combo.html('<option value="">Selecione a base operacional</option>');
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

Vectorlink.ComboLocalidade = (function() {
	
	function ComboLocalidade(comboOpSite) {
		this.comboOpSite = comboOpSite;
		this.combo = $('#localidade');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddenLocalidadeSelecionada = $('#inputHiddenLocalidadeSelecionada');
	}
	
	ComboLocalidade.prototype.iniciar = function() {
		resetLocalidade.call(this);
		this.comboOpSite.on('alterado', onOpSiteAlterado.bind(this));
		var codigoOpSite = this.comboOpSite.combo.val();
		inicializarLocalidades.call(this, codigoOpSite);
		
	}
	
	function onOpSiteAlterado(evento, codigoOpSite) {
		this.inputHiddenLocalidadeSelecionada.val('');
		inicializarLocalidades.call(this, codigoOpSite);
	}
	
	function inicializarLocalidades(codigoOpSite) {
		if (codigoOpSite) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'operationalSite': codigoOpSite }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarLocalidadesFinalizado.bind(this));
		} else {
			resetLocalidade.call(this);
		}
	}
	
	function onBuscarLocalidadesFinalizado(localidades) {
		var options = [];
		localidades.forEach(function(locality) {
			options.push('<option value="' + locality.id + '">' + locality.name + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoLocalidadeSelecionada = this.inputHiddenLocalidadeSelecionada.val();
		if (codigoLocalidadeSelecionada) {
			this.combo.val(codigoLocalidadeSelecionada);
		}
	}
	
	function resetLocalidade() {
		this.combo.html('<option value="">Selecione a localidade</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		resetLocalidade.call(this);
		this.imgLoading.show();
	}
	
	function finalizarRequisicao() {
		this.imgLoading.hide();
	}
	
	
	return ComboLocalidade;
	
}());



$(function() {
	
	var comboDistrito = new Vectorlink.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboOpSite = new Vectorlink.ComboOpSite(comboDistrito);
	comboOpSite.iniciar();
	
	var comboLocalidade = new Vectorlink.ComboLocalidade(comboOpSite);
	comboLocalidade.iniciar();
	
	
	
});

