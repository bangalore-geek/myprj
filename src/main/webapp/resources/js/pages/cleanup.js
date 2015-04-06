$(function() {
			$.Class('defysope.cleanup.Main', {}, {
						init : function(el, options) {
							this.el = $(el);
							$.extend(this.options, options);
						}
					});
		});