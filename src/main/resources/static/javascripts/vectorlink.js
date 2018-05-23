var Vectorlink = Vectorlink || {};

Vectorlink.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
//		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
//		this.plain.maskMoney({ precision: 0, thousands: '.' });
		this.decimal.maskNumber({ decimal: ',', thousands: '.' });
		this.plain.maskNumber({ integer: true, thousands: '.' });
	}
	
	return MaskMoney;
	
}());

Vectorlink.MaskPhoneNumber = (function() {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	
	return MaskPhoneNumber;
	
}());

Vectorlink.MaskPidom = (function() {
	
	function MaskPidom() {
		this.inputPidom = $('.js-pidom');
	}
	
	MaskPidom.prototype.enable = function() {
		this.inputPidom.mask('0-000000');
	}
	
	return MaskPidom;
	
}());

Vectorlink.MaskDate = (function() {
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}
	
	return MaskDate;
	
}());

Vectorlink.Security = (function() {
	
	function Security() {
		this.token = $('input[name=_csrf]').val();
		this.header = $('input[name=_csrf_header]').val();
	}
	
	Security.prototype.enable = function() {
		$(document).ajaxSend(function(event, jqxhr, settings) {
			jqxhr.setRequestHeader(this.header, this.token);
		}.bind(this));
	}
	
	return Security;
	
}());


Vectorlink.MaskStudyCode = (function() {
	
	function MaskStudyCode() {
		this.inputStudyCode = $('.js-studyCode');
	}
	
	MaskStudyCode.prototype.enable = function() {
		this.inputStudyCode.mask('0000 000');
	}
	
	return MaskStudyCode;
	
}());

numeral.language('pt-br');

Vectorlink.formatarMoeda = function(valor) {
	return numeral(valor).format('0,0.00');
}

Vectorlink.recuperarValor = function(valorFormatado) {
	return numeral().unformat(valorFormatado);
}

$(function() {
	var maskMoney = new Vectorlink.MaskMoney();
	maskMoney.enable();
	
	var maskPhoneNumber = new Vectorlink.MaskPhoneNumber();
	maskPhoneNumber.enable();
	
	var maskPidom = new Vectorlink.MaskPidom();
	maskPidom.enable();
	
	var maskDate = new Vectorlink.MaskDate();
	maskDate.enable();
	
	var maskStudyCode = new Vectorlink.MaskStudyCode();
	maskStudyCode.enable();
	
	var security = new Vectorlink.Security();
	security.enable();
	
});
