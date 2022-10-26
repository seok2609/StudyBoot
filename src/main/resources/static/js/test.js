console.log("start");

$("#btn").click(function(){
    console.log("ㅎㅇ");
});


$(".buttons").click(function(){
    console.log("buttons");
});


//.test를 누르면 아이디가 btn2인 곳으로 전달
$(".test").on("click", "#btn2", function(){

});