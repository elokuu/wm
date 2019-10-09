var e=1;

function zulin(){
	
	if(document.getElementById("titems").value=="val_2"){
	document.getElementById("yajin").style.display="block";

	}
	else{
		document.getElementById("yajin").style.display="none";
		e=1;
}
}
function zhifu(money){
	
	
	myWindow=window.open();
	myWindow.document.write("现在你需要支付1元")

}
function huanqian(num,borrow){	
	
	var a=confirm("你真的完成了此条订单吗?");
	if(a==1){
		
		$("#shangpin"+num).fadeOut();
		if(borrow){
			alert("租金已经返还给对方!\n商品已撤单!")
		}
		else
		alert("商品已撤单!");
	myWindow=window.open();
	myWindow.document.write("现在返还给您1元");
	
	}
}
