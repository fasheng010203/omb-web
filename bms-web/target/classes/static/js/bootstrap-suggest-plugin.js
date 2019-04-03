/**
 * bootstrap-suggest-plugin - v0.1.24
 * @description 这是一个基于 bootstrap 按钮式下拉菜单组件的搜索建议插件，必须使用于按钮式下拉菜单组件上。
 * @author [object Object]
 * @GitHub https://github.com/lzwme/bootstrap-suggest-plugin.git
 * @since 2018-05-31 10:25:55
 */

!function(t){if("function"==typeof define&&define.amd)define(["jquery"],t);else if("object"==typeof exports&&"object"==typeof module)t(require("jquery"));else{if(!window.jQuery)throw new Error("Not found jQuery.");t(window.jQuery)}}(function(c){var p,l=c(window),s="ActiveXObject"in window,t=navigator.userAgent.match(/Chrome\/(\d+)/);t&&(t=+t[1]);var h=s||51<t,v="bsSuggest",g="onDataRequestSuccess",y="disabled",m=!0,w=!1;function b(t){return t.data()}function x(t,e){return void 0!==e?t.attr("alt",e):t.attr("alt")}function k(t,e){return void 0!==e?t.attr("data-id",e):t.attr("data-id")}function S(t,e,n){if(e&&e.key){var i,o,r=n.separator||",",a=k(t);n&&n.multiWord?((i=t.val().split(r))[i.length-1]=e.key,a?(o=a.split(r)).push(e.id):o=[e.id],k(t,o.join(r)).val(i.join(r)).focus()):k(t,e.id||"").val(e.key).focus(),t.data("pre-val",t.val()).trigger("onSetSelectValue",[e,(n.data.value||n._lastData.value)[e.index]])}}function j(i,o,t){if(o.is(":visible")){var r=i.parent(),e=r.height(),n=r.width();t.autoDropup&&setTimeout(function(){var t=i.offset().top,e=l.scrollTop(),n=o.height();l.height()+e-t<n&&n+e<t?r.addClass("dropup"):r.removeClass("dropup")},10);var a={};return"left"===t.listAlign?a={left:i.siblings("div").width()-n,right:"auto"}:"right"===t.listAlign&&(a={left:"auto",right:0}),s&&!t.showBtn&&(r.hasClass("dropup")?(a.top="auto",a.bottom=e):(a.top=e,a.bottom="auto")),t.autoMinWidth||(a.minWidth=n),o.css(a),i}}function C(t,e){var n,i,o;if(-1===e.indexId&&!e.idField||e.multiWord)return t;i=e.inputBgColor,o=e.inputWarnColor;var r=t.val(),a=t.data("pre-val");return k(t)||!r?(t.css("background",i||""),!r&&a&&t.trigger("onUnsetSelectValue").data("pre-val","")):(n=t.css("backgroundColor").replace(/ /g,"").split(",",3).join(","),~o.indexOf(n)||t.trigger("onUnsetSelectValue").data("pre-val","").css("background",o)),t}function D(t,e,n){var i,o,r=t.parent().find("tbody tr."+n.listHoverCSS);r.length&&(i=(r.index()+3)*r.height(),(o=+e.css("maxHeight").replace("px",""))<i||e.scrollTop()>o?i-=o:i=0,e.scrollTop(i))}function A(t,e){t.find("tr."+e.listHoverCSS).removeClass(e.listHoverCSS)}function f(t){var e,n=m;for(e in t)if("value"===e){n=w;break}return n?(window.console&&window.console.trace,w):t.value.length?t:w}function F(t,e){var n=e.effectiveFields;return!("__index"===t||n.length&&!~c.inArray(t,n))}function T(t,e,n,i){n.html('<div style="padding:10px 5px 5px">'+t+"</div>").show(),j(e,n,i)}function q(t,e){var n=t.parent().find("ul:eq(0)");n.is(":visible")||(n.show(),t.trigger("onShowDropdown",[e?e.data.value:[]]))}function H(t,e){var n=t.parent().find("ul:eq(0)");n.is(":visible")&&(n.hide(),t.trigger("onHideDropdown",[e?e.data.value:[]]))}function W(t,e,n){var i,o,r,a,l,s,u,d=t.parent().find("ul:eq(0)"),f=0,c=['<table class="table table-condensed table-sm" style="margin:0">'],p=e.value;if(!e||!(i=p.length))return n.emptyTip?T(n.emptyTip,t,d,n):(d.empty(),H(t,n)),t;if(n._lastData&&JSON.stringify(n._lastData)===JSON.stringify(e)&&d.find("tr").length===i)return q(t,n),j(t,d,n);if(n._lastData=e,n.showHeader){for(r in c.push("<thead><tr>"),p[0])F(r,n)&&(c.push("<th>",n.effectiveFieldsAlias[r]||r,0===f?"("+i+")":"","</th>"),f++);c.push("</tr></thead>")}for(c.push("<tbody>"),o=0;o<i;o++){for(r in f=0,a=[],l=(u=p[o])[n.idField]||"",s=u[n.keyField]||"",u)s||n.indexKey!==f||(s=u[r]),l||n.indexId!==f||(l=u[r]),f++,F(r,n)&&a.push('<td data-name="',r,'">',u[r],"</td>");c.push('<tr data-index="',u.__index||o,'" data-id="',l,'" data-key="',s,'">',a.join(""),"</tr>")}return c.push("</tbody></table>"),d.html(c.join("")),q(t,n),setTimeout(function(){if(!h){var t=d.find("table:eq(0)"),e=0,n=0;d.height()<t.height()&&+d.css("minWidth").replace("px","")<d.width()&&(e=18,n=20),d.css("paddingRight",e),t.css("marginBottom",n)}},301),j(t,d,n),t}function B(e,n){n=n||"";var t=e._preAjax;t&&t.abort&&4!==t.readyState&&t.abort();var i={type:"GET",dataType:e.jsonp?"jsonp":"json",timeout:5e3};e.jsonp&&(i.jsonp=e.jsonp);var o,r=e.fnAdjustAjaxParam;if(c.isFunction(r)){if(o=r(n,e),w===o)return;c.extend(i,o)}return i.url=function(){if(!n||i.data)return i.url||e.url;var t="?";return/=$/.test(e.url)?t="":/\?/.test(e.url)&&(t="&"),e.url+t+encodeURIComponent(n)}(),e._preAjax=c.ajax(i).done(function(t){e.data=e.fnProcessData(t)}).fail(function(t){e.fnAjaxFail&&e.fnAjaxFail(t,e)})}function _(t,e,n,i){return n=c.trim(n),i.ignorecase&&(t=t.toLocaleLowerCase(),n=n.toLocaleLowerCase()),n&&(F(e,i)||(o=e,r=i,~c.inArray(o,r.searchFields)))&&(~n.indexOf(t)||i.twoWayMatch&&~t.indexOf(n));var o,r}var n={url:null,jsonp:null,data:{value:[]},indexId:0,indexKey:0,idField:"",keyField:"",autoSelect:m,allowNoKeyword:m,getDataMethod:"firstByUrl",delayUntilKeyup:w,ignorecase:w,effectiveFields:[],effectiveFieldsAlias:{},searchFields:[],twoWayMatch:m,multiWord:w,separator:",",delay:300,emptyTip:"",searchingTip:"搜索中...",autoDropup:w,autoMinWidth:w,showHeader:w,showBtn:m,inputBgColor:"",inputWarnColor:"rgba(255,0,0,.1)",listStyle:{"padding-top":0,"max-height":"375px","max-width":"800px",overflow:"auto",width:"auto",transition:"0.3s","-webkit-transition":"0.3s","-moz-transition":"0.3s","-o-transition":"0.3s"},listAlign:"left",listHoverStyle:"background: #07d; color:#fff",listHoverCSS:"jhover",clearable:w,keyLeft:37,keyUp:38,keyRight:39,keyDown:40,keyEnter:13,fnProcessData:function(t){return f(t)},fnGetData:function(t,e,n,i){var o,r,a,l,s={value:[]},u=i.fnPreprocessKeyword;if(t=t||"",c.isFunction(u)&&(t=u(t,i)),i.url){var d;i.searchingTip&&(d=setTimeout(function(){T(i.searchingTip,e,e.parent().find("ul"),i)},600)),B(i,t).done(function(t){n(e,i.data,i),e.trigger(g,t),"firstByUrl"===i.getDataMethod&&(i.url=null)}).always(function(){d&&clearTimeout(d)})}else{if(f(o=i.data))if(t){for(l=o.value.length,r=0;r<l;r++)for(a in o.value[r])if(o.value[r][a]&&_(t,a,o.value[r][a]+"",i)){s.value.push(o.value[r]),s.value[s.value.length-1].__index=r;break}}else s=o;n(e,s,i)}},fnAdjustAjaxParam:null,fnPreprocessKeyword:null,fnAjaxFail:null},i={init:function(f){var e=this;return void 0===(f=f||{}).showHeader&&f.effectiveFields&&1<f.effectiveFields.length&&(f.showHeader=m),(f=c.extend(m,{},n,f)).processData&&(f.fnProcessData=f.processData),f.getData&&(f.fnGetData=f.getData),"firstByUrl"===f.getDataMethod&&f.url&&!f.delayUntilKeyup&&B(f).done(function(t){f.url=null,e.trigger(g,t)}),c("#"+v).length||c("head:eq(0)").append('<style id="'+v+'">.'+f.listHoverCSS+"{"+f.listHoverStyle+"}</style>"),e.each(function(){var t,n,e,i,o,r,a,l=c(this),s=l.parent(),u=(i=f,o=(e=l).prev("i.clearable"),i.clearable&&!o.length&&(o=c('<i class="clearable glyphicon glyphicon-remove"></i>').prependTo(e.parent())),o.css({position:"absolute",top:12,zIndex:4,cursor:"pointer",fontSize:12}).hide()),d=s.find("ul:eq(0)");(r=l,a=f,!d.length||r.data(v)?w:(r.data(v,{options:a}),m))&&(f.showBtn||(l.css("borderRadius",4),s.css("width","100%").find(".btn:eq(0)").hide()),l.removeClass(y).prop(y,w).attr("autocomplete","off"),d.css(f.listStyle),f.inputBgColor||(f.inputBgColor=l.css("backgroundColor")),l.on("keydown",function(t){var e,n;if(d.is(":visible")){if(e=d.find("."+f.listHoverCSS),n="",A(d,f),t.keyCode===f.keyDown){if(e.length?e.next().length?n=b(e.next().mouseover()):f.autoSelect&&k(l,"").val(x(l)):n=b(d.find("tbody tr:first").mouseover()),D(l,d,f),!f.autoSelect)return}else if(t.keyCode===f.keyUp){if(e.length?e.prev().length?n=b(e.prev().mouseover()):f.autoSelect&&k(l,"").val(x(l)):n=b(d.find("tbody tr:last").mouseover()),D(l,d,f),!f.autoSelect)return}else t.keyCode===f.keyEnter?(n=b(e),H(l,f)):k(l,"");S(l,n,f)}else k(l,"")}).on("compositionstart",function(t){p=m}).on("compositionend",function(t){p=w}).on("keyup input paste",function(t){var e;t.keyCode&&C(l,f),~c.inArray(t.keyCode,[f.keyDown,f.keyUp,f.keyEnter])?l.val(l.val()):(clearTimeout(n),n=setTimeout(function(){p||(e=l.val(),c.trim(e)&&e===x(l)||(x(l,e),f.multiWord&&(e=e.split(f.separator).reverse()[0]),(e.length||f.allowNoKeyword)&&f.fnGetData(c.trim(e),l,W,f)))},f.delay||300))}).on("focus",function(){j(l,d,f)}).on("blur",function(){t||H(l,f)}).on("click",function(){var t=l.val();if(c.trim(t)&&t===x(l)&&d.find("table tr").length)return q(l,f);d.is(":visible")||(f.multiWord&&(t=t.split(f.separator).reverse()[0]),(t.length||f.allowNoKeyword)&&f.fnGetData(c.trim(t),l,W,f))}),s.find(".btn:eq(0)").attr("data-toggle","").click(function(){if(d.is(":visible"))H(l,f);else{if(f.url){if(l.click().focus(),!d.find("tr").length)return w}else W(l,f.data,f);q(l,f)}return w}),d.mouseenter(function(){t=1,l.blur()}).mouseleave(function(){t=0,l.focus()}).on("mouseenter","tbody tr",function(){return A(d,f),c(this).addClass(f.listHoverCSS),w}).on("mousedown","tbody tr",function(){var t=b(c(this));S(l,t,f),x(l,t.key),C(l,f),H(l,f)}),u.length&&(u.click(function(){k(l,"").val(""),C(l,f)}),s.mouseenter(function(){l.prop(y)||u.css("right",f.showBtn?Math.max(l.next(".input-group-btn").width(),33)+2:12).show()}).mouseleave(function(){u.hide()})))})},show:function(){return this.each(function(){c(this).click()})},hide:function(){return this.each(function(){H(c(this))})},disable:function(){return this.each(function(){c(this).attr(y,m).parent().find(".btn:eq(0)").prop(y,m)})},enable:function(){return this.each(function(){c(this).attr(y,w).parent().find(".btn:eq(0)").prop(y,w)})},destroy:function(){return this.each(function(){c(this).off().removeData(v).removeAttr("style").parent().find(".btn:eq(0)").off().show().attr("data-toggle","dropdown").prop(y,w).next().css("display","").off()})},version:function(){return"0.1.24"}};c.fn[v]=function(t){if("string"==typeof t&&i[t]){var e=m;return this.each(function(){if(!c(this).data(v))return e=w}),e||"init"===t||"version"===t?i[t].apply(this,[].slice.call(arguments,1)):this}return i.init.apply(this,arguments)}});
