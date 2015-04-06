$(function() {
			$.Class('defysope.import.Main', {}, {
						init : function(el, options) {
							this.el = $(el);
							$.extend(this.options, options);
						}
					});
		});