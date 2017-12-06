;$.extend({
    /**
     * hpsgts @2017.11.17
     * 通过url获取JSON对象
     */
    getLoadJson : function (url, params) {
        var data = null;
        $.ajax({
            url : url,
            type: "get",
            dataType : "json",
            async : false,
            data : params,
            success : function(rlt) {
                data = rlt;
            },
            error : function (req, error, errThrow) {
                $.error("function load json error: " + error);
            }
        });
        return data;
    },
    postForm : function (url, params) {
        var data = null;
        $.ajax({
            url : url,
            type: "post",
            dataType : "json",
            async : false,
            data : params,
            processData:false,//post一个对象需要设置为false
            contentType:false,
            success : function(rlt) {
                data = rlt;
            },
            error : function (req, error, errThrow) {
                $.error("function load json error: " + error);
            }
        });
        return data;
    }
});
$.fn.setForm = function(data){
    return this.each(function(){
        var input, name;
        if(data == null){this.reset(); return; }
        for(var i = 0; i < this.length; i++){
            input = this.elements[i];
            //checkbox的name可能是name[]数组形式
            name = (input.type == "checkbox")? input.name.replace(/(.+)\[\]$/, "$1") : input.name;
            if(data[name] == undefined) continue;
            switch(input.type){
                case "checkbox":
                    if(data[name] == ""){
                        input.checked = false;
                    }else{
                        //数组查找元素
                        if(data[name].indexOf(input.value) > -1){
                            input.checked = true;
                        }else{
                            input.checked = false;
                        }
                    }
                    break;
                case "radio":
                    if(data[name] == ""){
                        input.checked = false;
                    }else if(input.value == data[name]){
                        input.checked = true;
                    }
                    break;
                case "button": break;
                default: input.value = data[name];
            }
        }
    });
};