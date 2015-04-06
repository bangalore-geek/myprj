$(function() {
			$.Class('defysope.privacy.Main', {}, {
						init : function(el, options) {
							this.el = $(el);
							$.extend(this.options, options);
						}
					});
		});