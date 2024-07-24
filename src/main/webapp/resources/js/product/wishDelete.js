//배열
const wishDelete = document.getElementsByClassName("wishDelete");
const all = document.getElementById("all");
const ch = document.getElementsByClassName("ch");

all.addEventListener("click", ()=>{
    for(let c of ch){
        c.checked=all.checked;
    } 
    
})

for(let c of ch){
    c.addEventListener("click", ()=>{

        let flag=true;
        for(let check of ch){
            if(!check.checked){
                flag =false;
                break;
            }
        }
        all.checked=flag;
    })
}


for(let w of wishDelete){
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        //Server 삭제 요청
        //option js의 객체 형식,
        fetch("./deleteWishList?bookNumber="+id, {
            method:"GET"
        }).then((r)=>{return r.text()})
          .then((r)=>{
            r=r.trim();
            if(r>0){
                //w.parentNode.parentNode.remove();
                let del = w.getAttribute("data-del-id")
                document.getElementById(del).remove();
            }else {
                alert('삭제 실패');
            }
          }).catch(()=>{alert('삭제 실패')});



    });
}

