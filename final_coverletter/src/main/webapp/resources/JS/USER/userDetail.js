
function add_div(id){
	var field = document.getElementById(id);
	console.log(field);
	console.log("1");
	var parent = field.parentNode;
	console.log(parent);
	console.log("2");
	var bro = parent.previousSibling.previousSibling;
	console.log(bro);
	console.log("3");
	var bro2 = parent.previousSibling.previousSibling.previousSibling.previousSibling;
	console.log(bro2);
	console.log("4");

	var div = document.createElement('div');
	
	 div.innerHTML = document.getElementById(bro2.id).innerHTML;
	 document.getElementById(bro.id).appendChild(div);
}

function remove_div(obj){
	
	var object = obj;
	var object_p = object.parentNode;
	var p_bro = object_p.previousSibling.previousSibling;
	 
	var tag = document.getElementById( p_bro.id );
     tag.removeChild( tag.lastChild );
}


function Address() {
	window.open("Address.do","","width=500px,height=500px");
	
}

window.onload = function () {                

    var slider1 = new rSlider({
        target: '#slider1',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    var slider2 = new rSlider({
        target: '#slider2',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider2:" + vals);
        }
    });
    var slider3 = new rSlider({
        target: '#slider3',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider3:" + vals);
        }
    });
    var slider4 = new rSlider({
        target: '#slider4',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider4:" + vals);
        }
    });
    var slider5 = new rSlider({
        target: '#slider5',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        width: '700px',
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider5:" + vals);
        }
    });
    

};



