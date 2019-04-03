//=================================================
//============= Validation.js 相关 start ============
//=================================================

jQuery.validator.setDefaults({
    debug: true
});
// 手机号码验证
jQuery.validator.addMethod("isPhone", function (value, element) {
    var length = value.length;
    return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));
}, "请正确填写您的手机号码。");

// 密码验证，以字母开头，长度在6-12之间，必须包含数字和特殊字符。
jQuery.validator.addMethod("isPwd", function (value, element) {
    var str = value;
    if (str.length < 6 || str.length > 18)
        return false;
    if (!/^[a-zA-Z]/.test(str))
        return false;
    if (!/[0-9]/.test(str))
        return fasle;
    return this.optional(element) || /[^A-Za-z0-9]/.test(str);
}, "以字母开头，长度在6-12之间，必须包含数字和特殊字符。");

//=================================================
//============= Validation.js 相关 end ============
//=================================================


//=================================================
//============= jqgrid.js 相关 start ==============
//=================================================
/**
 * jqgrid 分页按钮美化
 * @param table
 */
function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
    })
}

/**
 * jqgrid 通用搜索方法
 * @param gridUrl  请求数据的url
 * @param gridId  grid的id名称
 */
function search(gridUrl, gridId) {
    var strPrms = "";
    var grid_selector = '#' + gridId;
    var params = ($("#search_form").find(":input"));
    for (var i = 0; i < params.size(); i++) {
        if (!Zx.isEmpty($(params.get(i)).val())) {
            strPrms += $(params.get(i)).attr("name") + "=" + $(params.get(i)).val() + "&";
        }
    }
    jQuery(grid_selector).jqGrid('setGridParam', {
        url: gridUrl + "?" + strPrms
    }).trigger("reloadGrid");

}

/**
 * 清空搜索form表单  表单id search_form
 */
function clearSearch() {
    // 清空input
    var params = ($("#search_form").find(":input"));
    for (var i = 0; i < params.size(); i++) {
        if (!Zx.isEmpty($(params.get(i)).val())) {
            $(params.get(i)).val('');
        }
    }
    // 清空 bootstrap-select
    $('.selectpicker').selectpicker('val', '');
}

/**
 * jqgrid 绑定键盘上下方向键
 * @param e  键盘按键对象
 * @param grid  jqgrid 对象
 * @param focusField 编辑行时焦点 的列
 */
function keydownMethod(e, grid, focusField) {
    switch (e.which) {
        case 38:// 向上
            var $grid = grid //$(this);
            var $td = $(e.target).closest("tr.jqgrow>td");
            var $tr = $td.closest("tr.jqgrow");
            var rowid = $tr.attr("id");
            var $prev = $tr.prev("tr.jqgrow");
            var p = $grid.jqGrid("getGridParam");
            var cm = $td.length > 0 ? p.colModel[$td[0].cellIndex] : null;
            var cmName = cm !== null && cm.editable ? cm.name : focusField;
            var selectedRowId = $grid.jqGrid('getGridParam', 'selrow');
            if (selectedRowId == null || rowid !== selectedRowId) {
                return;
            }
            if ($prev.length < 1) {
                return;
            }
            var rowidPrev = $prev.attr("id");
            $grid.jqGrid('saveRow', rowid, {
                aftersavefunc: function () {
                    $(this).jqGrid("setSelection", rowidPrev, false)
                        .jqGrid("editRow", rowidPrev, {
                            keys: true,
                            focusField: focusField
                        });
                }
            });
            e.preventDefault();
            break;
        case 40: // 向下

            var $grid = grid;//$(this);
            var $td = $(e.target).closest("tr.jqgrow>td");
            var $tr = $td.closest("tr.jqgrow");
            var rowid = $tr.attr("id");
            var $trNext = $tr.next("tr.jqgrow");
            var p = $grid.jqGrid("getGridParam");
            var cm = $td.length > 0 ? p.colModel[$td[0].cellIndex] : null;
            var cmName = cm !== null && cm.editable ? cm.name : focusField;
            var selectedRowId = $grid.jqGrid('getGridParam', 'selrow');
            if (selectedRowId == null || rowid !== selectedRowId) {
                return;
            }
            if ($trNext.length < 1) {
                return;
            }
            var rowidNext = $trNext.attr("id");
            var data=$grid.jqGrid('getRowData',rowidNext);
            if(data.id=="" || data.id=="合计" || data.id=="总金额" ){
                jQuery('#grid_id').editRow(id, false);
                return
            }

            $grid.jqGrid('saveRow', rowid, {
                aftersavefunc: function () {
                    $(this).jqGrid("setSelection", rowidNext, false)
                        .jqGrid("editRow", rowidNext, {
                            keys: true,
                            focusField: focusField
                        });
                }
            });
            e.preventDefault();
            break;
        default:
            return;
    }
}

/**
 *  jqgrid sex 转换
 * @param cellvalue
 * @param options
 * @param rowObject
 * @returns {string}
 */
function sexFormat(cellvalue, options, rowObject) {
    var result;
    if (rowObject.sex == 1) {
        result = "男";
    } else if (rowObject.sex == 0) {
        result = "女";
    } else {
        result = "未知状态";
    }
    return result;
}


