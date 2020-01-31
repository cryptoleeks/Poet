var delay = 1000;

function del() {
    document.querySelector('.app_canvas_frame').contentDocument.querySelector('.del_btn').click();
    setTimeout("yes()", delay);
}

function yes() {
    document.querySelector('.qz_dialog_layer_btn').click();
    setTimeout("del()", delay);
}

del();
