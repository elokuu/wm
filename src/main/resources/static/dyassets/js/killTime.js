$(document).ready(function() {
	
  $("#li1").mouseover(function() {
    $(this).attr("class","activeLi");
  });
  
  $("#li2").mouseover(function() {
    $(this).attr("class","activeLi");
  });
  
  $("#li4").mouseover(function() {
    $(this).attr("class","activeLi");
  });
  
  $("#li1").mouseout(function() {
    $(this).attr("class","");
  });
  
  $("#li2").mouseout(function() {
    $(this).attr("class","");
  });
  
  $("#li4").mouseout(function() {
    $(this).attr("class","");
  });
  
});