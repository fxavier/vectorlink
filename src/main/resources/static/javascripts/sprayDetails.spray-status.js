var Vectorlink = Vectorlink || {};

Vectorlink.MascaraVariaveis = (function() {
	
	function MascaraVariaveis() {
		this.comboSprayStatus = $('#sprayStatus');
		this.inputSprayedMan = $('#sprayedMan');
		this.inputSprayedWomen = $('#sprayedWomen');
		this.inputsprayedPregnantWomen = $('#sprayedPregnantWomen');
		this.inputSprayedChildren = $('#sprayedChildren');
		this.inputReasonNotSprayed = $('#reasonNotSprayed');
		this.inputNotSprayedMen = $('#notSprayedMen');
		this.inputNotSprayedWomen = $('#notSprayedWomen');
		this.inputNotSprayedPregnantWomen = $('#notSprayedPregnantWomen');
		this.inputNotSprayedChildren = $('#notSprayedChildren');
		
	}
	
	MascaraVariaveis.prototype.iniciar = function() {
		this.comboSprayStatus.on('change', onStatusAlterado.bind(this));
		var statusSelecionado = this.comboSprayStatus.find('option:selected').text;
	
		
	}
	
	function onStatusAlterado(evento) {		
		var statusSelecionado = $(evento.currentTarget);
		if(statusSelecionado.val() == 'SPRAYED'){
		abilitarSprayInputs.call(this, statusSelecionado);
		this.inputSprayedMan.val('');
		this.inputSprayedWomen.val('');
		this.inputsprayedPregnantWomen.val('');
		this.inputSprayedChildren.val('');
		resetNotSprayed.call(this);
		} else {
			abilitarNotSprayInputs.call(this, statusSelecionado);
			this.inputReasonNotSprayed.val('');
			this.inputNotSprayedMen.val('');
			this.inputNotSprayedWomen.val('');
			this.inputNotSprayedPregnantWomen.val('');
			this.inputNotSprayedChildren.val('');
			resetSprayed.call(this);
		}
	}
	
	function abilitarSprayInputs(statusSelecionado) {
		this.comboSprayStatus.text(statusSelecionado.data('documento'));
		this.inputSprayedMan.removeAttr('disabled');
		this.inputSprayedWomen.removeAttr('disabled');
		this.inputsprayedPregnantWomen.removeAttr('disabled');
		this.inputSprayedChildren.removeAttr('disabled');
		
		
	}
	
	function abilitarNotSprayInputs(statusSelecionado){
		this.comboSprayStatus.text(statusSelecionado.data('documento'));
		this.inputReasonNotSprayed.removeAttr('disabled');
		this.inputNotSprayedMen.removeAttr('disabled');
		this.inputNotSprayedWomen.removeAttr('disabled');
		this.inputNotSprayedPregnantWomen.removeAttr('disabled');
		this.inputNotSprayedChildren.removeAttr('disabled');
		
	}
	
	function resetNotSprayed() {
		this.inputReasonNotSprayed.attr('disabled','disabled');
		this.inputNotSprayedMen.attr('disabled','disabled');
		this.inputNotSprayedWomen.attr('disabled','disabled');
		this.inputNotSprayedPregnantWomen.attr('disabled','disabled');
		this.inputNotSprayedChildren.attr('disabled','disabled');
	}
	
	function resetSprayed() {
		this.inputSprayedMan.attr('disabled','disabled');
		this.inputSprayedWomen.attr('disabled','disabled');
		this.inputsprayedPregnantWomen.attr('disabled','disabled');
		this.inputSprayedChildren.attr('disabled','disabled');
	}
	
	return MascaraVariaveis;
	
}());


$(function() {
	var mascaraVariaveis = new Vectorlink.MascaraVariaveis();
	mascaraVariaveis.iniciar();
		
});