/**
 * 根据id 获取jqgrid rows的原始数据
 * @param rows  原始数据
 * @param id  要获取的行id
 * @returns {*}
 */
function getGridRowData(rows, id) {
    if (rows.length <= 0) {
        return;
    }
    for (var i = 0; i < rows.length; i++) {
        if (id == rows[i].id) {
            return rows[i];
        }
    }
}

//=================================================
//============= jqgrid.js 相关 end ================
//=================================================


/**
 * 清空新增弹出框
 * @param formId  form表单的id
 */
function clearAddForm(frm) {
    // 清空input
    if (Zx.isEmpty(frm)) {
        frm = '#addForm';
    }
    var params = ($(frm).find(":input"));
    for (var i = 0; i < params.size(); i++) {
        //排除radio
        if (params.get(i).type == 'radio' || params.get(i).type == 'checkbox') {
            continue;
        }
        if (!Zx.isEmpty($(params.get(i)).val())) {
            $(params.get(i)).val('');
        }
    }
    // 清空 bootstrap-select的选中项
    $('.selectpicker').selectpicker('val', '');
    //清除 Validation 验证信息
    $("#addForm").validate().resetForm();
}


/**
 * js 数组排序比较算法
 * @param prop  数字型排序，不支持字符
 * @returns {Function}
 */
var compare = function (prop) {
    return function (obj1, obj2) {
        var val1 = obj1[prop];
        var val2 = obj2[prop];
        if (!isNaN(Number(val1)) && !isNaN(Number(val2))) {
            val1 = Number(val1);
            val2 = Number(val2);
        }
        if (val1 < val2) {
            return -1;
        } else if (val1 > val2) {
            return 1;
        } else {
            return 0;
        }
    }
}


/**
 * 表单赋值扩展
 */
$.extend({
    setForm: function (frm, jsonValue) {
        var obj = $(frm);
        $.each(jsonValue, function (name, ival) {
            var $oinput = obj.find("input[name=" + name + "]");
            if ($oinput.attr("type") == "radio" || $oinput.attr("type") == "checkbox") {
                $oinput.each(function () {
                    if (Object.prototype.toString.apply(ival) == '[object Array]') {// 是复选框，并且是数组
                        for (var i = 0; i < ival.length; i++) {
                            if (!Zx.isEmpty(ival)) {
                                if ($(this).val() == ival[i]) {
                                    $(this).prop("checked", "checked");
                                }
                            }
                        }
                    } else {
                        if (!Zx.isEmpty(ival)) {
                            if ($(this).val() == ival) {
                                $(this).prop("checked", "checked");
                            }
                        }

                    }
                });
            } else if ($oinput.attr("type") == "textarea") {// 多行文本框
                obj.find("[name=" + name + "]").html(ival);
            } else {
                obj.find("[name=" + name + "]").val(ival);
            }
        });
    },
    getFormJson: function (frm) {
        var o = {};
        var a = $(frm).serializeArray();

        $.each(a, function () {
            if (this.name == "password") {
                this.value = this.value;
            }
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    }
});

/**
 *获取格式化时间
 *
 **/
function getNowFormatDate() {

    var date = new Date();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    function checkTime(i) {
        if (i < 10) {
            i = "0" + i
        }
        return i
    }
    var currentdate = date.getFullYear() + "-" + checkTime(month) + "-" + checkTime(strDate)
        + " " + checkTime(date.getHours()) + ":" + checkTime(date.getMinutes()) + ":" + checkTime(date.getSeconds());
    return currentdate;
}


// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function(fmt)
{ //author: meizz
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}
/**
 *生成随机数据
 *
 **/
function generateNum(n){
    if(typeof(n)=='undefined')n=3

    var _data=new Date().Format("yyMMddhhmm");
    var res = _data;
    for(var i = 0; i < n ; i ++) {
        var num = Math.floor(Math.random()*10); //向下取整生成0--9的数字
        res += num;
    }

    return res;
}

//按钮展示
function btnDisplay(i,s) {

    if(i==1)
    {
        $("#saveBtnId").hide();
        if(s==0) {
            $("#auditBtnId").show();
        }else{
            $("#auditBtnId").hide();
        }
        $("#antiAuditBtnId").hide();
    }else if(i==-1){
        $("#saveBtnId").hide();
        $("#auditBtnId").hide();

        if(s!=0)
        {
            $("#antiAuditBtnId").show();
        }else{
            $("#antiAuditBtnId").hide();
        }

    }else{

        if(s==0) {
            $("#saveBtnId").show();
        }else{
            $("#saveBtnId").hide();
        }
        $("#auditBtnId").hide();
        $("#antiAuditBtnId").hide();
    }

}

function closeForm(){
    if(confirm('确认要关闭吗？')){
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
    }

}

/**添加联系方式（电话或手机）**/
jQuery.validator.addMethod("isTel", function(value, element) {
    var length = value.length;
    var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
    return this.optional(element) || (phone.test(value));
}, "请填写正确的联系方式");//可以自定义默认提示信息

