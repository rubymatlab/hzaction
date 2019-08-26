

//初始化下标
function resetTrNum(tableId) {
	$tbody = $("#"+tableId+"");
	$tbody.find('>tr').each(function(i){
		$(':input, select,button,a', this).each(function(){
			var $this = $(this),validtype_str = $this.attr('validType'), name = $this.attr('name'),id=$this.attr('id'),onclick_str=$this.attr('onclick'), val = $this.val();
			if(name!=null){
				if (name.indexOf("#index#") >= 0){
					$this.attr("name",name.replace('#index#',i));
				}else{
					var s = name.indexOf("[");
					var e = name.indexOf("]");
					var new_name = name.substring(s+1,e);
					$this.attr("name",name.replace("["+new_name+"]","["+i+"]"));
				}
			}
			if(id!=null){
				if (id.indexOf("#index#") >= 0){
					$this.attr("id",id.replace('#index#',i));
				}else{
					var s = id.indexOf("[");
					var e = id.indexOf("]");
					var new_id = id.substring(s+1,e);
					$this.attr("id",id.replace("["+new_id+"]","["+i+"]"));
				}
			}
			if(onclick_str!=null){
				if (onclick_str.indexOf("#index#") >= 0){
					$this.attr("onclick",onclick_str.replace(/#index#/g,i));
				}else{
					if(name!=null && name.indexOf("imgBtn")>=0){
						var s = onclick_str.indexOf("[");
						var e = onclick_str.indexOf("]");
						var new_onclick_str = onclick_str.substring(s+1,e);
						$this.attr("onclick",onclick_str.replace(new_onclick_str,i+"\\"+"\\"));
					}
				}
			}
			if(validtype_str!=null){
				if(validtype_str.indexOf("#index#") >= 0){
					$this.attr("validType",validtype_str.replace('#index#',i));
				}
			}
		});
		$(this).find('div[name=\'xh\']').html(i+1);
	});
}
//通用弹出式文件上传
function commonUpload(callback,inputId){
    $.dialog({
           content: "url:systemController.do?commonUpload",
           lock : true,
           title:"文件上传",
           zIndex:getzIndex(),
           width:700,
           height: 200,
           parent:windowapi,
           cache:false,
       ok: function(){
               var iframe = this.iframe.contentWindow;
               iframe.uploadCallback(callback,inputId);
               return true;
       },
       cancelVal: '关闭',
       cancel: function(){
       } 
   });
}
//通用弹出式文件上传-回调
function commonUploadDefaultCallBack(url,name,inputId){
	$("#"+inputId+"_href").attr('href',url).html('下载');
	$("#"+inputId).val(url);
}
function browseImages(inputId, Img) {// 图片管理器，可多个上传共用
}
function browseFiles(inputId, file) {// 文件管理器，可多个上传共用
}
function decode(value, id) {//value传入值,id接受值
	var last = value.lastIndexOf("/");
	var filename = value.substring(last + 1, value.length);
	$("#" + id).text(decodeURIComponent(filename));
}


(function ($) {
    //设置值
    function _setValues(jq, values, remainText) {
        var options = $.data(jq, "combogrid").options;
        var grid = $.data(jq, "combogrid").grid;
        var rows = grid.datagrid("getRows");
        var ss = [];
        for (var i = 0; i < values.length; i++) {
            var index = grid.datagrid("getRowIndex", values[i]);
            if (index >= 0) {
                grid.datagrid("selectRow", index);
                ss.push(rows[index][options.textField]);
            } else {
                ss.push(values[i]);
            }
        }
        if ($(jq).combo("getValues").join(",") == values.join(",")) {
            return;
        }
        $(jq).combo("setValues", values);
        if (!remainText) {
            $(jq).combo("setText", ss.join(options.separator));
        }
    };
    //查询
    function _query(jq, q) {
        var options = $.data(jq, "combogrid").options;
        var grid = $.data(jq, "combogrid").grid;
        $.data(jq, "combogrid").remainText = true;
        if (options.multiple && !q) {
            _setValues(jq, [], true);
        } else {
            _setValues(jq, [q], true);
        }
        if (options.mode == "remote") {
            grid.datagrid("clearSelections");
            grid.datagrid("load", $.extend({}, options.queryParams, { [options.textField]: '*'+q+'*' }));
        } else {
            if (!q) {
                return;
            }
            var rows = grid.datagrid("getRows");
            for (var i = 0; i < rows.length; i++) {
                if (options.filter.call(jq, q, rows[i])) {
                    grid.datagrid("clearSelections");
                    grid.datagrid("selectRow", i);
                    return;
                }
            }
        }
    };
    //解析器
    $.fn.combogrid.parseOptions = function (target) {
        var t = $(target);
        return $.extend({}, $.fn.combo.parseOptions(target),
            $.fn.datagrid.parseOptions(target),
            $.parser.parseOptions(target, ["idField", "textField", "mode"]));
    };
    $.fn.combogrid.defaults = $.extend({}, $.fn.combo.defaults,
        $.fn.datagrid.defaults, {
            loadMsg: null,//在数据表格加载远程数据的时候显示消息
            idField: null,//ID字段名称
            textField: null,//ID字段名称
            //定义在文本改变的时候如何读取数据网格数据。设置为'remote'，
            //数据表格将从远程服务器加载数据。当设置为'remote'模式的时候，用户输入将会发送到名为'q'的http请求参数，向服务器检索新的数据。
            mode: "remote",

            keyHandler: {
            	up: function () {
                    selectRow(this, -1);
                },
                down: function () {
                    selectRow(this, 1);
                },
                enter: function () {
                    selectRow(this, 0);
                    $(this).combo("hidePanel");
                },
                query: function (q) {
                    _query(this, q);
                }
            },
            //定义在'mode'设置为'local'的时候如何选择本地数据，返回true时则选择该行
            filter: function (q, row) {
            var options = $(this).combogrid("options");
            return row[options.textField].indexOf(q) == 0;
        }
    });
})(jQuery);
