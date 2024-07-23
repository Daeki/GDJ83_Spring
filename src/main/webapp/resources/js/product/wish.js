const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");
//Arrow Function
//함수 선언
// function [함수명](){}
// ()->{}
addWish.addEventListener("click", (e)=>{
    let id = addWish.getAttribute("data-product-id")
    console.log(id);
    //console.log(e.target.getAttribute("data-prouct-id"));
    fetch("./addWish?bookNumber="+id, {
    method:"GET"
   })
   .then((res)=>{return res.text()})
   .then((res)=>{
       if(res>0){
            let check = confirm("WishList 확인??");
            if(check){
                location.href="./wishList";
            }
       }else {
            alert('Wish List 추가 실패')
       }
   }).catch(()=>{
    alert("오류 발생");
   })
})


//function(res){
//  return res.text();
//}
// addWish.addEventListener("click", function(){
//    fetch("./addWish?num=15&name=iu", {
//     method:"GET"
//    })
// });