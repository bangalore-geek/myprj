$(function() {
			$.Class('defysope.manage.Main', {}, {
						init : function(el, options) {
							this.el = $(el);
							$.extend(this.options, options);
						}
					});
		});