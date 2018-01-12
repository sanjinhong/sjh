// 去掉空格
function trim(value) {
  if (value)
    value = value.replace(/^\s*|\s*$/g, "");
  if (!value)
    return "";
  else
    return value;
}


// 对参数编码
function encodeStr(val) {
	return encodeURIComponent(encodeURIComponent(trim(val)));
}


// 打开模式窗口
function openModal(url, args, width, height) {
  var ua = navigator.userAgent.toLowerCase();
  if (!width) {
    var width = window.screen.availWidth - 10;
  }

  if (!height) {
    var height = window.screen.availHeight - 30;
  } else {
    if (window.ActiveXObject && ua.indexOf('msie 6.') >= 0) { // IE6
      height = height + 40;
    }
  }

  if (!args) args = "";

  var rtn = window.showModalDialog(url, args, 'dialogWidth=' + width + 'px;dialogHeight=' + height + 'px;resizeable=no;scroll=no;status=no;help=no;');
  return rtn;
}