var josnMod = {
	//动态加载进来的数据的格式
	picSrc: "image/pic1.jpg", //图片的链接
	picComment: '"... tomorrow_is_another_day!"', //照片评论
	share: 50,  //分享次数
	heart: 77, //收藏次数
	comment: 85, //评论次数
	userImg:"image/headImg2.png", //用户头像链接
	userName:"sun太阳婆婆", //用户名
	text:"远方等待着一个永远的白瑞德", //动态说说详情
}

var noteJosnList = [
	{picSrc:"image/pic9.jpg",
	picComment:"诗爷好萌",
	share:52,
	heart:36,
	comment:21,
	userImg:"image/headImg2.png",
	userName:"牛芳-whatever",
	text:"木兰花一样的女子"
	},
	
	{picSrc:"image/pic10.jpg",
	picComment:"养一只可以温暖我的猫",
	share:22,
	heart:33,
	comment:21,
	userImg:"image/headImg3.png",
	userName:"索拉的记忆",
	text:"好可爱呀~"
	},
	
	{picSrc:"image/pic11.jpg",
	picComment:"思嘉有着猫一样的目光，猫一样的微笑",
	share:21,
	heart:37,
	comment:21,
	userImg:"image/headImg4.png",
	userName:"北悠梓弥",
	text:"一个猫一样的女人。"
	},
	
	{picSrc:"image/pic12.jpg",
	picComment:"朴正允",
	share:52,
	heart:36,
	comment:22,
	userImg:"image/headImg2.png",
	userName:"牛芳-whatever",
	text:"正允，阳光明媚的沙滩上，你比阳光还要耀眼夺目！"
	}
	
]

//动态加载数据，最后的str即为原本页面呈现的静态html代码
function addOneNote(josnModle) {
	var str = '<div class="pic col-md-3 col "><img src="';
	str = str + josnModle["picSrc"];
	str = str + '" /><div class="content"><p>';
	str = str + josnModle["picComment"];
	str = str + '</p><span class="glyphicon glyphicon-share">';
	str = str + josnModle["share"];
	str = str + '</span><span class="glyphicon glyphicon-heart">';
	str = str + josnModle["heart"];
	str = str + '</span><span class="glyphicon glyphicon-comment">';
	str = str + josnModle["comment"];
	str = str + '</span></div><div class="user"><img src="';
	str = str + josnModle["userImg"];
	str = str + '" class="img-circle"/><span class="name">&nbsp;&nbsp;';
	str = str + josnModle["userName"];
	str = str + '</span><p class="text">';
	str = str + josnModle["text"];
	str = str + '</p></br></div></div>	';
	document.getElementById("addMoreNote").innerHTML = document.getElementById("addMoreNote").innerHTML + str;
}

function addSomeNote(noteJosnList) {
	for(var i = 0; i < noteJosnList.length; i++) {
		addOneNote(noteJosnList[i]);
	}
	$(window.document.getElementById("lookMoreButton")).fadeOut();
	$(window.document.getElementById("noMore")).fadeIn();
}

$(document).ready(function() {
	$("#lookMoreButton").click(function() {
		addSomeNote(noteJosnList);
	});
	
  	$("#li1").mouseover(function() {
    	$(this).attr("class","activeLi");
  	});
  
  	$("#li3").mouseover(function() {
    	$(this).attr("class","activeLi");
  	});
  
  	$("#li4").mouseover(function() {
    	$(this).attr("class","activeLi");
  	});
  
  	$("#li1").mouseout(function() {
    	$(this).attr("class","");
  	});
  
  	$("#li3").mouseout(function() {
    	$(this).attr("class","");
  	});
  
  	$("#li4").mouseout(function() {
    	$(this).attr("class","");
  	});
  
});

