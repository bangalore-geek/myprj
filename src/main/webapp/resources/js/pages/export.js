$(function() {
			$.Class('defysope.export.Main', {}, {
						init : function(el, options) {
							this.el = $(el);
							$.extend(this.options, options);
						}
					});
		});