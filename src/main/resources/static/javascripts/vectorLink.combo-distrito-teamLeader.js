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

Vectorlink.ComboTeamLeader = (function() {
	
	function ComboTeamLeader(comboDistrito) {
		this.comboDistrito = comboDistrito;
		this.combo = $('#teamLeader');
		this.imgLoading = $('.js-img-loading');
		this.inputHiddeTeamLeaderSelecionado = $('#inputHiddeTeamLeaderSelecionado');
	}
	
	ComboTeamLeader.prototype.iniciar = function() {
		reset.call(this);
		this.comboDistrito.on('alterado', onDistritoAlterado.bind(this));
		var codigoDistrito = this.comboDistrito.combo.val();
		inicializarTeamLeaders.call(this, codigoDistrito);
	}
	
	
	
	function onDistritoAlterado(evento, codigoDistrito) {
		this.inputHiddeTeamLeaderSelecionado.val('');
		inicializarTeamLeaders.call(this, codigoDistrito);
	}
	
	function inicializarTeamLeaders(codigoDistrito) {
		if (codigoDistrito) {
			var resposta = $.ajax({
				url: this.combo.data('url'),
				method: 'GET',
				contentType: 'application/json',
				data: { 'distrito': codigoDistrito }, 
				beforeSend: iniciarRequisicao.bind(this),
				complete: finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarTeamLeadersFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}
	
	function onBuscarTeamLeadersFinalizado(teamLeaders) {
		var options = [];
		teamLeaders.forEach(function(teamLeader) {
			options.push('<option value="' + teamLeader.id + '">' + teamLeader.name + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
		
		var codigoTeamLeaderSelecionado = this.inputHiddeTeamLeaderSelecionado.val();
		if (codigoTeamLeaderSelecionado) {
			this.combo.val(codigoTeamLeaderSelecionado);
		}
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione o chefe da equipa</option>');
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
	
	return ComboTeamLeader;
	
}());


$(function() {
	
	var comboDistrito = new Vectorlink.ComboDistrito();
	comboDistrito.iniciar();
	
	var comboTeamLeader = new Vectorlink.ComboTeamLeader(comboDistrito);
	comboTeamLeader.iniciar();
	
	
});

